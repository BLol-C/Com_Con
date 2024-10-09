package exam1;

public class Undergrad extends Student{
	private String year;

	public Undergrad(int id, String name, double gpa,String year) {
		super(id, name, gpa);
		this.setYear(year);
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public String toString() {
		return "Student: " + "\n"
				+ "ID: " + id + "\n"
				+ "Name: " + name + "\n"
				+ "GPA: " + gpa + "\n"
				+ "Year: " + year + "\n";
	}
}
