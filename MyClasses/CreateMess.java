package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CreateMess extends JFrame implements ActionListener {
    // Declare UI components and variables
    JPanel p1;
    JLabel label_1, label_2, label_3, label_4, label_5, label_6, designlabel, imageLabel;
    JTextField t1, t2, t3, t4;
    JButton create, back, changeUbillsButton;
    FileWriter mealData;
    float bills;

    // Constructor to set up the GUI
    public CreateMess() {

        try {
            FileReader fr1 = new FileReader("./Data/UtilityBills.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            String line = br1.readLine();
            if (line != null) {
                bills = Integer.parseInt(line); // Read utility bills from file
            }
            br1.close();

        } catch (Exception e) {
        }

        p1 = new JPanel();
        p1.setSize(new Dimension(1100, 700));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        // Load and add image to panel
        ImageIcon picture = new ImageIcon(
                new ImageIcon("./Images/pic3.png").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
        imageLabel = new JLabel();
        imageLabel.setBounds(670, 180, 400, 300);
        imageLabel.setIcon(picture);
        imageLabel.setLayout(null);
        imageLabel.setOpaque(true);
        p1.add(imageLabel);

        // Add design label to panel
        designlabel = new JLabel("__________________________________________");
        designlabel.setForeground(new Color(0xD4D2D2));
        designlabel.setFont(new Font("Maiandra GD", Font.BOLD, 40));
        designlabel.setBounds(100, 92, 1005, 45);
        designlabel.setLayout(null);
        p1.add(designlabel);

        // Add "Welcome to your Mess Solution!" labels
        label_1 = new JLabel("Welcome to your ");
        label_1.setForeground(Color.gray);
        label_1.setFont(new Font("Elephant", Font.PLAIN, 40));
        label_1.setBounds(100, 140, 350, 45);
        label_1.setLayout(null);
        p1.add(label_1);

        label_2 = new JLabel("Mess Solution !");
        label_2.setForeground(Color.gray);
        label_2.setFont(new Font("Elephant", Font.PLAIN, 40));
        label_2.setBounds(100, 180, 350, 45);
        label_2.setLayout(null);
        p1.add(label_2);

        // Add "Mess name" label and text field
        label_3 = new JLabel("Mess name - ");
        label_3.setForeground(new Color(0x266196));
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_3.setBounds(100, 285, 200, 25);
        label_3.setLayout(null);
        p1.add(label_3);

        t1 = new JTextField();
        t1.setBounds(350, 285, 300, 25);
        t1.setBackground(Color.white);
        t1.setForeground(Color.gray);
        t1.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        t1.setLayout(null);
        p1.add(t1);

        // Add "Month" label and text field
        label_4 = new JLabel("Month - ");
        label_4.setForeground(new Color(0x266196));
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_4.setBounds(100, 320, 200, 25);
        label_4.setLayout(null);
        p1.add(label_4);

        t2 = new JTextField();
        t2.setBounds(350, 320, 300, 25);
        t2.setBackground(Color.white);
        t2.setForeground(Color.gray);
        t2.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        t2.setLayout(null);
        p1.add(t2);

        // Add "Number of member" label and text field
        label_5 = new JLabel("Number of member - ");
        label_5.setForeground(new Color(0x266196));
        label_5.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_5.setBounds(100, 355, 260, 25);
        label_5.setLayout(null);
        p1.add(label_5);

        t3 = new JTextField();
        t3.setBounds(350, 355, 300, 25);
        t3.setBackground(Color.white);
        t3.setForeground(Color.gray);
        t3.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        t3.setLayout(null);
        p1.add(t3);

        // Add "Utilities Bill" label and text field
        label_6 = new JLabel("Utilities Bill - ");
        label_6.setForeground(new Color(0x266196));
        label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_6.setBounds(100, 390, 350, 25);
        label_6.setLayout(null);
        p1.add(label_6);

        t4 = new JTextField();
        t4.setText(Float.toString(bills)); // Set utility bills amount
        t4.setBounds(350, 390, 110, 25);
        t4.setBackground(Color.white);
        t4.setForeground(Color.gray);
        t4.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        t4.setLayout(null);
        t4.setEditable(false); // Make the field non-editable
        p1.add(t4);

        // Add "Change utility bills" button
        changeUbillsButton = new JButton("Change utility bills");
        changeUbillsButton.setBackground(new Color(0x8FC1DD));
        changeUbillsButton.setForeground(Color.white);
        changeUbillsButton.setFont(new Font("Maiandra GD", Font.BOLD, 14));
        changeUbillsButton.setBounds(465, 390, 185, 25);
        changeUbillsButton.setFocusable(false);
        changeUbillsButton.addActionListener(this);
        p1.add(changeUbillsButton);

        // Add "Create" button
        create = new JButton("Create");
        create.setBackground(new Color(0x60A7CE));
        create.setForeground(Color.white);
        create.setFont(new Font("Maiandra GD", Font.BOLD, 18));
        create.setBounds(381, 480, 110, 30);
        create.setFocusable(false);
        create.addActionListener(this);
        p1.add(create);

        // Add "Back" button
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(0x60A7CE));
        back.setFont(new Font("Maiandra GD", Font.BOLD, 18));
        back.setBounds(238, 480, 110, 30);
        back.setFocusable(false);
        back.addActionListener(this);
        p1.add(back);

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
        if (e.getSource() == back) {
            dispose();
            HomePage h2 = new HomePage();
            h2.setVisible(true);
        }

        else if (e.getSource() == create) {
            if (!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty()) {
                try {
                    String messName = t1.getText();
                    String month = t2.getText();
                    int member = Integer.parseInt(t3.getText()); // Parse number of members
                    mealData = new FileWriter("./Data/NewMessInfo.txt");
                    mealData.write(messName + "\n");
                    mealData.write(month + '\n');
                    mealData.write(String.valueOf(member) + '\n');
                    mealData.close();
                    dispose();
                    new AddParticipant();

                } catch (Exception a) {
                    JOptionPane.showMessageDialog(CreateMess.this, "Number of member only contains integer number(s).",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(CreateMess.this, "Please fill all the fields.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource() == changeUbillsButton) {
            dispose();
            UtilityBills u1 = new UtilityBills();
            u1.setVisible(true);
        }
    }
}
