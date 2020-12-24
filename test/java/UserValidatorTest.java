import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


public class UserValidatorTest extends TestCase {


    //use case 1 test cases for first name
    @Test
    //when the name starts with a capital letter
    public void givenFirstName_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("Ashwini");
        Assert.assertEquals(true, result);
    }

    @Test
    //when a name starts with a small letter
    public void givenFirstName_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("ashwini");
        Assert.assertEquals(false, result);
    }

    //when a name has 3 or more letters
    @Test
    public void givenFirstName_MinimumThreeLetters_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("Ash");
        Assert.assertEquals(true, result);
    }

    @Test
    //when a name does not contain 3 minimum letters
    public void givenFirstName_NotHaveMinimumThreeLetters_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("As");
        Assert.assertEquals(false, result);
    }

    //LastName
    @Test
    public void givenLastName_WhenLastNameStartsWithCapitalLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("Patil");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenLastName_WhenLastNameNotStartsWithCapitalLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("patil");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_WhenLastNameHaveMinimumThreeLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("Pat");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenLastName_WhenLastNameNotHaveMinimumThreeLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("pa");
        Assert.assertEquals(false, result);
    }

    //email pattern
    @Test
    public void givenEmail_WhenEmailStartsWithSmallLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("ashwinip309@gmail.com");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenEmail_WhenEmailNotStartsWithSmallLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("Abc@gmail.com");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenEmail_WhenEmailEndsWithComOrIn_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("abc111@redix.com");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenEmail_WhenEmailNotEndsWithComOrIn_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("Abc@gmail.akdh");
        Assert.assertEquals(false, result);
    }

    //phone
    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsFollowedByCountryCode_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("91 9669367025");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsNotFollowedByCountryCode_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("8105290414");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsTenDigit_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("91 9604989258");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsNotTenDigit_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("91 8105215");
        Assert.assertEquals(false, result);
    }

    //password
    @Test
    public void givenPassword_WhenPasswordIsMinimumEightDigit_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Ashu234$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordIsNotMinimumEightDigit_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("patil");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneCapitalLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Ashwini0805$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordNotHaveAtleastOneCapitalLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("djdhjd@");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneNumericNumber_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Ashwinipatil2$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordNotHaveAtleastOneNumericNumber_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("afjsdh@");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneSpeacialCharacter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Ashu7597$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordNotHaveAtleastOneSpeacialCharacter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("sdfkls123");
        Assert.assertEquals(false, result);
    }

    //
    @RunWith(Parameterized.class)
    public static class MultipleEntryEmail {
        String emailId;
        boolean expected_Result;
        private UserValidator emailVariable;
        UserValidator formObject = new UserValidator();

        public MultipleEntryEmail(String emailId, boolean expected_Result) {
            this.emailId = emailId;
            this.expected_Result = expected_Result;
        }

        @Before
        public void initialize() {
            emailVariable = new UserValidator();
        }

        @Parameterized.Parameters
        public static Collection emails() {
            return Arrays.asList(new Object[][]{
                    {"ashwinip309@gmail.com", true},
                    {"Abc@gmail.com", false},
                    {"abc111@redix.com", true},
                    {"Abc@gmail.akdh", false}
            });
        }

        @Test
        public void testEmailId() {
            System.out.println("Parameterized email is " + emailId);
            assertEquals(expected_Result, emailVariable.validateMultipleEmail(emailId));
        }
    }
}