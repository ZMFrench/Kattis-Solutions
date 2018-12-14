package kattis018;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * piglatin
 */
public class PigLatin {
  static Scanner sc = new Scanner(System.in);
  static PrintWriter oF = new PrintWriter(System.out, true);
  
  public static void main(String[] args) {
    String line = "", outStr = "", proc = "";
    
    while(sc.hasNextLine()){
      line = sc.nextLine();
      
      boolean isFirstWord = true;
      int len = line.length();
      
      for(int i = 0; i < len; i++){
        char c = line.charAt(i);
        if(c == ' '){
          if(!isFirstWord){
            outStr += " ";
          }
          else{
            isFirstWord = false;
          }
          
          outStr += toPigLatin(proc);
          proc = "";
        }
        else{
          proc += c;
        }
      }
      
      if(!isFirstWord){
        outStr += " ";
      }
      
      outStr += toPigLatin(proc);
      oF.println(outStr);
      
      proc = "";
      outStr = "";
    }
  }
    
  private static String toPigLatin(String inStr){
    boolean isFirstLetter = true, vowelFound = false;
    String outStr = "";
    int i = 0;
    char c = '\n';
    while(!vowelFound){
      c = inStr.charAt(i);
      if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y'){
        vowelFound = true;
        if(isFirstLetter){
          outStr = inStr;
          outStr += "yay";
        }
        else{
          outStr = inStr.substring(i);
          outStr += inStr.substring(0, i);
          outStr += "ay";
        }
      }
      
      isFirstLetter = false;
      i++;
    }
    
    return outStr;
  }
}
