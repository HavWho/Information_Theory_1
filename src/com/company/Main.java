package com.company;

import java.util.Scanner;

import static com.company.Rails.*;
import static com.company.Column.*;
import static com.company.Lattice.*;
import static com.company.Vigener.*;

public class Main {

    public static void main(String[] args) {
        Scanner ScannerInt = new Scanner(System.in);
        Scanner ScannerString = new Scanner(System.in);
        Scanner ScannerInt2 = new Scanner(System.in);

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
        System.out.println(DecryptColumn(EncryptColumn(StringForEncrypt, StringKey), StringKey));

        System.out.println("\n");

        boolean flag = true;

        System.out.print("Input matrix size for Lattice method: ");

        //do {
            //int n;
            //n = ScannerInt2.nextInt();

            //if (n % 2 == 0 && n * n >= StringForEncrypt.length()) {

               // flag = false;

                //int[][] MatrixForLattice = new int[n][n];
                //MatrixForLattice = latticeInput(n);

                //System.out.println("Rotating Lattice encryption method: ");
                //System.out.println(EncryptLattice(StringForEncrypt, n, MatrixForLattice));
                //System.out.println("decryption: ");
                //System.out.println(DecryptLattice(EncryptLattice(StringForEncrypt, n, MatrixForLattice), n, MatrixForLattice));
            //} //else {
                //System.out.println("Incorrect input!");
            //}
        //} while(flag);

        System.out.println("\n");

        System.out.println("Vigener encryption method: ");
        Vigener vigener = new Vigener(ScannerString.nextLine(), StringForEncrypt);
        System.out.println(vigener.EncryptVigener(StringForEncrypt));
        System.out.println("decryption: ");
        System.out.println(vigener.DecryptVigener(vigener.EncryptVigener(StringForEncrypt), vigener.key));
    }
}
