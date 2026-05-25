/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart3;

/**
 *
 * @author setheMA OFENTSE
 */
public class POEPART3 {

    }

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.POEPART3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sethe
 */
public class POEPART3 {

        import java.util.*;

public class QuickChatPart3 {
    // Arrays for different message categories
    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();

  
    static class Message {
        String id;
        String recipient;
        String text;

        Message(String id, String recipient, String text) {
            this.id = id;
            this.recipient = recipient;
            this.text = text;
        }

       
        String createHash() {
            String[] words = text.split(" ");
            String firstWord = words[0];
            String lastWord = words[words.length - 1];
            return id.substring(0, 2) + ":" + firstWord + lastWord;
        }

        
        public String String() {
            return "ID: " + id + ", Hash: " + createHash() +
                   ", Recipient: " + recipient + ", Message: " + text;
        }
    }

    
    static void sendMessage(Message m) {
        sentMessages.add(m);
        System.out.println("Message sent");
    }

    static void storeMessage(Message m) {
        storedMessages.add(m);
        System.out.println("Message stored");
    }

    static void disregardMessage(Message m) {
        disregardedMessages.add(m);
        System.out.println("Message disregarded");
    }


    static void showSentMessages() {
        for (Message m : sentMessages) {
            System.out.println(m);
        }
    }

    
    static void showLongestStored() {
        String longest = "";
        for (Message m : storedMessages) {
            if (m.text.length() > longest.length()) {
                longest = m.text;
            }
        }
        System.out.println("Longest stored message: " + longest);
    }

    
    static void searchById(String id) {
        for (Message m : storedMessages) {
            if (m.id.equals(id)) {
                System.out.println("Found: " + m.text);
                return;
            }
        }
        System.out.println("Message ID not found");
    }


    static void searchByRecipient(String rec) {
        for (Message m : storedMessages) {
            if (m.recipient.equals(rec)) {
                System.out.println("Found: " + m.text);
            }
        }
    }


    static void deleteByHash(String hash) {
        Iterator<Message> it = storedMessages.iterator();
        while (it.hasNext()) {
            Message m = it.next();
            if (m.createHash().equals(hash)) {
                it.remove();
                System.out.println("Message deleted: " + m.text);
                return;
            }
        }
        System.out.println("Hash not found");
    }

    
    static void displayReport() {
        System.out.println("Report of Sent Messages:");
        for (Message m : sentMessages) {
            System.out.println("Hash: " + m.createHash() +
                               ", Recipient: " + m.recipient +
                               ", Message: " + m.text);
        }
    }

    
    public static void main(String[] args) {
        System.out.println("QuickChat Part 3 Demo");

        Message m1 = new Message("01", "+27834557896", "Did you get the cake?");
        sendMessage(m1);

        Message m2 = new Message("02", "+27838884567", "Where are you? You are late! I have asked you to be on time.");
        storeMessage(m2);

        Message m3 = new Message("03", "+27834484567", "Yohoooo, I am at your gate.");
        disregardMessage(m3);

        Message m4 = new Message("04", "+27838884567", "Ok, I am leaving without you.");
        storeMessage(m4);

        showSentMessages();
        showLongestStored();
        searchById("02");
        searchByRecipient("+27838884567");
        deleteByHash(m2.createHash());
        displayReport();
    }
}
}

