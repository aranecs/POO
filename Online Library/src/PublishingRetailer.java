package tema1;

import java.util.ArrayList;
import java.util.List;

public class PublishingRetailer {
	int ID;
	String name;
	List<IPublishingArtifact> publishingArtifacts;
	List<Country> countries;
	
	public PublishingRetailer(int ID, String name) {
		this.ID = ID;
		this.name = name;
		this.publishingArtifacts = new ArrayList<IPublishingArtifact>();
		this.countries = new ArrayList<Country>();	
	}
	
	public void addPublishingArtifact(IPublishingArtifact IPA) {
		this.publishingArtifacts.add(IPA);
	}
	
	public void addCountry(Country c) {
		this.countries.add(c);
	}
}
