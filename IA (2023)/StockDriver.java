import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;

public class StockDriver {
    final static String reset = "\u001B[0m";
    final static String bold = "\u001B[1m";
    final static String yellow = "\u001B[33m";
    final static String green = "\u001B[32m";
    final static String red = "\u001B[31m";
    final static String blue = "\u001B[34m";
    final static String cyan = "\u001B[36m";
    final static String magenta = "\u001B[35m";
    final static String white = "\u001B[37m";
    final static String black = "\u001B[30m";
    final static String bgBlack = "\u001B[40m";
    final static String border = "==============================";

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
        System.out.println(bold + yellow + border + reset);
        System.out.printf("%sWelcome, %-27s%s\n", bold, name, reset);
        System.out.println(bold + cyan + "Please select an option:" + reset);
        System.out.println(bold + yellow + border + reset);
        System.out.println(bold + blue + "1. View your portfolio" + reset);
        System.out.println(bold + magenta + "2. Load an existing portfolio" + reset);
        System.out.println(bold + green + "3. Sell shares" + reset);
        System.out.println(bold + red + "4. Display the current portfolio" + reset);
        System.out.println(bold + white + "5. Add a stock to the portfolio" + reset);
        System.out.println(bold + bgBlack + "6. Remove a stock from the portfolio" + reset);
        System.out.println(bold + yellow + "7. Sort the portfolio by price using" + reset);
        System.out.println(bold + cyan + "8. Search for a stock" + reset);
        System.out.println(bold + yellow + border + reset);
        // System.out.println("+-------------------------------------+");
        // System.out.printf("| Date: %-30s|\n", java.time.LocalDate.now());
        // System.out.println("+-------------------------------------+");
        // System.out.printf("| Welcome, %-27s|\n", name);
        // System.out.println("+-------------------------------------+");
        // System.out.println("| Please select an option: |");
        // System.out.println("| |");
        // System.out.println("| 1. View your portfolio |");
        // System.out.println("| 2. Load an existing portfolio |");
        // System.out.println("| 3. Sell shares |");
        // System.out.println("| 4. Display the current portfolio |");
        // System.out.println("| 5. Add a stock to the portfolio |");
        // System.out.println("| 6. Remove a stock from the portfolio|");
        // System.out.println("| 7. Sort the portfolio by price using|");
        // System.out.println("| quick sort |");
        // System.out.println("| 8. Search for a stock |");
        // System.out.println("| |");
        // System.out.println("+-------------------------------------+");
    }

    public void optionOne() {
        try {
            Account account = new Account();
            String name = account.getUser();
            double wallet = account.getWallet();

            // Define the ASCII art for the border
            String border = "==============================";

            // Print out the top border
            System.out.println(yellow + border + reset);

            // Print out the user's name in yellow, with a bold header
            System.out.println(bold + "User: " + yellow + name + reset);

            // String walletString = String.format("$%,d", wallet);
            // System.out.println("this is walletstring : " + wallet + "");
            System.out.println(bold + "Wallet: " + green + wallet + reset);

            // Print out the bottom border
            System.out.println(yellow + border + reset);

            LinkedList<Stock> stockList = account.getStock();
            boolean loop = true;

            int tracker = 0;

            Scanner input = new Scanner(System.in);

            int linkedListLength = stockList.size();

            int count = 1;
            while (loop == true) {
                System.out.println("");
                System.out.println(bold + "Your Stocks: " + reset);
                System.out.println(yellow + border + reset);

                for (Stock stock : stockList) {
                    System.out.println(
                            count + ": " + stock.getName() + "| " + "Number of Shares " + stock.getAmountOfShares());
                    count++;
                }

                System.out.println(yellow + border + reset);

                System.out.println("Stock<pg" + (tracker + 1) + "-" + linkedListLength + ">");
                System.out.println("Enter a number to select a stock: ");
                tracker = (input.nextInt() - 1);
                System.out.println("Name: " + stockList.get(tracker).getName());
                System.out.println("Ticker: " + stockList.get(tracker).getTicker());
                System.out.println("Shares: " + stockList.get(tracker).getAmountOfShares());
                System.out.println("Price: " + stockList.get(tracker).getPrice());
                System.out.println("Net: " + stockList.get(tracker).getNet());
                System.out.println("Total: " + stockList.get(tracker).getTotal());
                System.out.println("Total Spent: " + stockList.get(tracker).getTotalMoneySpent());
                System.out.println("Total Gained: " + stockList.get(tracker).getTotalMoneyGained());
                System.out.println("Sector: " + stockList.get(tracker).getSector());

            }

        } catch (Exception e) {
            System.out.println("You have no stocks!");
        }

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

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the stock you want to sell: ");
        String name = input.nextLine();
        System.out.println("Enter the amount of shares you want to sell: ");
        int amount = input.nextInt();

        account.sellStock(name, amount);

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

    public void optionEight() {
        try {

            // Define the ASCII art for the border and prompt
            String prompt = "     ENTER THE STOCK NAME     ";

            // Print out the border and prompt
            System.out.println(yellow + border + reset);
            System.out.println(bold + prompt + reset);
            System.out.println(yellow + border + reset);

            Scanner input = new Scanner(System.in);
            String stockName = input.next().toUpperCase();
            Scraper scrape = new Scraper();
            String stock = scrape.findStockName(stockName);
            double stockPrice = scrape.findStockPrice(stockName);
            String sector = scrape.findSector(stockName);

            if (stock == null) {
                System.out.println("Stock not found");
                return;
            }

            // Define the ASCII art for the header and border
            String header = "STOCK INFO";

            // Print out the header and top border
            System.out.println(yellow + header + reset);
            System.out.println(yellow + border + reset);

            // Print out the stock name and price
            System.out.println("Stock: " + stock);
            System.out.println("Price: " + stockPrice);

            // Print out the menu options
            System.out.println(bold + "1. To buy shares" + reset);
            System.out.println(bold + "2. To view bar chart" + reset);
            System.out.println(bold + "3. To return to menu" + reset);

            // Print out the bottom border
            System.out.println(yellow + border + reset);

            int choice = input.nextInt();

            switch (choice) {
                case 1:

                    // Print out the border and prompt
                    System.out.println(yellow + border + reset);
                    System.out.println(bold + "HOW MANY SHARES WOULD YOU LIKE TO BUY?" + reset);
                    System.out.println(yellow + border + reset);
                    int shares = input.nextInt();

                    Account account = new Account();
                    double balance = account.checkBalance();
                    double total = (shares * stockPrice);

                    if (total <= balance) {
                        account.updateBalance(-total);
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
