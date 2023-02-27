import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class menu {
    public static void main(String[] args) throws Exception {
       while(true) {
          menu();		  
       }
    
    }  // ends main
    public static void menu() throws Exception {
    
    /**************  File read and Array Object Creation  *********************************/
      

    
    /**************  MENU CHOICES Loop *********************************/
       int choice = menuChoice();
    
       do {     
       
          if (choice == 1)   // Review Array of Objects 
          {
          
             reviewObjects();		 
            
          }
          else if (choice==2) 
          {
          
            //  processRecs(records, processed);
          
          }	
           
          else if (choice==3) 
          {
             quit();
          
          }
       
       
          choice = menuChoice();	  // get users choice for reloop
       
       
       
       }while( (choice >= 1 ) && (choice < 4)  ) ;   // loop on do-while loop
      
    } // end menu method
 
    public static int menuChoice() 
    {
     
       String prompt =   "\n 1) Review (subset) of array of your Object"
                             + "\n 2) Process values"
                             + "\n 3) Quit"
                             + "\n Enter your choice: ";
                            
       System.out.print(prompt);
      
       Scanner keyIn = new Scanner(System.in);
       int c = keyIn.nextInt();
       return c;
    
    } // end menuChoice method
      
    public static void reviewObjects() throws Exception{
        File read = new File("Stock.txt");
        Scanner scan = new Scanner(read);
        String line = scan.nextLine();
        
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            String[] parts = line.split(",");
            String name = parts[0];
            String ticker = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);
            double total = Double.parseDouble(parts[4]);
            int marketCap = Integer.parseInt(parts[5]);
            int high = Integer.parseInt(parts[6]);
            int low = Integer.parseInt(parts[7]);
            String sectors = parts[8];
            System.out.println("Name: " + name + " Ticker: " + ticker + " Quantity: " + quantity + " Price: " + price + " Total: " + total + " Market Cap: " + marketCap + " High: " + high + " Low: " + low + " Sectors: " + sectors);
        }
    
            scan.close();
       
       
       pause();
    
    }
      
      
      
    public static void processRecs(int arrayIn[], int arrayProcess[]) 
    {
          
       for(int i=0; i< 7; i++)	
          arrayProcess[i]= 2*arrayIn[i];
              
       for(int i=0; i< 7; i++)	
          System.out.println(arrayProcess[i]);
              
       pause();
              
    } // end method
      
    public static void pause()
    {
       Scanner kb = new Scanner(System.in);
       System.out.print("Press anything to continue");
       kb.nextLine();
            
    } // end pause method
    
    public static void quit()
    {
       System.out.println("Exiting program, Bye");
       System.exit(0);
 
 }
 
}
