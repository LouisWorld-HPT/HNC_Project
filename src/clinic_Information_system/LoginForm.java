package clinic_Information_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("____System has Started____");
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\letter-a.png"));
		setTitle("Aung Clinic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1001, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Login_Cover = new JPanel();
		panel_Login_Cover.setBackground(new Color(0, 100, 159));
		panel_Login_Cover.setBounds(0, 0, 500, 454);
		contentPane.add(panel_Login_Cover);
		panel_Login_Cover.setLayout(null);
		
		JLabel lblTextDecoration = new JLabel("Aung Clinic");
		lblTextDecoration.setOpaque(true);
		lblTextDecoration.setBackground(new Color(0, 0, 0,125));
		lblTextDecoration.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblTextDecoration.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextDecoration.setForeground(new Color(255, 255, 255));
		lblTextDecoration.setBounds(50, 68, 393, 56);
		panel_Login_Cover.add(lblTextDecoration);
		
		JLabel lblNewLabel_1 = new JLabel("Your Health is Your Wealth");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Rage Italic", Font.BOLD, 30));
		lblNewLabel_1.setBounds(50, 121, 393, 56);
		panel_Login_Cover.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon("Images\\SBackGound3.jpg");
		Image OriginalImage = icon.getImage();
		Image ResizedImage = OriginalImage.getScaledInstance(500, 550, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon("Images\\Flower7.jpg"));
		lblNewLabel.setBounds(0, 0, 500, 478);
		panel_Login_Cover.add(lblNewLabel);
		
		
		
		JPanel panel_Login = new JPanel();
		panel_Login.setBackground(new Color(128, 128, 192,120));
		panel_Login.setBounds(498, 0, 500, 454);
		contentPane.add(panel_Login);
		panel_Login.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 31, 432, 380);
		panel_Login.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogin = new JLabel("Login");
		panel.add(lblLogin, BorderLayout.NORTH);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Rockwell", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(8, 104, 137, 18);
		panel_1.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Rockwell", Font.BOLD, 18));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblPassword.setBounds(8, 164, 137, 18);
		panel_1.add(lblPassword);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back !");
		lblWelcomeBack.setOpaque(true);
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setForeground(Color.WHITE);
		lblWelcomeBack.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblWelcomeBack.setBackground(new Color(0, 0, 0,100));
//		lblWelcomeBack.setBounds(19, 14, 393, 56);
		panel_1.add(lblWelcomeBack);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Rockwell", Font.BOLD, 18));
		textField.setBounds(131, 97, 281, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Rockwell", Font.BOLD, 18));
		passwordField.setBounds(131, 157, 281, 32);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login_username = textField.getText();
				char[] password = passwordField.getPassword();
				String login_password = new String(password);
				int result = Clinic_System.UserLogin(login_username,login_password);
				System.out.println("Status From system :: " + result);
				if(result != -1) {
					System.out.println("User Input was Correct");
					System.out.println("Directing to UserInterface UI...");
					System.out.println("________________________________");
					UserInterFace UI = new UserInterFace(result);
					UI.setVisible(true);
					dispose();
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "UserName or Password not found", "Error", JOptionPane.WARNING_MESSAGE);
					System.out.println("User Input was Incorrect");
					System.out.println("The system has been reset");
					System.out.println("__________________________");
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Rockwell", Font.BOLD, 17));
		btnLogin.setBounds(30, 208, 382, 39);
		btnLogin.setFocusable(false);
		panel_1.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setForeground(new Color(64, 0, 0));
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Rockwell", Font.BOLD, 17));
		btnReset.setBounds(30, 261, 382, 39);
		btnReset.setFocusable(false);
		panel_1.add(btnReset);
	}
}
