package ladder2_1211;

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
         
        int count = 0;
         
        while(x != 100) {
            if(arr[x][y - 1] == 0 && arr[x][y+1] == 0 && arr[x+1][y] == 1 ) {
                x += 1;
                count++;
            }
             
            if (arr[x][y - 1] == 1 && arr[x][y+1] == 0) {
                while(arr[x][y - 1] != 0) {
                    y -= 1;
                    count++;
                }
                if(arr[x][y - 1] == 0 && arr[x][y+1] == 1 && arr[x+1][y] == 1 ) {
                    x += 1;
                    count++;
                }
            }
            if (arr[x][y - 1] == 0 && arr[x][y+1] == 1) {
                while(arr[x][y+1] != 0) {
                    y += 1;
                    count++;
                }
                if(arr[x][y - 1] == 1 && arr[x][y+1] == 0 && arr[x+1][y] == 1 ) {
                    x += 1;
                    count++;
                }
            }
        }
         
        return count;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            arr = new int[102][102];
            String s = "";
            int index = 0;
            int min = 10000;
            for(int j = 1; j <= 100; j++) {
                for(int k = 1; k <= 100; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
             
                for(int k = 1; k <= 100; k++) {
                    if(arr[1][k] == 1) {
                        s = 1 + " " + k;
                        int temp = bfs(s);
                        if(min >= temp) {
                            min = temp;
                            index = k;
                        }
                    }
                }
             
            System.out.printf("#%d %d\n",num,index-1);
        }
    }
}

