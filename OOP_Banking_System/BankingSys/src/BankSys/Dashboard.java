package BankSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private double balance = 0.0;  // Initialize balance
    private JLabel balanceLabel;
    private DefaultListModel<String> transactionListModel;
    private JList<String> transactionList;
    private JButton depositButton;
    private JButton withdrawButton;
    private JPanel panel;
    private JLabel lblNewLabel;

    public Dashboard() {
        // Set up the frame
        setTitle("Dashboard");
        setSize(719, 637);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Initialize components
        balanceLabel = new JLabel("Current Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
        balanceLabel.setBounds(23, 108, 181, 16);
        transactionListModel = new DefaultListModel<>();
        transactionList = new JList<>(transactionListModel);
        JScrollPane scrollPane = new JScrollPane(transactionList);
        scrollPane.setBounds(20, 135, 673, 290);
        depositButton = new JButton("Deposit");
        depositButton.setBounds(20, 438, 290, 47);
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(372, 525, 290, 47);

        // Add components to the frame
        getContentPane().add(balanceLabel);
        getContentPane().add(scrollPane);
        getContentPane().add(depositButton);
        getContentPane().add(withdrawButton);
        
        panel = new JPanel();
        panel.setBackground(new Color(230, 230, 250));
        panel.setBounds(0, 0, 703, 71);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        lblNewLabel = new JLabel("Bibo.");
        lblNewLabel.setBounds(22, 23, 97, 37);
        lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 30));
        panel.add(lblNewLabel);

        // Add action listeners to buttons
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform deposit action
                double amount = getAmount();
                deposit(amount);
                // Update transaction list
                transactionListModel.addElement(String.format("Deposit: $%.2f", amount));
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform withdrawal action
                double amount = getAmount();
                if (withdraw(amount)) {
                    // Update transaction list
                    transactionListModel.addElement(String.format("Withdrawal: $%.2f", amount));
                } else {
                    // Show insufficient balance message
                    JOptionPane.showMessageDialog(Dashboard.this, "Insufficient balance", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    private double getAmount() {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(this, "Enter amount:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    private void deposit(double amount) {
        balance += amount;
        updateBalanceLabel();
    }

    private boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            updateBalanceLabel();
            return true;
        }
        return false;
    }

    private void updateBalanceLabel() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
