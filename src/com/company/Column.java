package com.company;

public class Column {
    private static char [][] outArray;

    private static int[] GetKeyEncrypt(String key){
        char c = (char)2000;
        int[] keyNumArr = new int[key.length()];

        StringBuilder keyBuild = new StringBuilder(key);
        for (int i = 0; i < keyBuild.length(); i++) {
            int min = i;
            for (int j = 0; j < keyBuild.length(); j++) {
                if (keyBuild.charAt(j) != c) {
                    min = j;
                    break;
                }
            }

            for (int j = 0; j < keyBuild.length(); j++){
                if ((int)keyBuild.charAt(j) < (int)keyBuild.charAt(min)){
                    min = j;
                }
            }
            keyNumArr[i] = min;
            keyBuild.setCharAt(min, c);
        }
        return keyNumArr;
    }

    private static int[] GetKeyDecrypt(String key){
        int[] keyNumArr = new int[key.length()];
        StringBuilder keyBuild = new StringBuilder(key);

        for (int i = 0; i < keyBuild.length(); i++) {
            int min = 0;
            for (int j = 0; j < keyBuild.length(); j++)
            {
                if ((int)keyBuild.charAt(i) > (int)keyBuild.charAt(j))
                {
                    min++;
                }
                else if (((int)keyBuild.charAt(i) == (int)keyBuild.charAt(j)) && (i > j))
                {
                    min++;
                }
            }
            keyNumArr[i] = min;
        }
        return keyNumArr;
    }

    public static String EncryptColumn(String toEncrypt, String key) {

        int col = key.length();
        int row = 0;
        String temp = "";

        while (temp.length() < toEncrypt.length()) {
            temp = temp.concat(key);
            row++;
        }

        outArray = new char[row][col];
        String EncryptBuffer = toEncrypt;

        while (EncryptBuffer.length() % col != 0){
            EncryptBuffer = EncryptBuffer.concat(String.valueOf('&'));
        }

        int index = 0;
        int m = 0;
        while (index < EncryptBuffer.length()){
            int n = 0;
            while (n < col && index < EncryptBuffer.length()) {
                outArray[m][n] = EncryptBuffer.charAt(index);
                n++;
                index++;
            }
            m++;
        }

        String resultText = "";
        int[] keys = GetKeyEncrypt(key);

        for (int number : keys) {
            for (int j = 0; j < row; j++)
                resultText = resultText.concat(String.valueOf(outArray[j][number]));
        }
        return resultText;
    }
}
