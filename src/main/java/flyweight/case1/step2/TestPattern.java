package flyweight.case1.step2;

public class TestPattern {
    public static void main(String[] args) {
        MyData md1 = new MyData();
        md1.xpos = 10;
        md1.ypos = 11;
        md1.name = "홍길동";

        MyData md2 = new MyData();
        md2 = md1;

        MyData md3 = new MyData();
        md3.xpos = 20;
        md3.ypos = 21;
        md3.name = "손오공";

        md2.name = "전우지";
        md2.xpos = 5;
    }
}

class MyData {
    int xpos;
    int ypos;
    String name;
}
