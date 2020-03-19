package observer.case2.spet1;

public interface Publisher {
    public void addObserver(Observer observer);

    public void deleteObserver(Observer observer);

    public void notifyObservers();
}
