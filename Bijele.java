package kattis6;

import java.util.Scanner;

/**
 *
 * Bijele
 */
public class Bijele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int[] corr = new int[]{1,1,2,2,2,8};
        
        for(int i = 0; i<6;i++){
            int alpha = sc.nextInt();
            alpha = corr[i] - alpha;
            System.out.println(alpha);
        }
    }
}
