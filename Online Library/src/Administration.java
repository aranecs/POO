package tema1;

import java.util.ArrayList;
import java.util.List;

public class Administration
{
	public List<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
		// parcurg toate publishing retailer-urile ca sa gasesc cel cu id-ul necesar
		PublishingRetailer pr = tema1.getPublishingRetailer(tema1.publishingRetailersALL, publishingRetailerID);
		// parcurg publishing artifacts din acest retailer si formez lista de carti
		List<Book> resultBooks = new ArrayList<Book>();
		for (IPublishingArtifact IPA : pr.publishingArtifacts) {
			resultBooks.add(((Book) IPA));
		}
		
		return resultBooks;
	}
	
	public List<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID) {
		// parcurg toate publishing retailer-urile ca sa gasesc cel cu id-ul necesar
		PublishingRetailer pr = tema1.getPublishingRetailer(tema1.publishingRetailersALL, publishingRetailerID);
		Book b;
		int langID;
		boolean exists; // existenta limbii in Languages 
		List<Language> Languages = new ArrayList<Language>();
		for (IPublishingArtifact IPA : pr.publishingArtifacts) {
			exists = false; // presupun ca limba nu exista
			b = (Book) IPA;
			langID = Integer.parseInt(b.languageID);
			// verific daca nu am adaugat deja o limba (pentru a nu avea dublicate)
			for (Language l : Languages) {
				if (l.ID == langID) {
					// daca exista
					exists = true;
				}
			}
			
			// adaug limba daca nu exista
			if (exists == false) {
				for (Language l : tema1.languagesALL) {
					if (l.ID == langID) {
						Languages.add(l);
					}
				}
			}
		}
		
		return Languages;
	}
	
	public List<Country> getCountriesForBookID(int bookID) {
		List<Country> Countries = new ArrayList<Country>();
		boolean contain;
		Book book;
		// parcurg toate retailer urile
		for(PublishingRetailer pr : tema1.publishingRetailersALL) {
			contain = false; // presupun ca retailer ul nu contine cartea
			// parcurg toate cartile de la retailer
			for(IPublishingArtifact ipa : pr.publishingArtifacts) {
				book = (Book) ipa;
				// verific daca contine cartea cu ID-ul necesar
				if (book.ID == bookID) {
					contain = true;
					break; // ies din for
				}
				
			}
			
			// daca contine cartea
			if (contain == true) {
				// adaug la tari toate tarile din acel retailer
				for(Country c : pr.countries) {
					Countries.add(c);
				}
			}
		}
		
		return Countries;
		
	}
}
