package view_1206;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            int[][] arr = new int[num][255];
            int a = 0;
            for(int j = 0; j < num; j++) {
                a = sc.nextInt();
                for(int k = 0; k < a; k++) {
                    arr[j][k] = 1;
                }
            }
            int count = 0;
            for(int j = 2; j < num - 2; j++) {
                for(int k = 0; k < 255; k++) {
                    if(arr[j][k] == 1 && arr[j - 1][k] == 0 && arr[j + 1][k] == 0
                            && arr[j - 2][k] == 0 && arr[j + 2][k] == 0) {
                        count++;
                    }
                }
            }
            System.out.printf("#%d %d\n",i,count);
        }
    }
}

