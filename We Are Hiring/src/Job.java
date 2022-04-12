package temaPOO;
import java.util.*;

public class Job {
	String jobName;
	String companyName;
	boolean flag;
	Constraint graduatedYear;
	Constraint experienceYears;
	Constraint media;
	ArrayList<User> candidati;
	int noPositions;
	int salary;
	
	public Job() {
		this.jobName = "";
		this.companyName = "";
		this.flag = true;
		this.graduatedYear = new Constraint();
		this.experienceYears = new Constraint();
		this.media = new Constraint();
		this.candidati = new ArrayList<User>();
		this.noPositions = 0;
		this.salary = 0;
		
	}
	
	public ArrayList<User> getCandidati() {
		return candidati;
	}

	public void setCandidati(ArrayList<User> candidati) {
		this.candidati = candidati;
	}

	public int getNoPositions() {
		return noPositions;
	}

	public void setNoPositions(int noPositions) {
		this.noPositions = noPositions;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Constraint getGraduatedYear() {
		return graduatedYear;
	}

	public void setGraduatedYear(Constraint graduatedYear) {
		this.graduatedYear = graduatedYear;
	}

	public Constraint getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(Constraint experienceYears) {
		this.experienceYears = experienceYears;
	}

	public Constraint getMedia() {
		return media;
	}

	public void setMedia(Constraint media) {
		this.media = media;
	}
	
	public void apply(User user) {
		Company company = null; //compania mama
		Recruiter recruiter; // recruiter-ul selectat
		// caut compania
		for (Company tmp : Application.companies) {
			if (this.companyName.equals(tmp.name)) {
				company = tmp;
				break;
			}
			if (company == null) {
				return;
			}
		}
		
		// presupun ca recruiter-ul selectat este primul din lista
		recruiter = company.recruiters.get(0);
		// variabilele in care voi pastra rangul parcurgerei
		int currentRecruiterDegree;
		int tmpRecruiterDegree;
		// parcurg lista de recruiteri din companie
		// verificand proprietatile din enunt
		for (Recruiter tmp : company.recruiters) {
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
		// adaug utilizatorul in lista de observatori cand acesta aplica
		company.addObserver(user);
		// apelul functiei evaluate(Job, User) din clasa Recruiter
		recruiter.evaluate(this, user);
		
	}
	
	public boolean meetsRequirments(User user) {
		// verific anul absolvirii
		if ((user.getGraduationYear() > this.graduatedYear.superior) ||
				(user.getGraduationYear() < this.graduatedYear.inferior)) {
			return false;
		}
		// verific media
		if ((user.meanGPA() > this.media.superior) || (user.meanGPA() < this.media.inferior)) {
			return false;
		}
		// verific numarul anilor de experienta
		// noi stim ca functia getTotalScore din clasa user are formula :
		// numar_ani_experienta * 1.5 + medie_academica => de aici deducem anii de experienta :
		// numar_ani_experienta = (getTotalScore() - media_academica)/1.5
		double numarAniExperienta = (user.getTotalScore() - user.meanGPA())/1.5;
		if (numarAniExperienta > this.experienceYears.superior ||
				numarAniExperienta < this.experienceYears.inferior) {
			return false;
		}
		// altfel toate constrangerele sunt indeplinite
		return true;
	}
}
