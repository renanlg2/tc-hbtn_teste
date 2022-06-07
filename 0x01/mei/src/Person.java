import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private Date birthdate;
    private boolean anotherComanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, int birthdate, boolean anotherComanyOwner, boolean pensioner, boolean publicServer) {
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonth().getValue();

        this.name = name;
        this.surname = surname;
        this.birthdate = new Date(currentDay, currentMonth, birthdate);
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
        LocalDate bithDateLocalDate = LocalDate.from(Instant.ofEpochMilli(this.birthdate.getTime()).atZone(ZoneId.systemDefault()));

        return (
                this.getSalary() < 130000 &&
                        Period.between(bithDateLocalDate, LocalDate.now()).getYears() >= 18 &&
                        !this.anotherComanyOwner &&
                        !this.pensioner &&
                        !publicServer
        );
    }
}
