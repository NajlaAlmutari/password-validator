package com.acme.csci3130assig2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }



    public class UserPasswordValidatorTest {

        @Test
        public void testStage1ValidatingPassword() {
            // Rules:
            // - it is not “password” (case insensitive)
            // - it is at least 8 characters long

            assertEquals(UserPasswordValidator.Stage1ValidatingPassword("PASSWOrD"), 1);
            assertEquals(UserPasswordValidator.Stage1ValidatingPassword("XYZJ"), 1);
            assertEquals(UserPasswordValidator.Stage1ValidatingPassword("XYZJKHIG"), 2);
            assertEquals(UserPasswordValidator.Stage1ValidatingPassword("XYZJKHIGQR"), 2);
        }
}
    @Test
    public void testStage2ValidatingPassword() {
        // Rules:
        // 1 -  at least 8 characters long
        // 2 -  not “password” (case insensitive)
        // 3 - at least one upper and lower case character
        // 4 - at least one special character @,!,&, #,$
        // 5 - at least one digit

        // rule 2, 3 matching
        assertEquals(UserPasswordValidator.Stage2ValidatingPassword("Xyzj"), 2);

        // rule 2, 3, 5 matching
        assertEquals(UserPasswordValidator.Stage2ValidatingPassword("Xyzj57"), 3);

        // rule 2, 3, 5, 1 matching
        assertEquals(UserPasswordValidator.Stage2ValidatingPassword("Xyzj57kh"), 4);

        // rule 2, 5, 1 matching
        assertEquals(UserPasswordValidator.Stage2ValidatingPassword("xyzj57kh"), 3);

        // rule 2, 3, 5, 1 matching
        assertEquals(UserPasswordValidator.Stage2ValidatingPassword("Xyzj57kh"), 4);

        // rule 2, 1, 4, 5, 3 matching
        assertEquals(UserPasswordValidator.Stage2ValidatingPassword("Xyzj57$kh"), 5);
    }
}