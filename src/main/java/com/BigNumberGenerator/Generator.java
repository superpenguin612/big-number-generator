/*
VERSION HISTORY

v3.0 - adding support for numbers up to 10^(long max value)
v2.0 - adding support for numbers up to nongen-novem-nonagin-tillion (10^3002)
v1.5 - adding support for "Start Counting"
v1.0 - adding power
v0.1 - remake of original (option for power only)

*/

package com.BigNumberGenerator;

import static java.lang.Math.floor;
import static java.lang.Math.ceil;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Generator {

    public static void main(String[] args) {
        String numberString = "";

        // <editor-fold defaultstate="collapsed" desc="Power" >
        if ("Power".equals(args[0])) {
            BigDecimal three = new BigDecimal("3");
            BigDecimal one = new BigDecimal("1");

            BigDecimal arraySize = new BigDecimal(args[1]).divide(three, RoundingMode.FLOOR).add(one);

            BigDecimal slotNum = new BigDecimal("0");

            if (new BigDecimal(args[1]).remainder(three).compareTo(new BigDecimal(0)) == 0) {
                System.out.println(createNameOfThreeDigitSet("001", slotNum, arraySize));
            } else if (new BigDecimal(args[1]).remainder(three).compareTo(new BigDecimal(1)) == 0) {
                System.out.println(createNameOfThreeDigitSet("010", slotNum, arraySize));
            } else if (new BigDecimal(args[1]).remainder(three).compareTo(new BigDecimal(2)) == 0) {
                System.out.println(createNameOfThreeDigitSet("100", slotNum, arraySize));
            } else {
                return;
            }
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Just a Number" >
        if ("Just a Number".equals(args[0])) {
            numberString = args[1];

            String[] separatedSets = new String[(int) ceil(numberString.length() / 3d)];
            for (int i = 0; i < (floor(numberString.length() / 3)); i++) {
                if (numberString.length() % 3 == 1) {
                    separatedSets[i + 1] = Character.toString(numberString.charAt(i * 3 + 1))
                            + Character.toString(numberString.charAt(i * 3 + 2))
                            + Character.toString(numberString.charAt(i * 3 + 3));
                } else if (numberString.length() % 3 == 2) {
                    separatedSets[i + 1] = Character.toString(numberString.charAt(i * 3 + 2))
                            + Character.toString(numberString.charAt(i * 3 + 3))
                            + Character.toString(numberString.charAt(i * 3 + 4));
                } else {
                    separatedSets[i] = Character.toString(numberString.charAt(i * 3 + 0))
                            + Character.toString(numberString.charAt(i * 3 + 1))
                            + Character.toString(numberString.charAt(i * 3 + 2));
                }
            }
            // tacking on additional tens place or ones place
            switch (numberString.length() % 3) {
                case 1:
                    separatedSets[0] = "00" + String.valueOf(Character.digit(numberString.charAt(0), 10));
                    break;
                case 2:
                    separatedSets[0] = "0" + String.valueOf(Character.digit(numberString.charAt(0), 10))
                            + String.valueOf(Character.digit(numberString.charAt(1), 10));
                    break;
            }

            BigDecimal arraySize = new BigDecimal(separatedSets.length);
            for (int i = 0; i < separatedSets.length; i++) {
                if (!"000".equals(separatedSets[i])) {
                    BigDecimal slotNum = new BigDecimal(i);
                    System.out.println(createNameOfThreeDigitSet(separatedSets[i], slotNum, arraySize));
                }
            }
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Start Counting" >
        if ("Start Counting".equals(args[0])) {
            long number = 0L;
            for (long n = 1L; n < 9_223_372_036_854_775_807L; n++) {
                number = n;
                numberString = String.valueOf(number);

                String[] separatedSets = new String[(int) ceil(numberString.length() / 3d)];
                for (int i = 0; i < (floor(numberString.length() / 3)); i++) {
                    if (numberString.length() % 3 == 1) {
                        separatedSets[i + 1] = Character.toString(numberString.charAt(i * 3 + 1))
                                + Character.toString(numberString.charAt(i * 3 + 2))
                                + Character.toString(numberString.charAt(i * 3 + 3));
                    } else if (numberString.length() % 3 == 2) {
                        separatedSets[i + 1] = Character.toString(numberString.charAt(i * 3 + 2))
                                + Character.toString(numberString.charAt(i * 3 + 3))
                                + Character.toString(numberString.charAt(i * 3 + 4));
                    } else {
                        separatedSets[i] = Character.toString(numberString.charAt(i * 3 + 0))
                                + Character.toString(numberString.charAt(i * 3 + 1))
                                + Character.toString(numberString.charAt(i * 3 + 2));
                    }
                }
                // tacking on additional tens place or ones place
                switch (numberString.length() % 3) {
                    case 1:
                        separatedSets[0] = "00" + String.valueOf(Character.digit(numberString.charAt(0), 10));
                        break;
                    case 2:
                        separatedSets[0] = "0" + String.valueOf(Character.digit(numberString.charAt(0), 10))
                                + String.valueOf(Character.digit(numberString.charAt(1), 10));
                        break;
                }

                BigDecimal arraySize = new BigDecimal(separatedSets.length);
                for (int i = 0; i < separatedSets.length; i++) {
                    if (!"000".equals(separatedSets[i])) {
                        BigDecimal slotNum = new BigDecimal(i);
                        System.out.println(createNameOfThreeDigitSet(separatedSets[i], slotNum, arraySize));
                    }
                }
                try {
                    Thread.sleep(Integer.parseInt(args[1]));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Start Counting Powers">
        if ("Start Counting Powers".equals(args[0])) {
            BigDecimal slotNum = new BigDecimal(0);
            for (long i = 1L; i < 9_223_372_036_854_775_807L; i++) {
                BigDecimal arraySize = new BigDecimal(i);
                System.out.println(createNameOfThreeDigitSet("001", slotNum, arraySize));
                try {
                    Thread.sleep(Integer.parseInt(args[1]));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

        }
        // </editor-fold>

    }

    static String createNameOfThreeDigitSet(String threeDigitSet, BigDecimal slotNum, BigDecimal arraySize) {
        // Finished
        // <editor-fold defaultstate="collapsed" desc="Hundreds Maker" >
        // names for hundreds
        String[] oneToNine = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] elevenToNineteen = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };
        String[] tenToNinety = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
                "ninety" };
        String[] hundred = { "hundred" };
        // splitting digits
        int[] separatedHundredsDigits = new int[3];
        for (int i = 0; i < threeDigitSet.length(); i++) {
            separatedHundredsDigits[i] = Character.digit(threeDigitSet.charAt(i), 10);
        }

        // hundreds place (999: NINE HUNDRED ninety nine)
        String part1 = "";
        switch (separatedHundredsDigits[0]) {
            case 0:
                part1 = oneToNine[0];
                break;
            case 1:
                part1 = oneToNine[1] + " " + hundred[0];
                break;
            case 2:
                part1 = oneToNine[2] + " " + hundred[0];
                break;
            case 3:
                part1 = oneToNine[3] + " " + hundred[0];
                break;
            case 4:
                part1 = oneToNine[4] + " " + hundred[0];
                break;
            case 5:
                part1 = oneToNine[5] + " " + hundred[0];
                break;
            case 6:
                part1 = oneToNine[6] + " " + hundred[0];
                break;
            case 7:
                part1 = oneToNine[7] + " " + hundred[0];
                break;
            case 8:
                part1 = oneToNine[8] + " " + hundred[0];
                break;
            case 9:
                part1 = oneToNine[9] + " " + hundred[0];
                break;
        }

        // tens place (999: nine hundred NINETY nine)
        String part2 = "";
        if (separatedHundredsDigits[1] == 1 && separatedHundredsDigits[2] != 0) {
            switch (separatedHundredsDigits[2]) {
                case 0:
                    part2 = elevenToNineteen[0];
                    break;
                case 1:
                    part2 = elevenToNineteen[1];
                    break;
                case 2:
                    part2 = elevenToNineteen[2];
                    break;
                case 3:
                    part2 = elevenToNineteen[3];
                    break;
                case 4:
                    part2 = elevenToNineteen[4];
                    break;
                case 5:
                    part2 = elevenToNineteen[5];
                    break;
                case 6:
                    part2 = elevenToNineteen[6];
                    break;
                case 7:
                    part2 = elevenToNineteen[7];
                    break;
                case 8:
                    part2 = elevenToNineteen[8];
                    break;
                case 9:
                    part2 = elevenToNineteen[9];
                    break;
            }
        } else {
            switch (separatedHundredsDigits[1]) {
                case 0:
                    part2 = tenToNinety[0];
                    break;
                case 1:
                    part2 = tenToNinety[1];
                    break;
                case 2:
                    part2 = tenToNinety[2];
                    break;
                case 3:
                    part2 = tenToNinety[3];
                    break;
                case 4:
                    part2 = tenToNinety[4];
                    break;
                case 5:
                    part2 = tenToNinety[5];
                    break;
                case 6:
                    part2 = tenToNinety[6];
                    break;
                case 7:
                    part2 = tenToNinety[7];
                    break;
                case 8:
                    part2 = tenToNinety[8];
                    break;
                case 9:
                    part2 = tenToNinety[9];
                    break;

            }
        }

        // ones place (999: nine hundred ninety NINE)
        String part3 = "";
        if (separatedHundredsDigits[1] != 1) {
            switch (separatedHundredsDigits[2]) {
                case 0:
                    part3 = oneToNine[0];
                    break;
                case 1:
                    part3 = oneToNine[1];
                    break;
                case 2:
                    part3 = oneToNine[2];
                    break;
                case 3:
                    part3 = oneToNine[3];
                    break;
                case 4:
                    part3 = oneToNine[4];
                    break;
                case 5:
                    part3 = oneToNine[5];
                    break;
                case 6:
                    part3 = oneToNine[6];
                    break;
                case 7:
                    part3 = oneToNine[7];
                    break;
                case 8:
                    part3 = oneToNine[8];
                    break;
                case 9:
                    part3 = oneToNine[9];
                    break;
            }
        }
        String hundredsName;
        if (separatedHundredsDigits[0] != 0 && separatedHundredsDigits[1] == 1 && separatedHundredsDigits[2] != 0) { // 911
                                                                                                                     // (S)
            hundredsName = part1 + " " + part2;
        } else if (separatedHundredsDigits[0] == 0 && separatedHundredsDigits[1] == 1
                && separatedHundredsDigits[2] != 0) { // 011 (S)
            hundredsName = part2;
        } else if (separatedHundredsDigits[0] == 0 && separatedHundredsDigits[1] == 0
                && separatedHundredsDigits[2] != 0) { // 009
            hundredsName = part3;
        } else if (separatedHundredsDigits[0] == 0 && separatedHundredsDigits[1] != 0
                && separatedHundredsDigits[2] == 0) { // 090
            hundredsName = part2;
        } else if (separatedHundredsDigits[0] == 0 && separatedHundredsDigits[1] != 0
                && separatedHundredsDigits[2] != 0) { // 099
            hundredsName = part2 + " " + part3;
        } else if (separatedHundredsDigits[0] != 0 && separatedHundredsDigits[1] == 0
                && separatedHundredsDigits[2] == 0) { // 900
            hundredsName = part1;
        } else if (separatedHundredsDigits[0] != 0 && separatedHundredsDigits[1] == 0
                && separatedHundredsDigits[2] != 0) { // 909
            hundredsName = part1 + " " + part3;
        } else if (separatedHundredsDigits[0] != 0 && separatedHundredsDigits[1] != 0
                && separatedHundredsDigits[2] == 0) { // 990
            hundredsName = part1 + " " + part2;
        } else { // 999
            hundredsName = part1 + " " + part2 + " " + part3;
        }

        // </editor-fold>

        String name = "";

        // <editor-fold defaultstate="collapsed" desc="illions Maker" >
        BigDecimal prefix = arraySize.subtract(slotNum).subtract(new BigDecimal(2));
        String prefixString = prefix.toPlainString();

        // splitting prefix into three digit sets
        String[] separatedPrefixSets = new String[(int) ceil(prefixString.length() / 3d)];
        for (int i = 0; i < (floor(prefixString.length() / 3)); i++) {
            if (prefixString.length() % 3 == 1) {
                separatedPrefixSets[i + 1] = Character.toString(prefixString.charAt(i * 3 + 1))
                        + Character.toString(prefixString.charAt(i * 3 + 2))
                        + Character.toString(prefixString.charAt(i * 3 + 3));
            } else if (prefixString.length() % 3 == 2) {
                separatedPrefixSets[i + 1] = Character.toString(prefixString.charAt(i * 3 + 2))
                        + Character.toString(prefixString.charAt(i * 3 + 3))
                        + Character.toString(prefixString.charAt(i * 3 + 4));
            } else {
                separatedPrefixSets[i] = Character.toString(prefixString.charAt(i * 3 + 0))
                        + Character.toString(prefixString.charAt(i * 3 + 1))
                        + Character.toString(prefixString.charAt(i * 3 + 2));
            }
        }

        // adding on 1st part
        switch (prefixString.length() % 3) {
            case 1:
                separatedPrefixSets[0] = "00" + String.valueOf(Character.digit(prefixString.charAt(0), 10));
                break;
            case 2:
                if (prefixString.equals("-1")) {
                    return hundredsName;
                }
                separatedPrefixSets[0] = "0" + String.valueOf(Character.digit(prefixString.charAt(0), 10))
                        + String.valueOf(Character.digit(prefixString.charAt(1), 10));
                break;
        }

        // <editor-fold defaultstate="collapsed" desc="millia (repeats)">
        if (separatedPrefixSets.length >= 2) {
            for (int n = 0; n < separatedPrefixSets.length - 1; n++) {
                // names for -illion numbers
                String[] oneToNineLPrefixes = { "", "un", "duo", "tre", "quattuor", "quin", "sex", "septen", "octo",
                        "novem" };
                String[] tenToNinetyLPrefixes = { "", "dec", "vigin", "trigin", "quadragin", "quinquagin", "sexagin",
                        "septuagin", "octogin", "nonagin" };
                String[] hundredToNineHundredLPrefixes = { "", "cen", "duocen", "trecen", "quadringen", "quingen",
                        "sescen", "septingen", "octingen", "nongen" };

                String illionPrefix = "";

                String prefixPart1 = ""; // 9 thousand 900 9 90 (90)
                String prefixPart2 = ""; // 9 thousand 900 9 90 (9)
                String prefixPart3 = ""; // 9 thousand 900 9 90 (900)

                // splitting respective value in separatedPrefixSets into 3
                int separatedPrefixSetsByDigit[] = new int[3];
                for (int i = 0; i < 3; i++) {
                    separatedPrefixSetsByDigit[i] = Character.digit(separatedPrefixSets[n].charAt(i), 10);
                }

                // setting name
                if (separatedPrefixSetsByDigit[1] != 0) {
                    // part1 (one and TEN)
                    switch (separatedPrefixSetsByDigit[1]) {
                        case 0:
                            prefixPart1 = tenToNinetyLPrefixes[0];
                            break;
                        case 1:
                            prefixPart1 = tenToNinetyLPrefixes[1];
                            break;
                        case 2:
                            prefixPart1 = tenToNinetyLPrefixes[2];
                            break;
                        case 3:
                            prefixPart1 = tenToNinetyLPrefixes[3];
                            break;
                        case 4:
                            prefixPart1 = tenToNinetyLPrefixes[4];
                            break;
                        case 5:
                            prefixPart1 = tenToNinetyLPrefixes[5];
                            break;
                        case 6:
                            prefixPart1 = tenToNinetyLPrefixes[6];
                            break;
                        case 7:
                            prefixPart1 = tenToNinetyLPrefixes[7];
                            break;
                        case 8:
                            prefixPart1 = tenToNinetyLPrefixes[8];
                            break;
                        case 9:
                            prefixPart1 = tenToNinetyLPrefixes[9];
                            break;
                    }
                    illionPrefix = prefixPart1;
                }
                if (separatedPrefixSetsByDigit[2] != 0) {
                    // part2 (ONE and ten)
                    switch (separatedPrefixSetsByDigit[2]) {
                        case 0:
                            prefixPart2 = oneToNineLPrefixes[0];
                            break;
                        case 1:
                            prefixPart2 = oneToNineLPrefixes[1];
                            break;
                        case 2:
                            prefixPart2 = oneToNineLPrefixes[2];
                            break;
                        case 3:
                            prefixPart2 = oneToNineLPrefixes[3];
                            break;
                        case 4:
                            prefixPart2 = oneToNineLPrefixes[4];
                            break;
                        case 5:
                            prefixPart2 = oneToNineLPrefixes[5];
                            break;
                        case 6:
                            prefixPart2 = oneToNineLPrefixes[6];
                            break;
                        case 7:
                            prefixPart2 = oneToNineLPrefixes[7];
                            break;
                        case 8:
                            prefixPart2 = oneToNineLPrefixes[8];
                            break;
                        case 9:
                            prefixPart2 = oneToNineLPrefixes[9];
                            break;
                    }
                    illionPrefix = prefixPart2 + illionPrefix;
                }
                if (separatedPrefixSetsByDigit[0] != 0) {
                    switch (separatedPrefixSetsByDigit[0]) {
                        case 0:
                            prefixPart3 = hundredToNineHundredLPrefixes[0];
                            break;
                        case 1:
                            prefixPart3 = hundredToNineHundredLPrefixes[1];
                            break;
                        case 2:
                            prefixPart3 = hundredToNineHundredLPrefixes[2];
                            break;
                        case 3:
                            prefixPart3 = hundredToNineHundredLPrefixes[3];
                            break;
                        case 4:
                            prefixPart3 = hundredToNineHundredLPrefixes[4];
                            break;
                        case 5:
                            prefixPart3 = hundredToNineHundredLPrefixes[5];
                            break;
                        case 6:
                            prefixPart3 = hundredToNineHundredLPrefixes[6];
                            break;
                        case 7:
                            prefixPart3 = hundredToNineHundredLPrefixes[7];
                            break;
                        case 8:
                            prefixPart3 = hundredToNineHundredLPrefixes[8];
                            break;
                        case 9:
                            prefixPart3 = hundredToNineHundredLPrefixes[9];
                            break;
                    }
                    illionPrefix = prefixPart3 + illionPrefix;
                }

                if ("001".equals(separatedPrefixSets[n])) {
                    illionPrefix = "";
                }

                for (int j = 0; j < separatedPrefixSets.length - n - 1; j++) {
                    illionPrefix = illionPrefix + "millia";
                }

                name = name + illionPrefix;
            }
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Non-millia (final run)">
        if (arraySize.subtract(slotNum) == new BigDecimal(1)) {
            name = hundredsName;
        } else {
            // names for -illion numbers
            String[] oneToNineLSpecial = { "", "mil", "bil", "tril", "quadril", "quintil", "sextil", "septil", "octil",
                    "nonil" };
            String[] oneToNineLPrefixes = { "", "un", "duo", "tre", "quattuor", "quin", "sex", "septen", "octo",
                    "novem" };
            String[] tenToNinetyLPrefixes = { "", "dec", "vigin", "trigin", "quadragin", "quinquagin", "sexagin",
                    "septuagin", "octogin", "nonagin" };
            String[] hundredToNineHundredLPrefixes = { "", "cen", "duocen", "trecen", "quadringen", "quingen", "sescen",
                    "septingen", "octingen", "nongen" };

            String illionPrefix = "";

            String prefixPart1 = ""; // 9 thousand 900 9 90 (90)
            String prefixPart2 = ""; // 9 thousand 900 9 90 (9)
            String prefixPart3 = ""; // 9 thousand 900 9 90 (900)

            // splitting final value in separatedPrefixSets into 3
            int separatedPrefixSetsByDigit[] = new int[3];
            for (int i = 0; i < separatedPrefixSets[separatedPrefixSets.length - 1].length(); i++) {
                separatedPrefixSetsByDigit[i] = Character
                        .digit(separatedPrefixSets[separatedPrefixSets.length - 1].charAt(i), 10);
            }

            // setting name
            if (separatedPrefixSetsByDigit[0] == 0 && separatedPrefixSetsByDigit[1] == 0
                    && separatedPrefixSets.length == 1) {
                // specials if it is between thousand and nonillion
                switch (separatedPrefixSetsByDigit[2]) {
                    case 0:
                        illionPrefix = "thousand";
                        break;
                    case 1:
                        illionPrefix = oneToNineLSpecial[1];
                        break;
                    case 2:
                        illionPrefix = oneToNineLSpecial[2];
                        break;
                    case 3:
                        illionPrefix = oneToNineLSpecial[3];
                        break;
                    case 4:
                        illionPrefix = oneToNineLSpecial[4];
                        break;
                    case 5:
                        illionPrefix = oneToNineLSpecial[5];
                        break;
                    case 6:
                        illionPrefix = oneToNineLSpecial[6];
                        break;
                    case 7:
                        illionPrefix = oneToNineLSpecial[7];
                        break;
                    case 8:
                        illionPrefix = oneToNineLSpecial[8];
                        break;
                    case 9:
                        illionPrefix = oneToNineLSpecial[9];
                        break;
                }
            } else {
                // part1 (hundred and one and TEN)
                switch (separatedPrefixSetsByDigit[1]) {
                    case 0:
                        prefixPart1 = tenToNinetyLPrefixes[0];
                        break;
                    case 1:
                        prefixPart1 = tenToNinetyLPrefixes[1];
                        break;
                    case 2:
                        prefixPart1 = tenToNinetyLPrefixes[2];
                        break;
                    case 3:
                        prefixPart1 = tenToNinetyLPrefixes[3];
                        break;
                    case 4:
                        prefixPart1 = tenToNinetyLPrefixes[4];
                        break;
                    case 5:
                        prefixPart1 = tenToNinetyLPrefixes[5];
                        break;
                    case 6:
                        prefixPart1 = tenToNinetyLPrefixes[6];
                        break;
                    case 7:
                        prefixPart1 = tenToNinetyLPrefixes[7];
                        break;
                    case 8:
                        prefixPart1 = tenToNinetyLPrefixes[8];
                        break;
                    case 9:
                        prefixPart1 = tenToNinetyLPrefixes[9];
                        break;
                }

                // part2 (hundred and ONE and ten)
                switch (separatedPrefixSetsByDigit[2]) {
                    case 0:
                        prefixPart2 = oneToNineLPrefixes[0];
                        break;
                    case 1:
                        prefixPart2 = oneToNineLPrefixes[1];
                        break;
                    case 2:
                        prefixPart2 = oneToNineLPrefixes[2];
                        break;
                    case 3:
                        prefixPart2 = oneToNineLPrefixes[3];
                        break;
                    case 4:
                        prefixPart2 = oneToNineLPrefixes[4];
                        break;
                    case 5:
                        prefixPart2 = oneToNineLPrefixes[5];
                        break;
                    case 6:
                        prefixPart2 = oneToNineLPrefixes[6];
                        break;
                    case 7:
                        prefixPart2 = oneToNineLPrefixes[7];
                        break;
                    case 8:
                        prefixPart2 = oneToNineLPrefixes[8];
                        break;
                    case 9:
                        prefixPart2 = oneToNineLPrefixes[9];
                        break;
                }

                // part3 (HUNDRED and one and ten)
                switch (separatedPrefixSetsByDigit[0]) {
                    case 0:
                        prefixPart3 = hundredToNineHundredLPrefixes[0];
                        break;
                    case 1:
                        prefixPart3 = hundredToNineHundredLPrefixes[1];
                        break;
                    case 2:
                        prefixPart3 = hundredToNineHundredLPrefixes[2];
                        break;
                    case 3:
                        prefixPart3 = hundredToNineHundredLPrefixes[3];
                        break;
                    case 4:
                        prefixPart3 = hundredToNineHundredLPrefixes[4];
                        break;
                    case 5:
                        prefixPart3 = hundredToNineHundredLPrefixes[5];
                        break;
                    case 6:
                        prefixPart3 = hundredToNineHundredLPrefixes[6];
                        break;
                    case 7:
                        prefixPart3 = hundredToNineHundredLPrefixes[7];
                        break;
                    case 8:
                        prefixPart3 = hundredToNineHundredLPrefixes[8];
                        break;
                    case 9:
                        prefixPart3 = hundredToNineHundredLPrefixes[9];
                        break;
                }

                illionPrefix = prefixPart3 + prefixPart2 + prefixPart1;
            }

            name = name + illionPrefix;

            if (Integer.parseInt(separatedPrefixSets[separatedPrefixSets.length - 1]) >= 1
                    && Integer.parseInt(separatedPrefixSets[separatedPrefixSets.length - 1]) <= 9
                    && separatedPrefixSets.length == 1) {
                name = name + "lion";
            } else if (separatedPrefixSetsByDigit[1] == 1) {
                name = name + "illion";
            } else if ("thousand".equals(name)) {
            } else {
                name = name + "tillion";
            }
            if (separatedHundredsDigits[0] == 0 && separatedHundredsDigits[1] == 0 && separatedHundredsDigits[2] == 0) {
                name = "";
            }
        }
        // </editor-fold>

        name = hundredsName + " " + name;

        // </editor-fold>
        return name;
    }
}