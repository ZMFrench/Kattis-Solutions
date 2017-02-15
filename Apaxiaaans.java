package kattis012;

import java.util.Scanner;

/**
 *
 * apaxiaaans
 */
public class Apaxiaaans {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String strIn = sc.next();
        String strOut = "";
        char c;
        char last = '\n';
        int i = 0;
        
        while(i<strIn.length()){
            c = strIn.charAt(i);
            if(c != last){
                last = c;
                strOut += c;
            }
            i++;
        }
        System.out.println(strOut);
    }
}
