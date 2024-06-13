package MyClasses;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Year;

public class ShowFinalCalculation extends JFrame implements ActionListener {

    // Declare UI components
    JLabel messNameLabel, imageLabel, monthLabel, memberLabel, Billslabel, totalBazarLabel, totalMealConsumLabel,
            perMealLabel,
            label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, lineLabel;
    ImageIcon exitImageIcon, formulaImageIcon, logOutImageIcon;
    JPanel p1;
    JTextArea detailsArea, perBillsArea;
    JButton download, logOutButton, exitButton, formulaButton;
    String messName, month;
    JComboBox<String> comboBox;
    int numberOfPeople, totalMealConsum, perPersonBills, currentYear, housRent, gas,
            water, electricity, helpingHand, dust, internet, others;
    float totalBazar, perMeal, totalbills;
    String[] individualDetailsArray, namesArray;

    // Constructor to initialize the frame and components
    public ShowFinalCalculation() {

        currentYear = Year.now().getValue();
        p1 = new JPanel();
        p1.setSize(new Dimension(1030, 715));
        p1.setBackground(Color.white);
        p1.setLayout(null);

        // Setting up the image label
        ImageIcon picture = new ImageIcon(
                new ImageIcon("./Images/pic6.png").getImage().getScaledInstance(275, 205, Image.SCALE_DEFAULT));
        imageLabel = new JLabel(picture);
        imageLabel.setBounds(390, 155, 275, 205);
        imageLabel.setLayout(null);
        p1.add(imageLabel);

        try {
            // Reading mess info from a file
            FileReader fr = new FileReader("./Data/NewMessInfo.txt");
            BufferedReader br = new BufferedReader(fr);
            String messNameLine, monthLine, numberOfPeopleLine;

            // Reading each line and storing relevant data
            while ((messNameLine = br.readLine()) != null &&
                    (monthLine = br.readLine()) != null &&
                    (numberOfPeopleLine = br.readLine()) != null) {

                messName = messNameLine;
                month = monthLine;
                numberOfPeople = Integer.parseInt(numberOfPeopleLine);
            }
            br.close();

        } catch (Exception a) {
        }

        try {
            // Reading totals from a file
            FileReader fr = new FileReader("./Data/Totals.txt");
            BufferedReader br = new BufferedReader(fr);
            String line1, line2, line3;

            // Reading each line and storing relevant data
            while ((line1 = br.readLine()) != null &&
                    (line2 = br.readLine()) != null &&
                    (line3 = br.readLine()) != null) {

                totalBazar = Float.parseFloat(line1);
                totalMealConsum = Integer.parseInt(line2);
                perMeal = Float.parseFloat(line3);
            }
            br.close();

        } catch (Exception a) {
        }

        // Setting up the mess name label
        messNameLabel = new JLabel();
        messNameLabel.setText(messName);
        messNameLabel.setBounds(0, 35, 1030, 45);
        messNameLabel.setHorizontalAlignment(JLabel.CENTER);
        messNameLabel.setVerticalAlignment(JLabel.CENTER);
        messNameLabel.setBackground(Color.white);
        messNameLabel.setForeground(new Color(0x099584));
        messNameLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
        messNameLabel.setLayout(null);
        p1.add(messNameLabel);

        // Setting up the month label
        monthLabel = new JLabel();
        monthLabel.setText(month + ", " + currentYear);
        monthLabel.setBounds(0, 77, 1030, 25);
        monthLabel.setHorizontalAlignment(JLabel.CENTER);
        monthLabel.setVerticalAlignment(JLabel.CENTER);
        monthLabel.setBackground(Color.white);
        monthLabel.setForeground(Color.gray);
        monthLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        monthLabel.setLayout(null);
        p1.add(monthLabel);

        try {
            // Reading individual calculated data from a file
            FileReader fr = new FileReader("./Data/IndividualCalculatedData.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            namesArray = new String[numberOfPeople];
            int namesindex = 0;
            int detailsindex = 0;

            // Reading each line and storing names
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name")) {
                    // Extract and store the name from the line
                    String name = line.substring(line.indexOf(":") + 1).trim();
                    namesArray[namesindex] = name;
                    namesindex++;
                }
            }
            br.close();

        } catch (Exception a) {
        }

