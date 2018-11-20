package thediamondornamentofadasol;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= test; i++) {
            String[] s = sc.nextLine().split("");
            if(s.length == 1) {
                System.out.printf("..#..\n");
                System.out.printf(".#.#.\n");
                System.out.printf("#.%s.#\n",s[0]);
                System.out.printf(".#.#.\n");
                System.out.printf("..#..\n");
            }
            else if(s.length != 1 ) {
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < s.length; k++) {
                        if(j == 0 && k == 0) {
                            System.out.printf("..#..");
                        }
                        else if(j == 0 && k != 0) {
                            System.out.printf(".#..");
                            if(k == s.length-1) {
                                System.out.println();
                            }
                        }
                        else if(j == 1 && k == 0) {
                            System.out.printf(".#.#.");
                        }
                        else if(j == 1 && k != 0) {
                            System.out.printf("#.#.");
                            if(k == s.length-1) {
                                System.out.println();
                            }
                        }
                        else if(j == 2 && k == 0) {
                            System.out.printf("#.%s.#",s[k]);
                        }
                        else if(j == 2 && k != 0) {
                            System.out.printf(".%s.#",s[k]);
                            if(k == s.length-1) {
                                System.out.println();
                            }
                        }
                        else if(j == 3 && k == 0) {
                            System.out.printf(".#.#.");
                        }
                        else if(j == 3 && k != 0) {
                            System.out.printf("#.#.");
                            if(k == s.length-1) {
                                System.out.println();
                            }
                        }
                        else if(j == 4 && k == 0) {
                            System.out.printf("..#..");
                        }
                        else if(j == 4 && k != 0) {
                            System.out.printf(".#..");
                            if(k == s.length-1) {
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }
}
