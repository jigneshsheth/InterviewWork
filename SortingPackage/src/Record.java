
public class Record{
	
	private String firstName;
	private String lastName;
	private int studentID;
	private String birthdate;
	private double gpa;
	private String major;
	
	
	public Record(String fname, String lname, int id, String bdate, double gpa, String major) {
		this.firstName = fname;
		this.lastName = lname;
		this.studentID = id;
		this.birthdate = bdate;
		this.gpa = gpa;
		this.major = major;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}

	public String toString() {
		return this.firstName + ", " + this.lastName + "\n" + "ID: " + this.studentID + "\n" + this.birthdate +
				"\n" + "GPA: " + this.gpa + "\n" + this.major + "\n";
	}
}
