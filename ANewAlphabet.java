package kattis011;

import java.util.Scanner;

/**
 *
 * anewalphabet
 */
public class ANewAlphabet {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inp = "";
        
        while(sc.hasNext()){
            inp += sc.next();
            inp += " ";
        }
        inp = inp.toLowerCase();
        
        int i = 0;
        String str = "";
        while(i<inp.length()){
            char c = inp.charAt(i);
            str += translate(c);
            i++;
        }
        str = str.trim();
        System.out.println(str);
    }
    
    public static String translate(char c){
        switch(c){
            case 'a': return "@";
            case 'b': return "8";
            case 'c': return "(";
            case 'd': return "|)";
            case 'e': return "3";
            case 'f': return "#";
            case 'g': return "6";
            case 'h': return "[-]";
            case 'i': return "|";
            case 'j': return "_|";
            case 'k': return "|<";
            case 'l': return "1";
            case 'm': return "[]\\/[]";
            case 'n': return "[]\\[]";
            case 'o': return "0";
            case 'p': return "|D";
            case 'q': return "(,)";
            case 'r': return "|Z";
            case 's': return "$";
            case 't': return "']['";
            case 'u': return "|_|";
            case 'v': return "\\/";
            case 'w': return "\\/\\/";
            case 'x': return "}{";
            case 'y': return "`/";
            case 'z': return "2";
            case ' ': return " ";
            default: return String.valueOf(c);
        }
    }
}
