import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> holdings; // Stock symbol -> quantity

    public Portfolio() {
        holdings = new HashMap<>();
    }

    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    public void sellStock(String symbol, int quantity) {
        int currentQuantity = holdings.getOrDefault(symbol, 0);
        if (currentQuantity >= quantity) {
            holdings.put(symbol, currentQuantity - quantity);
        } else {
            System.out.println("Not enough stock to sell.");
        }
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }
}
