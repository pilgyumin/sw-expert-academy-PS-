package 영준이와신비한뿔의숲_3142;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] ar = new int[2];
            ar[0] = 0;
            ar[1] = m;
            int sum = ar[0] * 1 + ar[1] * 2;
            while(sum != n) {
                ar[0]++;
                ar[1]--;
                sum = ar[0] * 1 + ar[1] * 2;
            }
            System.out.printf("#%d %d %d\n",i,ar[0],ar[1]);
        }
    }
}

