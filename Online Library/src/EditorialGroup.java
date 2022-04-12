package tema1;
import java.util.ArrayList;
import java.util.List;

public class EditorialGroup implements IPublishingArtifact{
    int ID;//identificator unic
    String name;
    List<Book> books;
    
    public EditorialGroup(int ID, String name) {
    	this.ID = ID;
    	this.name = name;
    	this.books = new ArrayList<Book>();
    }
    
    public void addBook(Book b) {
    	this.books.add(b);
    }

	@Override
	public String Publish() {
        String result = "<xml>\n" + 
        				"\t<editorialGroup>\n" +
        				"\t\t<ID>" + this.ID + "<ID>\n" +
        				"\t\t<Name>" + this.name + "</Name>\n" +
        				"\t</editorialGroup>\n" + 
        				"\t<books>\n";
        for (Book b : this.books) {
        	String bookinfo = 
        			"\t\t<book>" +
        			"\t\t\t<title>" + b.name + "</title>\n" +
            		"\t\t\t<subtitle>" + b.subtitle + "</subtitle>\n" +
            		"\t\t\t<isbn>" + b.ISBN + "</isbn>\n" +
            		"\t\t\t<pageCount>" + b.PageCount + "</paceCount>\n" +
            		"\t\t\t<keywords>" + b.keywords + "</keywords>\n" +
            		"\t\t\t<languageID>" + b.languageID + "</languageID>\n" +
            		"\t\t\t<createdOn>" + b.createdOn + "</createdOn>\n";
            
            bookinfo += "\t\t\t<authors>";
            for (int i = 0; i < b.authors.size(); i++) {
            	bookinfo += b.authors.get(i).firstName + " " + b.authors.get(i).lastName + ";";
            }
            bookinfo += "\t\t\t</authors>\n" + "<\t\t/book>\n";
            result += bookinfo;
        }
        
        result += "\t</books>\n" + "</xml>\n";
        
        return result;
    }
}
