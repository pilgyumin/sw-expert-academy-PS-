package 늘어지는소리만들기_4676;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            String[] s = sc.next().split("");
            int num = sc.nextInt();
            int[] ar = new int[s.length+1];
            for(int j = 0; j < num; j++) {
                int a = sc.nextInt();
                ar[a]++;
            }
            System.out.printf("#%d ",i);
            for(int j = 0; j <= s.length; j++) {
                if(j != 0) {
                    System.out.print(s[j-1]);
                }
                for(int k = 0; k < ar[j]; k++) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}

