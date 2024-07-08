import java.util.Scanner;

public class Main {

    private static final Stock Google = null;
	private Scanner sc = new Scanner(System.in);
    public userAccount account;
    private Market t;
    
    public Main(userAccount account, Market t) {
        this.account = account;
        this.t = t;
    }

    public void start() {
        while (true) {
            System.out.println("1.Welcome");
            System.out.println("2. Market");
            System.out.println("3. Portfolio");
            System.out.println("4. Buy Stock");
            System.out.println("5. Sell Stock");
            System.out.println("6. View Balance");
            System.out.println("7. Exit");
            System.out.println("Choose an option:");
            
            int option = sc.nextInt();
            switch (option) {
                case 1:
            	    System.out.println("** Welcome to Stock Trading Platform **");
            	break;
                case 2:
                	System.out.println(" The Market View ");
                    t.displayMarket();
                    break;
                case 3:
                     System.out.println(" The User Portfolio ");
                    account.getPortfolio().displayUserPortfolio();
                    break;
                case 4:
                	System.out.println(" Buying a stock ");
                    buyStock();
                    break;
                case 5:
                	System.out.println(" Selling a stock ");
                    sellStocks();
                    break;
                case 6:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 7:
                    System.out.println(" Exit ");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    
    private void sellStocks() {
        System.out.println("Enter a symbol:");
        String symbol = sc.next();
        Stock s = t.getStock(symbol);
        if (s != null) {
            System.out.println("Enter quantity to sell:");
            int q = sc.nextInt();
            account.sellStocks(s, q);
        } else {
            System.out.println("Stock not found.");
        }
    }

    private void buyStock() {
        System.out.println("Enter a symbol:");
        String symbol = sc.next();
        Stock s = t.getStock(symbol);
        if (s != null) {
            System.out.println("Enter quantity to buy:");
            int q = sc.nextInt();
            account.buyStock(s, q);
        } else {
            System.out.println("Stock not found.");
        }
    }
    
    public static void main(String[] args) {
    	userAccount u = new userAccount("prachithorat", 100000);
        Stock Apple = new Stock("APPL", "Apple", 1700);
        Stock Google = new Stock("GO", "Google", 3000);

      
        userPortfolio p = u.getPortfolio();
        p.add(Apple, 5); 
        p.add(Google, 3); 

        Market m = new Market();
        m.addStock(Google);
        m.addStock(new Stock("NKE", "NIKE", 800));
        m.addStock(Apple);

        Main n = new Main(u, m);
        n.start();
    }
}
