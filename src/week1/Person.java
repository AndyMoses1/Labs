package week1;

public class Person {

	private String name;
	private String email;

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getDetails() {
		return name + " (" + email + ")";
	}

}
