package singleton.case1.step1;

public class TestPattern1 {

    public static void main(String[] args) {
        Database database;
        database = Database.getInstance("첫 번째");
        System.out.println("database.getName() = " + database.getName());

        database = Database.getInstance("두 번째");
        System.out.println("database.getName() = " + database.getName());

//        Database d1 = new Database("1");
//        Database d2 = new Database("2");
//        Database d3 = new Database("3");
//        Database d4 = new Database("4");
//        Database d5 = new Database("5");
//        Database d6 = new Database("6");

        System.out.println("database use");
    }
}
