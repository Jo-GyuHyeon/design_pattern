package singleton.case2;

public class TestPattern1 {
    public static void main(String[] args) {
        LogWriter loggger;

        loggger = LogWriter.getInstance();
        loggger.log("홍길동");

        loggger = LogWriter.getInstance();
        loggger.log("전우치");
    }
}
