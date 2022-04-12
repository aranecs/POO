package temaPOO;

interface Subject {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers(String notification);
}

interface Observer {
	void update(String notification);
}

