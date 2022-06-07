import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PersonTest {
    Person p;

    @BeforeEach
    public void setup(){
        p = new Person("Paul", "McCartney", 2000, true, true, true );
    }

    @Test
    public void show_full_name(){
        assertEquals("Paul McCartney", p.fullName());
    }

    @Test
    public void test_calculateYearlySalary(){
        p.setSalary(1200);
        assertEquals(14400, p.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI(){
        assertFalse(p.isMEI());
    }

    @Test
    public void person_is_not_MEI(){
        p.setSalary(15000);
        assertFalse(p.isMEI());
    }

}
