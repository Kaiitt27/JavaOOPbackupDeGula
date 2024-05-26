package BankSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deposit extends JFrame {

    private JLabel balanceLabel;
    private JTextField depositField;
    private JButton depositButton;
    private double balance;

    public deposit() {
    	getContentPane().setBackground(new Color(255, 255, 240));
        // Initialize the frame
        setTitle("Deposit Frame");
        setSize(676, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the balance with the initial deposit
        balance = 500.0;
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(50, 60, 580, 450);
        getContentPane().add(panel);
        panel.setLayout(null);
        JLabel label = new JLabel("Deposit Amount:");
        label.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
        label.setBounds(51, 166, 188, 31);
        panel.add(label);
        depositField = new JTextField(10);
        depositField.setBounds(51, 208, 484, 40);
        panel.add(depositField);
        depositButton = new JButton("Deposit");
        depositButton.setBounds(51, 378, 236, 40);
        panel.add(depositButton);
                
                JButton cancelbtn = new JButton("Cancel");
                cancelbtn.setBounds(297, 378, 236, 40);
                panel.add(cancelbtn);
                
                        // Create components
                        balanceLabel = new JLabel("Current Balance: $" + balance);
                        balanceLabel.setBounds(474, 24, 156, 14);
                        getContentPane().add(balanceLabel);
                        balanceLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 13));

        // Add action listener to the deposit button
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositText = depositField.getText();
                try {
                    double depositAmount = Double.parseDouble(depositText);
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        balanceLabel.setText("Current Balance: $" + balance);
                        depositField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new deposit().setVisible(true);
            }
        });
    }
}
