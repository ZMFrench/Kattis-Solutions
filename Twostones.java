package kattis8;

import java.util.Scanner;

/**
 *
 * twostones
 */
public class Twostones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0)
            System.out.println("Bob");
        else
            System.out.println("Alice");
    }
}
