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
        System.out.println(bold + magenta + "2. Search for a stock" + reset);
        System.out.println(bold + green + "3. Sell shares" + reset);
        System.out.println(bold + cyan + "4. Watch List" + reset);
        System.out.println(bold + red + "5. Quit" + reset);
        System.out.println(bold + yellow + border + reset);
    }

    public void optionOne(Scanner input, Account account) {
        try {
            String name = account.getUser();
            double wallet = account.getWallet();

            // Print out the top border
            System.out.println(yellow + border + reset);

            // Print out the user's name in yellow, with a bold header
            System.out.println(bold + "User: " + yellow + name + reset);

            // Print out the user's wallet in yellow, with a bold header
            System.out.println(bold + "Wallet: " + green + wallet + reset);

            // Print out the bottom border
            System.out.println(yellow + border + reset);

            LinkedList<Stock> stockList = account.getStock();
            boolean loop = true;

            int tracker = 0;

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
                count = 1; // Reset the count to 1

                System.out.println(yellow + border + reset);

                System.out.println("Stock <" + (1) + "-" + linkedListLength + ">");

                System.out.println(yellow + "1. Select a stock: " + reset);
                System.out.println(blue + "2. Sort the stock" + reset);
                System.out.println(red + "0. Enter 0 to go back to the main menu: " + reset);

                tracker = (input.nextInt());
                switch (tracker) {
                    case 1:
                        System.out.println(yellow + border + reset);
                        System.out.println(white + "Enter the stock number:" + reset);
                        tracker = (input.nextInt());
                        tracker = (tracker - 1);

                        System.out.println(bold + "STOCK INFORMATION" + reset);
                        System.out.println(yellow + border + reset);
                        System.out.println("Name: " + stockList.get(tracker).getName());
                        System.out.println("Ticker: " + stockList.get(tracker).getTicker());
                        System.out.println("Shares: " + stockList.get(tracker).getAmountOfShares());
                        System.out.println("Price: " + stockList.get(tracker).getPrice());
                        System.out.println("Net: " + stockList.get(tracker).getNet());
                        System.out.println("Total: " + stockList.get(tracker).getTotal());
                        System.out.println("Total Spent: " + stockList.get(tracker).getTotalMoneySpent());
                        System.out.println("Total Gained: " + stockList.get(tracker).getTotalMoneyGained());
                        System.out.println("Sector: " + stockList.get(tracker).getSector());
                        System.out.println(yellow + border + reset);
                        break;

                    case 2:

                    case 0:
                        loop = false;
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("You have no stocks!");
        }
    }

    public void optionTwo(Scanner input, Account account) {
        try {
            // Print out the border and prompt
            System.out.println(yellow + border + reset);
            System.out.println(bold + "     ENTER THE STOCK NAME     " + reset);
            System.out.println(yellow + border + reset);

            String stockName = input.next().toUpperCase();

            Scraper scrape = new Scraper();
            String stock = scrape.findStockName(stockName);
            double stockPrice = scrape.findStockPrice(stockName);
            String sector = scrape.findSector(stockName);

            if (stock == null) {
                System.out.println("Stock not found");
                return;
            }

            // Print out the header and top border
            System.out.println(yellow + "STOCK INFO" + reset);
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

    public void optionThree(Scanner input, Account account) {
        System.out.println("Option 3");

        System.out.println(yellow + border + reset);
        System.out.println(blue + "Enter the name of the stock you want to sell: " + reset);
        System.out.println(yellow + border + reset);
        String name = input.nextLine();
        System.out.println(yellow + border + reset);
        System.out.println(magenta + "Enter the amount of shares you want to sell: " + reset);
        System.out.println(yellow + border + reset);
        int amount = input.nextInt();

        account.sellStock(name, amount);

    }

    public void optionFour(Scanner input, Account account, Scraper scrape) {
        System.out.println(cyan + "Watchlist" + reset);
        System.out.println(yellow + border + reset);
        System.out.println(green + "1: Add a stock to your watchlist" + reset);
        System.out.println(blue + "2: View your watchlist" + reset);
        System.out.println(red + "3: Remove a stock from your watchlist" + reset);
        System.out.println(black + "4: Return to menu" + reset);
        System.out.println(yellow + border + reset);

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(yellow + border + reset);
                System.out.println(blue + "Enter the ticker name of the");
                System.out.println("stock you want to add to your watchlist: " + reset);
                System.out.println(yellow + border + reset);

                String tickerName = input.next().toUpperCase();
                double price = scrape.findStockPrice(tickerName);

                System.out.println(yellow + border + reset);
                System.out.println(magenta + "Enter the price you want to be notified at: " + reset);
                System.out.println("Current " + tickerName + " price: " + green + price + reset);
                System.out.println(yellow + border + reset);

                double targetPrice = input.nextDouble();

                account.addToWatchList(tickerName, price, targetPrice);
                break;
            case 2:
                String[][] watchList = account.getWatchList();

                for (int i = 0; i < watchList.length; i++) {
                    for (int j = 0; j < watchList[i].length; j++) {
                        if (watchList[i][j] != null) {
                            System.out.print(watchList[i][j] + "\n");
                        }
                    }
                    System.out.println("---------------------");
                }

                break;
            case 3:
                // account.removeStockFromWatchList();
                break;
            case 4:
                System.out.println("Return to menu");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public void optionFive() {
        System.exit(0);
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

    }

}
