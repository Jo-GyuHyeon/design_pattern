package singleton.case1.step2;

public class Database {
    private static Database singleton;
    private String name;

    private Database(String name) {
        try {
            Thread.sleep(100);
            this.name = name;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Database getInstance(String name) {
        if (singleton == null) {
            singleton = new Database(name);
        }
        return singleton;
    }

    public String getName() {
        return name;
    }
}
