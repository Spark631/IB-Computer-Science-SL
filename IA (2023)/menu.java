import java.util.Scanner;
import java.io.*;

class menu {
   public void showMenu() {
      Scanner input = new Scanner(System.in);
      int choice;

      StockDriver driver = new StockDriver();

      do {
         System.out.println("Hi there! Welcome to the Stock Portfolio Manager!");

         System.out.println("Please select an option from the menu below:");

         System.out.println("1. Create a new portfolio");

         System.out.println("2. Load an existing portfolio");

         System.out.println("3. Save the current portfolio");

         System.out.println("4. Display the current portfolio");

         System.out.println("5. Add a stock to the portfolio");

         System.out.println("6. Remove a stock from the portfolio");
         
         choice = input.nextInt();

         switch(choice) {
            case 1:
               System.out.println("You have selected to create a new portfolio");
               driver.optionOne();
               break;
            case 2:
               System.out.println("You have selected to load an existing portfolio");
               break;
            default:
               System.out.println("Invalid choice");
               break;
         }
      } while (choice != 3);
   }

   public static void mainInterface() {
      System.out.println("Hello ");
   }

}