import java.util.Scanner;
import java.io.IOException;

class menu {
   public void showMenu() throws IOException {

      Account account = new Account();
      StockDriver driver = new StockDriver();
      Scanner input = new Scanner(System.in);
      Scraper scraper = new Scraper();

      account.checkUser();
      int choice = 0;
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
               driver.optionOne(input, account);
               break;
            case 2:
               driver.optionTwo(input, account);
               break;
            case 3:
               driver.optionThree(input, account);
               break;
            case 4:
               driver.optionFour(input, account, scraper);
               break;
            case 5:
               System.out.println("Goodbye Trader!");
               System.exit(0);

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