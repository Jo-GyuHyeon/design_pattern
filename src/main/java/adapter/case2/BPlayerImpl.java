package adapter.case2;

public class BPlayerImpl extends BPlayer {

    @Override
    public void playFile(String fileName) {
        System.out.println("fileName = " + fileName);
    }

    @Override
    public void stopFile() {

    }
}
