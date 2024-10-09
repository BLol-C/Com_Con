package exam1;

public class Graduate extends Student {
	private String thesisTitle;
	
	public Graduate(int id, String name, double gpa,String thesistitle) {
		super(id, name, gpa);
		this.thesisTitle = thesistitle;
	}

	public String getThesisTitle() {
		return thesisTitle;
	}

	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}

	public String toString() {
		return "Student: " + "\n"
				+ "ID: " + id + "\n"
				+ "Name: " + name + "\n"
				+ "GPA: " + gpa + "\n"
				+ "Thesis: " + thesisTitle + "\n";
	}
}
