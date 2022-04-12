package temaPOO;

public class IT extends Department{
	public IT() {
		super();
	}
	
	public double getTotalSalaryBudget() {
		double totalSalaryBudget = 0.0;
		// parcurg toti angajatii si calculez totalSalaryBudget
		for (Employee employee: super.employees) {
			totalSalaryBudget += employee.salary;
		}
		// cei din departamentul IT sunt scutiti de taxe
		return totalSalaryBudget;
	}
}
