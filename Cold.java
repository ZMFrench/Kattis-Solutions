package kattis5;

import java.util.Scanner;

/**
 *
 * Cold
 */
public class Cold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        
        for(int i = 0; i < num; i++){
            int temp = sc.nextInt();
            if(temp < 0)
                count++;
        }
        System.out.println(count);
        
    }
}
