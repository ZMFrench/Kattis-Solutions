package kattis2;

import java.io.PrintWriter;
import java.util.Scanner;

public class Play2048 {
    
    static Scanner sc;
    static PrintWriter oF;
    
    public static void main(String[] args){
        
        
        sc = new Scanner(System.in);
        oF = new PrintWriter(System.out, true);
        
        Game pl = new Game();
        
        pl.fillBoard(pl.readData(sc));
        
        pl.setMove(sc.nextInt());
        
        pl.doMove(pl.getMove());
        
        pl.printBoard();
    }
}

class Game{
    int[][] grid = new int[4][4];
    int move;
    
    public Game(){
        
    }
    
    public Game(int[][] board, int m){
        grid = board.clone();
        move = m;
    }
    
    public int[][] getBoard(){
        return grid;
    }
    
    public int getMove(){
        return move;
    }
    
    public void setBoard(int[][] board){
        grid = board.clone();
    }
    
    public void setMove(int m){
        move = m;
    }
    
    public void fillBoard(int[][] arr){
        grid = arr.clone();
    }
    
    public void printBoard(){
        //for(int i = 0; i < 4; i++){
        //    System.out.println(grid[4*i] + " " + grid[4*i+1] + " " + grid[4*i+2] + " " + grid[4*i+3]);
        //}
        int j=0;
        while(j<4){
            System.out.println(grid[0][j]+ " " +grid[1][j]+ " " +grid[2][j]+ " " +grid[3][j]);
            j++;
        }
    }
    
