package 콩많이심기_4301;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[][] ar = new boolean[n][m];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if((j/2)%2 == 0 && (k/2)%2 == 0 || (j/2)%2 == 1 && (k/2)%2 == 1) {
                        ar[j][k] = true;
                    }
                }
            }
            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(ar[j][k]) {
                        count++;
                    }
                }
            }
            System.out.printf("#%d %d\n",i,count);
            }
        }
}

