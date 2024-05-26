package BankSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private double balance = 0.0;  // Initialize balance
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;

    public Dashboard() {
        // Set up the frame
        setTitle("Dashboard");
        setSize(719, 637);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Initialize components
        balanceLabel = new JLabel("Current Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setBounds(20, 109, 167, 38);
        amountField = new JTextField(10);
        amountField.setBounds(20, 158, 673, 317);
        depositButton = new JButton("Deposit");
        depositButton.setBounds(53, 499, 290, 55);
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(372, 499, 290, 55);

        // Add components to the frame
        add(balanceLabel);
        add(amountField);
        add(depositButton);
        add(withdrawButton);

        // Add action listeners to buttons
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositForm depositForm = new DepositForm();
                depositForm.setVisible(true);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawForm withdrawForm = new WithdrawForm();
                withdrawForm.setVisible(true);
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
