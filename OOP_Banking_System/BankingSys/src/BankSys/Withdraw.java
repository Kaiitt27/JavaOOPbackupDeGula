package BankSys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Withdraw extends JFrame {
    private double currentBalance = 1000.0; // Example starting balance
    private JLabel balanceLabel;
    private JTextField withdrawField;
    private JButton withdrawButton;
    private JLabel messageLabel;
    private JPanel panel;

    public Withdraw() {
        getContentPane().setBackground(new Color(255, 255, 240));
        // Setting up the frame
        setTitle("Withdraw Money");
        setSize(675, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Balance label
        balanceLabel = new JLabel("Current Balance: $" + currentBalance);
        balanceLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
        balanceLabel.setBounds(457, 23, 176, 25);
        getContentPane().add(balanceLabel);

        panel = new JPanel();
        panel.setBounds(51, 59, 564, 467);
        getContentPane().add(panel);
        panel.setLayout(null);

        // Withdraw amount label
        JLabel withdrawLabel = new JLabel("Enter amount to withdraw:");
        withdrawLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
        withdrawLabel.setBounds(52, 179, 310, 25);
        panel.add(withdrawLabel);

        // Withdraw amount text field
        withdrawField = new JTextField();
        withdrawField.setBounds(52, 215, 410, 44);
        panel.add(withdrawField);

        // Withdraw button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(52, 391, 217, 44);
        panel.add(withdrawButton);

        // Message label
        messageLabel = new JLabel("");
        messageLabel.setBackground(new Color(238, 232, 170));
        messageLabel.setBounds(52, 300, 350, 25);
        panel.add(messageLabel);

        // Button action listener
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleWithdraw();
            }
        });
    }

    private void handleWithdraw() {
        try {
            double withdrawAmount = Double.parseDouble(withdrawField.getText());

            if (withdrawAmount <= 0) {
                messageLabel.setText("Enter a positive amount.");
            } else if (withdrawAmount > currentBalance) {
                messageLabel.setText("Insufficient balance.");
            } else {
                currentBalance -= withdrawAmount;
                balanceLabel.setText("Current Balance: $" + currentBalance);
                messageLabel.setText("Withdrawal successful!");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Withdraw().setVisible(true);
            }
        });
    }
}
