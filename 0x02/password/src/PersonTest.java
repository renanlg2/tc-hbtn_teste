import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {
    private Person p;

    @BeforeAll
    void setup(){
         p = new Person();
    }

    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    void check_user_valid(String user){
        assertTrue(p.checkUser(user));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    void check_user_not_valid(String user){
        assertFalse(p.checkUser(user));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    void does_not_have_letters(String password){
        assertFalse(p.checkPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    void does_not_have_numbers(String password){
        assertFalse(p.checkPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    void does_not_have_eight_chars(String password){
        assertFalse(p.checkPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    void check_password_valid(String password){
        assertTrue(p.checkPassword(password));
    }



}
