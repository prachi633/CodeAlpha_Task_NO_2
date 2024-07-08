

public class userAccount {
    private String username;
    private double balance;
    private userPortfolio portfolio;

    public userAccount(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.portfolio = new userPortfolio();
    }

    public double getBalance() {
        return balance;
    }

    public userPortfolio getPortfolio() {
        return portfolio;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            portfolio.add(stock, quantity);
            System.out.println("Bought " + quantity + " of " + stock.getName());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void sellStocks(Stock stock, int quantity) {
        if (portfolio.remove(stock, quantity)) {
            balance += stock.getPrice() * quantity;
            System.out.println("Sold " + quantity + " of " + stock.getName());
        } else {
            System.out.println("Insufficient stocks to sell.");
        }
    }
}
