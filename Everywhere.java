package kattis9;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * everywhere
 */
public class Everywhere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i<n; i++){
            int num = sc.nextInt();
            HashSet set = new HashSet();
            for(int j = 0; j<num; j++){
                set.add(sc.next());
            }
            System.out.println(set.size());
        }
    }
}
