package observer.case2.step2;

//Observer 객체 역할
public class MyClassA implements Observer {

    Publisher observable; // 동록될 Observalbe
    private boolean bPlay; //실행 여부

    // 생성될때 직접 자기 자신을 옵저버에 등록한다.
    public MyClassA(Publisher o) {
        this.observable = o;
        observable.addObserver(this);
    }

    @Override
    public void update(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    private void myActControl() {
        if (bPlay) {
            System.out.println("MyClassA : 동작을 시작 합니다.");
        } else {
            System.out.println("MyClassA : 동작을 정지합니다.");
        }
    }
}
