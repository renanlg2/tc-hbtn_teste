import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private int birthdate;
    private boolean anotherComanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, int birthdate, boolean anotherComanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.anotherComanyOwner = anotherComanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
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
                        Period.between(LocalDate.of(this.birthdate, 01,01) , LocalDate.now()).getYears() >= 18 &&
                        !this.anotherComanyOwner &&
                        !this.pensioner &&
                        !publicServer
        );
    }
}
