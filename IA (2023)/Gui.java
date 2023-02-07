import javax.swing.*;
import java.awt.*;

public class Gui {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame("Stocks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);


        //add a button
        JButton button = new JButton("Click me");
        button.setBounds(50,100,95,30);
        frame.getContentPane().add(button);
        button.addActionListener(e -> System.out.println("Hello World"));
        //detect when the button is clicked and print "Hello World" to the console

        

    }
}
