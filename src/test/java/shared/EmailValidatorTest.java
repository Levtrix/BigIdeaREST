package shared;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {
    private EmailValidator emailValidator;
    private String correctEmail = "user@valid.com";
    private String incorrectEmail = "user@.invalid.com";

    @Before
    public void TestInitialize() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void TestCorrectEmailaddress() {
        assertEquals(true, emailValidator.validateEmail(correctEmail));
    }

    @Test
    public void TestIncorrectEmailaddress() {
        assertEquals(false, emailValidator.validateEmail(incorrectEmail));
    }

}