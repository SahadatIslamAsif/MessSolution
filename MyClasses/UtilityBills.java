package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UtilityBills extends JFrame implements ActionListener {

    // Declare UI components and variables
    JPanel p1;
    JButton save, cancel;
    JLabel UtilitiesPicLabel, label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    FileWriter uBillsData;
    int a, b, c, d, e, f, g, h, totalUBills;

    // Constructor to set up the GUI
    public UtilityBills() {
        p1 = new JPanel();
        p1.setSize(new Dimension(1100, 700));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        // Load and scale an image for the label
        ImageIcon utilityBillsIcon = new ImageIcon(
                new ImageIcon("./Images/billsPic.png").getImage().getScaledInstance(120, 120,
                        Image.SCALE_SMOOTH));

        // Create and add a label with the image
        UtilitiesPicLabel = new JLabel(utilityBillsIcon);
        UtilitiesPicLabel.setBounds(349, 20, 120, 120);
        p1.add(UtilitiesPicLabel);

        // Create and add labels for the form
        label_1 = new JLabel("My Bills");
        label_1.setForeground(Color.black);
        label_1.setFont(new Font("Elephant", Font.PLAIN, 50));
        label_1.setBounds(469, 50, 350, 65);
        p1.add(label_1);

        label_2 = new JLabel("Edit Your Bills");
        label_2.setForeground(Color.gray);
        label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_2.setBounds(469, 107, 350, 25);
        p1.add(label_2);

        label_3 = new JLabel("  House Rent");
        label_3.setForeground(Color.gray);
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_3.setBounds(155, 180, 190, 40);
        p1.add(label_3);

        // Create and add text fields for user input
        t1 = new JTextField();
        t1.setBounds(155, 220, 190, 90);
        t1.setBackground(Color.white);
        t1.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t1);

        label_4 = new JLabel("       Gas");
        label_4.setForeground(Color.gray);
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_4.setBounds(355, 180, 190, 40);
        p1.add(label_4);

        t2 = new JTextField();
        t2.setBounds(355, 220, 190, 90);
        t2.setBackground(Color.white);
        t2.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t2);

        label_5 = new JLabel("      Water");
        label_5.setForeground(Color.gray);
        label_5.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_5.setBounds(555, 180, 190, 40);
        p1.add(label_5);

        t3 = new JTextField();
        t3.setBounds(555, 220, 190, 90);
        t3.setBackground(Color.white);
        t3.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t3);

        label_6 = new JLabel("    Electricity");
        label_6.setForeground(Color.gray);
        label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_6.setBounds(755, 180, 190, 40);
        p1.add(label_6);

        t4 = new JTextField();
        t4.setBounds(755, 220, 190, 90);
        t4.setBackground(Color.white);
        t4.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t4);

        label_7 = new JLabel("Helping Hand");
        label_7.setForeground(Color.gray);
        label_7.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_7.setBounds(155, 350, 190, 40);
        p1.add(label_7);

        t5 = new JTextField();
        t5.setBounds(155, 390, 190, 90);
        t5.setBackground(Color.white);
        t5.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t5);

        label_8 = new JLabel("       Dust");
        label_8.setForeground(Color.gray);
        label_8.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_8.setBounds(355, 350, 190, 40);
        p1.add(label_8);

        t6 = new JTextField();
        t6.setBounds(355, 390, 190, 90);
        t6.setBackground(Color.white);
        t6.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t6);

        label_9 = new JLabel("     Internet");
        label_9.setForeground(Color.gray);
        label_9.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_9.setBounds(555, 350, 190, 40);
        p1.add(label_9);

        t7 = new JTextField();
        t7.setBounds(555, 390, 190, 90);
        t7.setBackground(Color.white);
        t7.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t7);

        label_10 = new JLabel("     Others");
        label_10.setForeground(Color.gray);
        label_10.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        label_10.setBounds(755, 350, 190, 40);
        p1.add(label_10);

        t8 = new JTextField();
        t8.setBounds(755, 390, 190, 90);
        t8.setBackground(Color.white);
        t8.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        p1.add(t8);

        // Create and add the Save button
        save = new JButton("Save");
        save.setBackground(new Color(0x60A7CE));
        save.setForeground(Color.white);
        save.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        save.setBounds(548, 550, 110, 30);
        save.setFocusable(false);
        save.addActionListener(this);
        p1.add(save);

        // Create and add the Cancel button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(new Color(0x60A7CE));
        cancel.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        cancel.setBounds(418, 550, 110, 30);
        cancel.setFocusable(false);
        cancel.addActionListener(this);
        p1.add(cancel);

        // Set properties for the JFrame
        this.setTitle("Utility Bills");
        this.setSize(1100, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(p1);

        // Load data from file if it exists
        try {
            File file = new File("./Data/UtilityBills.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int i = 1;
                br.readLine(); // Skip the total bills line
                while ((line = br.readLine()) != null && i <= 8) {
                    // Set the text fields with the data from the file
                    switch (i) {
                        case 1:
                            t1.setText(line);
                            break;
                        case 2:
                            t2.setText(line);
                            break;
                        case 3:
                            t3.setText(line);
                            break;
                        case 4:
                            t4.setText(line);
                            break;
                        case 5:
                            t5.setText(line);
                            break;
                        case 6:
                            t6.setText(line);
                            break;
                        case 7:
                            t7.setText(line);
                            break;
                        case 8:
                            t8.setText(line);
                            break;
                    }
                    i++;
                }
                br.close();
            }
        } catch (Exception e) {
        }
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent abc) {
        if (abc.getSource() == save) {
            // Create an array of text fields
            JTextField[] textFields = { t1, t2, t3, t4, t5, t6, t7, t8 };
            for (JTextField textField : textFields) {
                // Check if the current text field is empty
                if (textField.getText().isEmpty()) {
                    textField.setText("0");// set '0' if empty
                }
            }
            try {
                // Parse the input and calculate the total
                a = Integer.parseInt(t1.getText());
                b = Integer.parseInt(t2.getText());
                c = Integer.parseInt(t3.getText());
                d = Integer.parseInt(t4.getText());
                e = Integer.parseInt(t5.getText());
                f = Integer.parseInt(t6.getText());
                g = Integer.parseInt(t7.getText());
                h = Integer.parseInt(t8.getText());
                totalUBills = a + b + c + d + e + f + g + h;

                // Write the total and individual bills to the file
                uBillsData = new FileWriter("./Data/UtilityBills.txt");
                uBillsData.write(String.valueOf(totalUBills));
                uBillsData.write("\n");
                uBillsData.write(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g
                        + "\n" + h);
                uBillsData.close();
                dispose();
                new HomePage();
                JOptionPane.showMessageDialog(UtilityBills.this, "Your bills have been updated!", " ",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                // Handle exception for invalid input
                JOptionPane.showMessageDialog(UtilityBills.this, "Utility Bills should be integer numbers only.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        else if (abc.getSource() == cancel) {
            // Handle cancel button click
            dispose();
            HomePage h3 = new HomePage();
            h3.setVisible(true);
        }
    }
}
