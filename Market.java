import java.util.HashMap;
import java.util.Map;

public class Market {
    private Map<String, Stock> marketStocks = new HashMap<>();

    public void addStock(Stock stock) {
        marketStocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return marketStocks.get(symbol);
    }

    public void displayMarket() {
        if (marketStocks.isEmpty()) {
            System.out.println("No stocks available in the market.");
        } else {
            for (Stock stock : marketStocks.values()) {
                System.out.println(stock);
            }
        }
    }
}
