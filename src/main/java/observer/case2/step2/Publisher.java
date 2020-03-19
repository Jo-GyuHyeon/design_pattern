package observer.case2.step2;

public interface Publisher {
    public void addObserver(Observer observer);

    public void deleteObserver(Observer observer);

    public void notifyObservers();
}
