package com.pluralsight;
import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your name, step by step. Skip any fields that do not apply.");

        String firstName = getInputFromConsole("First name: ", s, false);
        String middleName = getInputFromConsole("Middle name or initial: ", s, true);
        String lastName = getInputFromConsole("Last name: ", s, true);
        String suffix = getInputFromConsole("Suffix: ", s, true);

        String fullName = parseFullName(firstName, middleName, lastName, suffix);
        System.out.println("Full name: " + fullName);
    }


    public static String getInputFromConsole(String display, Scanner s, boolean clearBuffer) {
        if (clearBuffer) s.nextLine();
        System.out.println(display);
        return s.nextLine().trim();
    }

    public static String parseFullName(String firstName, String middleName, String lastName, String suffix) {
        StringBuilder fullNameContainer = new StringBuilder();
        if (!firstName.isEmpty()) {
            fullNameContainer.append(firstName).append(" ");
        }
        if (!middleName.isEmpty()) {
            fullNameContainer.append(middleName).append(middleName.length() > 1 ? " " : ". ");
        }
        if (!lastName.isEmpty()) {
            fullNameContainer.append(lastName);
        }
        if (!suffix.isEmpty()) {
            fullNameContainer.append(", ").append(suffix);
        }
        return fullNameContainer.toString().trim();
    }
}
