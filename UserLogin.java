/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userlogin;

/**
 *
 * @author RC_Student_lab
 */

import java.util.Scanner;

public class UserLogin {

    public static void main(String[] args) {
        Methods methods = new Methods();
        Scanner input = new Scanner(System.in);

        // Registration Process
        System.out.println("Register..........");
        System.out.print("Enter First Name: ");
        methods.firstName = input.next();
        System.out.print("Enter Last Name: ");
        methods.surname = input.next();
        System.out.print("Enter Username: ");
        methods.userName = input.next();
        System.out.print("Enter Password: ");
        methods.password = input.next();
        System.out.println("Enter cellphone number");
        methods.cellPhone=input.next();
        System.out.println(methods.registerUser());

        // Ensure valid username and password complexity
        while (!methods.checkUsername() || !methods.checkPasswordComplexity()) {
            System.out.println("Try to register again!!!!!");
            System.out.print("Enter Username: ");
            methods.userName = input.next();
            System.out.print("Enter Password: ");
            methods.password = input.next();
             System.out.println("Enter cellphone number");
        methods.cellPhone=input.next();
            System.out.println(methods.registerUser());
        }

        // Login Process
        System.out.println("Login..........");
        System.out.print("Enter Username: ");
        methods.enteredUserName = input.next();
        System.out.print("Enter Password: ");
        methods.enteredPassword = input.next();
         System.out.println("Enter cellphone number");
        methods.enteredCell=input.next();
        System.out.println(methods.returnLoginStatus());

        while (!methods.loginUser()) {
            System.out.println("Try to Login again ..........");
            System.out.print("Enter Username: ");
            methods.enteredUserName = input.next();
            System.out.print("Enter Password: ");
            methods.enteredPassword = input.next();
             System.out.println("Enter cellphone number");
        methods.cellPhone=input.next();
            System.out.println(methods.returnLoginStatus());
        }

        
    }
}
