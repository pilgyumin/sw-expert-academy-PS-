package alargediscountonjaekwan_4050;

import java.util.Scanner;

public class Solution {
     
    public static int[] sort(int[] ar) {
        int mid = ar.length / 2;
        if(ar.length == 2) {
            int[] x = new int[2];
            if(ar[0] < ar[1]) {
                x[0] = ar[1];
                x[1] = ar[0];
            }
            else {
                x[0] = ar[0];
                x[1] = ar[1];
            }
            return x;
        }
        else if(ar.length > 2) {
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++) {
                left[i] = ar[i];
            }
            int[] right = new int[ar.length - mid];
            int j = 0;
            for(int i = mid; i < ar.length; i++) {
                right[j] = ar[i];
                j++;
            }
            int[] ar1 = sort(left);
            int[] ar2 = sort(right);
            int a = 0;
            int b = 0;
            int c = 0;
            int[] retu = new int[ar1.length + ar2.length];
            while(a < ar1.length && b < ar2.length) {
                if(ar1[a] > ar2[b]) {
                    retu[c] = ar1[a];
                    a++;
                    c++;
                }
                else {
                    retu[c] = ar2[b];
                    b++;
                    c++;
                }
            }
            if(a == ar1.length && b < ar2.length) {
                for(int x = c; x < retu.length; x++) {
                    retu[x] = ar2[b];
                    b++;
                }
            }
            else if(a < ar1.length && b == ar2.length) {
                for(int x = c; x < retu.length; x++) {
                    retu[x] = ar1[a];
                    a++;
                }
            }
            return retu;
        }
        return ar;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for(int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
            }
            int[] ans = sort(ar);
            int sum = 0;
            for(int j = 0; j < ans.length; j++) {
                if(j % 3 == 2) {
                    continue;
                }
                sum += ans[j];
            }
             
            System.out.printf("#%d %d\n",i,sum);
        }
    }
}

