package singleton.case2;

//    웹 상의 많은 페이지를 동시에 열어 본다는 것은 쓰레드에서 동시에 메서드를 호출하는 것과 동일 하다.
public class TestPattern2 {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
//            쓰레드 마다 구분되는 로그 작성용 파라미터
            Thread thread = new ThreadSub(i);
            thread.start();
        }
    }
}

//    외부 클래스
class ThreadSub extends Thread {
    int num;

    public ThreadSub(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        LogWriter logger = LogWriter.getInstance();
        if (num < 10) {
            logger.log("*** 0" + num + "***");
        } else {
            logger.log("*** " + num + "***");

        }
    }
}
