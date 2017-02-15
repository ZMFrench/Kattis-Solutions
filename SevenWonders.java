package kattis014;


import java.util.Scanner;

/**
 *
 * sevenwonders
 */
public class SevenWonders {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        int Ts = 0;
        int Cs = 0;
        int Gs = 0;
        int pts = 0;
        
        int i = 0;
        char c;

        while(i < str.length()){
            c = str.charAt(i);
            switch(c){
                case 'T':   Ts++;
                            break;
                case 'C':   Cs++;
                            break;
                case 'G':   Gs++;
                            break;
                default:
            }
            i++;
        }
           
        if(Ts > 0 && Cs > 0 && Gs > 0){
            pts += (7 * min(Ts, Cs, Gs));
        }
        
        pts += Math.pow(Ts, 2) + Math.pow(Cs, 2) + Math.pow(Gs, 2);
        
        System.out.println(pts);
    }
    
    private static int min(int alpha, int bravo, int charlie){
        int m = Math.min(alpha, bravo);
        m = Math.min(m, charlie);
        return m;
    }
    
}