        try {
            // Reading individual calculated data from a file
            FileReader fr = new FileReader("./Data/IndividualCalculatedData.txt");
            BufferedReader br = new BufferedReader(fr);
            String detailline;
            individualDetailsArray = new String[numberOfPeople];
            int namesindex = 0;
            int detailsindex = 0;

            // Reading each line and storing details for each individual
            while ((detailline = br.readLine()) != null) {
                if (detailline.equals("Individual Calculated Details :")) {
                    // Append the next 8 lines to form a complete set of details for an individual
                    StringBuilder details = new StringBuilder();
                    for (int i = 0; i < 8; i++) {
                        details.append(br.readLine()).append("\n");
                    }
                    individualDetailsArray[detailsindex] = details.toString();
                    details.setLength(0); // Clear the StringBuilder for the next individual
                    detailsindex++;

                }
            }
            br.close();

        } catch (Exception a) {
        }

        // Setting up the details area
        detailsArea = new JTextArea();
        detailsArea.setBounds(75, 218, 330, 145);
        detailsArea.setForeground(Color.gray);
        detailsArea.setFont(new Font("Courier New", Font.PLAIN, 15));
        detailsArea.setEditable(false);
        p1.add(detailsArea);

        label_7 = new JLabel();
        label_7.setText("Tap on drop-down menu for individual details");
        label_7.setBounds(75, 155, 300, 18);
        label_7.setForeground(new Color(0x266196));
        label_7.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        label_7.setLayout(null);
        p1.add(label_7);

