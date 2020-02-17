package adapter.case1;

public class TestPattern {
    public static void main(String[] args) {
        APlayer aPlayer = new APlayerImpl();
        aPlayer.play("aaa.mp3");

//        계약기간 만료로 AplyerImplt() 를 사용할수 없습니다.

        //Bplayer : 새로 도입된 방식 (잘 동작할 것이다.)

        BPlayer bPlayer = new BPlayerImpl();
        bPlayer.playFile("bbb.mp3");

        // Aplyer obj = (어댑터) = new BPlayerImpl();
        // 기존의 잘 동작하던 코드와 새로 도입된 코드를
        // 변경 없이 사용하고 싶은 것이다.
        // 어댑터 적용 후 에러가 난다면 어댑터 부분만 보면 될 것이다.

        aPlayer = new BToAAdapter(new BPlayerImpl());
        aPlayer.play("ccc.mp3");

        // APlayer obj = (어댑터 ) = new BPlayerImpl();
        // 기존의 잘 동작하던 코드와 새로 도입된 코드를
        // 변경 없이 사용하고 싶은 것이다.
        // 어댑터 적용후 에어가 난다면 어댑터 부분만 보면 될 것이다.

    }
}
