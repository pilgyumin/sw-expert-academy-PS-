package themaximumprizemoney_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Solution {
    private static int com;
    private static int max;
    private static int[] num1;
    private static boolean c = false;
    private static int[] count;
     
    public static int swap(int[] xx, int index) {
        String s = "";
        for(int a : xx) {
            s += a;
        }
        int m = Integer.parseInt(s);
        if(m == com) {
            for(int i = 0; i < count.length; i++) {
                if(count[i] > 1) {
                    max = com;
                    c = true;
                    return 0;
                }
            }
            if(index % 2 == 1) {
                int temp = xx[xx.length-1];
                xx[xx.length-1] = xx[xx.length - 2];
                xx[xx.length -2] = temp;
                String ss = "";
                for(int a : xx) {
                    ss += a;
                }
                int m2 = Integer.parseInt(ss);
                max = m2;
                c = true;
            }
            else {
                max = com;
                c = true;
            }
            return 0;
        }
        if(index == 0) {
             
            if(m > max) {
                max = m;
            }
            if(m == com) {
                c = true;
            }
            return 0;
        }
        int[] ar = new int[xx.length];
         
        for (int j = 0; j < ar.length; j++) {
            for (int k = j + 1 ; k < ar.length; k++) {
                for(int z = 0; z < ar.length ; z++) {
                    ar[z] = xx[z];
                }
                int temp = ar[j];
                ar[j] = ar[k];
                ar[k] = temp;
                swap(ar,index-1);
                 
                if(c) {
                    break;
                }
            }
            if(c) {
                break;
            }
        }
        return 0;
    }
 
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        try {
            int test = Integer.parseInt(br.readLine());
            for (int i = 1; i <= test; i++) {
                String[] div = br.readLine().split(" ");
                max = Integer.parseInt(div[0]);
                String[] s = String.valueOf(max).split("");
                int comp = Integer.parseInt(div[1]);
                num1 = new int[s.length];
                count = new int[10];
                int[] num2 = new int[s.length];
                for (int j = 0; j < num1.length; j++) {
                    num1[j] = Integer.parseInt(s[j]);
                    num2[j] = Integer.parseInt(s[j]);
                    count[num1[j]]++;
                }
                for (int j = 0; j < num2.length; j++) {
                    for (int k = j + 1; k < num2.length; k++) {
                        if(num2[j] < num2[k]) {
                            int temp = num2[j];
                            num2[j] = num2[k];
                            num2[k] = temp;
                        }
                    }
                }
                String ss = "";
                for (int j = 0; j < num1.length; j++) {
                    ss += num2[j];
                }
                com = Integer.parseInt(ss);
                swap(num1, comp);
                System.out.printf("#%d %d\n",i,max);
                c = false;
            }
             
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
}

