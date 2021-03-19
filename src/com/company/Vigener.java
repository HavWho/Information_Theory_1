package com.company;

public class Vigener {

    String key, text;

    public Vigener(String key, String toEncrypt){
        this.key = key;
        this.text = toEncrypt.replaceAll("\\s+","");
    }

    private static final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String GenerateSecretKey(String StringForWork, String key){

        StringBuilder resultKey = new StringBuilder();

        String withoutSpacesString = StringForWork.replaceAll("\\s+", "");
        String keyBuffer = key.replaceAll("\\s+", "");

        for (int i = 0; i < StringForWork.length(); i++){
            if (i >= keyBuffer.length()){
                int CharIndex = (i - keyBuffer.length()) % withoutSpacesString.length();
                resultKey.append(withoutSpacesString.charAt(CharIndex));
            }
            else{
                resultKey.append(keyBuffer.charAt(i));
            }
        }

        return resultKey.toString();

    }

    private static int GetIndexFromAlphabet(char symbol){
        return Alphabet.indexOf(symbol);
    }

    private static char GetCharFromAlphabet(int ind){
        return Alphabet.charAt(ind);
    }

    protected String EncryptVigener(String toEncrypt){

        StringBuilder resultText = new StringBuilder();

        int AlphabetLength = Alphabet.length();

        String newKey = GenerateSecretKey(this.text, this.key);

        for (int i = 0; i < this.text.length(); i++){

            int p = GetIndexFromAlphabet(this.text.charAt(i));
            int k = GetIndexFromAlphabet(newKey.charAt(i));
            int charIndex = (p + k) % AlphabetLength;
            resultText.append(GetCharFromAlphabet(charIndex));
        }

        return resultText.toString();

    }

    protected String DecryptVigener(String toDecrypt, String key){

        StringBuilder resultText = new StringBuilder();

        int AlphabetLength = Alphabet.length();

        String NewKey = "";

        for (int i = 0; i < this.text.length(); i++){
            int c = GetIndexFromAlphabet(toDecrypt.charAt(i));
            int k;
            if (i >= key.length()){
                k = GetIndexFromAlphabet(resultText.charAt((i - key.length())));
            }
            else{
                k = GetIndexFromAlphabet(key.charAt(i));
            }
            NewKey += GetCharFromAlphabet(k);
            int charIndex = (c - k + AlphabetLength) % AlphabetLength;
            resultText.append(GetCharFromAlphabet(charIndex));
        }

        return resultText.toString();

    }

}
