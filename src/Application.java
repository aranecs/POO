package temaPOO;

import java.util.*;

public class Application {
	private static Application instance;
	// Lista de companii
	static ArrayList<Company> companies;
	// Lista de utilizatori
	static ArrayList<User> users;
	
	
	private Application() {
		Application.companies = new ArrayList<Company>();
		Application.users = new ArrayList<User>();
	}
	
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}
		return instance;
	}
	
	// Determinarea companiilor care au fost inscrise in aplicatie
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	// Determinarea unei anumite companii in functie de numele furnizat
	public Company getCompany(String name) {
		for (Company tmp : companies) {
			if (Objects.equals(tmp.name, name)) {
				return tmp;
			}
		}
		// Nu exista compania cu numele "name" in lista de companii 
		return null;
	}
	// Adaugarea unei companii
	public void add(Company company) {
		// Daca compania deja a fost adaugata 
		if (companies.contains(company)) {
			return;
		}
		
		companies.add(company);
	}
	// Adaugarea unui utilizator
	public void add(User user) {
		// Daca utilizatorul deja a fost adaugat 
		if (users.contains(user)) {
			return;
		}
		
		users.add(user);
		
	}
	// Stergerea unei companii
	public boolean remove(Company company) {
		// Daca compania exista 
		if (companies.contains(company)) {
			companies.remove(company);
			return true;
		}
		else {
			return false;
		}
	}
	// Stergerea unui utilizator
	public boolean remove(User user) {
		// Daca utilizatorul exista 
		if (users.contains(user)) {
			users.remove(user);
			return true;
		}
		else {
			return false;
		}
	}
	// Determinarea joburilor disponibile de la companiile pe care le prefera utilizatorul
	public ArrayList<Job> getJobs(List<String> companies) {
		ArrayList<Job> newListJobs = new ArrayList<Job>(); 
		// parcurg companiile
		for (Company company : Application.companies) {
			// daca numele companiei se contine in lista transmisa ca parametru
			if (companies.contains(company.name)) {
				// adaug la lista de job-uri job-urile disponibile din companie
				newListJobs.addAll(company.getJobs());
			}
		}
		// returnez lista rezultanta
		return newListJobs;
	}
}
