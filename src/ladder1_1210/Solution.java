package ladder1_1210;

import java.util.Scanner;

public class Solution {
    private static int[][] arr;
     
    public static int bfs(String s) {
        String[] zz = s.split(" ");
        int[] start = new int[2];
        for(int i = 0; i < 2; i++) {
            start[i] = Integer.parseInt(zz[i]);
        }
         
        int x = start[0];
        int y = start[1];
         
        while(x != 1) {
            if(arr[x][y - 1] == 0 && arr[x][y+1] == 0 && arr[x-1][y] == 1 ) {
                x -= 1;
            }
             
            if (arr[x][y - 1] == 1 && arr[x][y+1] == 0) {
                while(arr[x][y - 1] != 0) {
                    y -= 1;
                }
                if(arr[x][y - 1] == 0 && arr[x][y+1] == 1 && arr[x-1][y] == 1 ) {
                    x -= 1;
                }
            }
            if (arr[x][y - 1] == 0 && arr[x][y+1] == 1) {
                while(arr[x][y+1] != 0) {
                    y += 1;
                }
                if(arr[x][y - 1] == 1 && arr[x][y+1] == 0 && arr[x-1][y] == 1 ) {
                    x -= 1;
                }
            }
        }
         
        return y -1;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            arr = new int[102][102];
            String s = "";
            for(int j = 1; j <= 100; j++) {
                for(int k = 1; k <= 100; k++) {
                    arr[j][k] = sc.nextInt();
                    if(arr[j][k] == 2) {
                        s = j + " " + k;
                    }
                }
            }
            System.out.printf("#%d %d\n",num,bfs(s));
        }
    }
}

