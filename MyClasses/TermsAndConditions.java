package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import MyInterfaces.tempFileHandler;

public class TermsAndConditions extends JFrame implements ActionListener, tempFileHandler {

    // Declare UI components and variables
    JPanel p1;
    JRadioButton agreeButton, disagreeButton;
    File tempFile = new File("./Data/tempDetails.txt");

    // Constructor to set up the GUI
    public TermsAndConditions() {
        p1 = new JPanel();
        p1.setSize(new Dimension(405, 550));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        // Text area for terms and conditions
        JTextArea termsArea = new JTextArea(
                "Our mission is to make Bachelor’s life simpler and easier by ensuring a hassle-free calculation system of meal and household expenses. The Mess Solution app is intended for use by individuals who are 18 years or older. By using the app, you agree to comply with all applicable laws and regulations. We reserve the right to modify or discontinue the app at any time without notice. We may collect and use your personal information in accordance with our Privacy Policy. You may not use the app for any illegal or unauthorized purpose. We may terminate or suspend your access to the app at any time for any reason. These terms and conditions constitute the entire agreement between you and Mess Solution regarding your use of the app.");
        termsArea.setForeground(Color.gray);
        termsArea.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        termsArea.setBounds(50, 50, 300, 220);
        termsArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        termsArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        termsArea.setWrapStyleWord(true); // Enable word wrapping
        termsArea.setLineWrap(true); // Enable line wrapping
        termsArea.setEditable(false);
        termsArea.setLayout(null);
        p1.add(termsArea);

        // Text area for credits
        JTextArea credit = new JTextArea(
                "A solo project of  Md. Sahadat Islam from American International University-Bangladesh(AIUB)");
        credit.setForeground(new Color(0x4472C4));
        credit.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        credit.setBounds(50, 280, 300, 30);
        credit.setWrapStyleWord(true); // Enable word wrapping
        credit.setLineWrap(true); // Enable line wrapping
        credit.setEditable(false);
        credit.setLayout(null);
        p1.add(credit);

        // Label for copyright notice
        JLabel copyRlabel = new JLabel("Copyright © (2023) Mess Solution. All rights reserved.");
        copyRlabel.setForeground(Color.gray);
        copyRlabel.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        copyRlabel.setBounds(50, 350, 300, 20);
        copyRlabel.setLayout(null);
        p1.add(copyRlabel);

        // Agree button
        agreeButton = new JRadioButton("Agree and continue");
        agreeButton.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        agreeButton.setForeground(new Color(0x4472C4));
        agreeButton.setBackground(Color.white);
        agreeButton.setBounds(50, 390, 300, 15);
        agreeButton.setFocusPainted(false);
        agreeButton.setBorderPainted(false);
        agreeButton.addActionListener(this);
        p1.add(agreeButton);

        // Disagree button
        disagreeButton = new JRadioButton("Disagree");
        disagreeButton.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        disagreeButton.setForeground(new Color(0x4472C4));
        disagreeButton.setBackground(Color.white);
        disagreeButton.setBounds(50, 405, 300, 15);
        disagreeButton.setFocusPainted(false);
        disagreeButton.setBorderPainted(false);
        disagreeButton.addActionListener(this);
        p1.add(disagreeButton);

        // Button group for radio buttons
        ButtonGroup group1 = new ButtonGroup();
        group1.add(agreeButton);
        group1.add(disagreeButton);

        // Set up frame properties
        this.setTitle("");
        this.setSize(410, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(p1);

    }

    // ActionListener Method to handle button click events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agreeButton) {
            try {
                // Read and write user details to file
                BufferedReader br = new BufferedReader(new FileReader("./Data/tempDetails.txt"));
                BufferedWriter wr = new BufferedWriter(new FileWriter("./Data/UserDetails.txt", true));

                String line;
                while ((line = br.readLine()) != null) {
                    wr.write(line + "\n");
                }
                br.close();
                wr.close();

            } catch (Exception a) {
            }

            // Close current frame and open sign-in frame
            dispose();
            SignIn f2 = new SignIn();
            f2.setVisible(true);
            JOptionPane optionPane = new JOptionPane("Successfully registered! Please sign in.",
                    JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog(null);
            dialog.setVisible(true);

        }

        else if (e.getSource() == disagreeButton) {
            // Close current frame and open sign-up frame
            dispose();
            SignUp r2 = new SignUp();
            r2.setVisible(true);

        }

        // Delete temporary file
        tempFile.delete();
    }

    public void deleteTempFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }
}