        // Setting up the combo box for names
        comboBox = new JComboBox<>(namesArray);
        comboBox.setBounds(103, 178, 200, 30);
        p1.add(comboBox);
        comboBox.setSelectedIndex(0); // selected index will be shown default without pressing on comboBox
        comboBox.addActionListener(this);
        comboBox.setFont(new Font("Maiandra GD", Font.PLAIN, 16));
        comboBox.setForeground(Color.gray);
        comboBox.setBackground(Color.white);
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(0x8FC1DD), 5));
        actionPerformed(new ActionEvent(comboBox, ActionEvent.ACTION_PERFORMED, null));

        try {
            // Reading utility bills data from a file
            FileReader fr = new FileReader("./Data/UtilityBills.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            // Reading each line and storing relevant data
            line = br.readLine();
            totalbills = Integer.parseInt(line);
            line = br.readLine();
            housRent = Integer.parseInt(line);
            line = br.readLine();
            gas = Integer.parseInt(line);
            line = br.readLine();
            water = Integer.parseInt(line);
            line = br.readLine();
            electricity = Integer.parseInt(line);
            line = br.readLine();
            helpingHand = Integer.parseInt(line);
            line = br.readLine();
            dust = Integer.parseInt(line);
            line = br.readLine();
            internet = Integer.parseInt(line);
            line = br.readLine();
            others = Integer.parseInt(line);
            br.close();
        } catch (Exception a) {
        }

        // Setting up the label
        label_6 = new JLabel("Combined Details of Mess");
        label_6.setBounds(725, 158, 170, 20);
        label_6.setOpaque(true); // Set the label to be opaque
        label_6.setBackground(new Color(0x8FC1DD));
        label_6.setForeground(Color.white);
        label_6.setHorizontalAlignment(JLabel.CENTER);
        label_6.setVerticalAlignment(JLabel.CENTER);
        label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        label_6.setLayout(null);
        p1.add(label_6);

        label_2 = new JLabel("Total Member ");
        label_2.setForeground(new Color(0x266196));
        label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        label_2.setBounds(725, 180, 250, 25);
        label_2.setLayout(null);
        p1.add(label_2);

        memberLabel = new JLabel();
        memberLabel.setText(" : " + Integer.toString(numberOfPeople));
        memberLabel.setBounds(865, 180, 250, 25);
        memberLabel.setBackground(Color.white);
        memberLabel.setForeground(Color.gray);
        memberLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        memberLabel.setLayout(null);
        p1.add(memberLabel);

        label_3 = new JLabel("Total Bazar ");
        label_3.setForeground(new Color(0x266196));
        label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        label_3.setBounds(725, 205, 250, 25);
        label_3.setLayout(null);
        p1.add(label_3);

        totalBazarLabel = new JLabel();
        totalBazarLabel.setText(" : " + Float.toString(totalBazar) + " TK");
        totalBazarLabel.setBounds(865, 205, 250, 25);
        totalBazarLabel.setBackground(Color.white);
        totalBazarLabel.setForeground(Color.gray);
        totalBazarLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        totalBazarLabel.setLayout(null);
        p1.add(totalBazarLabel);

        label_4 = new JLabel("Meal Consumed ");
        label_4.setForeground(new Color(0x266196));
        label_4.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        label_4.setBounds(725, 230, 250, 25);
        label_4.setLayout(null);
        p1.add(label_4);

        totalMealConsumLabel = new JLabel();
        totalMealConsumLabel.setText(" : " + Integer.toString(totalMealConsum));
        totalMealConsumLabel.setBounds(865, 230, 250, 25);
        totalMealConsumLabel.setBackground(Color.white);
        totalMealConsumLabel.setForeground(Color.gray);
        totalMealConsumLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        totalMealConsumLabel.setLayout(null);
        p1.add(totalMealConsumLabel);

        label_5 = new JLabel("Per Meal Cost ");
        label_5.setForeground(new Color(0x266196));
        label_5.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        label_5.setBounds(725, 255, 250, 25);
        label_5.setLayout(null);
        p1.add(label_5);

        perMealLabel = new JLabel();
        perMealLabel.setText(" : " + Float.toString(perMeal) + " TK");
        perMealLabel.setBounds(865, 255, 250, 25);
        perMealLabel.setBackground(Color.white);
        perMealLabel.setForeground(Color.gray);
        perMealLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        perMealLabel.setLayout(null);
        p1.add(perMealLabel);

        label_1 = new JLabel("Total Utility Bills ");
        label_1.setForeground(new Color(0x266196));
        label_1.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        label_1.setBounds(725, 280, 250, 25);
        label_1.setLayout(null);
        p1.add(label_1);

        Billslabel = new JLabel();
        Billslabel.setText(" : " + Float.toString(totalbills) + " TK");
        Billslabel.setBounds(865, 280, 250, 25);
        Billslabel.setBackground(Color.white);
        Billslabel.setForeground(Color.gray);
        Billslabel.setFont(new Font("Maiandra GD", Font.PLAIN, 18));
        Billslabel.setLayout(null);
        p1.add(Billslabel);

        label_6 = new JLabel("Per person Utility Bills");
        label_6.setBounds(725, 315, 170, 20);
        label_6.setOpaque(true); // Set the label to be opaque
        label_6.setBackground(new Color(0xB0B0B0));
        label_6.setForeground(Color.white);
        label_6.setHorizontalAlignment(JLabel.CENTER);
        label_6.setVerticalAlignment(JLabel.CENTER);
        label_6.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        Billslabel.setLayout(null);
        p1.add(label_6);

        perBillsArea = new JTextArea();
        perBillsArea.setText("House rent   : " + (housRent / numberOfPeople) + "\n" +
                "Gas          : " + (gas / numberOfPeople) + "\n" +
                "Water        : " + (water / numberOfPeople) + "\n" +
                "Electricity  : " + (electricity / numberOfPeople) + "\n" +
                "Helping Hand : " + (helpingHand / numberOfPeople) + "\n" +
                "Dust         : " + (dust / numberOfPeople) + "\n" +
                "Internet     : " + (internet / numberOfPeople) + "\n" +
                "Others       : " + (others / numberOfPeople) + "\n" +
                "Total        : " + (totalbills / numberOfPeople));
        perBillsArea.setBounds(725, 340, 180, 200);
        perBillsArea.setForeground(Color.gray);
        perBillsArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        perBillsArea.setEditable(false);
        p1.add(perBillsArea);

        // button and associated levels
        label_7 = new JLabel();
        label_7.setText("Download the whole details on your device");
        label_7.setBounds(75, 413, 300, 18);
        label_7.setForeground(new Color(0x266196));
        label_7.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        label_7.setLayout(null);
        p1.add(label_7);

        download = new JButton("Download");
        download.setForeground(Color.white);
        download.setBackground(new Color(0x8FC1DD));
        download.setFont(new Font("Maiandra GD", Font.BOLD, 15));
        download.setBounds(103, 435, 200, 30);
        download.setFocusable(false);
        download.addActionListener(this);
        p1.add(download);

        ImageIcon logOutImageIcon = new ImageIcon(
                new ImageIcon("./Images/logOut.png").getImage().getScaledInstance(68, 68,
                        Image.SCALE_SMOOTH));
        logOutButton = new JButton(logOutImageIcon);
        logOutButton.setBounds(387, 560, 68, 68);
        logOutButton.setLayout(null);
        logOutButton.setFocusable(false);
        logOutButton.setBorderPainted(false);
        logOutButton.addActionListener(this);
        p1.add(logOutButton);

        label_8 = new JLabel();
        label_8.setText("Log out");
        label_8.setBounds(398, 628, 50, 18);
        label_8.setForeground(Color.gray);
        label_8.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        label_8.setLayout(null);
        p1.add(label_8);

        formulaImageIcon = new ImageIcon(
                new ImageIcon("./Images/questionPic.png").getImage().getScaledInstance(90, 72,
                        Image.SCALE_SMOOTH));
        formulaButton = new JButton(formulaImageIcon);
        formulaButton.setBounds(487, 554, 90, 72);
        formulaButton.setLayout(null);
        formulaButton.setFocusable(false);
        formulaButton.setBorderPainted(false);
        formulaButton.addActionListener(this);
        p1.add(formulaButton);

        label_9 = new JLabel();
        label_9.setText("Formulas");
        label_9.setBounds(508, 628, 54, 18);
        label_9.setForeground(Color.gray);
        label_9.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        label_9.setLayout(null);
        p1.add(label_9);

        ImageIcon exitImageIcon = new ImageIcon(
                new ImageIcon("./Images/exit.png").getImage().getScaledInstance(63, 63, Image.SCALE_SMOOTH));
        exitButton = new JButton(exitImageIcon);
        exitButton.setBounds(605, 564, 63, 63);
        exitButton.setLayout(null);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(this);
        p1.add(exitButton);

        label_10 = new JLabel();
        label_10.setText("Exit");
        label_10.setBounds(626, 628, 50, 18);
        label_10.setForeground(Color.gray);
        label_10.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
        label_10.setLayout(null);
        p1.add(label_10);

        this.setTitle("");
        this.setSize(1030, 715);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(p1);
    }

    // custom dialogue box and its levels, buttons
    private static void showCustomDialog(JFrame parent) {
        JDialog customDialog = new JDialog(parent, "Formulas", true);
        customDialog.setSize(800, 400);
        customDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        customDialog.setLocationRelativeTo(parent);

        // Add your custom components to the dialog
        JLabel diaLogueLabel_1 = new JLabel("How it works?");
        diaLogueLabel_1.setBounds(0, 20, 780, 30);
        diaLogueLabel_1.setOpaque(true); // Set the label to be opaque
        diaLogueLabel_1.setForeground(Color.gray);
        diaLogueLabel_1.setHorizontalAlignment(JLabel.CENTER);
        diaLogueLabel_1.setVerticalAlignment(JLabel.CENTER);
        diaLogueLabel_1.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        diaLogueLabel_1.setLayout(null);
        customDialog.add(diaLogueLabel_1);

        JLabel diaLogueLabel_2 = new JLabel(
                "Per person utility bill = Total utility bill divided by Total member of this mess");
        diaLogueLabel_2.setBounds(50, 95, 690, 21);
        diaLogueLabel_2.setOpaque(true); // Set the label to be opaque
        diaLogueLabel_2.setBackground(new Color(0x8FC1DD));
        diaLogueLabel_2.setForeground(Color.white);
        diaLogueLabel_2.setHorizontalAlignment(JLabel.CENTER);
        diaLogueLabel_2.setVerticalAlignment(JLabel.CENTER);
        diaLogueLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 18));
        diaLogueLabel_2.setLayout(null);
        customDialog.add(diaLogueLabel_2);

        JLabel diaLogueLabel_3 = new JLabel(
                "Per meal =Total bazar cost divided by Total meal consumption of mess");
        diaLogueLabel_3.setBounds(50, 122, 690, 21);
        diaLogueLabel_3.setOpaque(true); // Set the label to be opaque
        diaLogueLabel_3.setBackground(new Color(0x8FC1DD));
        diaLogueLabel_3.setForeground(Color.white);
        diaLogueLabel_3.setHorizontalAlignment(JLabel.CENTER);
        diaLogueLabel_3.setVerticalAlignment(JLabel.CENTER);
        diaLogueLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 18));
        diaLogueLabel_3.setLayout(null);
        customDialog.add(diaLogueLabel_3);

        JLabel diaLogueLabel_4 = new JLabel(
                "Total food cost = Per meal rate multiplied by his/her total meal consumption");
        diaLogueLabel_4.setBounds(50, 149, 690, 21);
        diaLogueLabel_4.setOpaque(true); // Set the label to be opaque
        diaLogueLabel_4.setBackground(new Color(0x8FC1DD));
        diaLogueLabel_4.setForeground(Color.white);
        diaLogueLabel_4.setHorizontalAlignment(JLabel.CENTER);
        diaLogueLabel_4.setVerticalAlignment(JLabel.CENTER);
        diaLogueLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 18));
        diaLogueLabel_4.setLayout(null);
        customDialog.add(diaLogueLabel_4);

        JLabel diaLogueLabel_5 = new JLabel(
                "Net cost = his/her: (Total Bazar cost- Total food cost) + Utility Bills + additional cost");
        diaLogueLabel_5.setBounds(50, 176, 690, 21);
        diaLogueLabel_5.setOpaque(true); // Set the label to be opaque
        diaLogueLabel_5.setBackground(new Color(0x8FC1DD));
        diaLogueLabel_5.setForeground(Color.white);
        diaLogueLabel_5.setHorizontalAlignment(JLabel.CENTER);
        diaLogueLabel_5.setVerticalAlignment(JLabel.CENTER);
        diaLogueLabel_5.setFont(new Font("Maiandra GD", Font.BOLD, 16));
        diaLogueLabel_5.setLayout(null);
        customDialog.add(diaLogueLabel_5);

        JButton closeButton = new JButton("Close");
        closeButton.setForeground(Color.white);
        closeButton.setBackground(Color.gray);
        closeButton.setFont(new Font("Maiandra GD", Font.BOLD, 16));
        closeButton.setBounds(325, 300, 150, 30);
        closeButton.setFocusable(false);
        closeButton.setLayout(null);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customDialog.dispose();
            }
        });

        customDialog.add(closeButton);
        customDialog.setLayout(null);
        customDialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            // When the comboBox selection changes
            int selectedIndex = comboBox.getSelectedIndex();
            // Check if the selected index is valid
            if (selectedIndex >= 0 && selectedIndex < individualDetailsArray.length) {
                // Display the individual details in the JTextArea
                detailsArea.setText(individualDetailsArray[selectedIndex]);
            }

        } else if (e.getSource() == download) {
            // When the download button is clicked
            // Create the file chooser with default path and file name
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new File(messName + ".txt"));
            // Set the default directory to user's home directory
            fileChooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // Check if the file already exists
                if (selectedFile.exists()) {
                    // Show a confirmation dialog if the file exists
                    int overwrite = JOptionPane.showConfirmDialog(this,
                            "A file with the same name already exists. Do you want to overwrite it?",
                            "File Already Exists", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (overwrite == JOptionPane.NO_OPTION) {
                        return; // If user chooses not to overwrite, do not proceed
                    }
                }

                try {
                    // Open input file for reading
                    FileReader fr = new FileReader("./Data/IndividualCalculatedData.txt");
                    BufferedReader br = new BufferedReader(fr);
                    // Open output file for writing
                    FileWriter fw = new FileWriter(selectedFile);
                    BufferedWriter bw = new BufferedWriter(fw);

                    String line;
                    boolean skipLine = false;
                    // Read each line from input file
                    while ((line = br.readLine()) != null) {
                        if (line.equals("Individual Calculated Details :")) {
                            skipLine = true; // Skip the line "Individual Calculated Details :"
                            continue;
                        }
                        // Write the line to the output file
                        bw.write(line);
                        bw.newLine();
                    }

                    br.close();
                    fr.close();
                    bw.close();
                    fw.close();

                    // Show confirmation dialog after successful download
                    int choice = JOptionPane.showConfirmDialog(this,
                            "Info has been downloaded successfully! Do you want to open the file?", "Open File",
                            JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        // Open the file using the default desktop application
                        Desktop.getDesktop().open(selectedFile);
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error downloading file: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        else if (e.getSource() == logOutButton) {
            dispose();
            new SignIn();
        }

        else if (e.getSource() == exitButton) {
            System.exit(0); // Exit the application
        }

        else if (e.getSource() == formulaButton) {
            showCustomDialog(this); // Show the custom dialog with formulas
        }
    }
}
