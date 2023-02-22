package org.example;

import Kyus4.TheObservedPin;
import Kyus5.HumanReadableTime;
import Kyus5.ValidParentheses;

public class Main {
    public static void main(String[] args) {
        /* HumanReadableTime test
        HumanReadableTime test = new HumanReadableTime();
        System.out.println(test.makeReadable(5));
         */
        /*
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.validParentheses("(ab)"));
        */

        TheObservedPin test = new TheObservedPin();
        System.out.println(test.getPINs("1357"));
    }

}