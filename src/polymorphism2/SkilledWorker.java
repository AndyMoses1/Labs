package polymorphism2;

import java.util.ArrayList;

public class SkilledWorker extends Employee {
	private ArrayList<String> skills = new ArrayList<String>();

	public SkilledWorker(String name, String jobTitle) {
		super(name, jobTitle);
	}

	public void addSkill(String skill) {
		skills.add(skill);
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	@Override
	public String getInfo() {
		String info = super.getInfo();
		info += "Skills: " + String.join(", ", skills) + "\n";

		return info;
	}

}
