package temaPOO;

public class Marketing extends Department{
	public Marketing() {
		super();
	}
	
	public double getTotalSalaryBudget() {
		double totalSalaryBudget = 0.0;
		// parcurg toti angajatii si calculez totalSalaryBudget
		for (Employee employee: super.employees) {
			// daca au salariu mai mare de 5000 => impozit 10%
			if (employee.salary > 5000) {
				totalSalaryBudget += employee.salary * 90/100;
			// daca au un salariu mai mic de 3000 => vor fi scutiti de taxe
			} else if (employee.salary < 3000) {
				totalSalaryBudget += employee.salary; 
			// altfel salariul = [3000;5000] => impozitul e de 16%
			} else {
				totalSalaryBudget += employee.salary * 84/100;
			}
		}
		return totalSalaryBudget;
	}
}
