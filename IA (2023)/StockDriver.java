import java.io.*;
import java.util.Scanner;

public class StockDriver {

    public static void main(String args[]) throws Exception {

        menu startMenu = new menu();

        startMenu.showMenu();
    }

    public void createPortfolio() {
        System.out.println("Create a new portfolio");
    }

    public void options() {
        Account account = new Account();
        String name = account.checkUser();
        System.out.println("+-------------------------------------+");
        System.out.printf("| Date: %-30s|\n", java.time.LocalDate.now());
        System.out.println("+-------------------------------------+");
        System.out.printf("| Welcome, %-27s|\n", name);
        System.out.println("+-------------------------------------+");
        System.out.println("| Please select an option:            |");
        System.out.println("|                                     |");
        System.out.println("| 1. View your portfolio              |");
        System.out.println("| 2. Load an existing portfolio       |");
        System.out.println("| 3. Save the current portfolio       |");
        System.out.println("| 4. Display the current portfolio    |");
        System.out.println("| 5. Add a stock to the portfolio     |");
        System.out.println("| 6. Remove a stock from the portfolio|");
        System.out.println("| 7. Sort the portfolio by price using|");
        System.out.println("|    quick sort                       |");
        System.out.println("| 8. Search for a stock               |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
    }

    public void optionOne() {
        Account account = new Account();
        String name = account.getUser();
        double wallet = account.getWallet();

        // Define some ANSI escape codes for colors and formatting
        String reset = "\u001B[0m";
        String bold = "\u001B[1m";
        String yellow = "\u001B[33m";
        String green = "\u001B[32m";

        // Define the ASCII art for the border
        String border = "==============================";

        // Print out the top border
        System.out.println(yellow + border + reset);

        // Print out the user's name in yellow, with a bold header
        System.out.println(bold + "User: " + yellow + name + reset);

        // Print out the wallet balance in green, with a dollar sign and commas for
        // thousands
        String walletString = String.format("$%,d", wallet);
        System.out.println(bold + "Wallet: " + green + walletString + reset);

        // Print out the bottom border
        System.out.println(yellow + border + reset);
    }

    public void optionTwo() {
        System.out.println("Option 2");
        Account account = new Account();

        Stock stock = new Stock("Apple", "AAPL", 10, 100.00, 1000000000, 100, 50, "Technology");

        account.addStock(stock);
    }

    public void optionThree() {
        System.out.println("Option 3");
        Account account = new Account();
        account.getStock();
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
            Stock[] stockArray = new Stock[20];

            while (input.hasNextLine()) {
                String fileLine = input.nextLine();
                String[] data = fileLine.split(",");

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
                // stockArray[0] = stocks.Stock(data[0], data[1], Integer.parseInt(data[2]),
                // Double.parseDouble(data[3]),
                // Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                // Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]);
            }

            input.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void optionEight(String stockName) {
        try {
            Scraper scrape = new Scraper();
            String stock = scrape.findStockName(stockName);
            double stockPrice = scrape.findStockPrice(stockName);
            String sector = scrape.findSector(stockName);
            if (stock == null) {
                System.out.println("Stock not found");
                return;
            }

            System.out.println("Stock: " + stock);
            System.out.println("Price: " + stockPrice);

            System.out.println("1. To buy shares");
            System.out.println("2. To view bar chart");
            System.out.println("3. To return to menu");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How many shares would you like to buy?");
                    int shares = input.nextInt();

                    Account account = new Account();
                    double balance = account.checkBalance();
                    double total = (shares * stockPrice);

                    if (total <= balance) {
                        account.updateBalance(total);
                    } else {
                        System.out.println("Insufficient funds");
                        break;
                    }
                    System.out.println("You have bought " + shares + " shares of " + stockName);
                    Stock stockObj = new Stock(stock, stockName, shares, stockPrice, 0, total, 0, sector);
                    account.addStock(stockObj);

                    break;
                case 2:
                    scrape.createHashMap(stockName);
                    break;
                case 3:
                    System.out.println("Return to Menu");
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

}
