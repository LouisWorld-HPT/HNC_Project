package clinic_Information_system;

import java.awt.EventQueue;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterFace extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldUID;
	private JPasswordField passwordField;
	private int UserIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterFace frame = new UserInterFace(0);
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
	public UserInterFace(int UserIndex) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\letter-a.png"));
		this.UserIndex = UserIndex;
		UserManagement UserInfoObj = new UserManagement();
		setTitle("User Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1001, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon imageLoginIcon = new ImageIcon("Images\\Man.jpg");
		Image originalImage = imageLoginIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(120,140,Image.SCALE_SMOOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(128, 128, 192,120));
		panelLogin.setBounds(0, 0, 648, 443);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblGreating = new JLabel("Welcome ! User : " + UserInfoObj.getUserInfo_Name(UserIndex));
		lblGreating.setOpaque(true);
		lblGreating.setBackground(new Color(255,255,255,180));
		lblGreating.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreating.setFont(new Font("Georgia", Font.ITALIC, 25));
		lblGreating.setBounds(197, 89, 397, 43);
		panelLogin.add(lblGreating);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBorder(new LineBorder(new Color(0,0,0,125), 2));
		lblNewLabel.setBackground(new Color(255, 128, 64));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon( new ImageIcon(resizedImage));
		lblNewLabel.setBounds(64, 14, 125, 118);
		panelLogin.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(41, 141, 553, 232);
		panelLogin.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(49, 24, 107, 38);
		panel.add(lblName);
		
		JLabel lblUID = new JLabel("UID");
		lblUID.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblUID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUID.setBounds(49, 82, 107, 36);
		panel.add(lblUID);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(49, 142, 107, 36);
		panel.add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setText(UserInfoObj.getUserInfo_Name(UserIndex));
		textFieldUserName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUserName.setFont(new Font("Rockwell", Font.BOLD, 18));
		textFieldUserName.setBounds(179, 24, 333, 36);
		panel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldUID = new JTextField();
		textFieldUID.setText(UserInfoObj.getUserInfo_UID(UserIndex));
		textFieldUID.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUID.setFont(new Font("Rockwell", Font.BOLD, 18));
		textFieldUID.setColumns(10);
		textFieldUID.setBounds(179, 82, 333, 36);
		panel.add(textFieldUID);
		
		passwordField = new JPasswordField();
		passwordField.setText(UserInfoObj.getUserInfo_Password(UserIndex));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Rockwell", Font.BOLD, 18));
		passwordField.setBounds(179, 142, 333, 34);
		panel.add(passwordField);
		ImageIcon imageLoginIconBackgound = new ImageIcon("Images\\Flower12.jpg");
		Image originalImageBackgruond = imageLoginIconBackgound.getImage();
		Image resizedImageBackground = originalImageBackgruond.getScaledInstance(650,443,Image.SCALE_SMOOTH);
		
		
		
		JPanel panelFunction = new JPanel();
		panelFunction.setBorder(new LineBorder(new Color(0,0,0,125), 2));
		panelFunction.setBackground(new Color(0, 128, 192));
		panelFunction.setBounds(646, 0, 350, 443);
		contentPane.add(panelFunction);
		panelFunction.setLayout(null);
		
		JLabel lblAungClinic = new JLabel("Aung Clinic");
		lblAungClinic.setForeground(new Color(255, 255, 255));
		lblAungClinic.setOpaque(true);
		lblAungClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAungClinic.setFont(new Font("Rage Italic", Font.PLAIN, 30));
		lblAungClinic.setBackground(new Color(0, 0, 0,100));
		lblAungClinic.setBounds(19, 35, 301, 43);
		panelFunction.add(lblAungClinic);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(new Color(0, 0, 0,100));
		panelButton.setBounds(20, 92, 300, 174);
		panelFunction.add(panelButton);
		JButton btnSearch = new JButton("Search Infomation");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Directing to Searching form");
				dispose();
				Search_Session sortObj = new Search_Session(UserIndex);
				sortObj.setVisible(true);
			}
		});
		panelButton.setLayout(null);
		btnSearch.setFont(new Font("Rockwell", Font.ITALIC, 20));
		btnSearch.setBounds(46, 24, 213, 33);
		panelButton.add(btnSearch);
		
		JButton btnSort = new JButton("Sort Information");
		btnSort.setBackground(new Color(255, 255, 255));
		btnSort.setFocusable(false);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Directing to Sorting form");
				dispose();
				Sorting_Session sortObj = new Sorting_Session(UserIndex);
				sortObj.setVisible(true);
			}
		});
		btnSort.setFont(new Font("Rockwell", Font.ITALIC, 20));
		btnSort.setBounds(46, 71, 213, 33);
		panelButton.add(btnSort);
		
		JButton btnlogout = new JButton("Logout");
		btnlogout.setFocusable(false);
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to Logout ? " , "Logout" , JOptionPane.YES_NO_OPTION);
				if(option == 0) {
					dispose();
					LoginForm LoginObj = new LoginForm();
					LoginObj.setVisible(true);
				}
			}
		});
		btnlogout.setForeground(new Color(255, 255, 255));
		btnlogout.setBackground(new Color(255, 0, 0));
		btnlogout.setFont(new Font("Rockwell", Font.ITALIC, 20));
		btnlogout.setBounds(46, 118, 213, 33);
		panelButton.add(btnlogout);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\Flower7A.jpg"));
		lblNewLabel_1.setBounds(0, 0, 373, 483);
		panelFunction.add(lblNewLabel_1);
		
		
	}
}
