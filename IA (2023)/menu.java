import java.util.Scanner;
import java.io.*;

class menu {
   public void showMenu() throws IOException {
      Account account = new Account();
      account.checkUser();

      Scanner input = new Scanner(System.in);
      int choice = 0;

      StockDriver driver = new StockDriver();
      do {
         driver.options();
         try {
            choice = input.nextInt();
         } catch (Exception e) {
            System.out.println("Invalid choice");
            showMenu();
         }

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
               driver.optionEight();
               break;

            default:
               System.out.println("Invalid choice");
               break;
         }

      } while (choice != 9);

      input.close();
   }

   public static void mainInterface() {
      System.out.println("Hello ");
   }

}