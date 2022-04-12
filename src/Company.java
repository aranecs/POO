package temaPOO;

import java.util.*;

public class Company implements Subject{
	String name;
	Manager manager;

	ArrayList<Department> departments;
	ArrayList<Recruiter> recruiters;
	
	ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public Company(String name, Manager manager) {
		this.name = name;
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	// Adaugarea unui nou departament in companie
	public void add(Department department) {
		if (departments.contains(department)) {
			return;
		}

		departments.add(department);
	}
	// Adaugarea unui nou recruiter in companie
	public void add(Recruiter recruiter) {
		if (recruiters.contains(recruiter)) {
			return;
		}

		recruiters.add(recruiter);
	}
	// Adaugarea unui angaja intr-un departament
	public void add(Employee employee, Department department) {
		// verific daca exista departamentul dat
		if (this.departments.contains(department)) {
			// adaug employee in department
			this.departments.get(this.departments.indexOf(department)).add(employee);
		}
	}
	// Eliminarea unui angajat din companie
	public void remove(Employee employee) {
		// caut angajatul in departamente
		for (Department tmp : departments) {
			if (tmp.employees.contains(employee)) {
				tmp.employees.remove(employee);
				break; // deorece poate fi doar un angajat
			}
		}
	}
	// Eliminarea unui departament din companie si a tuturor angajatilor acestuia
	public void remove(Department department) {
		this.departments.remove(department);
	}
	// Eliminarea unui recruiter
	public void remove(Recruiter recruiter) {
		this.recruiters.remove(recruiter);
	}
	// Mutarea unui departament in alt departament si a tuturor angajatilor acestuia
	public void move(Department source, Department destination) {
		// adaug lista de angajati din sursa la lista de angajati din destinatie
		destination.employees.addAll(source.employees);
		// adaug lista de job-uri din sursa la lista de job-uri din destinatie
		destination.availableJobs.addAll(source.availableJobs);
	}
	// Mutarea unui angajat dintr-un departament in alt departament
	public void move(Employee employee, Department newDepartment) {
		// sterg angajatul din companie
		this.remove(employee);
		// adaug angajatul in departamentul nou
		newDepartment.add(employee);
	}
	// Verificarea existentei unui departament in companie
	public boolean contains(Department department) {
		if (this.departments.contains(department)) {
			return true;
		}
		return false;
	}
	// Verificarea existentei unui angajat in companie
	public boolean contains(Employee employee) {
		// parcurg toate departamentele
		for (Department tmp : departments) {
			// daca exista angajat
			if (tmp.employees.contains(employee)) {
				return true;
			}
		}
		return false;
	}
	// Verificarea existentei unui recruiter in companie
	public boolean contains(Recruiter recruiter) {
		if (recruiters.contains(recruiter)) {
			return true;
		}
		return false;
	}
	// Determinarea recruiterului potrivit pentru un utilizator
	public Recruiter getRecruiter(User user) {
		// implimentata si in metoda apply() din clasa Job

		// daca nu exista recruiteri
		if (this.recruiters == null) {
			return null;
		}

		Recruiter recruiter;
		// presupun ca recruiter-ul selectat este primul din lista
		recruiter = this.recruiters.get(0);
		// variabilele in care voi pastra rangul parcurgerei
		int currentRecruiterDegree;
		int tmpRecruiterDegree;
		// parcurg lista de recruiteri din companie
		// verificand proprietatile din enunt
		for (Recruiter tmp : this.recruiters) {
			currentRecruiterDegree = user.getDegreeInFriedship(recruiter);
			tmpRecruiterDegree = user.getDegreeInFriedship(tmp);
			// daca tmp este mai indepartat ca recruiterul selectat
			if (tmpRecruiterDegree > currentRecruiterDegree) {
				// actualizez recruiter-ul selectat
				recruiter = tmp;
			} else if (tmpRecruiterDegree == currentRecruiterDegree) {
				// daca sunt egale, aleg dupa rating
				if (tmp.rating > recruiter.rating) {
					recruiter = tmp;
				}
			}
		}
		// returnez recruiter-ul
		return recruiter;
	}
	// Determinarea joburilor dintr-o companie (cele ce nu au fost inca inchise)
	public ArrayList<Job> getJobs() {
		// fac o lista noua de job-uri
		ArrayList<Job> newJobs = new ArrayList<Job>();

		// parcurg toate departamentele din companie si adaug job-urile active in lista
		for (Department tmp : departments) {
			newJobs.addAll(tmp.availableJobs);
		}
		// returnez lista formata
		return newJobs;
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	public void notifyObservers(String notification) {
		for (Observer observer : observers) {
			observer.update(notification);
		}
	}
}
