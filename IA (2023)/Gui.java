// // import javax.swing.*;
// // import java.awt.*;

// // public class Gui {
// //     public static void main(String[] args) {
// //         // TODO Auto-generated method stub
// //         JFrame frame = new JFrame("Stocks");
// //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// //         frame.setSize(500, 500);
// //         frame.setVisible(true);


// //         //add a button
// //         JButton button = new JButton("Click me");
// //         button.setBounds(50,100,95,30);
// //         frame.getContentPane().add(button);
// //         button.addActionListener(e -> System.out.println("Hello World"));
// //         //detect when the button is clicked and print "Hello World" to the console

        

// //     }
// // }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class Gui extends JFrame implements ActionListener {
//     private JLabel usernameLabel, passwordLabel;
//     private JTextField usernameField;
//     private JPasswordField passwordField;
//     private JButton loginButton;

//     public Gui() {
//         setTitle("Login Screen");
//         setSize(400, 200);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);

//         usernameLabel = new JLabel("Username: ");
//         passwordLabel = new JLabel("Password: ");
//         usernameField = new JTextField();
//         passwordField = new JPasswordField();
//         loginButton = new JButton("Login");

//         setLayout(new GridBagLayout());
//         GridBagConstraints constraints = new GridBagConstraints();
//         constraints.insets = new Insets(10, 10, 10, 10);

//         constraints.gridx = 0;
//         constraints.gridy = 0;
//         add(usernameLabel, constraints);

//         constraints.gridx = 1;
//         add(usernameField, constraints);

//         constraints.gridx = 0;
//         constraints.gridy = 1;
//         add(passwordLabel, constraints);

//         constraints.gridx = 1;
//         add(passwordField, constraints);

//         constraints.gridx = 0;
//         constraints.gridy = 2;
//         constraints.gridwidth = 2;
//         constraints.anchor = GridBagConstraints.CENTER;
//         add(loginButton, constraints);

//         loginButton.addActionListener(this);

//         setVisible(true);
//     }

//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == loginButton) {
//             String username = usernameField.getText();
//             char[] password = passwordField.getPassword();

//             // You can add code here to validate the username and password.
//             // If they are valid, you can move to the next screen or display a success message.
//             // If they are invalid, you can display an error message.
//         }
//     }

//     public static void main(String[] args) {
//         new Gui();
//     }
// }