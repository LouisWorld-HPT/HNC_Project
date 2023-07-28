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
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.Toolkit;

public class Sorting_Session extends JFrame {
	private static JTable table;
	private JPanel contentPane;
	private JRadioButton rdbtnPatient;
	private JRadioButton rdbtnDoctor;
	private DefaultTableModel tableModel;
	private static DefaultTableModel model;  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sorting_Session frame = new Sorting_Session(0);
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
	public Sorting_Session(int Useri) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\letter-a.png"));
		setTitle("Sorting_Information");
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
		panelLeftUser.setBounds(0, 32, 318, 90);
		contentPane.add(panelLeftUser);
		panelLeftUser.setLayout(null);

		JLabel lblTextDecoration = new JLabel("Sort Focus >> Patient");
		lblTextDecoration.setOpaque(false);
		lblTextDecoration.setForeground(Color.WHITE);
		lblTextDecoration.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblTextDecoration.setBackground(new Color(0, 0, 0, 100));
		lblTextDecoration.setBounds(38, 36, 248, 25);
		panelLeftUser.add(lblTextDecoration);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(192, 192, 192));
		panelSearch.setBounds(0, 119, 318, 324);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		JComboBox comboBox = new JComboBox(model);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setRenderer(dlcr);
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "By Name", "By ID"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setFont(new Font("Rockwell", Font.BOLD, 18));
		comboBox.setBounds(8, 14, 302, 37);
		panelSearch.add(comboBox);
		
		JButton btnSearch = new JButton("Sort");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sortType = (String) comboBox.getSelectedItem();
				if(rdbtnPatient.isSelected() && sortType != null) {
					System.out.println("Patient is selected");
					Sort_Patient(sortType);
				}
				else if(rdbtnDoctor.isSelected()&& sortType != null) {
					System.out.println("Doctor is selected");
					Sort_Doctor(sortType);
				}
				else {
					System.out.println("HIIIiii");
					JOptionPane.showMessageDialog(null,"Please, Choose One option", "Warning" , JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnSearch.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnSearch.setBounds(8, 96, 302, 39);
		btnSearch.setFocusable(false);
		panelSearch.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				rdbtnPatient.setSelected(true);
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
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setFocusable(false);
		btnReset.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnReset.setBounds(8, 144, 302, 37);
		panelSearch.add(btnReset);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(new Color(255, 255, 255));
		btnGoBack.setBackground(new Color(0, 0, 255));
		btnGoBack.setFocusable(false);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to go Back ? " , "Go Back" , JOptionPane.YES_NO_OPTION);
				if(option == 0) {
					dispose();
					UserInterFace UIobj = new UserInterFace(Useri);
					UIobj.setVisible(true);
			}
			}
		});
		btnGoBack.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnGoBack.setBounds(8, 189, 302, 37);
		panelSearch.add(btnGoBack);
		
		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTextDecoration.setText("Sort Focus : Paitent");
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
		rdbtnPatient.setBounds(8, 59, 146, 27);
		panelSearch.add(rdbtnPatient);
		rdbtnPatient.setSelected(true);
		
		
		
		rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDoctor.isSelected()) {
					lblTextDecoration.setText("Sort Focus : Doctor");
					table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"ID", "Name","Specialization","PhNumber", "Address" 
							}
						));
					tableInsertData("Doctor");
				}
			}
		});
		rdbtnDoctor.setFont(new Font("Rockwell", Font.PLAIN, 18));
		rdbtnDoctor.setBounds(164, 59, 146, 27);
		panelSearch.add(rdbtnDoctor);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPatient);
		group.add(rdbtnDoctor);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\Flower1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 318, 324);
		panelSearch.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, -4, 318, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Setting");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmGoBackMenu = new JMenuItem("Menu");
		mntmGoBackMenu.setPreferredSize(new Dimension(100,25));
		mntmGoBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserInterFace UIobj = new UserInterFace(Useri);
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
		lblClinicHour.setBounds(282, 14, 200, 25);
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
		Image Resized = OriginalSize.getScaledInstance(784, 465, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(Resized));
		lblNewLabel.setBounds(0, -22, 767, 465);
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
	public static Doctor Sort_Doctor(String sortType) {
		Doctor sorted_Doctor_Object;
		model = (DefaultTableModel) table.getModel();
		((DefaultTableModel) table.getModel()).setNumRows(0);;
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
			for(int i = 0; i<doctorObj.doctorData.length;i++) {
			String id = " " + doctorObj.doctorData[i].getId() + " ";
			String name = " " + doctorObj.doctorData[i].getName() + " ";
			String specialization = " " + doctorObj.doctorData[i].getSpecialization() + " ";
			String phone = " " + doctorObj.doctorData[i].getPhNumber() + " ";
			String address = " " + doctorObj.doctorData[i].getAddress() + " ";
			String [] data = new String[] {id,name,specialization,phone,address};
			model.addRow(data);
			}
			sorted_Doctor_Object = doctorObj;
			return sorted_Doctor_Object;
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
			for(int i = 0; i<doctorObj.doctorData.length;i++) {
			String id = " " + doctorObj.doctorData[i].getId() + " ";
			String name = " " + doctorObj.doctorData[i].getName() + " ";
			String specialization = " " + doctorObj.doctorData[i].getSpecialization() + " ";
			String phone = " " + doctorObj.doctorData[i].getPhNumber() + " ";
			String address = " " + doctorObj.doctorData[i].getAddress() + " ";
			String [] data = new String[] {id,name,specialization,phone,address};
			model.addRow(data);
			}
			sorted_Doctor_Object = doctorObj;
			return sorted_Doctor_Object;
		}
	}
	public static Patient Sort_Patient(String sortType) {
		Patient sorted_Patient_Object;
		model = (DefaultTableModel) table.getModel();
		((DefaultTableModel) table.getModel()).setNumRows(0);;
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
			for(int i = 0; i<patientObj.patientData.length;i++) {
				String id = " " + patientObj.patientData[i].getId() + " ";
				String date = " " + patientObj.patientData[i].getAppointmentDate() + " ";
				String name = " " + patientObj.patientData[i].getName() + " ";
				String doctorId = " " + patientObj.patientData[i].getDoctorId() + " ";
				String phone = " " + patientObj.patientData[i].getPhNumber() + " ";
				String address = " " + patientObj.patientData[i].getAddress() + " ";
				String [] data = new String[] {id,date,name,doctorId,phone,address};
				model.addRow(data);
			}
			sorted_Patient_Object = patientObj;
			return sorted_Patient_Object;
			
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
			for(int i = 0; i<patientObj.patientData.length;i++) {
				String id = " " + patientObj.patientData[i].getId() + " ";
				String date = " " + patientObj.patientData[i].getAppointmentDate() + " ";
				String name = " " + patientObj.patientData[i].getName() + " ";
				String doctorId = " " + patientObj.patientData[i].getDoctorId() + " ";
				String phone = " " + patientObj.patientData[i].getPhNumber() + " ";
				String address = " " + patientObj.patientData[i].getAddress() + " ";
				String [] data = new String[] {id,date,name,doctorId,phone,address};
				model.addRow(data);
			}
		}
		sorted_Patient_Object = patientObj;
		return sorted_Patient_Object;
	}
}
