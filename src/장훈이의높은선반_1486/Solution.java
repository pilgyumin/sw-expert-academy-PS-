package 장훈이의높은선반_1486;

import java.util.Scanner;

public class Solution {
    private static int b;
    private static int[] h;
    private static int max = 200000;
    private static boolean check[];
     
    public static int dfs(int a) {
         
        if(a == h.length) {
            int sum = 0;
            for(int i = 0; i < h.length; i++) {
                if(check[i] == true) {
                    sum += h[i];
                }
            }
            if(sum >= b && sum < max) {
                max = sum;
            }
            return 0;
        }
        check[a] = false;
        dfs(a+1);
        check[a] = true;
        dfs(a+1);
        return 0;
    }
     
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            b = sc.nextInt();
            h = new int[n];
            check = new boolean[n];
            for(int j = 0; j < n; j++) {
                h[j] = sc.nextInt();
            }
            dfs(0);
            System.out.printf("#%d %d\n",i,max-b);  
            max = 200000;
        }
    }
}

