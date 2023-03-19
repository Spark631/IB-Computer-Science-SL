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
               driver.optionOne();
               break;
            case 2:
               driver.optionTwo();
               break;
            case 3:
               driver.optionThree();
               break;
            case 4:
               driver.optionFour();
               break;
            case 5:
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