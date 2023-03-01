import java.io.*;
import java.util.Scanner;

public class StockDriver {
    
    public static void main(String args[]) throws Exception {

        Stock [] stocks = new Stock[] {
            new Stock("Apple", "AAPL", 100, 100.00, 10, 1000000000, 100,"Technology"),
            new Stock("Microsoft", "MSFT", 1004, 1400.00, 10000, 1000000, 1003,"Technology"),
            new Stock("Google", "GOOG", 1030, 1005.00, 10300, 0000, 1004,"Technology"),
            new Stock("Amazon", "AMZN", 200, 3040.00, 1000, 43, 1,"Technology"),
            new Stock("Facebook", "FB", 100, 1060.00, 10300, 30040000, 1200,"Technology"),
            new Stock("Tesla", "TSLA", 1400, 100.00, 10050, 1000000, 1040,"Technology"),
            new Stock("Netflix", "NFLX", 1040, 1300.00, 1050, 1000000000, 1050,"Technology"),
            new Stock("Twitter", "TWTR", 1010, 10350.00, 1030, 100000000, 100,"Technology"),
            new Stock("Snapchat", "SNAP", 1300, 1600.00, 1700, 10000000, 1200,"Technology"),
            new Stock("Square", "SQ", 100, 100.050, 1000, 50000000, 1300,"Technology"),
            new Stock("Shopify", "SHOP", 100, 10430.00, 1000, 100000000, 1050,"Technology"),
            new Stock("Pinterest", "PINS", 100, 120.00, 16000, 103000000, 1040,"Technology"),
            new Stock("Uber", "UBER", 1030, 10420.00, 1800, 10000, 1600,"Technology"),
            new Stock("Lyft", "LYFT", 1040, 1040.00, 100900, 100000, 1700,"Technology"),
            new Stock("Airbnb", "ABNB", 1500, 10410.00, 1000, 20000000, 1800,"Technology"),
        }; 
        FileOutputStream stream = new FileOutputStream("Stock.txt");
        PrintWriter writer = new PrintWriter(stream);
        // for (Stock stock : stocks) {
        //     stock.display();
        //     writer.println(stock.display());
        // }
        
        for (int i = 0; i < stocks.length; i++) {
            writer.println(stocks[i].display());
        }
        writer.close();

        menu startMenu = new menu();
    
        startMenu.showMenu();
    }

    public void options(){
        System.out.println("1. Create a new portfolio");
        System.out.println("2. Load an existing portfolio");
        System.out.println("3. Save the current portfolio");
        System.out.println("4. Display the current portfolio");
        System.out.println("5. Add a stock to the portfolio");
        System.out.println("6. Remove a stock from the portfolio");
        System.out.println("7. Sort the portfolio by price using quick sort");
    }

    public void optionOne() {
        System.out.println("Option 1");
    }

    public void optionTwo() {
        System.out.println("Option 2");
    }

    public void optionThree() {
        System.out.println("Option 3");
    }

    public void optionFour() {
        System.out.println("Option 4");
    }

    public void optionFive() {
        System.out.println("Option 5");
    }

    public void optionSix() {
        System.out.println("Option 6");
    }

    public void optionSeven() {
        System.out.println("Option 7");
        try {
            File readFile = new File("Stock.txt");
            Scanner input = new Scanner(readFile);

            int count = 0;
            Stock [] stockArray = new Stock[20];

            while (input.hasNextLine()) {
                String fileLine = input.nextLine();
                String [] data = fileLine.split(",");

                for (int i = 0; i < data.length; i++) {
                    System.out.println(data[i]);
                }

                String name = data[0];
                String ticker = data[1];
                int quantity = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                int marketCap = Integer.parseInt(data[4]);
                int high = Integer.parseInt(data[5]);
                int low = Integer.parseInt(data[6]);
                String sector = data[7];

                Stock stock = new Stock(name, ticker, quantity, price, marketCap, high, low, sector);
                stockArray[count] = stock;
                count++;
                // stockArray[0] = stocks.Stock(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]),
                //  Double.parseDouble(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]);
            }

            input.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }


}
