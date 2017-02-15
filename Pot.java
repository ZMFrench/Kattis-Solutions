package kattis4;

import java.util.Scanner;

/**
 *
 * Pot
 */
public class Pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        
        int sum = 0;
        for(int i = 0; i < num; i++){
            double a = Math.pow(getBase(arr[i]), getLast(arr[i]));
            sum += a;
        }
        System.out.println(sum);
    }
    
    public static int getLast(int alpha){
        return alpha % 10;
    }
    
    public static int getBase(int alpha){
        return alpha / 10;
    }
}
