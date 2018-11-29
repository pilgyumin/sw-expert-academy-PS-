package 상호의배틀필드_1873;

import java.util.Scanner;

public class Solution {
    private static String[][] ar;
    private static String[] command;
    private static int w;
    private static int h;
    private static int[] location = new int[2];
     
    public static int game(String s) {
        if(s.equals("U")) {
            if(ar[location[0] - 1][location[1]].equals(".")) {
                ar[location[0]][location[1]] = ".";
                ar[location[0] - 1][location[1]] = "^";
                location[0]--;
                return 1;
            }
            else {
                ar[location[0]][location[1]] = "^";
                return 1;
            }
        }
        else if(s.equals("D")) {
            if(ar[location[0] + 1][location[1]].equals(".")) {
                ar[location[0]][location[1]] = ".";
                ar[location[0] + 1][location[1]] = "v";
                location[0]++;
                return 1;
            }
            else {
                ar[location[0]][location[1]] = "v";
                return 1;
            }
        }
        else if(s.equals("L")) {
            if(ar[location[0]][location[1] - 1].equals(".")) {
                ar[location[0]][location[1]] = ".";
                ar[location[0]][location[1] - 1] = "<";
                location[1]--;
                return 1;
            }
            else {
                ar[location[0]][location[1]] = "<";
                return 1;
            }
        }
        else if(s.equals("R")) {
            if(ar[location[0]][location[1] + 1].equals(".")) {
                ar[location[0]][location[1]] = ".";
                ar[location[0]][location[1] + 1] = ">";
                location[1]++;
                return 1;
            }
            else {
                ar[location[0]][location[1]] = ">";
                return 1;
            }
        }
        else if(s.equals("S")) {
            shoot(ar[location[0]][location[1]]);
        }
        return 0;
    }
     
    public static int shootup(int xx, int yy) {
        int x = xx;
        int y = yy;
        if(ar[x][y].equals("#")) {
            return 0;
        }
        if(ar[x][y].equals("*")) {
            ar[x][y] = ".";
            return 0;
        }
        if(!ar[x-1][y].equals("#")) {
            x--;
            shootup(x,y);
        }
        return 0;
    }
     
    public static int shootdown(int xx, int yy) {
        int x = xx;
        int y = yy;
        if(ar[x][y].equals("#")) {
            return 0;
        }
        if(ar[x][y].equals("*")) {
            ar[x][y] = ".";
            return 0;
        }
        if(!ar[x+1][y].equals("#")) {
            x++;
            shootdown(x,y);
        }
        return 0;
    }
     
    public static int shootleft(int xx, int yy) {
        int x = xx;
        int y = yy;
        if(ar[x][y].equals("#")) {
            return 0;
        }
        if(ar[x][y].equals("*")) {
            ar[x][y] = ".";
            return 0;
        }
        if(!ar[x][y-1].equals("#")) {
            y--;
            shootleft(x,y);
        }
        return 0;
    }
     
    public static int shootright(int xx, int yy) {
        int x = xx;
        int y = yy;
        if(ar[x][y].equals("#")) {
            return 0;
        }
        if(ar[x][y].equals("*")) {
            ar[x][y] = ".";
            return 0;
        }
        if(!ar[x][y+1].equals("#")) {
            y++;
            shootright(x,y);
        }
        return 0;
         
    }
     
    public static void shoot(String l) {
        switch(ar[location[0]][location[1]]) {
        case "^":
            shootup(location[0],location[1]);
            break;
             
        case "v":
            shootdown(location[0],location[1]);
            break;
             
        case "<":
            shootleft(location[0],location[1]);
            break;
             
        case ">":
            shootright(location[0],location[1]);
            break;
        }
    }
     
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            h = sc.nextInt();
            w = sc.nextInt();
            ar = new String[h + 2][w + 2];
            for(int j = 0; j < h+2; j++) {
                String s[] = new String[w];
                if(j != 0 && j != h+1) {
                    s = sc.next().split("");
                }
                for(int k = 0; k < w + 2; k++) {
                    if(j == 0 || j == h+1) {
                        ar[j][k] = "#";
                        continue;
                    }
                    if(k == 0 || k == w+1) {
                        ar[j][k] = "#";
                        continue;
                    }
                    if(k != 0 && k != w+1) {
                        ar[j][k] = s[k-1];
                    }
                    if(ar[j][k].equals("v") || ar[j][k].equals("<") ||
                            ar[j][k].equals(">") || ar[j][k].equals("^")) {
                        location[0] = j;
                        location[1] = k;
                    }
                }
            }
            sc.nextInt();
            command = sc.next().split("");
            for(int j = 0; j < command.length; j++) {
                game(command[j]);
            }
            System.out.printf("#%d ",i);    
            for(int j = 1; j < h+1; j++) {
                for(int k = 1; k < w+1; k++) {
                    System.out.print(ar[j][k]);
                }
                System.out.println();
            }
        }
    }
}
