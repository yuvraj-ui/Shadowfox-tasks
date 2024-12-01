package javafx;

public class Student {
	private String studentID;
	private String name;
	private String major;
	private double gpa;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Student(String studentID, String name, String major, double gpa) {
		this.studentID = studentID;
		this.name = name;
		this.major = major;
		this.gpa = gpa;
	}

}
