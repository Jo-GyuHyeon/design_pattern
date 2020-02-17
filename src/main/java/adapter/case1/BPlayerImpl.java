package adapter.case1;

public class BPlayerImpl implements BPlayer {

    @Override
    public void playFile(String fileName) {
        System.out.println("fileName = " + fileName);
    }

    @Override
    public void stopFile() {

    }
}
