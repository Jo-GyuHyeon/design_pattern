package observer.case2.spet1;

//Observer 객체 역할
public class MyClassA implements Observer {

    private boolean bPlay; //실행 여부

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
