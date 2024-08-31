import java.util.Scanner;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        TradingEngine tradingEngine = new TradingEngine();
        Portfolio portfolio = new Portfolio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Market Data:");
                    for (Stock stock : tradingEngine.getMarket().values()) {
                        System.out.println(stock);
                    }
                    break;

                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    portfolio.buyStock(buySymbol, buyQuantity);
                    System.out.println("Stock bought.");
                    break;

                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    portfolio.sellStock(sellSymbol, sellQuantity);
                    System.out.println("Stock sold.");
                    break;

                case 4:
                    System.out.println("Portfolio Holdings:");
                    for (Map.Entry<String, Integer> entry : portfolio.getHoldings().entrySet()) {
                        String symbol = entry.getKey();
                        int quantity = entry.getValue();
                        Stock stock = tradingEngine.getStock(symbol);
                        if (stock != null) {
                            System.out.printf("%s (%s): %d shares\n", stock.getName(), symbol, quantity);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
