package Kyus5;

import java.util.HashMap;
import java.util.Map;

public class Scramblies {

    /*
    Complete the function scramble(str1, str2) that returns true if a portion of str1 characters
    can be rearranged to match str2, otherwise returns false.

        Notes:

        Only lower case letters will be used (a-z). No punctuation or digits will be included.
        Performance needs to be considered.
        Examples
        scramble('rkqodlw', 'world') ==> True
        scramble('cedewaraaossoqqyt', 'codewars') ==> True
        scramble('katas', 'steak') ==> False
    */

    //Commented solution:
    // I will create an array of 26 for each letter of the alphabet. the index will be according to ascii starting from 'a' position
    // then I will iterate str1 and for each character of str1 i'll increment the value or count of that char
    // after that, I will do a similar process for str2, but instead decrement.
    //possible solutions:
    // zero -> there is a character in str2 that is not found in 1 (I need only positive numbers)
    // negative -> false (i have more letters in str2 than 1)


    public static boolean scramble(String str1, String str2) {
        int[] charCount = new int[26]; // count of each character in str1
        for (char c : str1.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : str2.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // character not found in str1
            }
            charCount[c - 'a']--;
        }

        return true;
    }

}
