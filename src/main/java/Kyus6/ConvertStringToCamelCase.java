package Kyus6;

public class ConvertStringToCamelCase {
    /*
    Complete the method/function so that it converts dash/underscore delimited words into camel casing.
    The first word within the output should be capitalized only if the original word
    was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
    The next words should be always capitalized.

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
    * */

    // take a string as argument
    // look for "-" and get the index +1 to upper case
    // then replace it for nothing

    public static String toCamelCase(String s){
            String[] words = s.split("[_\\-]");
            s=words[0];
            for(int i=1; i<words.length; i++)
                s+=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
            return s;
        }
    }
/*

class Solution{

  static String toCamelCase(String str){
    String[] words = str.split("[-_]");
    return Arrays.stream(words, 1, words.length)
            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
            .reduce(words[0], String::concat);
  }
}

class Solution{

  static String toCamelCase(String s){
    String[] words = s.split("[_\\-]");
    s=words[0];
    for(int i=1; i<words.length; i++)
      s+=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
    return s;
  }
}
 */
