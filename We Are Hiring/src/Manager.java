package temaPOO;
import java.util.*;

public class Manager extends Employee {	
	String company;
	TreeSet<Request<Job, Consumer>> requests;

	public Manager(int index) {
		super(index);
		this.requests = new TreeSet<Request<Job, Consumer>>();
	}

	public void addRequests(Request<Job, Consumer> request) {
		requests.add(request);
	}

	public void process(Job job) {
		
		// daca jobul e inchis, nu procesez nimic
		if (job.flag == false) {
			return;
		}
		
		Request<Job, Consumer> tmpRequest;
		User candidat;
		int contor = 0; // contro pentru numarul de cereri procesate
		Iterator<Request<Job, Consumer>> i = requests.iterator();
		
		// iterez prin colectia de cereri
		while (i.hasNext()) {
			tmpRequest = i.next();
			
			// daca nu mai sunt pozitii vacante
			if (contor == job.noPositions) {
				return;
			}
			
			// selectez doar cererile necesare
			if (tmpRequest.getKey().equals(job)) {
				candidat = (User)tmpRequest.getValue1();
				
				// verific daca candidatul nu a fost angajat la alta companie
				if (Application.users.contains(candidat)) {
					// sterg candidatul din lista utilizatorilor 
					Application.users.remove(candidat);
					// sterg candidatul din lista candidatilor
					job.candidati.remove(candidat);
					// aflu departamentul corespunzator job-ului
					// (parcurg departamentele din companii cautand cel necesar)
					for (Company company : Application.companies) {
						// daca vre-o companie contine observatorul dat
						if (company.observers.contains(candidat)) {
							// il sterg
							company.removeObserver(candidat);
						}
						for (Department department : company.departments) {
							// sterg din lista de observatori ai companiei
							if (department.availableJobs.contains(job)) {
								// adaug in departament
								company.add(candidat.convert(), department);
								break; // nu mai parcurg alte departamente
							}
						}
					}
					contor++; // a fost angajat +1 candidat
					// daca s-au epuizat toate pozitiile vacante
					if (contor == job.noPositions) {
						// job-ul se inchide
						job.flag = false;
						// informez observatorii despre acest fapt companiei
						for(Company company : Application.companies) {
							// am gasit compania necesara
							if (company.name.equals(this.company)) {
								company.notifyObservers("Job-ul : " + job.jobName + " a fost inchis!");
							}
						}
					}
				}
			}
		}
	}
	
}
