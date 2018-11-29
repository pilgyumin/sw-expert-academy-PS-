package 테네스의특별한소수_4698;

import java.util.Scanner;

public class Solution {
    private static boolean[] check = new boolean[1000001];
    private static void cal() {
        for(int j = 2; j*j <= 1000000; j++) {
            if(check[j]) {
                continue;
            }
            for(int k = 2 * j; k <= 1000000; k+=j) {
                if(!check[k] && k % j == 0) {
                    check[k] = true;
                }
            }
        }
    }
     
    public static void main(String[] args) {
        cal();
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int d = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            boolean [] checked = check;
            checked[0] = true;
            checked[1] = true;
            for(int k = a; k <= b; k++) {
                if(!checked[k]) {
                    int num = k;
                    while (num > 0){
                        if(num % 10 == d){
                            count++;
                            break;
                            }
                        num=num/10;
                        }
                         
                    }
                }
            System.out.printf("#%d %d\n",i,count);
        }
    }
}

