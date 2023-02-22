package Kyus4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheObservedPin {

        public static List<String> getPINs(String observed) {

           /* My approach is:
            1- Map with key of each digit and add maps the digit and its adjacents
            2- Convert the pin into String array so that I can iterate over each character
            3- Combine all possible solutions for the observed PIN
            4- Return the List
           *
           * */

            // map each digit to an array of character with all possible digits
            Map<Character, char[]> adjacentDigits = new HashMap<>();
            adjacentDigits.put('1', new char[]{'1', '2', '4'});
            adjacentDigits.put('2', new char[]{'1', '2', '3', '5'});
            adjacentDigits.put('3', new char[]{'2', '3', '6'});
            adjacentDigits.put('4', new char[]{'1', '4', '5', '7'});
            adjacentDigits.put('5', new char[]{'2', '4', '5', '6', '8'});
            adjacentDigits.put('6', new char[]{'3', '5', '6', '9'});
            adjacentDigits.put('7', new char[]{'4', '7', '8'});
            adjacentDigits.put('8', new char[]{'5', '7', '8', '9', '0'});
            adjacentDigits.put('9', new char[]{'6', '8', '9'});
            adjacentDigits.put('0', new char[]{'0', '8'});

            // convert the observed PIN into an array of Characters
            char[] observedChars = observed.toCharArray();

            // Store all possible combinations into a List of Strings
            List<String> combinations = new ArrayList<>();
            combinations.add("");

            // for each character of the observed PIN bring each array of characters,
            // itearate over each possible combination of that digit and add them to the list created above.
            for (char c : observedChars) {
                char[] adjacent = adjacentDigits.get(c);
                int size = combinations.size();
                for (int i = 0; i < size; i++) {
                    String s = combinations.get(0);
                    for (char a : adjacent) {
                        combinations.add(s + a);
                    }
                    combinations.remove(0);
                }
            }
            return combinations;
        }


    /*Alright, detective, one of our colleagues successfully observed our target person, Robby the robber.
      We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this
      warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN
      he saw, when Robby entered it.


        The keypad has the following layout:
        ┌───┬───┬───┐
        │ 1 │ 2 │ 3 │
        ├───┼───┼───┤
        │ 4 │ 5 │ 6 │
        ├───┼───┼───┤
        │ 7 │ 8 │ 9 │
        └───┼───┼───┘
            │ 0 │
            └───┘

    He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually
    be another adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could
    also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.

    He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they
    never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.
    possible in sense of: the observed PIN itself and all variations considering the adjacent digits

    Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list in Java/Kotlin and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be strings, because of potentially leading '0's. We already prepared some test cases for you.
    Detective, we are counting on you!
     */

    /* This is another solutions I found interesting to keep in mind:
    *

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ObservedPin {

  public static List<String> getPINs(String observed) {
  	return Arrays.stream(observed.split(""))
        .map(Integer::parseInt)
        .map(ObservedPin::neighbors)
		    .reduce(ObservedPin::product).get();
	}

	private static List<String> product(List<String> lefts, List<String> rights) {
		return lefts.stream()
        .flatMap(s -> rights.stream().map(j -> s + j))
        .collect(Collectors.toList());
	}

	private static List<String> neighbors(int i) {
		switch (i) {
		case 1:	return Arrays.asList("1", "2", "4");
		case 2:	return Arrays.asList("1", "2", "3", "5");
		case 3:	return Arrays.asList("2", "3", "6");
		case 4:	return Arrays.asList("1", "4", "5", "7");
		case 5:	return Arrays.asList("2", "4", "5", "6", "8");
		case 6:	return Arrays.asList("3", "5", "6", "9");
		case 7:	return Arrays.asList("4", "7", "8");
		case 8:	return Arrays.asList("5", "7", "8", "9", "0");
		case 9:	return Arrays.asList("6", "8", "9");
		case 0:	return Arrays.asList("8", "0");
		}
		return null;
	}

}
    *
    * */

}
