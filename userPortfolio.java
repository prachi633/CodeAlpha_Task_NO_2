import java.util.HashMap;
import java.util.Map;

public class userPortfolio {
    private Map<Stock, Integer> stocks = new HashMap<>();

    public void add(Stock stock, int quantity) {
        if (quantity <= 0) return;
        stocks.put(stock, stocks.getOrDefault(stock, 0) + quantity);
    }

    public boolean remove(Stock stock, int quantity) {
        if (quantity <= 0) return false;
        int currentQuantity = stocks.getOrDefault(stock, 0);
        if (currentQuantity < quantity) {
            return false;
        }
        if (currentQuantity == quantity) {
            stocks.remove(stock);
        } else {
            stocks.put(stock, currentQuantity - quantity);
        }
        return true;
    }

    public void displayUserPortfolio() {
        if (stocks.isEmpty()) {
            System.out.println("Portfolio is empty.");
        } else {
            for (Map.Entry<Stock, Integer> entry : stocks.entrySet()) {
                System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
            }
        }
    }
}
