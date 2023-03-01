import java.util.Scanner;
import java.io.*;

class menu {
   public void showMenu() {
      Scanner input = new Scanner(System.in);
      int choice;

      StockDriver driver = new StockDriver();

      do {
         driver.options();
         
         choice = input.nextInt();

         switch(choice) {
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

            default:
               System.out.println("Invalid choice");
               break;
         }
      } while (choice != 6);
   }

   public static void mainInterface() {
      System.out.println("Hello ");
   }

}