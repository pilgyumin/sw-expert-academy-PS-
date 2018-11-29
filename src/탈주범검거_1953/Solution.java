package Å»ÁÖ¹ü°Ë°Å_1953;

import java.util.Scanner;

public class Solution {
 
    private static int[][] map;
    private static boolean[][] check;
    private static int n;
    private static int m;
    private static int r;
    private static int c;
    private static int l;
    private static int ans;
     
    public static int start(int x, int y, int cnt, int m) {
        if(cnt >= l) {
            return 0;
        }
        switch(m) {
        case 1:
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        }
        switch(map[x][y]) {
        case 1:
            check[x][y] = true;
            if(map[x-1][y] != 0 && map[x-1][y] != 3
                    && map[x-1][y] != 4 && map[x-1][y] != 7 && m != 2) {
                start(x-1,y,cnt+1,1);
            }
            if(map[x+1][y] != 0 && map[x+1][y] != 3
                    && map[x+1][y] != 5 && map[x+1][y] != 6 && m != 1) {
                start(x+1,y,cnt+1,2);
            }
            if(map[x][y+1] != 0 && map[x][y+1] != 2
                    && map[x][y+1] != 4 && map[x][y+1] != 5 && m != 4) {
                start(x,y+1,cnt+1,3);
            }
            if(map[x][y-1] != 0 && map[x][y-1] != 2
                    && map[x][y-1] != 6 && map[x][y-1] != 7 && m != 3) {
                start(x,y-1,cnt+1,4);
            }
            break;
        case 2:
            check[x][y] = true;
            if(map[x+1][y] != 0 && map[x+1][y] != 3
                    && map[x+1][y] != 5 && map[x+1][y] != 6 && m != 1) {
                start(x+1,y,cnt+1,2);
            }
            if(map[x-1][y] != 0 && map[x-1][y] != 3
                    && map[x-1][y] != 4 && map[x-1][y] != 7 && m != 2) {
                start(x-1,y,cnt+1,1);
            }
            break;
        case 3:
            check[x][y] = true;
            if(map[x][y+1] != 0 && map[x][y+1] != 2
                    && map[x][y+1] != 4 && map[x][y+1] != 5 && m != 4) {
                start(x,y+1,cnt+1,3);
            }
            if(map[x][y-1] != 0 && map[x][y-1] != 2
                    && map[x][y-1] != 6 && map[x][y-1] != 7 && m != 3) {
                start(x,y-1,cnt+1,4);
            }
            break;
        case 4:
            check[x][y] = true;
            if(map[x][y+1] != 0 && map[x][y+1] != 2
                    && map[x][y+1] != 4 && map[x][y+1] != 5 && m != 4) {
                start(x,y+1,cnt+1,3);
            }
            if(map[x-1][y] != 0 && map[x-1][y] != 3
                    && map[x-1][y] != 4 && map[x-1][y] != 7 && m != 2) {
                start(x-1,y,cnt+1,1);
            }
            break;
        case 5:
            check[x][y] = true;
            if(map[x][y+1] != 0 && map[x][y+1] != 2
                    && map[x][y+1] != 4 && map[x][y+1] != 5 && m != 4) {
                start(x,y+1,cnt+1,3);
            }
            if(map[x+1][y] != 0 && map[x+1][y] != 3
                    && map[x+1][y] != 5 && map[x+1][y] != 6 && m != 1) {
                start(x+1,y,cnt+1,2);
            }
            break;
        case 6:
            check[x][y] = true;
            if(map[x][y-1] != 0 && map[x][y-1] != 2
                    && map[x][y-1] != 6 && map[x][y-1] != 7 && m != 3) {
                start(x,y-1,cnt+1,4);
            }
            if(map[x+1][y] != 0 && map[x+1][y] != 3
                    && map[x+1][y] != 5 && map[x+1][y] != 6 && m != 1) {
                start(x+1,y,cnt+1,2);
            }
            break;
        case 7:
            check[x][y] = true;
            if(map[x][y-1] != 0 && map[x][y-1] != 2
                    && map[x][y-1] != 6 && map[x][y-1] != 7 && m != 3) {
                start(x,y-1,cnt+1,4);
            }
            if(map[x-1][y] != 0 && map[x-1][y] != 3
                    && map[x-1][y] != 4 && map[x-1][y] != 7 && m != 2) {
                start(x-1,y,cnt+1,1);
            }
            break;
        }
        return 0;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            l = sc.nextInt();
            ans = 0;
            map = new int[n + 2][m + 2];
            check = new boolean[n + 2][m + 2];
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    map[j][k] = sc.nextInt();
                }
            }
            start(r+1,c+1,0,0);
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    if(check[j][k]) {
                        ans++;
                    }
                }
            }
            System.out.printf("#%d %d\n",i,ans);
        }
    }
 
}

