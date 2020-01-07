package builder.step2;

import java.time.LocalDate;
import java.time.Month;

public class TestPattern {
    public static void main(String[] args) {
        Person p1 = Person.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .addressOne("add1")
                .addressTwo("add2")
                .birthDate(LocalDate.of(1993, Month.JULY, 28))
                .sex("male")
                .driverLicence(true)
                .married(true)
                .build();

        System.out.println(p1.getAddressOne());
    }
}
