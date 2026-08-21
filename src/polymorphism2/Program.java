package polymorphism2;

public class Program {

	public static void main(String[] args) {
		Manager director = new Manager("Sephiroth", "SOLDIER");
		Manager manager = new Manager("Cloud", "Team Lead");
		
		director.addEmployee(manager);

		manager.addEmployee(new Employee("Barret", "Developer"));
		manager.addEmployee(new Employee("Tifa", "Tester"));

		SkilledWorker worker = new SkilledWorker("Cid", "Engineer");
		worker.addSkill("Rockets");
		worker.addSkill("Space");
		manager.addEmployee(worker);

		System.out.println(director.getInfo());
	}
}
