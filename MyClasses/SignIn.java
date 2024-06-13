package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SignIn extends JFrame implements ActionListener {

    // Declare UI components and variables
    JPanel p1;
    JButton passShowButton, passHideButton, forgetpass, register, login;
    JLabel imageLabel_1, logoLabel1, logoLabel2, label_1, label_2, label_3, label_4,
            label_5, label_6, label_7, label_8;
    JTextField emailField;
    JPasswordField passfield;
    FileWriter LogInTempFile;
    String password;

    // Constructor to set up the GUI
    public SignIn() {

        p1 = new JPanel();
        p1.setSize(new Dimension(1100, 700));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        logoLabel1 = new JLabel("Mess Solution");
        logoLabel1.setForeground(new Color(0x78B4D6));
        logoLabel1.setFont(new Font("Chiller", Font.BOLD, 65));
        logoLabel1.setBounds(630, 150, 350, 45);
        logoLabel1.setLayout(null);
        p1.add(logoLabel1);

        logoLabel2 = new JLabel("Do not allow anything to impede your productivity.");
        logoLabel2.setForeground(new Color(0xA1A1A1));
        logoLabel2.setFont(new Font("Footlight MT Light", Font.PLAIN, 16));
        logoLabel2.setBounds(600, 190, 400, 30);
        logoLabel2.setLayout(null);
        p1.add(logoLabel2);

        // Create and add labels and images
        ImageIcon picture1 = new ImageIcon(
                new ImageIcon("./Images/pic1.jpg").getImage().getScaledInstance(520, 350, Image.SCALE_DEFAULT));
        imageLabel_1 = new JLabel();
        imageLabel_1.setBounds(500, 200, 520, 350);
        imageLabel_1.setIcon(picture1);
        imageLabel_1.setLayout(null);
        imageLabel_1.setOpaque(true);
        p1.add(imageLabel_1);

        // add images for password show and hide button
        ImageIcon showPassPic = new ImageIcon(
                new ImageIcon("./Images/showpass.png").getImage().getScaledInstance(35, 35,
                        Image.SCALE_DEFAULT));
        passShowButton = new JButton();
        passShowButton.setBounds(400, 320, 35, 35);
        passShowButton.setIcon(showPassPic);
        passShowButton.setFocusable(false);
        passShowButton.setBorderPainted(false);
        passShowButton.setLayout(null);
        passShowButton.addActionListener(this);
        p1.add(passShowButton);

        ImageIcon hidePassPic = new ImageIcon(
                new ImageIcon("./Images/hidePass.png").getImage().getScaledInstance(35, 35,
                        Image.SCALE_DEFAULT));
        passHideButton = new JButton();
        passHideButton.setBounds(401, 320, 35, 35);
        passHideButton.setIcon(hidePassPic);
        passHideButton.setLayout(null);
        passHideButton.setFocusable(false);
        passHideButton.setBorderPainted(false);
        passHideButton.addActionListener(this);
        p1.add(passHideButton);

        label_1 = new JLabel("Welcome to your");
        label_1.setForeground(Color.gray);
        label_1.setFont(new Font("Elephant", Font.PLAIN, 40));
        label_1.setBounds(100, 140, 350, 45);
        label_1.setLayout(null);
        p1.add(label_1);

        label_2 = new JLabel("Mess Solution !");
        label_2.setForeground(Color.gray);
        label_2.setFont(new Font("Elephant", Font.PLAIN, 40));
        label_2.setBounds(100, 185, 350, 45);
        label_2.setLayout(null);
        p1.add(label_2);

        label_3 = new JLabel("Enter your Email");
        label_3.setForeground(Color.gray);
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_3.setBounds(100, 260, 350, 25);
        label_3.setLayout(null);
        p1.add(label_3);

        emailField = new JTextField();
        emailField.setBounds(100, 283, 300, 25);
        emailField.setBackground(Color.white);
        emailField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        emailField.setLayout(null);
        p1.add(emailField);

        label_4 = new JLabel("Password");
        label_4.setForeground(Color.gray);
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_4.setBounds(100, 306, 350, 25);
        label_4.setLayout(null);
        p1.add(label_4);

        passfield = new JPasswordField();
        passfield.setBounds(100, 329, 300, 25);
        passfield.setBackground(Color.white);
        passfield.setLayout(null);
        p1.add(passfield);

        forgetpass = new JButton("Forgot password?");
        forgetpass.setForeground(new Color(0x60A7CE));
        forgetpass.setBackground(Color.white);
        forgetpass.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        forgetpass.setBounds(80, 356, 132, 18);
        forgetpass.setFocusable(false);
        forgetpass.setBorderPainted(false);
        p1.add(forgetpass);

        // Create and add the buttons
        login = new JButton("Sign in");
        login.setBackground(new Color(0x60A7CE));
        login.setForeground(Color.white);
        login.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        login.setBounds(100, 400, 300, 30);
        login.setFocusable(false);
        login.addActionListener(this);
        p1.add(login);

        label_5 = new JLabel("~~~~~~~~~~~~~    or    ~~~~~~~~~~~~");
        label_5.setForeground(Color.gray);
        label_5.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_5.setBounds(100, 430, 340, 24);
        label_5.setLayout(null);
        p1.add(label_5);

        register = new JButton("Register now");
        register.setBackground(Color.white);
        register.setForeground(new Color(0x60A7CE));
        register.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        register.setBounds(100, 460, 300, 30);
        register.setFocusable(false);
        register.addActionListener(this);
        p1.add(register);

        // Set properties for the JFrame
        this.setTitle("");
        this.setSize(1100, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(p1);
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register) {
            dispose();
            SignUp r = new SignUp();
            r.setVisible(true);

        } else if (ae.getSource() == login) {
            boolean logInStatus = false;
            String email = emailField.getText().toString();
            String pass = passfield.getText().toString();

            // Check if email and password fields are not empty
            if (!email.isEmpty() && !pass.isEmpty()) {
                try {
                    FileReader fr = new FileReader("./Data/UserDetails.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String detailline;

                    while ((detailline = br.readLine()) != null) {
                        // Check if the line contains "Personal Details :"
                        if (detailline.equals("Personal Details :")) {
                            // Read the next two lines which should contain email and password
                            String storedEmail = br.readLine();
                            String storedPass = br.readLine();
                            // If email and password match, set login status to true and exit the loop
                            if (storedEmail.equals(email) && storedPass.equals(pass)) {
                                logInStatus = true;
                                break; // Exit the loop since we found a match
                            }
                        }
                    }
                    br.close();
                    fr.close();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                // If login is successful, write email and password to temporary file
                if (logInStatus == true) {
                    try {
                        FileWriter LogInTempFile = new FileWriter("./Data/LogInTempFile.txt");
                        LogInTempFile.write(email + "\n");
                        LogInTempFile.write(pass + "\n");
                        LogInTempFile.close();

                    } catch (Exception ax) {
                        ax.printStackTrace();
                    }
                    this.setVisible(false);
                    new HomePage();

                } else {
                    // Show error message if login fails
                    JOptionPane.showMessageDialog(SignIn.this, "Username and password do not match.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    emailField.setText("");
                    passfield.setText("");
                }
            }

            else {
                // Show error message if email or password field is empty
                JOptionPane.showMessageDialog(SignIn.this, "Please fill all the fields.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        else if (ae.getSource() == passShowButton) {
            p1.remove(passShowButton);
            p1.add(passHideButton);
            p1.revalidate();
            p1.repaint();
            char echoChar = passfield.getEchoChar();
            if (echoChar != 0) {
                passfield.setEchoChar('\0'); // Show password
            } else {
                passfield.setEchoChar('*'); // Hide password
            }

        } else if (ae.getSource() == passHideButton) {
            p1.remove(passHideButton);
            p1.add(passShowButton);
            p1.revalidate();
            p1.repaint();
            passfield.setEchoChar('*'); // Hide password
        }

    }
}
