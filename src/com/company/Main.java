package com.company;

import java.util.Scanner;

import static com.company.Rails.*;
import static com.company.Column.*;

public class Main {

    public static void Vigener(String input) {

    }

    public static void main(String[] args) {
        Scanner ScannerInt = new Scanner(System.in);
        Scanner ScannerString = new Scanner(System.in);

        System.out.print("Input your string: ");
        String StringForEncrypt = ScannerInt.nextLine();

        System.out.print("Input your integer key: ");
        int key = ScannerInt.nextInt();

        System.out.print("Input your string key: ");
        String StringKey = ScannerString.nextLine();

        System.out.println("\n");

        System.out.println("Rails encryption method: ");
        System.out.println(EncryptRails(StringForEncrypt, key));
        System.out.println("decryption: ");
        System.out.println(DecryptRails(EncryptRails(StringForEncrypt, key), key));

        System.out.println("\n");

        System.out.println("Column encryption method: ");
        System.out.println(EncryptColumn(StringForEncrypt, StringKey));
        System.out.println("decryption: ");
    }
}
