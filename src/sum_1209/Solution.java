package sum_1209;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            int[][] arr = new int[100][100];
            for(int j = 0; j < 100; j++) {
                for(int k = 0; k < 100; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            int max = 0;
             
            for(int j = 0; j < 100; j++) {
                int sumwidth = 0;
                int sumheight = 0;
                for(int k = 0; k < 100; k++) {
                    sumwidth += arr[j][k];
                    sumheight += arr[k][j];
                }
                if(j == 0) {
                    max = (sumwidth > sumheight) ? sumwidth : sumheight;
                }
                else {
                    int temp = (sumwidth > sumheight) ? sumwidth : sumheight;
                    if(max < temp) {
                        max = temp;
                    }
                }
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int j = 0; j < 100; j++) {
                sum1 += arr[j][j];
                sum2 += arr[j][99-j];
            }
            sum1 = (sum1 > sum2) ? sum1 : sum2;
            max = (max > sum1) ? max : sum1;
            System.out.printf("#%d %d\n",num,max);
        }
    }
}
