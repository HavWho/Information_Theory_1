package com.company;

import java.util.Scanner;

import static com.company.Rails.*;

public class Main {

    public static void Vigener(String input) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your string: ");
        String StringForEncrypt = scanner.nextLine();

        System.out.print("Input your key: ");
        int key = scanner.nextInt();

        System.out.println("Rails encryption method: ");
        System.out.println(EncryptRails(StringForEncrypt, key));
        System.out.println(DecryptRails(EncryptRails(StringForEncrypt, key), key));
    }
}
