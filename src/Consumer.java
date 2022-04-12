package temaPOO;

import java.util.*;

public abstract class Consumer {
	// Resume
	Resume resume;
	// Retea sociala
	ArrayList<Consumer> consumers;
	// indexul utilizatorului = 0...numar de utilizatori - 1
	int index;
	
	// Constructorul
	public Consumer(int index) {
		this.resume = new Resume();
		this.consumers = new ArrayList<Consumer>();
		this.index = index;
	}

	// Adaugarea unor studii
	public void add(Education education) {
		this.resume.educations.add(education);
	}
	// Adaugarea unei experiente profesionale
	public void add(Experience experience) {
		this.resume.experiences.add(experience);
	}
	// Adaugarea unui nou cunoscut
	public void add(Consumer consumer) {
		this.consumers.add(consumer);
	}
	// Determinarea gradului de prietenie (parcurgere in latime in retea sociala)
	public int getDegreeInFriedship(Consumer consumer) {

		// presupun ca numarul maxim de consumeri va fi <= 1000
		boolean visited[] = new boolean[1000]; // vector de consumeri vizitati
		int degree[] = new int[1000] ;	// vector de graduri ale consumerilor

		// setez gradul consumerului curent
		degree[this.index] = 0;
		// folosesc structura queue pentru a parcurge "graful" de consumeri bfs
		LinkedList<Consumer> queue = new LinkedList<Consumer>();
		queue.add(this);

		// algoritmul standart bfs
		while (!queue.isEmpty()) {
			Consumer current = queue.removeFirst();

			if (visited[current.index]) {
				continue;
			}
			// marchez consumerul curent ca unul vizitat
			visited[current.index] = true;

			if (current.consumers == null) {
				continue;
			}

			// parcurg prietenii consumerului curent
			for (Consumer friend: current.consumers ) {
				// daca nu am vizitat prietenul consumer-ului curent =>
				if (visited[friend.index] == false) {
					// il adaug in coada
					queue.add(friend);
					// actualizez gradul
					if (degree[friend.index] == 0 ) {
						degree[friend.index] = degree[current.index] + 1;
					}
				}
			}
		}
		// daca degree[consumer.idx] == 0 avem 2 cazuri :
		// 1) consumer-ul parametru este consumer-ul propriuzis => returnam 0
		// 2) consumer-ul parametru nu este consumer-ul propriuzis => nu exista legatura intre cei 2 => returnam -1

		if (degree[consumer.index] == 0) {
			if (this.equals(consumer)) {
				return 0; // insasi consumer
			}
			else {
				return -1; // nu exista relatie de prietenie (directionata)
			}	
		}
		// returnez gradul de prietenie intre this(consumerul sursa) si consumer(parametru)
		return degree[consumer.index];
	}
	// Eliminarea unei persoane din reteaua sociala
	public void remove(Consumer consumer) {
		// Dupa cum a fost specificat pe forum => consumer-ul(parametru)
		// poate sa apara doar in lista cu cunostinde directe (grad = 1)
		
		// sterg persoana din reteaua sociala
		this.consumers.remove(consumer);
	}
	// Determinarea anului absolvirii
	public Integer getGraduationYear() {
		int graduationYear = 0; // (null) daca presupun ca nu a absolvit => nu am ce returna
		// verific educatia din resume
		for (Education education : this.resume.educations) {
			// daca gasesc informatie despre licenta (college)
			if (education.level.equals("college")) {
				// daca exista anul absolvirii
				if (education.end_date != null) {
					// parsez anul absolvirii din string in int
					graduationYear = Integer.parseInt(education.end_date.substring(6));
				}
			}
		}
		return graduationYear;
	}
	// Determinarea mediei studiilor absolvite
	public Double meanGPA() {
		double meanGPA = 0;
		// luand in considerare ca media de final nu va fi niciodata null (din enunt)
		// parcurg colectia educations si calculez media aritmetica
		for (Education education : this.resume.educations) {
			meanGPA = meanGPA + education.grade/this.resume.educations.size();
		}
		return meanGPA;
	}

	class Resume {
		Information information;
		TreeSet<Education> educations;
		TreeSet<Experience> experiences;
		
		public Resume() {
			this.information = new Information();
			this.educations = new TreeSet<Education>();
			this.experiences = new TreeSet<Experience>();
		}
	}
}
