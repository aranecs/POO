package temaPOO;

public class Experience implements Comparable<Experience> {
	String company;
	String position;
	String department;
	String start_date;
	String end_date;
	
	// constructorul clasei
	public Experience(String company, String position, String department, String start_date, String end_date) {
		// initializez variabilele clasei
		this.company = company;
		this.position = position;
		this.start_date = start_date;
		this.end_date = end_date;
		this.department = department;
		// verific daca datele sunt valide.
		try {			
			if (start_date != null && end_date != null) {
				// daca start data > end date (imposibil)
				if (compareDates(start_date, end_date) > 0) {
					// arunc exceptia
					// clasa InvalidDatesException -> in "Education.java"
					throw new InvalidDatesException();
				}
			}
		} catch (InvalidDatesException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *	metoda "compareDates" compara 2 date si returneaza:
	 *	numar pozitiv daca date1 > date2
	 *	numar negativ daca date1 < date2
	 *	0 daca date1 = date2 
	 */
	public int compareDates(String date1, String date2) {
		//[0,1,2,3,4,5,6,7,8,9] => indicii
		//[0,1,.,1,1,.,2,0,0,2] => string-ul de data
		
		// daca anii sunt egali
		if (date1.substring(6).compareTo(date2.substring(6)) == 0) {
			// daca lunile sunt egale
			if (date1.substring(3,5).compareTo(date2.substring(3,5)) == 0) {
				// daca zilele sunt egale
				if (date1.substring(0,2).compareTo(date2.substring(0,2)) == 0) {
					return 0;
				} else {
					// compar zilele
					return date1.substring(0,2).compareTo(date2.substring(0,2));
				}
			} else {
				// compar lunile
				return date1.substring(3,5).compareTo(date2.substring(3,5));
			}
		} else {
			// compar anii
			return date1.substring(6).compareTo(date2.substring(6));
		}
	}

	@Override
	public int compareTo(Experience experience) {
		// daca experienta e in curs ori e egala cu o alta => compar dupa nume (crescator)
		if (experience.end_date == null || this.end_date == null 
				|| compareDates(experience.end_date, this.end_date) == 0 ) {
			return compareDates(this.company, experience.company);
		}
		// altfel compar dupa end_date (descrescator)
		return compareDates(experience.end_date, this.end_date);
	}

	// o medota auxiliara pentru a printa continutul clasei
	public String toString() {
		return "company : " + this.company +
				"\nposition : " + this.position +
				"\ndepartment : " + this.department +
				"\nstart_date : " + this.start_date +
				"\nend_date : " + this.end_date + "\n\n";
	}
}
