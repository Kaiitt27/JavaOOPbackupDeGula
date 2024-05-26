package BankSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernametxt;
	private JPasswordField passtxt;
	private JPasswordField confirmpasstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 659, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(328, 0, 331, 561);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Sign Up");
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 50));
		lblNewLabel_2.setBounds(59, 168, 230, 82);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_2);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(41, 194, 217, 20);
		panel.add(usernametxt);
		usernametxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblNewLabel.setBounds(41, 175, 109, 14);
		panel.add(lblNewLabel);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(41, 253, 217, 20);
		panel.add(passtxt);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblNewLabel_1.setBounds(41, 236, 73, 14);
		panel.add(lblNewLabel_1);
		
		confirmpasstxt = new JPasswordField();
		confirmpasstxt.setBounds(41, 313, 217, 20);
		panel.add(confirmpasstxt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm Password");
		lblNewLabel_1_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(41, 295, 145, 14);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(95, 394, 122, 39);
		panel.add(btnNewButton);
	
	}
	public void actionPerformed(ActionEvent e, Object SignIn) {
        if (e.getSource() == SignIn) {
            String username = usernametxt.getText();
            @SuppressWarnings("deprecation")
            String password = passtxt.getText();
            @SuppressWarnings("deprecation")
            String confirmpassword = confirmpasstxt.getText();

            // Add login logic here
            if (password.equals(confirmpassword)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Proceed with the login process
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
            }
        } else if (e.getSource() == reset) {
            usernametxt.setText("");
            passtxt.setText("");
            confirmpasstxt.setText("");
        }
    }

    public static void main(String[] args) {
        // Set up the frame
        SignupExample frame = new SignupExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
	    

}
