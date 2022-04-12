package temaPOO;

public class Finance extends Department{
	public Finance() {
		super();
	}
	
	public double getTotalSalaryBudget() {
		double totalSalaryBudget = 0.0;
		int currentYear = 2021;
		int startYear; // Consider anul curent : 2021
		// parcurg toti angajatii si calculez totalSalaryBudget
		for (Employee employee: super.employees) {
			// (Calculez vechimea doar dupa ani, nu si dupa luni =>
			// de aceea cei care s-au angajat in decembrie 2020,
			// in ianuarie 2021 vor fi considerati ca au vechime de 1 an)
			
			// Nu e atat de logic, dar am facut-o pentru a usura algoritmul
			
			// aflu anul la care s-a angajat
			startYear = Integer.parseInt(employee.resume.experiences.first().start_date.substring(6));
			// verific vechimea angajatului
			if (currentYear - startYear >= 1) {
				// pentru cei cu o vechime >= 1 impozitul va fi 10%
				totalSalaryBudget += employee.salary * 90/100;
			} else {
				// pentru ceilalti va fi de 16%
				totalSalaryBudget += employee.salary * 84/100;
			}
		}
		return totalSalaryBudget;
	}
}
