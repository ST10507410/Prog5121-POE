/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ofentse sethema
 */
      

public class part2 {

    // Simple login simulation
    public static boolean login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // For now, accept any non-empty credentials
        if (!username.isEmpty() && !password.isEmpty()) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed. Please try again.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!login(sc)) {
            System.out.println("Exiting application...");
            return;
        }

        System.out.println("Welcome to QuickChat");

        System.out.print("How many messages would you like to send? ");
        int maxMessages = sc.nextInt();
        sc.nextLine(); // consume newline

        ArrayList<String> sentMessages = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    if (sentMessages.size() < maxMessages) {
                        System.out.print("Enter your message: ");
                        String message = sc.nextLine();
                        sentMessages.add(message);
                        System.out.println("Message sent!");
                    } else {
                        System.out.println("You have reached the maximum number of messages.");
                    }
                    break;

                case "2":
                    System.out.println("Coming Soon.");
                    break;

                case "3":
                    System.out.println("Exiting QuickChat. Goodbye!");
                    running = false;
                    break;
            

               
                   
            
        


   
    


    

