package iid3rp.util;

import java.util.*;

public class Cipherer
{
    public static String shift(String text, int shift)
    {
        String cipherText = "";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < text.length(); i++) 
        {
            char currentChar = text.charAt(i);
            if (!(Character.isLetter(currentChar))) 
            {
               cipherText += currentChar;
            } 
            else 
            {
                boolean isUppercase = Character.isUpperCase(currentChar);
                for (int j = 0; j < letters.length(); j++) 
                {
                    if (Character.toLowerCase(currentChar) == letters.charAt(j)) 
                    {
                        if(shift < 1)
                        {
                            shift = (26 - (Math.abs(shift) % 26));
                        }
                        char shiftedChar = letters.charAt((j + shift) % 26);
                        if (isUppercase) 
                        {
                            shiftedChar = Character.toUpperCase(shiftedChar);
                        }    
                        cipherText += shiftedChar;
                        break;
                    }
                }
            }
        }  
        return cipherText; 
    }
}