    public void printRow(int[] row){
        for(int i = 0; i < 4; i++){
            System.out.print(row[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
    
    public boolean isZero(int num){
        return num == 0;
    }
    
    private void left(){
        /**
         * This method is the method that will move tiles to the left if the user tries to swipe left
         * When a user swipes left, these things must happen:
         *      if a number has a blank spot to its left, it must fill that spot
         *      if a number is to the right of a number that matches it, it must combine with that number
         * Therefore in order to accomplish the swipe, we first will test to see if any numbers in the row match
         *      if there are matches, we test for empty space between them, or for if they are adjacent
         *      combine the numbers if any can be combined
         * Once combined (or if none can be combined), remaining tiles are swept left to fill empty space
         * this operation will be performed row by row, so a loop will occur 4 times
         * 
         * Before we combine two numbers, we have to make sure there is no number to the left of them, and then
         * we must ensure they don't combine with any other numbers afterward in the same move.
         * 
         */
        
        //create row for iteration
        int[] row = new int[4];
        //begin iteration
        int j = 0;
        while(j < 4){
            //populate row
            row[0] = grid[0][j];
            row[1] = grid[1][j];
            row[2] = grid[2][j];
            row[3] = grid[3][j];
            
            //test for match in row
            String m = findMatch(row);
            
            //perform combinations
            while(!m.equals("")){
                switch(m.charAt(0)){
                    case '0': row[0] = merge(row[0], row[1]);
                            row[1] = 0;
                            break;

                    case '1': row[0] = merge(row[0], row[2]);
                            row[2] = 0;
                            break;

                    case '2': row[0] = merge(row[0], row[3]);
                            row[3] = 0;
                            break;

                    case '3': row[1] = merge(row[1], row[2]);
                            row[2] = 0;
                            break;

                    case '4': row[1] = merge(row[1], row[3]);
                            row[3] = 0;
                            break;

                    case '5': row[2] = merge(row[2], row[3]);
                            row[3] = 0;
                            break;
                    }
                
                m = m.substring(1, m.length());
            }
            
            //perform slide
            int x = 0;
            int y = 0;
            
            while(x<4){
                while(y<3){
                    if(isZero(row[y])){
                        if(!isZero(row[y+1])){
                            row[y]=row[y+1];
                            row[y+1]=0;
                        }
                    }
                    y++;
                }
            y=0;
            x++;
            }
            
            //send adjusted row back to board
            grid[0][j] = row[0];
            grid[1][j] = row[1];
            grid[2][j] = row[2];
            grid[3][j] = row[3];
            
            j++;
        }
    }
    
    private void right(){
        /**
         * Now that we've coded the left, we simply copy it, and change the import and export for the other
         * directional swipes
         */
        
        //create row for iteration
        int[] row = new int[4];
        //begin iteration
        int j = 0;
        while(j < 4){
            //populate row
            row[0] = grid[3][j];
            row[1] = grid[2][j];
            row[2] = grid[1][j];
            row[3] = grid[0][j];
            
            //test for match in row
            String m = findMatch(row);
            
            //perform combinations
            while(!m.equals("")){
                switch(m.charAt(0)){
                    case '0': row[0] = merge(row[0], row[1]);
                            row[1] = 0;
                            break;

                    case '1': row[0] = merge(row[0], row[2]);
                            row[2] = 0;
                            break;

                    case '2': row[0] = merge(row[0], row[3]);
                            row[3] = 0;
                            break;

                    case '3': row[1] = merge(row[1], row[2]);
                            row[2] = 0;
                            break;

                    case '4': row[1] = merge(row[1], row[3]);
                            row[3] = 0;
                            break;

                    case '5': row[2] = merge(row[2], row[3]);
                            row[3] = 0;
                            break;
                    }
                
                m = m.substring(1, m.length());
            }
            
            //perform slide
            int x = 0;
            int y = 0;
            
            while(x<4){
                while(y<3){
                    if(isZero(row[y])){
                        if(!isZero(row[y+1])){
                            row[y]=row[y+1];
                            row[y+1]=0;
                        }
                    }
                    y++;
                }
            y=0;
            x++;
            }
            
            //send adjusted row back to board
            grid[3][j] = row[0];
            grid[2][j] = row[1];
            grid[1][j] = row[2];
            grid[0][j] = row[3];
            
            j++;
        }
    }
    
    private void up(){
        /**
         * Code copied from left() and adjusted slightly
         */
        
        //create row for iteration
        int[] row = new int[4];
        //begin iteration
        int i = 0;
        while(i < 4){
            //populate row
            row[0] = grid[i][0];
            row[1] = grid[i][1];
            row[2] = grid[i][2];
            row[3] = grid[i][3];
            
            //test for match in row
            String m = findMatch(row);
            
            //perform combinations
            while(!m.equals("")){
                switch(m.charAt(0)){
                    case '0': row[0] = merge(row[0], row[1]);
                            row[1] = 0;
                            break;

                    case '1': row[0] = merge(row[0], row[2]);
                            row[2] = 0;
                            break;

                    case '2': row[0] = merge(row[0], row[3]);
                            row[3] = 0;
                            break;

                    case '3': row[1] = merge(row[1], row[2]);
                            row[2] = 0;
                            break;

                    case '4': row[1] = merge(row[1], row[3]);
                            row[3] = 0;
                            break;

                    case '5': row[2] = merge(row[2], row[3]);
                            row[3] = 0;
                            break;
                    }
                
                m = m.substring(1, m.length());
            }
            
            //perform slide
            int x = 0;
            int y = 0;
            
            while(x<4){
                while(y<3){
                    if(isZero(row[y])){
                        if(!isZero(row[y+1])){
                            row[y]=row[y+1];
                            row[y+1]=0;
                        }
                    }
                    y++;
                }
            y=0;
            x++;
            }
            
            //send adjusted row back to board
            grid[i][0] = row[0];
            grid[i][1] = row[1];
            grid[i][2] = row[2];
            grid[i][3] = row[3];
            
            i++;
        }
    }
    
    private void down(){
        /**
         * Code copied from left() and adjusted slightly
         */
        
        //create row for iteration
        int[] row = new int[4];
        //begin iteration
        int i = 0;
        while(i < 4){
            //populate row
            row[0] = grid[i][3];
            row[1] = grid[i][2];
            row[2] = grid[i][1];
            row[3] = grid[i][0];
            
            //test for match in row
            String m = findMatch(row);
            
            //perform combinations
            while(!m.equals("")){
                switch(m.charAt(0)){
                    case '0': row[0] = merge(row[0], row[1]);
                            row[1] = 0;
                            break;

                    case '1': row[0] = merge(row[0], row[2]);
                            row[2] = 0;
                            break;

                    case '2': row[0] = merge(row[0], row[3]);
                            row[3] = 0;
                            break;

                    case '3': row[1] = merge(row[1], row[2]);
                            row[2] = 0;
                            break;

                    case '4': row[1] = merge(row[1], row[3]);
                            row[3] = 0;
                            break;

                    case '5': row[2] = merge(row[2], row[3]);
                            row[3] = 0;
                            break;
                    }
                
                m = m.substring(1, m.length());
            }
            
            //perform slide
            int x = 0;
            int y = 0;
            
            while(x<4){
                while(y<3){
                    if(isZero(row[y])){
                        if(!isZero(row[y+1])){
                            row[y]=row[y+1];
                            row[y+1]=0;
                        }
                    }
                    y++;
                }
            y=0;
            x++;
            }
            
            //send adjusted row back to board
            grid[i][3] = row[0];
            grid[i][2] = row[1];
            grid[i][1] = row[2];
            grid[i][0] = row[3];
            
            i++;
        }
    }
    
    private boolean containsMatches(int[] row){
        if(row[0] == row[1])
            return true;
        if(row[0] == row[2])
            return true;
        if(row[0] == row[3])
            return true;
        if(row[1] == row[2])
            return true;
        if(row[1] == row[3])
            return true;
        if(row[2] == row[3])
            return true;
        return false;
    }
    
    private boolean containsSpaces(int[] row){
        int i = 0;
        while(i < 4){
            if(row[i] == 0)
                return true;
        }
        return false;
    }
    
    private boolean containsAdjacentMatches(int[] row){
        if(row[0] == row[1])
            return true;
        if(row[1] == row[2])
            return true;
        if(row[2] == row[3])
            return true;
        return false;
    }
    
    private int merge(int int1, int int2){
        if(int1 == int2){
            return 2 * int1;
        }
        return int1;
    }
    
    public void doMove(int move){
        switch(move){
            case 0: this.left();
                    break;
            case 1: this.up();
                    break;
            case 2: this.right();
                    break;
            case 3: this.down();
                    break;
       }
    }
    
    private String findMatch(int[] row){
        String res = "";
        if(row[0] == row[1] && row[0] != 0){
            res += 0;
            if(row[2] == row[3] && row[2] != 0){
                res += 5;
                return res;
            }
            return res;
        }
        if(row[1] == 0){
            if(row[0] == row[2] && row[0] != 0){
                res += 1;
                return res;
            }
        }
        if(row[1] == 0 && row[2] == 0){
            if(row[0] == row[3] && row[0] != 0){
                res += 2;
                return res;
            }
        }
        if(row[1] == row[2] && row[2] != 0){
            res += 3;
            return res;
        }
        if(row[2] == 0){ 
            if(row[1] == row[3] && row[1] != 0)
                res += 4;
            return res;
        }
        if(row[2] == row[3] && row[2] != 0){
            res += 5;
        }
        return res;
    }
    
    public int[][] readData(Scanner sc){
        int[][] arr = new int[4][4];
        int i=0;
        int j=0;
        
        while(j<4){
            while(i<4){
                arr[i][j] = sc.nextInt();
                i++;
            }
            i = 0;
            j++;
        }
        return arr;
    }
}