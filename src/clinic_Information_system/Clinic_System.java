package clinic_Information_system;

class PersonInfo{
	private String id;
	private String name;
	private String phNumber;
	private String address;
	public Patient patientData[] = new Patient[15];
	public Doctor doctorData[] = new Doctor[10];
	// Constructor
	public PersonInfo() {
		
	}
	// Constructor
	public PersonInfo(String id, String name, String phNumber, String address) {
		this.id = id;
		this.name = name;
		this.phNumber = phNumber;
		this.address = address;
	}
	
	// Getter & setter Start
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	// Getter & Setter End
	
	
}


class Patient extends PersonInfo{
	private String doctor_Id;
	private String Appointment_Date;
	// Getter and Setter Start
	public String getDoctorId() {
		return doctor_Id;
	}
	public void setAge(String doctor_Id) {
		this.doctor_Id = doctor_Id;
	}
	public String getAppointmentDate() {
		return Appointment_Date;
	}
	public void setAppointmentDate(String doctor_Id) {
		this.doctor_Id = doctor_Id;
	}
	// Getter and Setter End
	// Constructor
	public Patient() {
		
	}
	public Patient(String id, String name,String doctor_Id, String phNumber, String address, String Appointment_Date) {
		super(id, name, phNumber, address);
		this.doctor_Id = doctor_Id;
		this.Appointment_Date = Appointment_Date;
	}
	
	public Patient InsertPatientData() {
		Patient PI = new Patient();
		PI.patientData[0] = new Patient("AID001", "Aye Myint" , "DID001", " 05467854" , "Yangon" , "5/7/2023");
		PI.patientData[1] = new Patient("AID002", "Bhone Si Thu" , "DID001", " 0957454524" , "Yangon", "5/8/2023");
		PI.patientData[2] = new Patient("AID003", "Myint Mar Thu" , "DID001", " 05467854" , "Yangon", "5/7/2023");
		PI.patientData[3] = new Patient("AID004", "Eain Myat Noe" , "DID001", " 05467854" , "Yangon", "5/8/2023");
		PI.patientData[4] = new Patient("AID005", "Chan Thar" , "DID001", " 05467854" , "Yangon", "9/7/2023");
		PI.patientData[5] = new Patient("AID006", "Hein Aung" , "DID001", " 05467854" , "Yangon", "7/8/2023");
		PI.patientData[6] = new Patient("AID007", "Thein Htay" , "DID001", " 05467854" , "Yangon", "2/7/2023");
		PI.patientData[7] = new Patient("AID008", "Ko Paing" , "DID001", " 05467854" , "Yangon", "5/8/2023");
		PI.patientData[8] = new Patient("AID009", "Mya Lay Nwel" , "DID001", " 05467854" , "Yangon", "10/7/2023");
		PI.patientData[9] = new Patient("AID010", "Sit Paing" , "DID001", " 05467854" , "Yangon", "6/8/2023");
		PI.patientData[10] = new Patient("AID011", "Ko lin" , "DID001", " 07874545" , "Yangon", "11/7/2023");
		PI.patientData[11] = new Patient("AID012", "Htay Lwin Oo" , "DID001", " 05467854" , "Yangon", "5/8/2023");
		PI.patientData[12] = new Patient("AID013", "Phyo Thant" , "DID001", " 05467854" , "Yangon", "9/7/2023");
		PI.patientData[13] = new Patient("AID014", "Wai Yan linn" , "DID001", " 05467854" , "Yangon", "4/8/2023");
		PI.patientData[14] = new Patient("AID015", "Aung Naing Thu" , "DID001", " 05467854" , "Yangon", "5/7/2023");
		return PI;
	}
	
	
	
}
class Doctor extends PersonInfo{
	private String specialization;
	// Getter And Setter Start
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	// Getter And Setter End
	// Constructor
	public Doctor () {

	}
	public Doctor(String id, String name, String phNumber, String address, String specialization) {
		super(id, name, phNumber, address);
		this.setSpecialization(specialization);
	}
	public Doctor InsertDoctorInfo() {
		Doctor PI = new Doctor();
		PI.doctorData[0] = new Doctor("DID001","Luke" , "09977755465" , "Yangon" , "Cardiology");
		PI.doctorData[1] = new Doctor("DID002","Louis" , "0987451345465" , "Yangon" , "Internal medicine");
		PI.doctorData[2] = new Doctor("DID003","Marcus" , "0987412331454" , "Yangon" , "Neurology");
		PI.doctorData[3] = new Doctor("DID004","Aung" , "09335415414" , "Yangon" , "Family medicine");
		PI.doctorData[4] = new Doctor("DID005","Direwen" , "0950748455" , "Yangon" , "Family medicine");
		PI.doctorData[5] = new Doctor("DID006","Lewis" , "09977755465" , "Yangon" , "Cardiology");
		PI.doctorData[6] = new Doctor("DID007","Ed sheeran" , "0987451345465" , "Yangon" , "Internal medicine");
		PI.doctorData[7] = new Doctor("DID008","Cindy" , "0987412331454" , "Yangon" , "Neurology");
		PI.doctorData[8] = new Doctor("DID009","Andy" , "09335415414" , "Yangon" , "Family medicine");
		PI.doctorData[9] = new Doctor("DID010","Ben" , "0950748455" , "Yangon" , "Urology");
		return PI;
	}
	
	
}
class UserManagement{
	private String userName;
	private String password;
	private String users[][] = new String[3][3];
	
	// getter and setter start
	
	public String getUserInfo_Name(int index) {
		return users[index][0];
	}
	public String getUserInfo_Password(int index) {
		return users[index][1];
	}
	public String getUserInfo_UID(int index) {
		return users[index][2];
	}
	// getter and setter End
	private void DataImplemetation() {
		users[0][0] = "Aung";
		users[0][1] = "asdf123!@#";
		users[0][2] = "UID001";
		users[1][0] = "Ben";
		users[1][1] = "qazx123!@#";
		users[1][2] = "UID002";
		users[2][0] = "Cindy";
		users[2][1] = "zaqw456!@#";
		users[2][2] = "UID003";
	}
	// Constructor 
	public UserManagement() {
		this.DataImplemetation();
	}
	public UserManagement(String userName , String password) {
		this.userName = userName;
		this.password = password;
		this.DataImplemetation();
	}
	public int CheckUser() {
		int found_row = -1;
		System.out.println("___Check User Session___");
		System.out.println("The Inforamtion to Check ===> " + userName + " " + password);
		for(int row = 0 ; row < users.length; row++) {
			if(userName.equals(users[row][0]) && password.equals(users[row][1])) {
				System.out.println("Input data ==> " + userName + " " + password);
				System.out.println(users[row][0] + " " + users[row][1]);
				found_row = row;
			}
		}
		return found_row;
	}
	
	
}

public class Clinic_System {
	public static int UserLogin(String userName, String password) {
		UserManagement obj = new UserManagement(userName,password);
		int result = obj.CheckUser();
		return result;
	}
	public static Patient PatinetData() {
		Patient P = new Patient();
		Patient Pobj = P.InsertPatientData();
		return Pobj;
	}
	public static Doctor DoctorData() {
		Doctor D = new Doctor();
		Doctor Dobj = D.InsertDoctorInfo();
		return Dobj;
	}
	public static void main(String[] args) {
		int system_respond = UserLogin("Aung", "asdf123!@#");
		System.out.println("System status : " + system_respond);
		
		
	}
}
