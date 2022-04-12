package temaPOO;
// clasa necesara pentru ecxeptie
@SuppressWarnings("serial")
class InvalidDatesException extends Exception {
	public InvalidDatesException() {
		super("Datele start_date si end_date sunt invalide din punct de vedere cronologic!");
	}
}

public class Education implements Comparable<Education> {
	String start_date;
	String end_date;
	String name;
	String level;
	float grade;
	
	// constructorul clasei
	public Education(String level, String name, String start_date, String end_date, float grade) {
		// initializez variabilele clasei
		this.level = level;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.grade = grade;
		// verific daca datele sunt valide.
		try {			
			if (start_date != null && end_date != null) {
				// daca start data > end date (imposibil)
				if (compareDates(start_date, end_date) > 0) {
					// arunc exceptia
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
	public int compareTo(Education education) {
		// Comparatie dupa end_date (descrescator)
		String str_A = education.end_date;
		String str_B = this.end_date;
		// daca studiile sunt in curs => compar cu start_date (crescator) 
		if (education.end_date == null || this.end_date == null) {
			str_A = this.start_date;
			str_B = education.start_date;
		}
		
		// daca datele sunt egale
		if (compareDates(str_A,str_B) == 0) {
			// compar mediile
			if (education.grade > this.grade) {
				return 1;
			} else if (education.grade == this.grade) {
				return 0;
			} else {
				return -1;
			}
		} else {
			// altfel compar datele
			return compareDates(str_A, str_B);
		}
	}

	// o medota auxiliara pentru a printa continutul clasei
	public String toString() {
		return "level : " + this.level +
				"\nname : " + this.name +
				"\nstart_date : " + this.start_date +
				"\nend_date : " + this.end_date +
				"\ngrade : " + this.grade + "\n\n";
	}
}
