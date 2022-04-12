package temaPOO;
import java.util.*;

public class User extends Consumer implements Observer {
	String notification = null;
	// lista de companii
	ArrayList<String> companies;
	
	public User(int index) {
		super(index);
		this.companies = new ArrayList<String>();
	}
	
	// pentru a adauga o companie (la sfarsitul listei)
	public void addCompany(String company) {
		this.companies.add(company);
	}
	// pentru a sterge o companie
	public void removeCompany(String company) {
		this.companies.remove(company);
	}
	
	// converteste User in Employee
	public Employee convert() {
		return new Employee(this.index);
	}
	
	// scorul unui utilizator :
	// numar_ani_experienta * 1.5 + medie_academica
	public Double getTotalScore() {
		int numAniExperienta = 0;
		int firstExperienceYear = 0;
		int lastExperienceYear = 2021;
		
		// daca nu a avut experienta
		if (this.resume.experiences.isEmpty()) {
			return meanGPA(); // returnez doar media academica
		}
		
		// extrag prima si ultima experienta pentru a face diferenta de date
		// daca ultima experienta e in continuu (end_date = null), voi considera
		// ca anul curent = 2021
		
		firstExperienceYear = Integer.parseInt(this.resume.experiences.last().start_date.substring(6));
		// verific daca ultima experienta nu e in proces
		if (resume.experiences.first() != null) {
			lastExperienceYear = Integer.parseInt(this.resume.experiences.first().end_date.substring(6));
		}
		// numarul anilor de experienta il rotungesc => +1
		numAniExperienta = lastExperienceYear - firstExperienceYear + 1;
		
		// returnez scorul
		return numAniExperienta * 1.5 + meanGPA();
	}
	
	public void update(String notification) {
		this.notification = notification;
	}
}
