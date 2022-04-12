package tema1;

public class Language {
    int ID;//identificator unic
    String code;//cod de limba, prescurtare a limbii
    String translation;
    
    public Language(int ID, String code, String translation) {
    	this.ID = ID;
    	this.code = code;
    	this.translation = translation;
    }
}
