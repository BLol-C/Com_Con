package exam1;

public class Student {


	protected String name;
	protected int id;
	protected double gpa;
	
	public Student(int id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	public Student(int id, double gpa) {
		super();
		this.id = id;
		this.gpa = gpa;
		this.name = " ";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String username) {
		this.name = username;
	}

	public double getGPA() {
		return this.gpa;
	}
	
	public double getID() {
		return this.id;
	}
	
	public String toString() {
		return "Student: " + "\n"
				+ "ID: " + id + "\n"
				+ "Name: " + name + "\n"
				+ "GPA: " + gpa + "\n";
	}
}
