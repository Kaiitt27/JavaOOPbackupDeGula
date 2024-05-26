package BankSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.border.TitledBorder;

import BankSys.Pin.PinListener;

import javax.swing.border.EtchedBorder;

public class Registration extends JFrame implements PinListener {
    private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField birthdateField;
    private JTextField addressField;
    private JTextField fatherNameField;
    private JTextField motherNameField;
    private JTextField contactNoField;
    private JTextField emailField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private String username;
    private String password;

    public Registration(String username, String password) {
		  this.username = username;
		  this.password = password;
		  createView();
    }

    private void createView() {
        //frmRegistration = new JFrame("Banking with us! Sign up for an account");
        setTitle("Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 675);
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 240));
        panel.setLayout(null);

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        lblFirstName.setBounds(85, 130, 106, 15);
        panel.add(lblFirstName);
        firstNameField = new JTextField();
        firstNameField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        firstNameField.setOpaque(false);
        firstNameField.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
        firstNameField.setBounds(10, 158, 230, 30);
        panel.add(firstNameField);

        JLabel label_4 = new JLabel("Middle Name:");
        label_4.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_4.setBounds(336, 130, 98, 15);
        panel.add(label_4);
        middleNameField = new JTextField();
        middleNameField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        middleNameField.setOpaque(false);
        middleNameField.setBounds(491, 158, 230, 30);
        panel.add(middleNameField);

        JLabel label_5 = new JLabel("Last Name:");
        label_5.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_5.setBounds(559, 130, 90, 15);
        panel.add(label_5);
        lastNameField = new JTextField();
        lastNameField.setOpaque(false);
        lastNameField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        lastNameField.setBounds(251, 158, 230, 30);
        panel.add(lastNameField);

        JLabel label_6 = new JLabel("Birthdate:");
        label_6.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_6.setBounds(50, 315, 106, 15);
        panel.add(label_6);
        birthdateField = new JTextField();
        birthdateField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        birthdateField.setOpaque(false);
        birthdateField.setBounds(166, 305, 508, 25);
        panel.add(birthdateField);

        JLabel label_7 = new JLabel("Gender:");
        label_7.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_7.setBounds(50, 261, 67, 14);
        panel.add(label_7);

        JLabel label_8 = new JLabel("Address:");
        label_8.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_8.setBounds(50, 341, 67, 15);
        panel.add(label_8);
        addressField = new JTextField();
        addressField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        addressField.setOpaque(false);
        addressField.setBounds(166, 335, 508, 25);
        panel.add(addressField);

        JLabel label_9 = new JLabel("Father Name:");
        label_9.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_9.setBounds(50, 432, 106, 15);
        panel.add(label_9);
        fatherNameField = new JTextField();
        fatherNameField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        fatherNameField.setOpaque(false);
        fatherNameField.setBounds(166, 425, 508, 25);
        panel.add(fatherNameField);

        JLabel label_10 = new JLabel("Mother Name:");
        label_10.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_10.setBounds(50, 399, 106, 20);
        panel.add(label_10);
        motherNameField = new JTextField();
        motherNameField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        motherNameField.setOpaque(false);
        motherNameField.setBounds(166, 395, 508, 25);
        panel.add(motherNameField);

        JLabel label_11 = new JLabel("Contact No:");
        label_11.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_11.setBounds(366, 261, 98, 15);
        panel.add(label_11);
        contactNoField = new JTextField();
        contactNoField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contactNoField.setOpaque(false);
        contactNoField.setBounds(468, 254, 154, 25);
        panel.add(contactNoField);

        JLabel label_12 = new JLabel("Email address:");
        label_12.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
        label_12.setBounds(50, 370, 106, 15);
        panel.add(label_12);
        emailField = new JTextField();
        emailField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        emailField.setOpaque(false);
        emailField.setBounds(166, 365, 508, 25);
        panel.add(emailField);
        JLabel label_13 = new JLabel();
        label_13.setBounds(193, 430, 188, 28);
        panel.add(label_13); // Empty label to fill the grid

        // Add the panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(panel);
                
                        JButton submitbtn = new JButton("Submit");
                        submitbtn.setBounds(559, 497, 98, 34);
                        panel.add(submitbtn);
                        submitbtn.setBorderPainted(false);
                        submitbtn.setBackground(new Color(220, 220, 220));
                        submitbtn.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
                        
                        JPanel panel_1 = new JPanel();
                        panel_1.setBackground(UIManager.getColor("Button.light"));
                        panel_1.setBounds(0, 0, 732, 82);
                        panel.add(panel_1);
                        panel_1.setLayout(null);
                        
                        JLabel lblNewLabel = new JLabel("Registration");
                        lblNewLabel.setBounds(10, 23, 201, 48);
                        panel_1.add(lblNewLabel);
                        lblNewLabel.setFont(new Font("Perpetua", Font.BOLD, 30));
                        
                        maleRadioButton = new JRadioButton("   Male");
                        maleRadioButton.setBounds(166, 255, 67, 23);
                        panel.add(maleRadioButton);

                        femaleRadioButton = new JRadioButton("  Female");
                        femaleRadioButton.setBounds(248, 255, 67, 23);
                        panel.add(femaleRadioButton);

                        genderButtonGroup = new ButtonGroup();
                        genderButtonGroup.add(maleRadioButton);
                        genderButtonGroup.add(femaleRadioButton);

                        submitbtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String firstName = firstNameField.getText();
                                String middleName = middleNameField.getText();
                                String lastName = lastNameField.getText();
                                String birthdate = birthdateField.getText();
                                String address = addressField.getText();
                                String fatherName = fatherNameField.getText();
                                String motherName = motherNameField.getText();
                                String contactNo = contactNoField.getText();
                                String email = emailField.getText();

                                // Start the Pin frame and wait for the pin confirmation
                                startPinFrame(firstName, middleName, lastName, birthdate, address, fatherName, motherName, contactNo, email);
                            }
                        });
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private String getSelectedGender() {
        if (maleRadioButton.isSelected()) {
            return "Male";
        } else if (femaleRadioButton.isSelected()) {
            return "Female";
        } else {
            return ""; // Return an empty string or handle the case where no gender is selected
        }
    }
    
    private void startPinFrame(String firstName, String middleName, String lastName, String birthdate, String address, String fatherName, String motherName, String contactNo, String email) {
        Pin pinFrame = new Pin();
        pinFrame.setPinListener(this); // Set the listener
        pinFrame.setVisible(true);
    }

    @Override
    public void pinConfirmed(String pin) {
        String firstName = firstNameField.getText();
        String middleName = middleNameField.getText();
        String lastName = lastNameField.getText();
        String birthdate = birthdateField.getText();
        String address = addressField.getText();
        String fatherName = fatherNameField.getText();
        String motherName = motherNameField.getText();
        String contactNo = contactNoField.getText();
        String email = emailField.getText();

        // Create a new Account object with the confirmed pin
        AccountManager accountManager = new AccountManager();
        Account newAccount = new Account(username, password, pin, firstName, middleName, lastName, new Date(), getSelectedGender(), address, fatherName, motherName, contactNo);
        accountManager.createAccount(newAccount);
        
        
        // Optionally, you can add code here to handle the new account creation, like storing it in a database
        JOptionPane.showMessageDialog(Registration.this, "Account created successfully!", "Account", JOptionPane.INFORMATION_MESSAGE);

        // Close the registration form
        dispose();
    }

    
    // main for testing
    /*public static void main(String[] args) {
        new Registration("user", "pass");
    }*/
}
