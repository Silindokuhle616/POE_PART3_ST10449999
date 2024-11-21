/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author bails
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testSetUserRegister() {
    }

    @Test
    public void testSetPassWordRegister() {
    }

    @Test
    public void testSetFirstName() {
    }

    @Test
    public void testSetLastName() {
    }

    @Test
    public void testSetUserLogin() {
    }

    @Test
    public void testSetUserPassword() {
    }

    @Test
    public void testGetUserRegister() {
    }

    @Test
    public void testGetPassWordRegister() {
    }

    @Test
    public void testGetFirstName() {
    }

    @Test
    public void testGetLastName() {
    }

    @Test
    public void testGetUserName() {
    }

    @Test
    public void testGetPasswordLogin() {
    }

    @Test
    public void testCheckUsernameTrue() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        assertTrue(login.checkUsername());
        System.out.println("Test CheckUsernameTrue: " + login.checkUsername());
    }

    @Test
    public void testCheckUsernameFalse() {
        Login login = new Login();
        login.setUserRegister("hytreee1");
        assertFalse(login.checkUsername());
        System.out.println("Test CheckUsernameFalse: " + login.checkUsername());
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        Login login = new Login();
        login.setPassWordRegister("!1Asdfgh");
        assertTrue(login.checkPasswordComplexity());
        System.out.println("Test CheckPasswordComplexityTrue: " + login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        Login login = new Login();
        login.setPassWordRegister("!1fgh");
        assertFalse(login.checkPasswordComplexity());
        System.out.println("Test CheckPasswordComplexityFalse: " + login.checkPasswordComplexity());
    }

    @Test
    public void testLoginUserUsernameFail() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        login.setUserPassword("Password");
        login.setUserLogin("kyl");
        login.setPassWordRegister("Password");
        assertFalse(login.loginUser());
        System.out.println("Test LoginUserNameFalse: " + login.loginUser());
    }

    @Test
    public void testLoginUserPasswordFail() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        login.setUserPassword("Password");
        login.setUserLogin("kay_1");
        login.setPassWordRegister("WrongPassword");
        assertFalse(login.loginUser());
        System.out.println("Test LoginPasswordFalse: " + login.loginUser());
    }

    @Test
    public void testLoginUserTrue() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        login.setUserPassword("Password");
        login.setUserLogin("kay_1");
        login.setPassWordRegister("Password");
        assertTrue(login.loginUser());
        System.out.println("Test LoginUserTrue: " + login.loginUser());
    }
}
