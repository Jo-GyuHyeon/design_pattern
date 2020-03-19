package observer.case2.spet1;

import java.util.ArrayList;
import java.util.List;

// subject 객체 역할
public class PlayController implements Publisher {
    private List<Observer> observers = new ArrayList<>();
    private boolean play;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(play);
        }
    }

    public void setFlag(boolean bPlay) {
        this.play = play;
        notifyObservers();
    }

    //실행 여부 플래그 값 반환
    public boolean getFlag() {
        return play;
    }
}
