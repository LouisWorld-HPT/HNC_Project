package clinic_Information_system;

import java.awt.EventQueue;


import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Toolkit;

public class Search_Session extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JRadioButton rdbtnPatient;
	private JRadioButton rdbtnDoctor;
	private DefaultTableModel tableModel;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Session frame = new Search_Session(0);
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
	public Search_Session(int UserIndex) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\letter-a.png"));
		setTitle("Search_Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1101, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(320, 0, 767, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// left panel
		JPanel panelLeftUser = new JPanel();
		panelLeftUser.setBackground(new Color(128, 128, 192));
		panelLeftUser.setBounds(0, 31, 328, 90);
		contentPane.add(panelLeftUser);
		panelLeftUser.setLayout(null);

		JLabel lblTextDecoration = new JLabel("Search Focus >> Patient");
		lblTextDecoration.setOpaque(false);
		lblTextDecoration.setForeground(Color.WHITE);
		lblTextDecoration.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblTextDecoration.setBackground(new Color(0, 0, 0, 100));
		lblTextDecoration.setBounds(38, 36, 263, 25);
		panelLeftUser.add(lblTextDecoration);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(192, 192, 192));
		panelSearch.setBounds(0, 120, 328, 323);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		JComboBox comboBox = new JComboBox(model);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				if(item != null) {
					textFieldSearch.setEnabled(true);
				}
			}
		});
		comboBox.setRenderer(dlcr);
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "By Name", "By ID"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setFont(new Font("Rockwell", Font.BOLD, 18));
		comboBox.setBounds(8, 67, 302, 37);
		panelSearch.add(comboBox);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setEnabled(false);
		textFieldSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSearch.setFont(new Font("Rockwell", Font.BOLD, 18));
		textFieldSearch.setBounds(8, 14, 302, 39);
		panelSearch.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchData = textFieldSearch.getText();
				String searchType = (String) comboBox.getSelectedItem();
				System.out.println(searchData + " " + searchType);
				if(rdbtnPatient.isSelected() && searchType != null) {
					System.out.println("Patient is selected");
					search_Patient(searchType, searchData);
				}
				else if(rdbtnDoctor.isSelected() && searchType != null) {
					System.out.println("Doctor is selected");
					search_Doctor(searchType,searchData);
				}
				else {
					JOptionPane.showMessageDialog(null,"Please, Choose One option to search", "Warning" , JOptionPane.WARNING_MESSAGE);
				}
		}
		});
		btnSearch.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnSearch.setBounds(8, 151, 302, 39);
		btnSearch.setFocusable(false);
		panelSearch.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearch.setText("");
				textFieldSearch.setEnabled(false);
				comboBox.setSelectedItem(null);
				rdbtnPatient.setSelected(true);
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "Name","Age","PhNumber", "Address" 
						}
					));
				tableModel = (DefaultTableModel) table.getModel();
				
			}
		});
		btnReset.setFocusable(false);
		btnReset.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnReset.setBounds(8, 199, 302, 37);
		panelSearch.add(btnReset);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(new Color(255, 255, 255));
		btnGoBack.setBackground(new Color(0, 0, 255));
		btnGoBack.setFocusable(false);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to Go Back ? " , "Go Back" , JOptionPane.YES_NO_OPTION);
				if(option == 0) {
					dispose();
					UserInterFace UIobj = new UserInterFace(UserIndex);
					UIobj.setVisible(true);
				}
			}
		});
		btnGoBack.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnGoBack.setBounds(8, 244, 302, 37);
		panelSearch.add(btnGoBack);
		
		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setFocusable(false);
		rdbtnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTextDecoration.setText("Search Foucs >> Patient");
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Appointment_ID","Appointment_Date","Patient_Name","DoctorID","PhNumber", "Address" 
						}
					));
				tableInsertData("Patient");
				
			}
		});
		rdbtnPatient.setFont(new Font("Rockwell", Font.PLAIN, 18));
		rdbtnPatient.setBounds(8, 114, 146, 27);
		panelSearch.add(rdbtnPatient);
		rdbtnPatient.setSelected(true);
		
		rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setFocusable(false);
		rdbtnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTextDecoration.setText("Search Foucs >> Doctor");
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "Name","Specialization","PhNumber", "Address" 
						}
					));
				tableInsertData("Doctor");
			}
		});
		rdbtnDoctor.setFont(new Font("Rockwell", Font.PLAIN, 18));
		rdbtnDoctor.setBounds(164, 114, 146, 27);
		panelSearch.add(rdbtnDoctor);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPatient);
		group.add(rdbtnDoctor);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setIcon(new ImageIcon("Images\\Flower1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 320, 333);
		panelSearch.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 328, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Setting");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmGoBackMenu = new JMenuItem("Menu");
		mntmGoBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserInterFace UIobj = new UserInterFace(UserIndex);
				UIobj.setVisible(true);
			}
		});
		mntmGoBackMenu.setForeground(new Color(64, 0, 0));
		mntmGoBackMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mntmGoBackMenu.setOpaque(true);
		mntmGoBackMenu.setBackground(new Color(255, 255, 255));
		mnNewMenu.add(mntmGoBackMenu);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginForm x = new LoginForm();
				x.setVisible(true);
			}
		});
		mntmLogout.setForeground(new Color(255, 0, 0));
		mntmLogout.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mntmLogout.setHorizontalAlignment(SwingConstants.CENTER);
		mntmLogout.setFocusable(false);
		mntmLogout.setOpaque(true);
		mntmLogout.setBackground(new Color(255, 255, 255));
		mnNewMenu.add(mntmLogout);
		
		
		
		// right panel
		JLabel lblClinicHour = new JLabel("Clinic Information");
		lblClinicHour.setForeground(new Color(255, 255, 255));
		lblClinicHour.setOpaque(true);
		lblClinicHour.setBackground(new Color(0, 0, 0,100));
		lblClinicHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblClinicHour.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblClinicHour.setBounds(289, 14, 200, 25);
		panel.add(lblClinicHour);
		
		JPanel panelTabel = new JPanel();
		panelTabel.setBounds(31, 53, 699, 353);
		panel.add(panelTabel);
		panelTabel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneTabel = new JScrollPane();
		panelTabel.add(scrollPaneTabel, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBorder(new CompoundBorder());
		table.setBackground(new Color(255,255,255));
		table.setForeground(new Color(64, 0, 0));
		table.setFont(new Font("Rockwell", Font.BOLD, 15));
		if (rdbtnPatient.isSelected()) {
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Appointment_ID","Appointment_Date","Patient_Name","DoctorID","PhNumber", "Address" 
					}
				));
			tableInsertData("Patient");
			
		}
		scrollPaneTabel.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ImageBackground = new ImageIcon("Images\\Flower15.jpg");
		Image OriginalSize = ImageBackground.getImage();
		Image Resized = OriginalSize.getScaledInstance(784, 443, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(Resized));
		lblNewLabel.setBounds(0, 0, 784, 443);
		panel.add(lblNewLabel);
		
		
	}
	public void tableInsertData(String TableName) {
		model = (DefaultTableModel) table.getModel();
		((DefaultTableModel) table.getModel()).setNumRows(0);;
		if(TableName.equals("Patient")) {
			Patient patientObj = Clinic_System.PatinetData();
			for(int i = 0 ; i < patientObj.patientData.length;i++) {
				String id = " " + patientObj.patientData[i].getId() + " ";
				String date = " " + patientObj.patientData[i].getAppointmentDate() + " ";
				String name = " " + patientObj.patientData[i].getName() + " ";
				String doctorId = " " + patientObj.patientData[i].getDoctorId() + " ";
				String phone = " " + patientObj.patientData[i].getPhNumber() + " ";
				String address = " " + patientObj.patientData[i].getAddress() + " ";
				String [] data = new String[] {id,date,name,doctorId,phone,address};
				model.addRow(data);
			}
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
		}
		else{
			Doctor doctorObj = Clinic_System.DoctorData();
			for(int i = 0 ; i < doctorObj.doctorData.length;i++) {
				String id = " " + doctorObj.doctorData[i].getId() + " ";
				String name = " " + doctorObj.doctorData[i].getName() + " ";
				String specialization = " " + doctorObj.doctorData[i].getSpecialization() + " ";
				String phone = " " + doctorObj.doctorData[i].getPhNumber() + " ";
				String address = " " + doctorObj.doctorData[i].getAddress() + " ";
				String [] data = new String[] {id,name,specialization,phone,address};
				model.addRow(data);
			}
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(1).setPreferredWidth(96);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
		}
	}
	public Doctor sort_Doctor(String sortType) {
		Doctor doctorObj = Clinic_System.DoctorData();
		doctorObj.InsertDoctorInfo();
		if(sortType.equals("By Name")) {
			for(int i = 0 ; i < doctorObj.doctorData.length; i++) {
				int min = i ;
				for(int j = i + 1; j < doctorObj.doctorData.length; j++) {
				if(doctorObj.doctorData[min].getName().compareTo(doctorObj.doctorData[j].getName()) > 0) {
					min = j;
					}
				}
				Doctor temp = doctorObj.doctorData[i];
				doctorObj.doctorData[i] = doctorObj.doctorData[min];
				doctorObj.doctorData[min] = temp;
				
			}
			return doctorObj;
		}
		else {
			for(int i = 0 ; i < doctorObj.doctorData.length; i++) {
				int min = i ;
				for(int j = i + 1; j < doctorObj.doctorData.length; j++) {
				if(doctorObj.doctorData[min].getId().compareTo(doctorObj.doctorData[j].getId()) > 0) {
					min = j;
					}
				}
				Doctor temp = doctorObj.doctorData[i];
				doctorObj.doctorData[i] = doctorObj.doctorData[min];
				doctorObj.doctorData[min] = temp;
			}
			return doctorObj;
		}
		
	}
	public Patient sort_Patient(String sortType) {
		Patient patientObj = Clinic_System.PatinetData();
		patientObj.InsertPatientData();
		if(sortType.equals("By Name")) {
			for(int i = 0 ; i < patientObj.patientData.length; i++) {
				int min = i ;
				for(int j = i + 1; j < patientObj.patientData.length; j++) {
				if(patientObj.patientData[min].getName().compareTo(patientObj.patientData[j].getName()) > 0) {
					min = j;
					}
				}
				Patient temp = patientObj.patientData[i];
				patientObj.patientData[i] = patientObj.patientData[min];
				patientObj.patientData[min] = temp;
			}
			return patientObj;
			
		}
		else {
			for(int i = 0 ; i < patientObj.patientData.length; i++) {
				int min = i ;
				for(int j = i + 1; j < patientObj.patientData.length; j++) {
				if(patientObj.patientData[min].getId().compareTo(patientObj.patientData[j].getId()) > 0) {
					min = j;
					}
				}
				Patient temp = patientObj.patientData[i];
				patientObj.patientData[i] = patientObj.patientData[min];
				patientObj.patientData[min] = temp;
				
			}
			return patientObj;
		}
		
	}	
	
	public void search_Patient(String SearchType, String SearchData) {
		Patient patientObj = sort_Patient(SearchType);
		int left = 0; 
		int right = patientObj.patientData.length-1;
		int mid;
		if(SearchType.equals("By Name")) {
			while(left <= right) {
				System.out.println("System is started");
				mid = (left+right)/2;
				System.out.println("Mid ==> " + patientObj.patientData[mid].getName());
				System.out.println("Left value : " + left);
				System.out.println("Left ==> " + patientObj.patientData[left].getName());
				System.out.println("Right value : " + right);
				System.out.println("Right ==> " + patientObj.patientData[right].getName());
				if(patientObj.patientData[mid].getName().compareTo(SearchData) >0) {
					right = mid-1;
					System.out.print("Bigger ?(+) : ");
					System.out.println(patientObj.patientData[mid].getName().compareTo(SearchData) >0);
				}
				else if(patientObj.patientData[mid].getName().compareTo(SearchData) < 0) {
					left = mid + 1;
					System.out.print("Smaller ?(-) : ");
					System.out.println(patientObj.patientData[mid].getName().compareTo(SearchData) >0);
				}
				else {
					System.out.println("Data is found ! ");
					System.out.println(patientObj.patientData[mid].getName());
					search_data_Found_Patient(mid,patientObj);
					break;
				}
			}
			if ( left > right) {
				JOptionPane.showMessageDialog(null, "The Data is not correct or not found", "Not found" , JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("Values are reset");
			left = 0;
			right = patientObj.patientData.length;
		}
		else {
			while(left <= right) {
				mid = (left+right)/2;
				if(patientObj.patientData[mid].getId().compareTo(SearchData) >0) {
					right = mid-1;
				}
				else if(patientObj.patientData[mid].getId().compareTo(SearchData) < 0) {
					left = mid + 1;
				}
				else {
					
					System.out.println("Data is found ! ");
					System.out.println(patientObj.patientData[mid]);
					search_data_Found_Patient(mid,patientObj);
					break;
				}
			}
			if ( left > right) {
				JOptionPane.showMessageDialog(null, "The Data is not correct or not found", "Not found" , JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("Values are reset");
			left = 0;
			right = patientObj.patientData.length;
		}
	}
	public void search_Doctor(String SearchType, String SearchData) {
		Doctor doctorObj = sort_Doctor(SearchType);
		int left = 0;
		int right = doctorObj.doctorData.length-1;
		int mid;
		if(SearchType.equals("By Name")) {
			while(left <= right) {
				System.out.println("System is started");
				mid = (left+right)/2;
				System.out.println("Mid ==> " + doctorObj.doctorData[mid].getName());
				System.out.println("Left value : " + left);
				System.out.println("Left ==> " + doctorObj.doctorData[left].getName());
				System.out.println("Right value : " + right);
				System.out.println("Right ==> " + doctorObj.doctorData[right].getName());
				if(doctorObj.doctorData[mid].getName().compareTo(SearchData) >0) {
					right = mid-1;
				}
				else if(doctorObj.doctorData[mid].getName().compareTo(SearchData) < 0) {
					left = mid + 1;
				}
				else {
					
					System.out.println("Data is found ! ");
					search_data_Found_Doctor(mid,doctorObj);
					break;
				}
			}
			if ( left > right) {
				JOptionPane.showMessageDialog(null, "The Data is not correct or not found", "Not found" , JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("Values are reset");
			left = 0;
			right = doctorObj.doctorData.length;
		}
		else {
			while(left <= right) {
				mid = (left+right)/2;
				if(doctorObj.doctorData[mid].getId().compareTo(SearchData) >0) {
					right = mid-1;
				}
				else if(doctorObj.doctorData[mid].getId().compareTo(SearchData) < 0) {
					left = mid + 1;
				}
				else {
					System.out.println("Data is found ! ");
					search_data_Found_Doctor(mid,doctorObj);
					break;
				}
			}
			if ( left > right) {
				JOptionPane.showMessageDialog(null, "The Data is not correct or not found", "Not found" , JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("Values are reset");
			left = 0;
			right = doctorObj.doctorData.length;
		}
	}
	public void search_data_Found_Patient(int FoundIndex, Patient patientObj) {
		model = (DefaultTableModel) table.getModel();
		((DefaultTableModel) table.getModel()).setNumRows(0);;
		String id = " " + patientObj.patientData[FoundIndex].getId() + " ";
		String date = " " + patientObj.patientData[FoundIndex].getAppointmentDate() + " ";
		String name = " " + patientObj.patientData[FoundIndex].getName() + " ";
		String doctor = " " + patientObj.patientData[FoundIndex].getDoctorId() + " ";
		String phone = " " + patientObj.patientData[FoundIndex].getPhNumber() + " ";
		String address = " " + patientObj.patientData[FoundIndex].getAddress() + " ";
		String [] data = new String[] {id,date,name,doctor,phone,address};
		model.addRow(data);
		
	}
	public void search_data_Found_Doctor(int FoundIndex, Doctor doctorObj) {
		model = (DefaultTableModel) table.getModel();
		((DefaultTableModel) table.getModel()).setNumRows(0);
		String id = " " + doctorObj.doctorData[FoundIndex].getId() + " ";
		String name = " " + doctorObj.doctorData[FoundIndex].getName() + " ";
		String specialization = " " + doctorObj.doctorData[FoundIndex].getSpecialization() + " ";
		String phone = " " + doctorObj.doctorData[FoundIndex].getPhNumber() + " ";
		String address = " " + doctorObj.doctorData[FoundIndex].getAddress() + " ";
		String [] data = new String[] {id,name,specialization,phone,address};
		model.addRow(data);
		
		
	}
}
