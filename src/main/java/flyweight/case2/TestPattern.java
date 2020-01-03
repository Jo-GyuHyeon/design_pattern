package flyweight.case2;

public class TestPattern {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        flyweightFactory.getSubject("a");
        flyweightFactory.getSubject("a");
        flyweightFactory.getSubject("b");
        flyweightFactory.getSubject("b");
    }
}
