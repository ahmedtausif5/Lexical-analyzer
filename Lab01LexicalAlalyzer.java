/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01lexicalalalyzer;

/**
 *
 * @author thor
 */
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Lab01LexicalAlalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        String[] numericals1 = {"\\d*\\.?\\d+"};
        String[] keywords1 = {"int", "String", "float", "if", "else"};
        String[] logicalOperator1 = {"<", ">", ">=", "<=", "==", "!="};
        String[] identifiers1 = {"\\b(?!(int|float|String|if|else|double|new|false|true|for|while)\\b)\\w+\\b"};
        String[] mathOperator1 = {"\\+", "-", "/", "\\*", "="};
        String[] others1 = {",", ";", "\\(", "\\)", "\\{", "\\}"};

        group numericals = new group(numericals1);
        group keywords = new group(keywords1);
        group logicalOperator = new group(logicalOperator1);
        group identifiers = new group(identifiers1);
        group mathOperator = new group(mathOperator1);
        group others = new group(others1);

        group[] count = new group[6];

        count[0] = numericals;
        count[1] = keywords;
        count[2] = logicalOperator;
        count[3] = identifiers;
        count[4] = mathOperator;
        count[5] = others;

        for (int x = 0; x < 6; x++) {

            for (int i = 0; i < count[x].regex.length; i++) {

                File f = new File("input.txt");
                Scanner sc = new Scanner(f);

                while (sc.hasNextLine()) {
                    String r = sc.nextLine();

                    Pattern p = Pattern.compile(count[x].regex[i]);
                    Matcher m = p.matcher(r);
                    //--------- 
                    for (int u = 0; u < 1; u++) {
                        if (m.find()) {

                            String j = m.group();
                            if (count[x].a.contains(j)) {

                                break;

                            } else {

                                count[x].a.add(m.group());

                            }

                        }
                    }
                    //=============
                }//while ends

            }

        }//for ends

        //---------------------- PRINTING ---------------------
        
        
        // prints all keywords
        System.out.print("Keywords: ");
        for (int i = 0; i < keywords.a.size(); i++) {
            System.out.print(keywords.a.get(i) + ", ");
        }
        System.out.println();
        
        
        
           // prints all identifiers
        System.out.print("Identifiers: ");
        for (int i = 0; i < identifiers.a.size(); i++) {
            System.out.print(identifiers.a.get(i) + ", ");
        }
        System.out.println();

        
        
         // prints all mathOperator
        System.out.print("Math Operators: ");
        for (int i = 0; i < mathOperator.a.size(); i++) {
            System.out.print(mathOperator.a.get(i) + ", ");
        }
        System.out.println();
        
        
        
        // prints all logical operators
        System.out.print("Logical Operators: ");
        for (int i = 0; i < logicalOperator.a.size(); i++) {
            System.out.print(logicalOperator.a.get(i) + ", ");
        }
        System.out.println();
       
        // prints all numericals
        System.out.print("Numerical Values: ");
        for (int i = 0; i < numericals.a.size(); i++) {
            System.out.print(numericals.a.get(i) + ", ");
        }
        System.out.println();

     
        
        // prints all others
        System.out.print("Others: ");
        for (int i = 0; i < others.a.size(); i++) {
            System.out.print(others.a.get(i) + " ");
        }
        System.out.println();

    }

}
