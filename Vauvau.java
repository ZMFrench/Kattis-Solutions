package kattis013;

import java.util.Scanner;

/**
 *
 * vauvau
 */
public class Vauvau {
    static boolean dog1;
    static boolean dog2;
            
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        
        int P = sc.nextInt();
        int M = sc.nextInt();
        int G = sc.nextInt();
        
        dog1Wake(A, B, P);
        dog2Wake(C, D, P);
        awake(dog1, dog2);
        
        dog1Wake(A, B, M);
        dog2Wake(C, D, M);
        awake(dog1, dog2);
        
        dog1Wake(A, B, G);
        dog2Wake(C, D, G);
        awake(dog1, dog2);   
    }
    
    public static void dog1Wake(int A, int B, int P){
        if(P > A){
            P = P - A;
            dog1Sleep(A, B, P);
        }
        else{
            dog1 = true;
        }
    }
    
    public static void dog1Sleep(int A, int B, int P){
        if(P>B){
            P = P - B;
            dog1Wake(A, B, P);
        }
        else{
            dog1 = false;
        }
    }
    public static void dog2Wake(int A, int B, int P){
        if(P > A){
            P-=A;
            dog2Sleep(A, B, P);
        }
        else{
            dog2 = true;
        }
    }
    
    public static void dog2Sleep(int A, int B, int P){
        if(P>B){
            P-=B;
            dog2Wake(A, B, P);
        }
        else{
            dog2 = false;
        }
    }
    
    public static void awake(boolean d1, boolean d2){
        if(d1 && d2){
            System.out.println("both");
        }
        else if(!d1 && !d2){
            System.out.println("none");
        }
        else{
            System.out.println("one");
        }
    }    
}
