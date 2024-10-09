package exam3;

public class Main {

	public static void main(String[] args) {
		Employee fixedSalary = new FixedSalary("Clark", "Kent", "555-999-5555", 15000.00);
		Employee hourlySalary = new HourlySalary("Bruce", "Wayne", "555-777-1111", 20.00, 165);
		Employee commissionPay = new CommissionPay("Peter", "Parker", "555-111-55555", 95000, 0.06);
		
//		java.util.ArrayList<Employee> employees = new java.util.ArrayList<Employee>();
//		
//		employees.add(fixedSalary);
//		employees.add(hourlySalary);
//		employees.add(commissionPay);
		
		Employee[] employees = new Employee[3];
		employees[0] = fixedSalary;
		employees[1] = hourlySalary;
		employees[2] = commissionPay;
		
		for(Employee emp : employees) {
			System.out.println(emp);
			System.out.printf("earned $%.2f\n\n", emp.earnings());
		}
		
		
	}

}
