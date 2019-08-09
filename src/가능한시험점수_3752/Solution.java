package 가능한시험점수_3752;

import java.util.Scanner;

public class Solution {
    private static int[] ar;
    private static boolean[] subset;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int num = sc.nextInt();
            ar = new int[num];
            subset = new boolean[10001];
            for(int j = 0; j < num; j++) {
                ar[j] = sc.nextInt();
            }
            subset[0] = true;
            for(int j = 0; j < ar.length; j++) {
                for(int k = subset.length - 1; k >= 0 ; k--) {
                    if(subset[k] == true) {
                        subset[k+ar[j]] = true;
                    }
                }
            }
            int count = 0;
            for(int j = 0; j <subset.length; j++) {
                if(subset[j] == true) {
                    count++;
                }
            }
            System.out.printf("#%d %d\n",i,count);
        }
    }
}

