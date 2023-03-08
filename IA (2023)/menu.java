import java.util.Scanner;
import java.io.*;

class menu {
   public void showMenu() {
      Scanner input = new Scanner(System.in);
      int choice;

      StockDriver driver = new StockDriver();
      Account account = new Account();
      do {

         try {
            account.readUser();
            driver.options();

         } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
         }

         choice = input.nextInt();

         switch (choice) {
            case 1:
               System.out.println("You have selected to create a new portfolio");
               driver.optionOne();
               break;
            case 2:
               System.out.println("You have selected to load an existing portfolio");
               driver.optionTwo();
               break;
            case 3:
               System.out.println("You have selected to save the current portfolio");
               driver.optionThree();
               break;
            case 4:
               System.out.println("You have selected to display the current portfolio");
               driver.optionFour();
               break;
            case 5:
               System.out.println("You have selected to add a stock to the portfolio");
               driver.optionFive();
               break;
            case 6:
               System.out.println("You have selected to remove a stock from the portfolio");
               driver.optionSix();
               break;
            case 7:
               System.out.println("You have selected to sort the portfolio by price using quick sort");
               driver.optionSeven();
               break;
            case 8:
               System.out.println("Enter the stock name: ");
               String stockName = input.next();

               driver.optionEight(stockName);
               break;

            default:
               System.out.println("Invalid choice");
               break;
         }
      } while (choice != 9);
   }

   public static void mainInterface() {
      System.out.println("Hello ");
   }

}