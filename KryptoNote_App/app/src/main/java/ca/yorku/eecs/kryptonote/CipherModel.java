package ca.yorku.eecs.kryptonote;

import android.widget.EditText;

public class CipherModel
{
    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWYZ";

    public CipherModel(String k){
        this.key = k;
    }



    private String makePad(String note){
        String pad = this.key;
        for (; pad.length()< note.length();){
            pad += this.key;
        }

        return pad;
    }

    public String encrypt(String note){
        String pad =makePad(note);
        String result ="";
        for (int i = 0; i < note.length(); i++){
            String c = note.substring(i,i+1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i+1));
            int newPosiion = (position + shift)%ALPHABET.length();
            result = result + ALPHABET.substring(newPosiion, newPosiion+1);
        }
        return result;
    }
    public String decrypt(String note){
        String pad =makePad(note);
        String result ="";
        for (int i = 0; i < note.length(); i++){
            String c = note.substring(i,i+1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i+1));
            int newPosiion = (position - shift)%ALPHABET.length();
            result = result + ALPHABET.substring(newPosiion, newPosiion+1);
        }
        return result;
    }
}
