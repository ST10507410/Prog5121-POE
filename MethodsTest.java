/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.userlogin;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MethodsTest {

    private Methods methods;

    @BeforeEach
    void setUp() {
        methods = new Methods();
        methods.firstName = "Test";
        methods.surname = "User";
    }

    void setValidDefaults() {
        methods.userName = "kyl_1";
        methods.password = "Ch&&sec@ke99!";
        methods.cellPhone = "+27838968976";
    }

    @Test
    void testLoginStatus_Success() {
        setValidDefaults();
        methods.enteredUserName = "kyl_1";
        methods.enteredPassword = "Ch&&sec@ke99!";
        methods.enteredCell = "+27838968976";

        String expected = "Successful login\nWelcome Test, User, it is great to see you.";
        assertEquals(expected, methods.returnLoginStatus());
    }

    @Test
    void testLoginStatus_Failure() {
        setValidDefaults();
        methods.enteredUserName = "wrong";
        methods.enteredPassword = "Ch&&sec@ke99!";
        methods.enteredCell = "+27838968976";

        String expected = "A failed login\nUsername or Password incorrect, please try again.";
        assertEquals(expected, methods.returnLoginStatus());
    }

    @Test
    void testUsernameValid() {
        methods.userName = "abc_d";
        assertTrue(methods.checkUsername());
    }

    @Test
    void testUsernameInvalid_NoUnderscore() {
        methods.userName = "abcde";
        assertFalse(methods.checkUsername());
    }

    @Test
    void testUsernameInvalid_TooLong() {
        methods.userName = "abcdef";
        assertFalse(methods.checkUsername());
    }

    @Test
    void testPasswordValidComplexity() {
        methods.password = "Abc@1234";
        assertTrue(methods.checkPasswordComplexity());
    }

    @Test
    void testPasswordInvalid_MissingUpper() {
        methods.password = "abc@1234";
        assertFalse(methods.checkPasswordComplexity());
    }

    @Test
    void testPasswordInvalid_MissingDigit() {
        methods.password = "Abc@defg";
        assertFalse(methods.checkPasswordComplexity());
    }

    @Test
    void testPasswordInvalid_MissingSpecial() {
        methods.password = "Abc12345";
        assertFalse(methods.checkPasswordComplexity());
    }

    @Test
    void testCellPhoneValid() {
        methods.cellPhone = "+27838968976";
        assertTrue(methods.checkCellPhone());
    }

    @Test
    void testCellPhoneInvalid_MissingPlus() {
        methods.cellPhone = "27838968976";
        assertFalse(methods.checkCellPhone());
    }

    @Test
    void testRegisterUser_AllValid() {
        setValidDefaults();
        String result = methods.registerUser();
        assertTrue(result.contains("Username successfully captured"));
        assertTrue(result.contains("Password successfully captured"));
        assertTrue(result.contains("Cell phone number successfully added"));
    }

    @Test
    void testRegisterUser_InvalidUsername() {
        methods.userName = "kyle";
        methods.password = "Ch&&sec@ke99!";
        methods.cellPhone = "+27838968976";
        String result = methods.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    void testRegisterUser_InvalidPassword() {
        methods.userName = "kyl_1";
        methods.password = "password";
        methods.cellPhone = "+27838968976";
        String result = methods.registerUser();
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    void testRegisterUser_InvalidPhone() {
        methods.userName = "kyl_1";
        methods.password = "Ch&&sec@ke99!";
        methods.cellPhone = "0831234567";
        String result = methods.registerUser();
        assertTrue(result.contains("Cell phone number incorrectly formatted"));
    }

    @Test
    void testLoginFailsDueToWrongCellPhone() {
        setValidDefaults();
        methods.enteredUserName = "kyl_1";
        methods.enteredPassword = "Ch&&sec@ke99!";
        methods.enteredCell = "+27831111111"; // Mismatch
        assertFalse(methods.loginUser());
    }
}