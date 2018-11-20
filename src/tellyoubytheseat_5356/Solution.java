package tellyoubytheseat_5356;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          String[][] arr;
          int test = sc.nextInt();
          sc.nextLine();
          for (int i = 1; i <= test; i++) {
            arr = new String[5][];
            int num = 0;
            for(int j = 0; j < 5; j++) {
             String[] s = sc.nextLine().split("");
             arr[j] = s;
             if(num < s.length) {
                 num = s.length;
             }
              
            }
            String answer = "";
            int a = 0;
            int b = 0;
            for(int k = 0; k < num * 5 ; k++) {
             if(a > 4) {
              a = 0;
              b++;
             }
             if(b > arr[a].length - 1) {
              a++;
              continue;
             }
             answer += arr[a][b];
             a++;
              
            }
            System.out.printf("#%d %s\n",i,answer);
          }
         }
}

