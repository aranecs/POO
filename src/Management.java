package temaPOO;

public class Management extends Department {
	public Management() {
		super();
	}
	
	public double getTotalSalaryBudget() {
		double totalSalaryBudget = 0.0;
		// parcurg toti angajatii si calculez totalSalaryBudget
		for (Employee employee: super.employees) {
			totalSalaryBudget += employee.salary;
		}
		// cei din departamentul Management vor avea un impozit egal cu 16%
		totalSalaryBudget = 84/100*totalSalaryBudget;
		return totalSalaryBudget;
	}
}
