package 등산로조성_1949;

import java.util.Scanner;

public class Solution {
     
    private static class Node {
        int x;
        int y;
         
        public Node(int a, int b) {
            this.x = a;
            this.y = b;
        }
         
        public String toString() {
            return "x : " + x + " y : " + y;
        }
    }
 
    private static int[][] map;
    private static Node[] top;
    private static int n;
    private static int cnt;
    private static int k;
    private static int ans;
     
    private static int dfs(int x, int y, int c, int cnt, int m) {
         
         
        if(c == 0) {
            int comp = 0;
            if(m == 1) {
                comp = map[x+1][y] - 1;
            }
            else if(m == 2) {
                comp = map[x-1][y] - 1;
            }
            else if(m == 3) {
                comp = map[x][y+1] - 1;
            }
            else if(m == 4) {
                comp = map[x][y-1] - 1;
            }
            int temp = map[x][y];
            map[x][y] = comp;
            if(map[x-1][y] < map[x][y] && m != 2) {
                dfs(x-1,y,c-1,cnt+1,1);
            }
            if(map[x+1][y] < map[x][y] && m != 1) {
                dfs(x+1,y,c-1,cnt+1,2);
            }
            if(map[x][y-1] < map[x][y] && m != 4) {
                dfs(x,y-1,c-1,cnt+1,3);
            }
            if(map[x][y+1] < map[x][y] && m != 3) {
                dfs(x,y+1,c-1,cnt+1,4);
            }
            map[x][y] = temp;
            if(ans < cnt) {
                ans = cnt;
            }
            return 0;
        }
         
        else if(c < 0) {
            if(map[x-1][y] < map[x][y] && m != 2) {
                dfs(x-1,y,c-1,cnt+1,1);
            }
            if(map[x+1][y] < map[x][y] && m != 1) {
                dfs(x+1,y,c-1,cnt+1,2);
            }
            if(map[x][y-1] < map[x][y] && m != 4) {
                dfs(x,y-1,c-1,cnt+1,3);
            }
            if(map[x][y+1] < map[x][y] && m != 3) {
                dfs(x,y+1,c-1,cnt+1,4);
            }
            if(ans < cnt) {
                ans = cnt;
            }
            return 0;
        }
         
         
        else if(c == 1) {
            if(map[x-1][y] >= map[x][y] && map[x-1][y] - map[x][y] < k && m != 2) {
                dfs(x-1,y,c-1,cnt+1,1);
            }
            if(map[x+1][y] >= map[x][y] && map[x+1][y] - map[x][y] < k && m != 1) {
                dfs(x+1,y,c-1,cnt+1,2);
            }
            if(map[x][y-1] >= map[x][y] && map[x][y-1] - map[x][y] < k && m != 4) {
                dfs(x,y-1,c-1,cnt+1,3);
            }
            if(map[x][y+1] >= map[x][y] && map[x][y+1] - map[x][y] < k && m != 3) {
                dfs(x,y+1,c-1,cnt+1,4);
            }
             
             
            if(map[x-1][y] < map[x][y] && m != 2) {
                dfs(x-1,y,c,cnt+1,1);
            }
            if(map[x+1][y] < map[x][y] && m != 1) {
                dfs(x+1,y,c,cnt+1,2);
            }
            if(map[x][y-1] < map[x][y] && m != 4) {
                dfs(x,y-1,c,cnt+1,3);
            }
            if(map[x][y+1] < map[x][y] && m != 3) {
                dfs(x,y+1,c,cnt+1,4);
            }
            if(ans < cnt) {
                ans = cnt;
            }
            return 0;
        }
        return 0;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            ans = 0;
            int max = 0;
            cnt = 0;
            map = new int[n + 2][n + 2];
            for (int j = 0; j < n + 2; j++) {
                for (int k = 0; k < n + 2; k++) {
                    if(j == 0 || j == n +1 || k == 0 || k == n + 1) {
                        map[j][k] = 100;
                        continue;
                    }
                    map[j][k] = sc.nextInt();
                    if(max < map[j][k]) {
                        max = map[j][k];
                        cnt = 0;
                    }
                    if(max == map[j][k]) {
                        cnt++;
                    }
                }
            }
            top = new Node[cnt];
            int c = 0;
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if(max == map[j][k]) {
                        Node n = new Node(j,k);
                        top[c] = n;
                        c++;
                    }
                }
            }
             
            for(int j = 0; j < cnt; j++) {
                dfs(top[j].x,top[j].y,1,1,0);
            }
            System.out.printf("#%d %d\n",i,ans);
        }
    }
}

