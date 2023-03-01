import java.io.*;



public class StockDriver {
    
    public static void main(String args[]) throws Exception {

        menu startMenu = new menu();

        startMenu.showMenu();

        Stock [] stocks = new Stock[] {
            new Stock("Apple", "AAPL", 100, 100.00, 10000, 1000000000, 100,"Technology"),
            new Stock("Microsoft", "MSFT", 1004, 1400.00, 10000, 1000000, 1003,"Technology"),
            new Stock("Google", "GOOG", 1030, 1005.00, 100300, 0000, 1004,"Technology"),
            new Stock("Amazon", "AMZN", 200, 3040.00, 1000, 43, 1,"Technology"),
            new Stock("Facebook", "FB", 100, 1060.00, 100300, 30040000, 1200,"Technology"),
            new Stock("Tesla", "TSLA", 1400, 100.00, 100500, 1000000, 1040,"Technology"),
            new Stock("Netflix", "NFLX", 1040, 1300.00, 1050, 1000000000, 1050,"Technology"),
            new Stock("Twitter", "TWTR", 1010, 10350.00, 1030, 100000000, 100,"Technology"),
            new Stock("Snapchat", "SNAP", 1300, 1600.00, 1700, 10000000, 1200,"Technology"),
            new Stock("Square", "SQ", 100, 100.050, 1000, 50000000, 1300,"Technology"),
            new Stock("Shopify", "SHOP", 100, 10430.00, 1000, 100000000, 1050,"Technology"),
            new Stock("Pinterest", "PINS", 100, 120.00, 16000, 103000000, 1040,"Technology"),
            new Stock("Uber", "UBER", 1030, 10420.00, 18000, 10000, 1600,"Technology"),
            new Stock("Lyft", "LYFT", 1040, 1040.00, 100900, 100000, 1700,"Technology"),
            new Stock("Airbnb", "ABNB", 1500, 10410.00, 100000, 20000000, 1800,"Technology"),
        };
        FileOutputStream stream = new FileOutputStream("Stock.txt");
        PrintWriter writer = new PrintWriter(stream);
        // for (Stock stock : stocks) {
            // stock.display();
            // System.out.println(Arrays.toString(stocks));
            // writer.println(stock.display());
        // }

        for (int i = 0; i < stocks.length; i++) {
            writer.println(stocks[i].display());
        }
        writer.close();
    }

    public void optionOne() {
        System.out.println("Option 1");
    }

}
