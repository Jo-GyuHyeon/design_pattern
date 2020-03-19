package observer.case2.step2;

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
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(play);
        }

        // 다음을 사용하면 구독 해지시 다음과 같은 에러가 발생한다.
        // ConcurrentModificationException
        for (Observer observer : observers) {
            observer.update(play);
        }
    }

    public void setFlag(boolean bPlay) {
        this.play = bPlay;
        notifyObservers();
    }

    //실행 여부 플래그 값 반환
    public boolean getFlag() {
        return play;
    }
}
