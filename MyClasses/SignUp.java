package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SignUp extends JFrame implements ActionListener {

        // Declare UI components and variables
        JPanel p1;
        JButton signUpButton, backTosignInButton;
        JLabel label_1, label_2, label_3, label_4, label_6, label_7, label_8, label_9, label_10, label_11, label_12;
        JTextField firstnameField, lastnameField, emailField, dobField, addressField;
        JPasswordField passfield, repassfield;
        String firstName, lastName, email, password, rePassword, dob, address;
        FileWriter tempFile;

        // Constructor to set up the GUI
        public SignUp() {
                p1 = new JPanel();
                p1.setSize(new Dimension(680, 700));
                p1.setBackground(Color.white);
                p1.setLayout(null);

                // Create and add labels for the form
                label_1 = new JLabel("Sign up");
                label_1.setForeground(Color.black);
                label_1.setFont(new Font("Elephant", Font.PLAIN, 35));
                label_1.setBounds(200, 50, 350, 45);
                label_1.setLayout(null);
                p1.add(label_1);

                label_2 = new JLabel("It's quick and easy.");
                label_2.setForeground(Color.gray);
                label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_2.setBounds(200, 87, 350, 25);
                label_2.setLayout(null);
                p1.add(label_2);

                label_3 = new JLabel("First name");
                label_3.setForeground(Color.gray);
                label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_3.setBounds(200, 140, 250, 25);
                label_3.setLayout(null);
                p1.add(label_3);

                firstnameField = new JTextField();
                firstnameField.setBounds(200, 160, 250, 25);
                firstnameField.setBackground(Color.white);
                firstnameField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
                firstnameField.setLayout(null);
                p1.add(firstnameField);

                label_4 = new JLabel("Last name");
                label_4.setForeground(Color.gray);
                label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_4.setBounds(200, 180, 250, 25);
                label_4.setLayout(null);
                p1.add(label_4);

                lastnameField = new JTextField();
                lastnameField.setBounds(200, 200, 250, 25);
                lastnameField.setBackground(Color.white);
                lastnameField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
                lastnameField.setLayout(null);
                p1.add(lastnameField);

                label_6 = new JLabel("Enter your Email");
                label_6.setForeground(Color.gray);
                label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_6.setBounds(200, 220, 250, 25);
                label_6.setLayout(null);
                p1.add(label_6);

                emailField = new JTextField();
                emailField.setBounds(200, 240, 250, 25);
                emailField.setBackground(Color.white);
                emailField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
                emailField.setLayout(null);
                p1.add(emailField);

                label_7 = new JLabel("Password");
                label_7.setForeground(Color.gray);
                label_7.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_7.setBounds(200, 260, 250, 25);
                label_7.setLayout(null);
                p1.add(label_7);

                passfield = new JPasswordField();
                passfield.setBounds(200, 280, 250, 25);
                passfield.setBackground(Color.white);
                passfield.setLayout(null);
                p1.add(passfield);

                label_8 = new JLabel("Re-type password");
                label_8.setForeground(Color.gray);
                label_8.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_8.setBounds(200, 300, 250, 25);
                label_8.setLayout(null);
                p1.add(label_8);

                repassfield = new JPasswordField();
                repassfield.setBounds(200, 320, 250, 25);
                repassfield.setBackground(Color.white);
                repassfield.setLayout(null);
                p1.add(repassfield);

                label_9 = new JLabel("Date of birth");
                label_9.setForeground(Color.gray);
                label_9.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_9.setBounds(200, 340, 250, 25);
                label_9.setLayout(null);
                p1.add(label_9);

                dobField = new JTextField();
                dobField.setBounds(200, 360, 250, 25);
                dobField.setBackground(Color.white);
                dobField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
                dobField.setLayout(null);
                p1.add(dobField);

                label_10 = new JLabel("Address");
                label_10.setForeground(Color.gray);
                label_10.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_10.setBounds(200, 380, 250, 25);
                label_10.setLayout(null);
                p1.add(label_10);

                addressField = new JTextField();
                addressField.setBounds(200, 400, 250, 25);
                addressField.setBackground(Color.white);
                addressField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
                addressField.setLayout(null);
                p1.add(addressField);

                JTextArea termsArea = new JTextArea(
                                "By clicking Agree & Join, you agree to the Mess Solution User Agreement, Privacy Policy and Terms & Condition");
                termsArea.setForeground(Color.gray);
                termsArea.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                termsArea.setBounds(200, 425, 250, 45);
                termsArea.setWrapStyleWord(true); // Enable word wrapping
                termsArea.setLineWrap(true); // Enable line wrapping
                termsArea.setEditable(false);
                termsArea.setLayout(null);
                p1.add(termsArea);

                // add and set properties of buttons
                signUpButton = new JButton("Agree & Join");
                signUpButton.setBackground(new Color(0x60A7CE));
                signUpButton.setForeground(Color.white);
                signUpButton.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
                signUpButton.setBounds(200, 500, 250, 30);
                signUpButton.setFocusable(false);
                signUpButton.addActionListener(this);
                p1.add(signUpButton);

                label_11 = new JLabel("Already on Mess Solution?");
                label_11.setForeground(Color.gray);
                label_11.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
                label_11.setBounds(200, 530, 250, 25);
                label_11.setLayout(null);
                p1.add(label_11);

                backTosignInButton = new JButton("Sing in");
                backTosignInButton.setForeground(new Color(0x60A7CE));
                backTosignInButton.setBackground(Color.white);
                backTosignInButton.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
                backTosignInButton.setHorizontalAlignment(SwingConstants.LEFT);
                backTosignInButton.setBounds(335, 530, 75, 25);
                backTosignInButton.setFocusable(false);
                backTosignInButton.setBorderPainted(false);
                backTosignInButton.addActionListener(this);
                p1.add(backTosignInButton);

                // Set properties for the JFrame
                this.setTitle("");
                this.setSize(680, 700);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setLayout(null);
                this.setVisible(true);
                this.setResizable(false);
                this.add(p1);

        }

        // ActionListener method to handle button clicks
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signUpButton) {
                        // Validate if all fields are filled
                        if (!firstnameField.getText().isEmpty() && !lastnameField.getText().isEmpty()
                                        && !emailField.getText().isEmpty() && !passfield.getText().isEmpty()
                                        && !repassfield.getText().isEmpty() && !dobField.getText().isEmpty()
                                        && !addressField.getText().isEmpty()) {

                                // Compare password and retyped password before processing
                                if (passfield.getText().equals(repassfield.getText())) {
                                        try {
                                                firstName = firstnameField.getText();
                                                lastName = lastnameField.getText();
                                                email = emailField.getText();
                                                password = passfield.getText();
                                                rePassword = repassfield.getText();
                                                dob = dobField.getText();
                                                address = addressField.getText();

                                                tempFile = new FileWriter("./Data/tempDetails.txt");
                                                tempFile.write("Personal Details :\n");
                                                tempFile.write(email + "\n" + password + "\n" + firstName + "\n"
                                                                + lastName + "\n" + dob + "\n" + address + "\n");
                                                tempFile.close();
                                                dispose();
                                                TermsAndConditions t1 = new TermsAndConditions();
                                                t1.setVisible(true);

                                        } catch (Exception a) {
                                        }

                                } else {
                                        // Show error if passwords don't match
                                        JOptionPane.showMessageDialog(SignUp.this,
                                                        "Passwords do not match. Please re-enter.",
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                }
                        }

                        else {
                                // Show error if any field is empty
                                JOptionPane.showMessageDialog(SignUp.this, "Please fill all the fields.",
                                                "Error", JOptionPane.ERROR_MESSAGE);
                        }

                }

                else if (e.getSource() == backTosignInButton) {
                        // Switch to sign-in frame
                        dispose();
                        SignIn f1 = new SignIn();
                        f1.setVisible(true);

                }
        }
}