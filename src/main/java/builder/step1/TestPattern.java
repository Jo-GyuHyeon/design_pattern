package builder.step1;

public class TestPattern {
    public static void main(String[] args) {
        Person p1 = createPersonForTesting();
        System.out.println(p1.getFirstName());
    }

    public static Person createPersonForTesting() {
        Person person = new Person();
        person.setFirstName("First");
        person.setLastName("LastName");
        person.setAddressOne("ADD1");
        person.setAddressTwo("ADD2");
        person.setSex("Man");
        person.setDriverLicence(false);
        person.setMarried(true);
//        멤버변수가 많다면 변수에 값 세팅이 어려워진다.

        return person;
    }
}
