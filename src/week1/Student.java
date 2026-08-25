package week1;

public class Student extends Person {
	private String studentId;

	public Student(String name, String email, String studentId) {
		super(name, email);
		this.studentId = studentId;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + " " + studentId + " ";
	}

}
