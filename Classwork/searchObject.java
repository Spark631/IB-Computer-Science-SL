import java.util.Scanner;

public class searchObject {

    public int accountNumber;
    public String name;
    public double balance;

    public searchObject(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        searchObject[] array = new searchObject[3];

        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter the account number: ");
            int accountNumber = input.nextInt();
            System.out.println("Enter the name: ");
            String name = input.next();
            System.out.println("Enter the balance: ");
            double balance = input.nextDouble();
            array[i] = new searchObject(accountNumber, name, balance);
        }
        
        array[0] = new searchObject(123, "Donny", 100000);
        array[2] = new searchObject(789, "Jackeline", 10);
        array[1] = new searchObject(456, "Derek", 5);

        System.out.println("Enter the account number you want to search for: ");
        int target = input.nextInt();
        input.close();

        int index = search(target, array);
        System.out.println("The index of " + target + " is " + index);
    }

    public static int search(int target, searchObject[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].accountNumber == target) {
                return i;
            }
        }
        System.out.println("The account number " + target + " was not found. So...");
        return -1;
    }

}
