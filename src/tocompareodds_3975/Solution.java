package tocompareodds_3975;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
             
            double alice = (double) a / (double) b;
            double bob = (double) c/ (double) d;
             
            if(alice > bob) {
                System.out.printf("#%d ALICE\n",i);
            }
            else if(alice < bob) {
                System.out.printf("#%d BOB\n",i);
            }
            else if(alice == bob) {
                System.out.printf("#%d DRAW\n",i);
            }
        }
    }
}

