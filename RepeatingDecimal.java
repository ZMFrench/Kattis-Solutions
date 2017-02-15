package kattis015;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * repeatingdecimal
 */
public class RepeatingDecimal {
    public static void main(String[] args){
        
        
        //Create Scanner and pointers
        Scanner sc = new Scanner(System.in);
        BigDecimal bd1, bd2;
        int scale, a, b;
        
        //begin iterating through data
        while(sc.hasNext()){
            //read numbers from file
            a = sc.nextInt();
            b = sc.nextInt();
            scale = sc.nextInt();
            
            //create BigDecimals
            bd1 = new BigDecimal(a);
            bd2 = new BigDecimal(b);
            bd1.setScale(scale);
            bd2.setScale(scale);
            
            //perform division
            bd1 = bd1.divide(bd2, scale, RoundingMode.DOWN);
            
            //print to System.out
            System.out.println(bd1);
        }
    }
}
