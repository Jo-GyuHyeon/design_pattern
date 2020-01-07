package observer.case1;

public class TestPattern {
    public static void main(String[] args) {
        PlayController playController = new PlayController();

        MyClassA classA = new MyClassA(playController);
        MyClassB classB = new MyClassB(playController);

        System.out.println("== 모든 클래스 일시 정지 ==");
        playController.setFlag(false);
        System.out.println();

        System.out.println("== 모든 클래스 다시 시작 ==");
        playController.setFlag(true);
        System.out.println();
    }
}
