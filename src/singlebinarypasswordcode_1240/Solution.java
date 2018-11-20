package singlebinarypasswordcode_1240;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        hm.put("0001101", 0);
        hm.put("0011001", 1);
        hm.put("0010011", 2);
        hm.put("0111101", 3);
        hm.put("0100011", 4);
        hm.put("0110001", 5);
        hm.put("0101111", 6);
        hm.put("0111011", 7);
        hm.put("0110111", 8);
        hm.put("0001011", 9);
         
        for(int i = 1; i <= test; i++) {
            int garo = sc.nextInt();
            int sero = sc.nextInt();
            sc.nextLine();
            int[][] arr = new int[garo][sero];
            boolean check = false;
            int startj = 0;
            int startk = 0;
            for(int j = 0; j < garo; j++) {
                String[] ss = sc.next().split("");
                for(int k = 0; k < sero; k++) {
                    arr[j][k] = Integer.parseInt(ss[k]);
                    if(arr[j][k] == 1 && !check) {
                        startj = j;
                        startk = k-3;
                        check = true;
                    }
                }
            }
            int[] bit = new int[8];
            int index = 0;
            String s = "";
            int sum = 0;
            for(int k = startk; k < startk + 56; k+=7) {
                s = (String.valueOf(arr[startj][k]) + arr[startj][k + 1] + arr[startj][k + 2]
                        + arr[startj][k + 3] + arr[startj][k + 4] + arr[startj][k + 5]
                                + arr[startj][k + 6]);
                 
                 
                try {
                    bit[index] = hm.get(s);
                    sum += hm.get(s);
                } catch(NullPointerException e) {
                    startk++;
                    k = startk - 7;
                    index = 0;
                    sum = 0;
                    continue;
                }
                index++;
            }
            int ans = (bit[0] + bit[2] + bit[4] + bit[6]) * 3 + bit[1]
                    + bit[3] + bit[5] + bit[7];
 
            if(ans % 10 == 0) {
                System.out.printf("#%d %d\n",i,sum);
            }
            else {
                System.out.printf("#%d %d\n",i,0);
            }
        }
    }
}

