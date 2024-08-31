import java.util.HashMap;
import java.util.Map;

public class TradingEngine {
    private Map<String, Stock> market;

    public TradingEngine() {
        market = new HashMap<>();
        // Add some sample stocks
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 175.50));
        market.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.75));
    }

    public Stock getStock(String symbol) {
        return market.get(symbol);
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = market.get(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        } else {
            System.out.println("Stock not found.");
        }
    }

    public Map<String, Stock> getMarket() {
        return market;
    }
}
