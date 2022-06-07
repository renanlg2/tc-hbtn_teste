import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private int birthDate;
    private boolean anotherCompanyOwner;
    private boolean Pensioner;
    private boolean PublicServer;
    private float salary;

    public Person(String name, String surname, int birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        Pensioner = pensioner;
        PublicServer = publicServer;
    }

    public String fullName() {
        return this.name + " " + this.surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public double calculateYearlySalary() {
        return this.getSalary() * 12;
    }

    public boolean isMEI() {

        return (
                this.getSalary() < 130000 &&
                        Period.between(LocalDate.of(this.birthDate, 01,01) , LocalDate.now()).getYears() >= 18 &&
                        !this.anotherCompanyOwner &&
                        !this.Pensioner &&
                        !PublicServer
        );
    }
}
