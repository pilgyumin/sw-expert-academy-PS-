package atoweringmountain_4796;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int num = sc.nextInt();
            int[] ar = new int[num];
            for (int j = 0; j < num; j++) {
                ar[j] = sc.nextInt();
            }
 
            int ans = 0;
            for (int k = 1; k < ar.length - 1; k++) {
                int x = 0;
                int y = 0;
                if (ar[k - 1] < ar[k] && ar[k + 1] < ar[k]) {
                    int m = k;
                    while (m <= ar.length - 2 && ar[m + 1] < ar[m]) {
                        x++;
                        m++;
                    }
                    int n = k;
                    while (n >= 1 && ar[n] > ar[n - 1]) {
                        y++;
                        n--;
                    }
                    ans += (x * y);
                }
            }
            System.out.printf("#%d %d\n", i, ans);
        }
    }
}

