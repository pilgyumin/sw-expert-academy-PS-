package 세상의모든펠린드롬_4522;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= test; i++) {
            String[] s = sc.nextLine().split("");
             
            int num = s.length / 2;
            boolean answer = false;
            answer = even(s,num);
            if(answer == true) {
                System.out.printf("#%d Exist\n",i);
            }
            else if(answer == false) {
                System.out.printf("#%d Not exist\n",i);
            }
        }
    }
     
    private static boolean even(String[] s, int num) {
        boolean ans = true;
        boolean[] checked = new boolean[num];
        for(int j = 0; j < num; j++) {
            checked[j] = true;
        }
        for(int j = 0; j < num; j++) {
            if(!s[j].equals("?") && !s[s.length-1-j].equals("?") && !s[j].equals(s[s.length-1-j])) {
                checked[j] = false;
            }
        }
        for(int j = 0; j < num; j++) {
            if(checked[j] == false) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}

