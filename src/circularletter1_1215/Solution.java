package circularletter1_1215;

import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = 10;
        for(int i = 1; i <= test; i++) {
            int len = sc.nextInt();
            sc.nextLine();
            String[][] arr = new String[8][8];
            for(int j = 0; j < 8; j++) {
                arr[j] = sc.nextLine().split("");
            }
            System.out.printf("#%d %d\n",i,find(arr,len));
        }
    }
     
    public static int find(String[][] arr,int len) {
        boolean same = true;
        int find = 0;
        for(int j = 0; j < 8; j++) {
            for(int k = 0; k <= 8-len; k++) {
                for(int m = 0; m < len/2; m++) {
                    if(!arr[j][k+m].equals(arr[j][k+len-1-m])) {
                        same = false;
                    }
                }
                if(same) {
                    find++;
                }
                same = true;
            }
        }
        for(int j = 0; j < 8; j++) {
            for(int k = 0; k <= 8-len; k++) {
                for(int m = 0; m < len/2; m++) {
                    if(!arr[k+m][j].equals(arr[k+len-1-m][j])) {
                        same = false;
                    }
                }
                if(same) {
                    find++;
                }
                same = true;
            }
        }
        return find;
    }
}
 
