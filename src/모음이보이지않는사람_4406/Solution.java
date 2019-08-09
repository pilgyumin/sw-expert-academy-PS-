package 모음이보이지않는사람_4406;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            String[] s = sc.next().split("");
            System.out.printf("#%d ",i);
            for(int j = 0; j < s.length; j++) {
                if(s[j].equals("a") || s[j].equals("e") || s[j].equals("i") ||
                        s[j].equals("o") || s[j].equals("u")) {
                    continue;
                }
                System.out.print(s[j]);
            }
            System.out.println();
        }
    }
}

