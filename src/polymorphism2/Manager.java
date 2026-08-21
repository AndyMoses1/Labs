package polymorphism2;

import java.util.ArrayList;

public class Manager extends Employee {
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public Manager(String name, String jobTitle) {
		super(name, jobTitle);
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String getInfo() {
		String info = super.getInfo();

		for (Employee employee : employees) {
			info += employee.getInfo();
		}

		return info;
	}

}
