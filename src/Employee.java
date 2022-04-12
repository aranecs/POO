package temaPOO;

public class Employee extends Consumer {
	String company;
	int salary;

	// constructorul principal (de la Consumer)
	Employee(int index){
		super(index);
		this.company = null;
		this.salary = 0;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
