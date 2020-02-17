package adapter.case1;

public class APlayerImpl implements APlayer {
    @Override
    public void play(String fileName) {
        System.out.println("fileName = " + fileName);
    }

    @Override
    public void stop() {

    }
}
