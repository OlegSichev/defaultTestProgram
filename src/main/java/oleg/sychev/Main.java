package oleg.sychev;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введи что нибудь, а я тебе покажу. что ты ввел)");
        String input = scanner.nextLine();
        System.out.println(input);
    }
}