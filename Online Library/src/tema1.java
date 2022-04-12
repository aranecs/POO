package tema1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*; 

public class tema1 {
	
	// listele cu baza de date a aplicatiei
	static List<Author> authorsALL = new ArrayList<Author>();
	static List<Book> booksALL = new ArrayList<Book>();
	static List<Country> countriesALL = new ArrayList<Country>();
	static List<EditorialGroup> editorialGroupsALL= new ArrayList<EditorialGroup>();
	static List<Language> languagesALL = new ArrayList<Language>();
	static List<PublishingBrand> publishingBrandsALL = new ArrayList<PublishingBrand>();
	static List<PublishingRetailer> publishingRetailersALL = new ArrayList<PublishingRetailer>();
	
	public static void main(String[] args) {
		// fisierele de input pentru a citi datele
		File authorsIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\authors.in");
		File booksIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\books.in");
		File books_authorsIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\books-authors.in");
		File countriesIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\countries.in");
		File editorialGroupIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\editorial-groups.in");
		File EDBookIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\editorial-groups-books.in");
		File languagesIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\languages.in");
		File publishingBrandIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-brands.in");
		File PBBookIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-brands-books.in");
		File publishingRetailerIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-retailers.in");
		File PRBookIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-retailers-books.in");
		File PRCountryIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-retailers-countries.in");
		File PREditorialGroupIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-retailers-editorial-groups.in");
		File PRPublishingBrandIN = new File("C:\\Users\\arane\\eclipse-workspace\\TemaMihaela\\init\\publishing-retailers-publishing-brands.in");

		// listele cu baza de date a aplicatiei
		//List<Author> authorsALL = new ArrayList<Author>();
		//List<Book> booksALL = new ArrayList<Book>();
		//List<Country> countriesALL = new ArrayList<Country>();
		//List<EditorialGroup> editorialGroupsALL= new ArrayList<EditorialGroup>();
		//List<Language> languagesALL = new ArrayList<Language>();
		//List<PublishingBrand> publishingBrandsALL = new ArrayList<PublishingBrand>();
		//List<PublishingRetailer> publishingRetailersALL = new ArrayList<PublishingRetailer>();
		
		// CITIRE AUTORI (authors.in)
		try (BufferedReader br = new BufferedReader(new FileReader(authorsIN))) {	
			String matrix[] = new String[3];
			String line;

			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 3);			
				// adaug autorul
				authorsALL.add(new Author(matrix[1], matrix[2], Integer.parseInt(matrix[0])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE CARTI (books.in)
		try (BufferedReader br = new BufferedReader(new FileReader(booksIN))) {	 
			String matrix[] = new String[8];
			String line;
			
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 8);
				// adaug cartea
				booksALL.add(new Book(Integer.parseInt(matrix[0]), matrix[1], matrix[2], matrix[3], Integer.parseInt(matrix[4]), matrix[5], matrix[6], matrix[7]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE ASOCIERE CARTE-AUTOR (books-authors.in)
		try (BufferedReader br = new BufferedReader(new FileReader(books_authorsIN))) {	 
			String matrix[] = new String[2];
			String line;
			int bookID;
			int authorID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				bookID = Integer.parseInt(matrix[0]);
				authorID = Integer.parseInt(matrix[1]);
				// gasesc cartea si autorul dupa ID
				Book b = getBook(booksALL, bookID);
				Author a = getAuthor(authorsALL, authorID);
				// adaug autorul la carte
				b.addAuthor(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE TARI (countries.in)
		try (BufferedReader br = new BufferedReader(new FileReader(countriesIN))) {	
			String matrix[] = new String[2];
			String line;

			// citesc prima linie de care nu am nevoie
			line = br.readLine();
					
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 2);			
				// adaug tara
				countriesALL.add(new Country(Integer.parseInt(matrix[0]), matrix[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE GRUPURI EDITORIALE (editorial-groups.in)
		try (BufferedReader br = new BufferedReader(new FileReader(editorialGroupIN))) {	
			String matrix[] = new String[2];
			String line;

			// citesc prima linie de care nu am nevoie
			line = br.readLine();
							
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 2);			
				// adaug grupul
				editorialGroupsALL.add(new EditorialGroup(Integer.parseInt(matrix[0]), matrix[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE ASOCIERE GRUP EDITORIAL-CARTE (editorial-groups-books.in)
		try (BufferedReader br = new BufferedReader(new FileReader(EDBookIN))) {	 
			String matrix[] = new String[2];
			String line;
			int bookID;
			int EDID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				bookID = Integer.parseInt(matrix[1]);
				EDID = Integer.parseInt(matrix[0]);
				// gasesc cartea si grupul dupa ID
				Book b = getBook(booksALL, bookID);
				EditorialGroup ed = getEditorialGroup(editorialGroupsALL, EDID);
				// adaug cartea la grup
				ed.addBook(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE LIMBI (languages.in)
		try (BufferedReader br = new BufferedReader(new FileReader(languagesIN))) {	
			String matrix[] = new String[3];
			String line;

			// citesc prima linie de care nu am nevoie
			line = br.readLine();
							
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 3);			
				// adaug limba
				languagesALL.add(new Language(Integer.parseInt(matrix[0]), matrix[1], matrix[2]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE PUBLISHING BRANDS (publishing-brands.in)
		try (BufferedReader br = new BufferedReader(new FileReader(publishingBrandIN))) {	
			String matrix[] = new String[2];
			String line;

			// citesc prima linie de care nu am nevoie
			line = br.readLine();
									
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 2);			
				// adaug limba
				publishingBrandsALL.add(new PublishingBrand(Integer.parseInt(matrix[0]), matrix[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE ASOCIERE PUBLISHING BRAND-CARTE (publishing-brands-books.in)
		try (BufferedReader br = new BufferedReader(new FileReader(PBBookIN))) {	 
			String matrix[] = new String[2];
			String line;
			int bookID;
			int PBID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				bookID = Integer.parseInt(matrix[1]);
				PBID = Integer.parseInt(matrix[0]);
				// gasesc cartea si brand ul dupa ID
				Book b = getBook(booksALL, bookID);
				PublishingBrand pb = getPublishingBrand(publishingBrandsALL, PBID);
				// adaug cartea la grup
				pb.addBook(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE PUBLISHING RETAILERS (publishing-retailers.in)
		try (BufferedReader br = new BufferedReader(new FileReader(publishingRetailerIN))) {	
			String matrix[] = new String[2];
			String line;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// extrag datele din linie
				matrix = line.split("###", 2);			
				// adaug publishingRetailer
				publishingRetailersALL.add(new PublishingRetailer(Integer.parseInt(matrix[0]), matrix[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// CITIRE ASOCIERE PUBLISHING RETAILER-CARTE (publishing-retailers-books.in)
		try (BufferedReader br = new BufferedReader(new FileReader(PRBookIN))) {	 
			String matrix[] = new String[2];
			String line;
			int bookID;
			int PRID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				bookID = Integer.parseInt(matrix[1]);
				PRID = Integer.parseInt(matrix[0]);
				// gasesc cartea si retail ul dupa ID
				Book b = getBook(booksALL, bookID);
				PublishingRetailer pr = getPublishingRetailer(publishingRetailersALL, PRID);
				// adaug cartea la PR
				pr.addPublishingArtifact(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE ASOCIERE PUBLISHING RETAILER-TARA (publishing-retailers-countries.in)
		try (BufferedReader br = new BufferedReader(new FileReader(PRCountryIN))) {	 
			String matrix[] = new String[2];
			String line;
			int countryID;
			int PRID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				countryID = Integer.parseInt(matrix[1]);
				PRID = Integer.parseInt(matrix[0]);
				// gasesc cartea si retail ul dupa ID
				Country c = getCountry(countriesALL, countryID);
				PublishingRetailer pr = getPublishingRetailer(publishingRetailersALL, PRID);
				// adaug tara la PR
				pr.addCountry(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE ASOCIERE PUBLISHING RETAILER-GRUPEDITORIAL (publishing-retailers-editorial-groups.in)
		try (BufferedReader br = new BufferedReader(new FileReader(PREditorialGroupIN))) {	 
			String matrix[] = new String[2];
			String line;
			int groupID;
			int PRID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				groupID = Integer.parseInt(matrix[1]);
				PRID = Integer.parseInt(matrix[0]);
				// gasesc grupul si retail ul dupa ID
				EditorialGroup ed = getEditorialGroup(editorialGroupsALL, groupID);
				PublishingRetailer pr = getPublishingRetailer(publishingRetailersALL, PRID);
				// adaug toate cartile de la grup editorial catre publishing retailer
				for (Book b : ed.books) {
					pr.addPublishingArtifact(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// CITIRE ASOCIERE PUBLISHING RETAILER-GRUPEDITORIAL (publishing-retailers-publishing-brands.in)
		try (BufferedReader br = new BufferedReader(new FileReader(PRPublishingBrandIN))) {	 
			String matrix[] = new String[2];
			String line;
			int publisherID;
			int PRID;
			// citesc prima linie de care nu am nevoie
			line = br.readLine();
			// citesc informatia necesara
			while ((line = br.readLine()) != null) {
				// pentru a extrage datele din linie
				matrix = line.split("###", 2);
				publisherID = Integer.parseInt(matrix[1]);
				PRID = Integer.parseInt(matrix[0]);
				// gasesc grupul si retail ul dupa ID
				PublishingBrand pb = getPublishingBrand(publishingBrandsALL, publisherID);
				PublishingRetailer pr = getPublishingRetailer(publishingRetailersALL, PRID);
				// adaug toate cartile de la publishing brand catre publishing retailer
				for (Book b : pb.books) {
					pr.addPublishingArtifact(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// instanta a clasei Administration
		Administration admin = new Administration();
		
		
		List<Book> tmpb = admin.getBooksForPublishingRetailerID(1);
		for(Book b : tmpb) {
			System.out.println(b.Publish());
		}
		
		List<Language> tmpl = admin.getLanguagesForPublishingRetailerID(1);
		for(Language l : tmpl) {
			System.out.println(l.translation);
		}
		
		System.out.println();
		
		List<Country> tmpc = admin.getCountriesForBookID(204);
		for(Country c : tmpc) {
			System.out.println(c.countryCode);
		}
		
	}
	
	
	// metoda pentru a selecta cartea dupa ID
	public static Book getBook(List<Book> list, int ID){
		for (Book b : list) {
			if (b.ID == ID) {
				return b;
			}
		}
		return null;
	}
		
	// metoda pentru a selecta autorul dupa ID
	public static Author getAuthor(List<Author> list, int ID){
		for (Author a : list) {
			if (a.ID == ID) {
				return a;
			}
		}
		return null;
	}
	
	// metoda pentru a selecta grupul editorial dupa ID
	public static EditorialGroup getEditorialGroup(List<EditorialGroup> list, int ID){
		for (EditorialGroup ed : list) {
			if (ed.ID == ID) {
				return ed;
			}
		}
		return null;
	}
	
	// metoda pentru a selecta brand ul de publicare dupa ID
	public static PublishingBrand getPublishingBrand(List<PublishingBrand> list, int ID){
		for (PublishingBrand pb : list) {
			if (pb.ID == ID) {
				return pb;
			}
		}
		return null;
	}
	
	// metoda pentru a selecta brand ul de publicare dupa ID
	public static PublishingRetailer getPublishingRetailer(List<PublishingRetailer> list, int ID){
		for (PublishingRetailer pr : list) {
			if (pr.ID == ID) {
				return pr;
			}
		}
		return null;
	}
	
	// metoda pentru a selecta tara dupa ID
	public static Country getCountry(List<Country> list, int ID){
		for (Country c : list) {
			if (c.ID == ID) {
				return c;
			}
		}
		return null;
	}
	
}
