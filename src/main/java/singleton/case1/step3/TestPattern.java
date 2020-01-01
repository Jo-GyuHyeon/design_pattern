package singleton.case1.step3;

public class TestPattern {

    static int nNUm = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                nNUm++;
                Database database = Database.getInstance(nNUm + "번째 Database");
                System.out.println("This is the " + database.getName());

            } catch (Exception e) {
                e.getStackTrace();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(task);
            t.start();
        }
    }
}
