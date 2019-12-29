package di;

import java.util.Date;

public class UnderstandDI {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }

    public static void getDate(Date d) {
        Date date = d;
        System.out.println(date);
    }

    public static void memberUser1() {
//        강한 결합 : 직접 생성
        Member m1 = new Member();
//        억지스럽지만 Member 클래스의 생성자 메서드를 private 으로 변경하면 문제가 생긴다
//        이와 반대로 약한 겷합은 안전하고 유연하게 대체 가능하다
    }

    public static void memberUser2(Member m) {
//        약한 결합 : 생성된 것을 주입 받음 - 의존 주입 (Dependency Injection)
        Member m2 = m;
    }
}

//    Member를 사용한다.-->Member의 기능에 의존한다 라는 의미
class Member {
    String name;
    String nickname;

    public Member() {

    }
//    private Member() {
//    }
}
