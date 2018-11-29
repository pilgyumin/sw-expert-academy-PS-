package °ÅµìÁ¦°ö_1217;

import java.util.Scanner;

public class Solution {
     
    public static int multi(int a, int b) {
        int mul = 1;
        if(b == 1) {
            return a;
        }
         
        else if(b > 1) {
            mul *= multi(a, b-1) * a;
             
        }
        return mul;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
             
            System.out.printf("#%d %d\n",num,multi(a,b));
        }   
    }
}

