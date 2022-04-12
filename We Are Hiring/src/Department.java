package temaPOO;
import java.util.*;

public abstract class Department implements IDepartment {
	ArrayList<Employee> employees;
	ArrayList<Job> availableJobs;
	
	public Department() {
		this.employees = new ArrayList<Employee>();
		this.availableJobs = new ArrayList<Job>();
	}
	
	public abstract double getTotalSalaryBudget( );
	
	public ArrayList<Job> getJobs() {
		return this.availableJobs;
	}
	
	public void add(Employee employee) {
		this.employees.add(employee);
	}
	
	public void remove(Employee employee) {
		this.employees.remove(employee);
	}
	
	public void add(Job job) {
		this.availableJobs.add(job);
		// pentru a notifica candidatii
		// aflu companie
		for (Company company : Application.companies) {
			if (company.departments.contains(this)) {
				company.notifyObservers("A fost adaugat noul JOB : " + job.jobName + " cu " + job.noPositions + " locuri vacante.");
			}
		}
	}
	
	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}
}
