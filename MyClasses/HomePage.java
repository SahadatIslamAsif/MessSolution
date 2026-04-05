package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {
    // Declare UI components and variables
    JPanel p1;
    JButton profile, Utilities, createMess, logOut, exit;
    JLabel logoLabel, imageLabel, label_1, label_2, label_3, label_4, label_5, label_6;

    // Constructor to set up the GUI
    public HomePage() {
        p1 = new JPanel();
        p1.setSize(new Dimension(1100, 700));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        // Load and add image
        ImageIcon picture = new ImageIcon(
                new ImageIcon("./Images/pic2.jpg").getImage().getScaledInstance(757, 375, Image.SCALE_DEFAULT));
        imageLabel = new JLabel();
        imageLabel.setBounds(230, 90, 757, 375);
        imageLabel.setIcon(picture);
        imageLabel.setLayout(null);
        imageLabel.setOpaque(true);
        p1.add(imageLabel);

        // Add logo
        logoLabel = new JLabel("Mess Solution");
        logoLabel.setForeground(new Color(0x78B4D6));
        logoLabel.setFont(new Font("Chiller", Font.BOLD, 65));
        logoLabel.setBounds(680, 465, 350, 50);
        logoLabel.setLayout(null);
        p1.add(logoLabel);

        // Add tagline
        label_1 = new JLabel("Solution is here!");
        label_1.setForeground(Color.gray);
        label_1.setFont(new Font("Courier New", Font.PLAIN, 16));
        label_1.setBounds(811, 508, 350, 30);
        label_1.setLayout(null);
        p1.add(label_1);

        // Add profile button
        ImageIcon MyProfileIcon = new ImageIcon(
                new ImageIcon("./Images/MyProfilePic.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        profile = new JButton(MyProfileIcon);
        profile.setBackground(Color.white);
        profile.setBounds(90, 100, 120, 120);
        profile.setFocusable(false);
        profile.setBorderPainted(false);
        profile.addActionListener(this);
        p1.add(profile);

        // Add profile label
        label_2 = new JLabel("Edit profile");
        label_2.setBounds(90, 220, 120, 18);
        label_2.setForeground(Color.gray);
        label_2.setHorizontalAlignment(JLabel.CENTER);
        label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        p1.add(label_2);

        // Add utility bills button
        ImageIcon utilityBillsIcon = new ImageIcon(
                new ImageIcon("./Images/billsPic.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        Utilities = new JButton(utilityBillsIcon);
        Utilities.setBackground(Color.white);
        Utilities.setBounds(90, 244, 120, 120);
        Utilities.setFocusable(false);
        Utilities.setBorderPainted(false);
        Utilities.addActionListener(this);
        p1.add(Utilities);

        // Add utility bills label
        label_3 = new JLabel("Edit utility bills");
        label_3.setBounds(90, 365, 120, 18);
        label_3.setForeground(Color.gray);
        label_3.setHorizontalAlignment(JLabel.CENTER);
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        p1.add(label_3);

        // Add create mess button
        ImageIcon createMessIcon = new ImageIcon(
                new ImageIcon("./Images/createMealPic.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        createMess = new JButton(createMessIcon);
        createMess.setBackground(Color.white);
        createMess.setBounds(90, 397, 120, 120);
        createMess.setFocusable(false);
        createMess.setBorderPainted(false);
        createMess.addActionListener(this);
        p1.add(createMess);

        // Add create mess label
        label_4 = new JLabel("Create a mess");
        label_4.setBounds(90, 520, 120, 18);
        label_4.setForeground(Color.gray);
        label_4.setHorizontalAlignment(JLabel.CENTER);
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        p1.add(label_4);

        // Add log out button
        ImageIcon logOutImageIcon = new ImageIcon(
                new ImageIcon("./Images/logOut.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        logOut = new JButton(logOutImageIcon);
        logOut.setBounds(250, 459, 60, 60);
        logOut.setFocusable(false);
        logOut.setBorderPainted(false);
        logOut.addActionListener(this);
        p1.add(logOut);

        // Add log out label
        label_5 = new JLabel("Log out");
        label_5.setBounds(249, 520, 60, 18);
        label_5.setForeground(Color.gray);
        label_5.setHorizontalAlignment(JLabel.CENTER);
        label_5.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        p1.add(label_5);

        // Add exit button
        ImageIcon exitIcon = new ImageIcon(
                new ImageIcon("./Images/exit.png").getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH));
        exit = new JButton(exitIcon);
        exit.setBounds(335, 465, 55, 55);
        exit.setFocusable(false);
        exit.setBorderPainted(false);
        exit.addActionListener(this);
        p1.add(exit);

        // Add exit label
        label_6 = new JLabel("Exit");
        label_6.setBounds(335, 520, 55, 18);
        label_6.setForeground(Color.gray);
        label_6.setHorizontalAlignment(JLabel.CENTER);
        label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        p1.add(label_6);

        // Set up the frame
        this.setTitle("");
        this.setSize(1100, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(p1);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == profile) {
            dispose();
            MyProfile m2 = new MyProfile();
        }

        else if (e.getSource() == Utilities) {
            dispose();
            UtilityBills u1 = new UtilityBills();
        }

        else if (e.getSource() == logOut) {
            dispose();
            SignIn L = new SignIn(); // Log out
        }

        else if (e.getSource() == createMess) {
            dispose();
            CreateMess N = new CreateMess();
        }

        else if (e.getSource() == exit) {
            dispose();
            System.exit(0); // Exit application
        }
    }
}
