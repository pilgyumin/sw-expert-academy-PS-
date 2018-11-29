package È¦¼öÀÏ±îÂ¦¼öÀÏ±î_5549;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            String[] s = sc.next().split("");
            if(Integer.parseInt(s[s.length-1]) % 2 == 0) {
                System.out.printf("#%d Even\n",i);
            }
            else {
                System.out.printf("#%d Odd\n",i);
            }
        }
    }
}

