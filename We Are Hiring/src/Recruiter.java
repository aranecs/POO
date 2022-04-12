package temaPOO;

public class Recruiter extends Employee {
	String company;
	double rating;
	
	public Recruiter(int index) {
		super(index);
		this.rating = 5.0;
	}
	
	public Double evaluate(Job job, User user) {
		Double score = this.rating * user.getTotalScore();
		
		// creez cererea de angajare
		Request<Job, Consumer> request = new Request<Job, Consumer>(job, (User)user, (Recruiter)this, score);
		
		// caut manager-ul companiei
		for (Company company : Application.companies) {
			// daca numele companiei corespunde cu numele companiei recruiter-ului
			if (company.name.equals(this.company)) {
				// adaug cererea
				company.manager.addRequests(request);
				break;
			}
		}
		
		// actualizarea rating-ului
		this.rating += 0.1;
		// returnez : rating_recruiter * scor_user
		return score;
	}
}
