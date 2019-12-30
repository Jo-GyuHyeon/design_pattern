package singleton.case1.step1;

public class Database {
    private static Database singleton;
    private String name;

    public Database(String name) {
        super();
        this.name = name;
    }

    public static Database getInstance(String name) {
        if (singleton == null) {
            singleton = new Database(name);
        }
        return singleton;
    }

    public String getName() {
        return name;
    }
}
