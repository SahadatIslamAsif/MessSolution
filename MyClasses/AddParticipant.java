package MyClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class AddParticipant extends JFrame implements ActionListener {
    // Declare UI components and variables
    ArrayList<MemberDetails> memberDetailsList;// List to store member details
    JPanel p1;
    JButton cancel, add, calculateButton, changeUbillsButton, showMembersButton;
    JLabel imageLabel, sidelogo, designlabel, label_1, label1_1, label_2, label_3, label_4, label_5, label_6, label_7,
            label_8,
            label_9, label_10, label_11, label_12;
    JTextField nameField, bazar1Field, bazar2Field, bazar3Field, mealCountField, messNameField, monthField, uBillsField,
            memberField, additionalCostField;
    FileWriter bazardata, totaldata;
    String messName, month, name;
    int bazar1, bazar2, bazar3, personalBazar, mealCount, additionalCost, numberOfPeople;
    float bills, personalBills, netCost;
    double consumedFood;
    static int count = 0;
    static int totalMeal = 0;
    static float totalBazar = 0;
    static double perMeal = 0;

    // Constructor to set up the GUI
    public AddParticipant() {

        memberDetailsList = new ArrayList<>();

        // Read utility bills from file
        try {
            FileReader fr1 = new FileReader("./Data/UtilityBills.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            String line = br1.readLine();
            if (line != null) {
                bills = Integer.parseInt(line);
            }
            br1.close();
        } catch (Exception e) {
        }

        // Read mess information from file
        try {
            FileReader fr2 = new FileReader("./Data/NewMessInfo.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            String messNameLine, monthLine, numberOfPeopleLine;

            while ((messNameLine = br2.readLine()) != null &&
                    (monthLine = br2.readLine()) != null &&
                    (numberOfPeopleLine = br2.readLine()) != null) {
                messName = messNameLine;
                month = monthLine;
                numberOfPeople = Integer.parseInt(numberOfPeopleLine);
            }
            br2.close();
        } catch (Exception a) {
        }

        p1 = new JPanel();
        p1.setSize(new Dimension(1000, 700));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        // Load and set images
        ImageIcon picture = new ImageIcon(
                new ImageIcon("./Images/pic4.png").getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT));
        imageLabel = new JLabel();
        imageLabel.setBounds(600, 153, 200, 120);
        imageLabel.setIcon(picture);
        imageLabel.setLayout(null);
        imageLabel.setOpaque(true);
        p1.add(imageLabel);

        ImageIcon logo = new ImageIcon(
                new ImageIcon("./Images/logo.png").getImage().getScaledInstance(40, 60,
                        Image.SCALE_DEFAULT));
        sidelogo = new JLabel();
        sidelogo.setBounds(125, 50, 40, 60);
        sidelogo.setIcon(logo);
        sidelogo.setLayout(null);
        sidelogo.setOpaque(true);
        p1.add(sidelogo);

        // Set up labels and text fields
        label_1 = new JLabel("Add participant's ");
        label_1.setForeground(Color.gray);
        label_1.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
        label_1.setBounds(125, 100, 350, 30);
        label_1.setLayout(null);
        p1.add(label_1);

        label1_1 = new JLabel("info");
        label1_1.setForeground(Color.gray);
        label1_1.setFont(new Font("Maiandra GD", Font.BOLD, 40));
        label1_1.setBounds(125, 120, 350, 45);
        label1_1.setLayout(null);
        p1.add(label1_1);

        label_2 = new JLabel("Enter participant's name");
        label_2.setForeground(Color.gray);
        label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_2.setBounds(125, 190, 350, 25);
        label_2.setLayout(null);
        p1.add(label_2);

        nameField = new JTextField();
        nameField.setBounds(125, 213, 250, 25);
        nameField.setBackground(Color.white);
        nameField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        nameField.setLayout(null);
        p1.add(nameField);

        label_3 = new JLabel("Enter 1st term bazar cost");
        label_3.setForeground(Color.gray);
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_3.setBounds(125, 238, 350, 25);
        label_3.setLayout(null);
        p1.add(label_3);

        bazar1Field = new JTextField();
        bazar1Field.setBounds(125, 261, 250, 25);
        bazar1Field.setBackground(Color.white);
        bazar1Field.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        bazar1Field.setLayout(null);
        p1.add(bazar1Field);

        label_4 = new JLabel("Enter 2nd term bazar cost");
        label_4.setForeground(Color.gray);
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_4.setBounds(125, 286, 350, 25);
        label_4.setLayout(null);
        p1.add(label_4);

        bazar2Field = new JTextField();
        bazar2Field.setBounds(125, 309, 250, 25);
        bazar2Field.setBackground(Color.white);
        bazar2Field.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        bazar2Field.setLayout(null);
        p1.add(bazar2Field);

        label_5 = new JLabel("Enter 3rd term bazar cost");
        label_5.setForeground(Color.gray);
        label_5.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_5.setBounds(125, 334, 350, 25);
        label_5.setLayout(null);
        p1.add(label_5);

        bazar3Field = new JTextField();
        bazar3Field.setBounds(125, 357, 250, 25);
        bazar3Field.setBackground(Color.white);
        bazar3Field.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        bazar3Field.setLayout(null);
        p1.add(bazar3Field);

        label_7 = new JLabel("Total meal Consumption");
        label_7.setForeground(Color.gray);
        label_7.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_7.setBounds(125, 382, 350, 25);
        label_7.setLayout(null);
        p1.add(label_7);

        mealCountField = new JTextField();
        mealCountField.setBounds(125, 405, 250, 25);
        mealCountField.setBackground(Color.white);
        mealCountField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        mealCountField.setLayout(null);
        p1.add(mealCountField);

        label_8 = new JLabel("Additional cost");
        label_8.setForeground(Color.gray);
        label_8.setFont(new Font("Maiandra GD", Font.PLAIN, 12));
        label_8.setBounds(125, 430, 350, 25);
        label_8.setLayout(null);
        p1.add(label_8);

        additionalCostField = new JTextField();
        additionalCostField.setBounds(125, 453, 250, 25);
        additionalCostField.setBackground(Color.white);
        additionalCostField.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
        additionalCostField.setLayout(null);
        p1.add(additionalCostField);

        // Create and add left side buttons
        add = new JButton("Add");
        add.setBackground(new Color(0x60A7CE));
        add.setForeground(Color.white);
        add.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        add.setBounds(263, 516, 110, 30);
        add.setFocusable(false);
        add.addActionListener(this);
        p1.add(add);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(new Color(0x60A7CE));
        cancel.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        cancel.setBounds(125, 516, 110, 30);
        cancel.setFocusable(false);
        cancel.addActionListener(this);
        p1.add(cancel);

        // Set up labels and non editable text fields retrived from file
        designlabel = new JLabel("___________________");
        designlabel.setForeground(new Color(0xD4D2D2));
        designlabel.setFont(new Font("Maiandra GD", Font.BOLD, 40));
        designlabel.setBounds(500, 216, 470, 45);
        designlabel.setLayout(null);
        p1.add(designlabel);

        label_9 = new JLabel("Mess name :");
        label_9.setForeground(new Color(0x266196));
        label_9.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_9.setBounds(500, 280, 200, 25);
        label_9.setLayout(null);
        p1.add(label_9);

        messNameField = new JTextField();
        messNameField.setText(messName);
        messNameField.setBounds(680, 280, 226, 25);
        messNameField.setBackground(Color.white);
        messNameField.setForeground(Color.gray);
        messNameField.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        messNameField.setEditable(false);
        messNameField.setLayout(null);
        p1.add(messNameField);

        label_10 = new JLabel("Month :");
        label_10.setForeground(new Color(0x266196));
        label_10.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_10.setBounds(500, 310, 350, 25);
        label_10.setLayout(null);
        p1.add(label_10);

        monthField = new JTextField();
        monthField.setText(month);
        monthField.setBounds(680, 310, 226, 25);
        monthField.setBackground(Color.white);
        monthField.setForeground(Color.gray);
        monthField.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        monthField.setEditable(false);
        monthField.setLayout(null);
        p1.add(monthField);

        label_11 = new JLabel("Utilities Bill :");
        label_11.setForeground(new Color(0x266196));
        label_11.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_11.setBounds(500, 340, 350, 25);
        label_11.setLayout(null);
        p1.add(label_11);

        uBillsField = new JTextField();
        uBillsField.setText(Float.toString(bills));
        uBillsField.setBounds(680, 342, 226, 25);
        uBillsField.setBackground(Color.white);
        uBillsField.setForeground(Color.gray);
        uBillsField.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        uBillsField.setEditable(false);
        uBillsField.setLayout(null);
        p1.add(uBillsField);

        label_12 = new JLabel("Total Member :");
        label_12.setForeground(new Color(0x266196));
        label_12.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
        label_12.setBounds(500, 370, 350, 25);
        label_12.setLayout(null);
        p1.add(label_12);

        memberField = new JTextField();
        memberField.setText(Integer.toString(numberOfPeople));
        memberField.setBounds(680, 372, 226, 25);
        memberField.setBackground(Color.white);
        memberField.setForeground(Color.gray);
        memberField.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        memberField.setEditable(false);
        memberField.setLayout(null);
        p1.add(memberField);

        // Create and add right side buttons
        calculateButton = new JButton("Calculate Now");
        calculateButton.setForeground(Color.white);
        calculateButton.setBackground(new Color(0x60A7CE));
        calculateButton.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        calculateButton.setBounds(710, 424, 155, 30);
        calculateButton.setFocusable(false);
        calculateButton.addActionListener(this);
        p1.add(calculateButton);

        showMembersButton = new JButton("Show Members");
        showMembersButton.setBackground(Color.white);
        showMembersButton.setForeground(new Color(0x60A7CE));
        showMembersButton.setFont(new Font("Footlight MT Light", Font.PLAIN, 18));
        showMembersButton.setBounds(540, 424, 155, 30);
        showMembersButton.setFocusable(false);
        showMembersButton.addActionListener(this);
        p1.add(showMembersButton);

        // Set properties for the JFrame
        this.setTitle("");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(p1);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            // Check if 'Name' and 'Number of meal consumption' are empty
            if (nameField.getText().isEmpty() && mealCountField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(AddParticipant.this,
                        "'Name' and 'Number of meal consumption' can not be empty.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if name field is empty
            }

            // Set empty bazar fields to "0"
            if (bazar1Field.getText().isEmpty()) {
                bazar1Field.setText("0");
            }
            if (bazar2Field.getText().isEmpty()) {
                bazar2Field.setText("0");
            }
            if (bazar3Field.getText().isEmpty()) {
                bazar3Field.setText("0");
            }
            if (additionalCostField.getText().isEmpty()) {
                additionalCostField.setText("0");
            }

            if (count < numberOfPeople) {
                try {
                    // Parse input values and add member details
                    name = nameField.getText();
                    bazar1 = Integer.parseInt(bazar1Field.getText());
                    bazar2 = Integer.parseInt(bazar2Field.getText());
                    bazar3 = Integer.parseInt(bazar3Field.getText());
                    mealCount = Integer.parseInt(mealCountField.getText());
                    additionalCost = Integer.parseInt(additionalCostField.getText());
                    personalBazar = bazar1 + bazar2 + bazar3;

                    // Create a new MemberDetails object and add it to the list
                    MemberDetails member = new MemberDetails(name, bazar1, bazar2, bazar3,
                            personalBazar, mealCount, additionalCost);
                    memberDetailsList.add(member);

                    // Clear input fields for the next entry
                    nameField.setText("");
                    bazar1Field.setText("");
                    bazar2Field.setText("");
                    bazar3Field.setText("");
                    mealCountField.setText("");
                    additionalCostField.setText("");

                    // Update total bazar and total meal counts
                    totalBazar += member.getPersonalBazar();
                    totalMeal += member.getMealCount();
                    // per meal calculated and rounded to 3 decimal point
                    perMeal = Math.ceil((totalBazar / totalMeal) * Math.pow(10, 3)) / Math.pow(10, 3);
                    count++;

                } catch (Exception ea) {
                    JOptionPane.showMessageDialog(AddParticipant.this, "Please enter data properly.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(AddParticipant.this, "You can not add more member.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            try {
                // add combined totals in a file
                totaldata = new FileWriter("./Data/Totals.txt");
                totaldata.write(totalBazar + "\n" + totalMeal + "\n" + perMeal);
                totaldata.close();

            } catch (Exception a) {
            }
        }

        else if (e.getSource() == cancel) {

            // clear objects and make totals '0'
            memberDetailsList.clear();
            totalBazar = 0;
            totalMeal = 0;
            count = 0;
            dispose();
            HomePage h1 = new HomePage();
            h1.setVisible(true);

        } else if (e.getSource() == showMembersButton) {
            // Check if the member details list is empty
            if (memberDetailsList.isEmpty()) {
                // Show a message dialog if no members have been added yet
                JOptionPane.showMessageDialog(AddParticipant.this, "No members added yet.", "Info",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Create a custom dialog to display member details
                JDialog customDialog = new JDialog(AddParticipant.this, "Member Details", true);
                customDialog.setSize(800, 400);
                customDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                customDialog.setLocationRelativeTo(AddParticipant.this);

                JTextArea textArea = new JTextArea();
                textArea.setEditable(false); // Make it non-editable
                textArea.setFont(new Font("Maiandra GD", Font.PLAIN, 14));

                // Append each member's details to the text area
                for (MemberDetails member : memberDetailsList) {
                    textArea.append("Name: " + member.getName() + "\n");
                    textArea.append("1st Term: " + member.getBazar1() + " TK\n");
                    textArea.append("2nd Term: " + member.getBazar2() + " TK\n");
                    textArea.append("3rd Term: " + member.getBazar3() + " TK\n");
                    textArea.append("Total Personal Bazar: " + member.getPersonalBazar() + " TK\n");
                    textArea.append("Meal Consumption: " + member.getMealCount() + "\n");
                    textArea.append("Additional Cost: " + member.getAdditionalCost() + "\n\n");
                }
                // Add a scroll pane to the dialog to allow scrolling through the text area
                JScrollPane scrollPane = new JScrollPane(textArea);
                customDialog.add(scrollPane);
                customDialog.setVisible(true);
            }
        } else if (e.getSource() == calculateButton) {
            if (numberOfPeople == count) {
                try {
                    FileReader fr = new FileReader("./Data/Totals.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line1, line2, line3;

                    while ((line1 = br.readLine()) != null &&
                            (line2 = br.readLine()) != null &&
                            (line3 = br.readLine()) != null) {

                        totalBazar = Float.parseFloat(line1);
                        totalMeal = Integer.parseInt(line2);
                        perMeal = Float.parseFloat(line3);
                    }

                    br.close();
                } catch (Exception a) {
                }

                // final calculations and write every members' detail to a txt file
                try {
                    bazardata = new FileWriter("./Data/IndividualCalculatedData.txt");
                    for (MemberDetails m : memberDetailsList) {
                        consumedFood = Math.ceil((m.getMealCount() * perMeal) * Math.pow(10, 3)) / Math.pow(10, 3);
                        personalBills = bills / numberOfPeople;
                        netCost = Math.round(-personalBills - m.getAdditionalCost()
                                + (m.getPersonalBazar() - (m.getMealCount() * perMeal)));
                        bazardata.write("Individual Calculated Details :\n");
                        bazardata.write("Name                   : " + m.getName() + "\n");
                        bazardata.write("Total Bazar            : " + m.getPersonalBazar() + " TK\n");
                        bazardata.write("Total meal consumed    : " + m.getMealCount() + "\n");
                        bazardata.write("Total food consumed of : " + consumedFood + " TK\n");
                        bazardata.write("Utility BIlls          : " + personalBills + " TK\n");
                        bazardata.write("Additional Cost        : " + m.getAdditionalCost() + " TK\n");
                        bazardata.write("Net cost of this month : " + netCost + " TK\n");
                        if (netCost > 0) {
                            bazardata.write("Will get " + netCost + " TK (rounded)\n");
                        } else {
                            bazardata.write("Have to pay " + (-netCost) + " TK (rounded)\n");
                        }
                        bazardata.write("\n");
                    }
                    bazardata.close();

                } catch (Exception a) {
                }
                dispose();
                new ShowFinalCalculation();

            } else {
                // remaining members' warning dialogue box
                JOptionPane.showMessageDialog(AddParticipant.this,
                        "Please add " + (numberOfPeople - count) + " more member(s)",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}