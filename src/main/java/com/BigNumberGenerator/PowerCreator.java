package com.BigNumberGenerator;

import static java.lang.Math.floor;
import static java.lang.Math.ceil;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerCreator {
    BigDecimal power;
    private String result;
    
    public PowerCreator(String input) {
        this.power = new BigDecimal(input);
    }
    
    void calculate() {
        if("0".equals(this.power.remainder(new BigDecimal(3)).toPlainString())) {
            this.result = "one " + illionsMaker(this.power);
        } else if ("1".equals(this.power.remainder(new BigDecimal(3)).toPlainString())) {
            this.result = "ten " + illionsMaker(this.power);
        } else if ("2".equals(this.power.remainder(new BigDecimal(3)).toPlainString())) {
            this.result = "one hundred " + illionsMaker(this.power);
        } else {
            this.result = "";
        }
    }
    
    String illionsMaker(BigDecimal power) {
        String name = "";
        
        BigDecimal size = power
            .divide(new BigDecimal(3), RoundingMode.FLOOR)
            .add(new BigDecimal(1));
        
        BigDecimal prefix = size.subtract(new BigDecimal(2));
        String prefixString = prefix.toPlainString();
        
        //splitting prefix into three digit sets
        String[] separatedPrefixSets = new String[(int) ceil(prefixString.length() / 3d)];
        for(int i = 0; i < (floor(prefixString.length() / 3)); i++) {
            if (prefixString.length() % 3 == 1) {
            separatedPrefixSets[i+1] = 
                Character.toString(prefixString.charAt(i*3 + 1)) +
                Character.toString(prefixString.charAt(i*3 + 2)) +
                Character.toString(prefixString.charAt(i*3 + 3));
            } else if (prefixString.length() % 3 == 2) {
            separatedPrefixSets[i+1] = 
                Character.toString(prefixString.charAt(i*3 + 2)) +
                Character.toString(prefixString.charAt(i*3 + 3)) +
                Character.toString(prefixString.charAt(i*3 + 4));
            } else {
            separatedPrefixSets[i] = 
                Character.toString(prefixString.charAt(i*3 + 0)) +
                Character.toString(prefixString.charAt(i*3 + 1)) +
                Character.toString(prefixString.charAt(i*3 + 2));
            }
        }
        
        //adding on 1st part
        switch(prefixString.length() % 3) {
            case 1:
                separatedPrefixSets[0] = 
                    "00" + String.valueOf(Character.digit(prefixString.charAt(0), 10));
                break;
            case 2:
                if(!prefixString.equals("-1")) {
                    separatedPrefixSets[0] = 
                    "0" + String.valueOf(Character.digit(prefixString.charAt(0), 10)) +
                    String.valueOf(Character.digit(prefixString.charAt(1), 10));
                } else {
                    return "";
                }
                
                break;

            }
        
        
        //Millia (repeats)
        if (separatedPrefixSets.length >= 2) {
            for (int n = 0; n < separatedPrefixSets.length - 1; n++) {
                //names for -illion numbers
                String[] oneToNineLPrefixes =
                {"", "un", "duo", "tre", "quattuor", "quin", "sex", "septen", "octo", "novem"};
                String[] tenToNinetyLPrefixes =
                {"", "dec", "vigin", "trigin", "quadragin", "quinquagin", "sexagin", "septuagin", "octogin", "nonagin"};
                String[] hundredToNineHundredLPrefixes =
                {"", "cen", "duocen", "trecen", "quadringen", "quingen", "sescen", "septingen", "octingen", "nongen"};
                
                String illionPrefix = "";
                
                String prefixPart1 = ""; //9 thousand 900 9 90 (90)
                String prefixPart2 = ""; //9 thousand 900 9 90 (9)
                String prefixPart3 = ""; //9 thousand 900 9 90 (900)
                
                //splitting respective value in separatedPrefixSets into 3
                int separatedPrefixSetsByDigit[] = new int[3];
                for (int i = 0; i < 3; i++) {
                    separatedPrefixSetsByDigit[i] = Character.digit(
                            separatedPrefixSets[n].charAt(i), 10);
                }
                
                //setting name
                if (separatedPrefixSetsByDigit[1] != 0) {
                    //part1 (one and TEN)
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
                } if (separatedPrefixSetsByDigit[2] != 0) {
                    //part2 (ONE and ten)
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
                } if (separatedPrefixSetsByDigit[0] != 0) {
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
                
                if("001".equals(separatedPrefixSets[n])) {
                    illionPrefix = "";
                }
                
                for (int j = 0; j < separatedPrefixSets.length - n - 1; j++) {
                    illionPrefix = illionPrefix + "millia";
                }
                
                name = name + illionPrefix;
            }
        }

        
        //Non-millia (final run)
        if (power == new BigDecimal(1)) {
            return "";
        } else {
            //names for -illion numbers
            String[] oneToNineLSpecial =
            {"", "mil", "bil", "tril", "quadril", "quintil", "sextil", "septil", "octil", "nonil"};
            String[] oneToNineLPrefixes =
            {"", "un", "duo", "tre", "quattuor", "quin", "sex", "septen", "octo", "novem"};
            String[] tenToNinetyLPrefixes =
            {"", "dec", "vigin", "trigin", "quadragin", "quinquagin", "sexagin", "septuagin", "octogin", "nonagin"};
            String[] hundredToNineHundredLPrefixes =
            {"", "cen", "duocen", "trecen", "quadringen", "quingen", "sescen", "septingen", "octingen", "nongen"};
            
            String illionPrefix = "";
            
            String prefixPart1 = ""; //9 thousand 900 9 90 (90)
            String prefixPart2 = ""; //9 thousand 900 9 90 (9)
            String prefixPart3 = ""; //9 thousand 900 9 90 (900)
            
            //splitting final value in separatedPrefixSets into 3
            int separatedPrefixSetsByDigit[] = new int[3];
            for (int i = 0; i < separatedPrefixSets[separatedPrefixSets.length - 1].length(); i++) {
                separatedPrefixSetsByDigit[i] = Character.digit(
                        separatedPrefixSets[separatedPrefixSets.length - 1].charAt(i), 10);
            }
            
            //setting name
            if (separatedPrefixSetsByDigit[0] == 0 &&
                    separatedPrefixSetsByDigit[1] == 0 &&
                    separatedPrefixSets.length == 1) {
                //specials if it is between thousand and nonillion
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
                //part1 (hundred and one and TEN)
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
                
                //part2 (hundred and ONE and ten)
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
                
                //part3 (HUNDRED and one and ten)
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
            
            if(Integer.parseInt(separatedPrefixSets[separatedPrefixSets.length - 1]) >= 1 &&
                    Integer.parseInt(separatedPrefixSets[separatedPrefixSets.length - 1]) <= 9 &&
                    separatedPrefixSets.length == 1) {
                name = name + "lion";
            } else if (separatedPrefixSetsByDigit[1] == 1) {
                name = name + "illion";
            } else if ("thousand".equals(name)){
            } else {
                name = name + "tillion";
            }
        }
        
        return name;
    }
    
    String getResult() {
        return result;
    }
}
