package tema1;
import java.util.ArrayList;
import java.util.List;

public class Book implements IPublishingArtifact{
    int ID; //identificator unic
    String name;//numele de publicare al cartii
    String subtitle;//subtitlu al cartii
    String ISBN;//identificat unic al cartii
    int PageCount;//numar de pagini
    String keywords;//cuvinte cheie ale cartii, separate prin ";"
    String languageID;//limba in care este scrisa
    String createdOn;//data adaugarii in sistem a cartii
    List<Author> authors = new ArrayList<Author>();

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount,
    		String keywords, String languageID, String createdOn) {
    	this.ID = ID;
    	this.name = name;
    	this.subtitle = subtitle;
    	this.ISBN = ISBN;
    	this.PageCount = pageCount;
    	this.keywords = keywords;
    	this.languageID = languageID;
    	this.createdOn = createdOn;
    }
    
    // pentru a adauga un autor in carte
    public void addAuthor(Author author) {
    	this.authors.add(author);
    }

    @Override
    public String Publish() {
        String result = "<xlm>\n" +
        		"\t<title>" + this.name + "</title>\n" +
        		"\t<subtitle>" + this.subtitle + "</subtitle>\n" +
        		"\t<isbn>" + this.ISBN + "</isbn>\n" +
        		"\t<pageCount>" + this.PageCount + "</paceCount>\n" +
        		"\t<keywords>" + this.keywords + "</keywords>\n" +
        		"\t<languageID>" + this.languageID + "</languageID>\n" +
        		"\t<createdOn>" + this.createdOn + "</createdOn>\n";
        
        result += "\t<authors>";
        for (int i = 0; i < this.authors.size(); i++) {
        	result += this.authors.get(i).firstName + " " + this.authors.get(i).lastName + ";";
        }
        result += "</authors>\n" + "</xml>\n";
        
        return result;
    }
}
