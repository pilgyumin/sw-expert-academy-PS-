package number7_3_5GameofSaemae_5948;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
         
        for(int i = 1; i <= test; i++) {
            int[] ar = new int[7];
            for(int j = 0; j < 7; j++) {
                ar[j] = sc.nextInt();
            }
            int[] sum = new int[301];
            for(int j = 0; j < 5; j++) {
                for(int k = j+1; k < 6; k++) {
                    for(int l = k+1; l < 7; l++) {
                        sum[ar[j]+ar[k]+ar[l]]++;
                    }
                }
            }
            int cnt = 0;
            int ans = 0;
            for(int j = sum.length - 1; j >= 0; j--) {
                if(sum[j] != 0) {
                    cnt++;
                }
                if(cnt == 5) {
                    ans = j;
                    break;
                }
            }
            System.out.printf("#%d %d\n",i,ans);
        }
    }
}

