package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyProfile extends JFrame implements ActionListener {

    // Declare UI components and variables
    JPanel p1;
    JButton save, cancel, passShowButton, passHideButton, rePassHideButton, rePassShowButton;
    JLabel imageLabel, label_1, label_2, label_3, label_4, label_6, label_7, label_8, label_9, label_10;
    JTextField firstnameField, lastnameField, emailField, dobField, addressField;
    JPasswordField passfield, repassfield;
    String email, pass;

    // Constructor to set up the GUI
    public MyProfile() {
        p1 = new JPanel();
        p1.setSize(new Dimension(1050, 700));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        ImageIcon picture = new ImageIcon(
                new ImageIcon("./Images/pic5.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        imageLabel = new JLabel();
        imageLabel.setBounds(550, 100, 400, 400);
        imageLabel.setIcon(picture);
        imageLabel.setLayout(null);
        imageLabel.setOpaque(true);
        p1.add(imageLabel);

        // Add labels and text fields for user information
        label_1 = new JLabel("My Info");
        label_1.setForeground(Color.black);
        label_1.setFont(new Font("Elephant", Font.PLAIN, 35));
        label_1.setBounds(150, 80, 350, 45);
        label_1.setLayout(null);
        p1.add(label_1);

        label_2 = new JLabel("Edit Your Info");
        label_2.setForeground(Color.gray);
        label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_2.setBounds(150, 118, 350, 25);
        label_2.setLayout(null);
        p1.add(label_2);

        label_3 = new JLabel("First name");
        label_3.setForeground(new Color(0x266196));
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_3.setBounds(150, 160, 350, 25);
        label_3.setLayout(null);
        p1.add(label_3);

        firstnameField = new JTextField("");
        firstnameField.setBounds(150, 183, 350, 25);
        firstnameField.setForeground(Color.gray);
        firstnameField.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
        firstnameField.setEditable(true);
        firstnameField.setLayout(null);
        p1.add(firstnameField);

        label_4 = new JLabel("Last name");
        label_4.setForeground(new Color(0x266196));
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_4.setBounds(150, 206, 350, 25);
        label_4.setLayout(null);
        p1.add(label_4);

        lastnameField = new JTextField("");
        lastnameField.setBounds(150, 229, 350, 25);
        lastnameField.setForeground(Color.gray);
        lastnameField.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
        lastnameField.setEditable(true);
        lastnameField.setLayout(null);
        p1.add(lastnameField);

        label_6 = new JLabel("Enter your Email");
        label_6.setForeground(new Color(0x266196));
        label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_6.setBounds(150, 252, 350, 25);
        label_6.setLayout(null);
        p1.add(label_6);

        emailField = new JTextField("");
        emailField.setBounds(150, 275, 350, 25);
        emailField.setForeground(Color.gray);
        emailField.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
        emailField.setEditable(false); // Email field is not editable
        emailField.setLayout(null);
        p1.add(emailField);

        label_7 = new JLabel("Reset Password");
        label_7.setForeground(new Color(0x266196));
        label_7.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_7.setBounds(150, 298, 350, 25);
        label_7.setLayout(null);
        p1.add(label_7);

        passfield = new JPasswordField("");
        passfield.setBounds(150, 321, 350, 25);
        passfield.setForeground(Color.gray);
        passfield.setEditable(true);
        passfield.setLayout(null);
        p1.add(passfield);

        label_8 = new JLabel("Re-type new password");
        label_8.setForeground(new Color(0x266196));
        label_8.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_8.setBounds(150, 344, 350, 25);
        label_8.setLayout(null);
        p1.add(label_8);

        repassfield = new JPasswordField("");
        repassfield.setBounds(150, 367, 350, 25);
        repassfield.setForeground(Color.gray);
        repassfield.setEditable(true);
        repassfield.setLayout(null);
        p1.add(repassfield);

        label_9 = new JLabel("Date of birth");
        label_9.setForeground(new Color(0x266196));
        label_9.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_9.setBounds(150, 390, 350, 25);
        label_9.setLayout(null);
        p1.add(label_9);

        dobField = new JTextField("");
        dobField.setBounds(150, 413, 350, 25);
        dobField.setForeground(Color.gray);
        dobField.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
        dobField.setLayout(null);
        dobField.setEditable(true);
        p1.add(dobField);

        label_10 = new JLabel("Address");
        label_10.setForeground(new Color(0x266196));
        label_10.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_10.setBounds(150, 436, 350, 25);
        label_10.setLayout(null);
        p1.add(label_10);

        addressField = new JTextField("");
        addressField.setBounds(150, 459, 350, 25);
        addressField.setForeground(Color.gray);
        addressField.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
        addressField.setEditable(true);
        addressField.setLayout(null);
        p1.add(addressField);

        // Add show and hide password buttons and set their properties
        ImageIcon showPassPic = new ImageIcon(
                new ImageIcon("./Images/showpass.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        passShowButton = new JButton();
        passShowButton.setBounds(500, 313, 35, 35);
        passShowButton.setIcon(showPassPic);
        passShowButton.setFocusable(false);
        passShowButton.setBorderPainted(false);
        passShowButton.setLayout(null);
        passShowButton.addActionListener(this);
        p1.add(passShowButton);

        ImageIcon hidePassPic = new ImageIcon(
                new ImageIcon("./Images/hidePass.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        passHideButton = new JButton();
        passHideButton.setBounds(501, 313, 35, 35);
        passHideButton.setIcon(hidePassPic);
        passHideButton.setLayout(null);
        passHideButton.setFocusable(false);
        passHideButton.addActionListener(this);
        p1.add(passHideButton);

        // Create an ImageIcon for the "show password" button by scaling the image
        ImageIcon showPassPic2 = new ImageIcon(
                new ImageIcon("./Images/showpass.png").getImage().getScaledInstance(35, 35,
                        Image.SCALE_DEFAULT));
        rePassShowButton = new JButton();
        rePassShowButton.setBounds(500, 359, 35, 35);
        rePassShowButton.setIcon(showPassPic2);
        rePassShowButton.setFocusable(false);
        rePassShowButton.setBorderPainted(false);
        rePassShowButton.setLayout(null);
        rePassShowButton.addActionListener(this);
        p1.add(rePassShowButton);

        // Create an ImageIcon for the "hide password" button by scaling the image
        ImageIcon hidePassPic2 = new ImageIcon(
                new ImageIcon("./Images/hidePass.png").getImage().getScaledInstance(35, 35,
                        Image.SCALE_DEFAULT));
        rePassHideButton = new JButton();
        rePassHideButton.setBounds(501, 359, 35, 35);
        rePassHideButton.setIcon(hidePassPic2);
        rePassHideButton.setLayout(null);
        rePassHideButton.setFocusable(false);
        rePassHideButton.setBorderPainted(false);
        rePassHideButton.addActionListener(this);
        p1.add(rePassHideButton);

        // Create and configure the "Save" button
        save = new JButton("Save");
        save.setBackground(new Color(0x60A7CE));
        save.setForeground(Color.white);
        save.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
        save.setBounds(548, 550, 110, 30);
        save.setFocusable(false);
        save.addActionListener(this);
        p1.add(save);

        // Create and configure the "Cancel" button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(new Color(0x60A7CE));
        cancel.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
        cancel.setBounds(418, 550, 110, 30);
        cancel.setFocusable(false);
        cancel.addActionListener(this);
        p1.add(cancel);

        try {
            BufferedReader br = new BufferedReader(new FileReader("./Data/UserDetails.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("./Data/LogInTempFile.txt"));
            email = br2.readLine(); // Read email from temporary login file
            pass = br2.readLine(); // Read password from temporary login file

            String line;
            // Read and populate user details if email and password match
            while ((line = br.readLine()) != null) {
                if (line.equals("Personal Details :")) {
                    String storedEmail = br.readLine();
                    String storedPass = br.readLine();
                    if (storedEmail.equals(email) && storedPass.equals(pass)) {
                        emailField.setText(email);
                        passfield.setText(pass);
                        repassfield.setText(pass);
                        firstnameField.setText(br.readLine());
                        lastnameField.setText(br.readLine());
                        dobField.setText(br.readLine());
                        addressField.setText(br.readLine());
                    }
                }
            }
            br.close();
            br2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setTitle("");
        this.setSize(1050, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.add(p1);

    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            // Ensure the passwords match before proceeding
            if (!passfield.getText().equals(repassfield.getText())) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader("./Data/UserDetails.txt"));
                StringBuilder userDetailsFile = new StringBuilder();
                String line;

                // Read and update user details if email and password match
                while ((line = br.readLine()) != null) {
                    if (line.equals("Personal Details :")) {
                        String storedEmail2 = br.readLine();
                        String storedPass2 = br.readLine();
                        if (storedEmail2.equals(email) && storedPass2.equals(pass)) {
                            userDetailsFile.append("Personal Details :").append("\n");
                            userDetailsFile.append(emailField.getText()).append("\n");
                            userDetailsFile.append(passfield.getText()).append("\n");
                            userDetailsFile.append(firstnameField.getText()).append("\n");
                            userDetailsFile.append(lastnameField.getText()).append("\n");
                            userDetailsFile.append(dobField.getText()).append("\n");
                            userDetailsFile.append(addressField.getText()).append("\n");
                        } else {
                            userDetailsFile.append("Personal Details :").append("\n");
                            userDetailsFile.append(storedEmail2).append("\n");
                            userDetailsFile.append(storedPass2).append("\n");
                            userDetailsFile.append(br.readLine()).append("\n"); // Read and append first name
                            userDetailsFile.append(br.readLine()).append("\n"); // Read and append last name
                            userDetailsFile.append(br.readLine()).append("\n"); // Read and append DOB
                            userDetailsFile.append(br.readLine()).append("\n"); // Read and append address
                        }
                    }
                }

                br.close();

                // Write updated user details to file
                BufferedWriter bw = new BufferedWriter(new FileWriter("./Data/UserDetails.txt"));
                bw.write(userDetailsFile.toString());
                bw.close();

            } catch (Exception ey) {
                ey.printStackTrace();
            }

            dispose();
            HomePage h2 = new HomePage();
            h2.setVisible(true);
            JOptionPane optionPane = new JOptionPane("Your info has been updated !",
                    JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog(null);
            dialog.setVisible(true);

        }

        else if (e.getSource() == cancel) {
            dispose();
            HomePage h3 = new HomePage();
            h3.setVisible(true);

        }

        else if (e.getSource() == passShowButton) {
            p1.remove(passShowButton); // Remove "show password" button
            p1.add(passHideButton); // Add "hide password" button
            p1.revalidate(); // Refresh the panel
            p1.repaint(); // Repaint the panel
            char echoChar = passfield.getEchoChar();
            if (echoChar != 0) {
                passfield.setEchoChar('\0'); // Show password
            } else {
                passfield.setEchoChar('*'); // Hide password
            }

        }

        else if (e.getSource() == passHideButton) {
            p1.remove(passHideButton); // Remove "hide password" button
            p1.add(passShowButton); // Add "show password" button
            p1.revalidate(); // Refresh the panel
            p1.repaint(); // Repaint the panel
            passfield.setEchoChar('*'); // Hide password

        }

        else if (e.getSource() == rePassShowButton) {
            p1.remove(rePassShowButton);
            p1.add(rePassHideButton);
            p1.revalidate();
            p1.repaint();
            char echoChar = repassfield.getEchoChar();
            if (echoChar != 0) {
                repassfield.setEchoChar('\0');
            } else {
                repassfield.setEchoChar('*');
            }
        }

        else if (e.getSource() == rePassHideButton) {
            p1.remove(rePassHideButton);
            p1.add(rePassShowButton);
            p1.revalidate();
            p1.repaint();
            repassfield.setEchoChar('*');
        }
    }
}
