package flattern_1208;

import java.util.Scanner;

public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int dump = sc.nextInt();
            int[] arr = new int[100];
            int max = 0;
            int min = 100;
            for(int j = 0; j < 100; j++) {
                arr[j] = sc.nextInt();
                if(arr[j] > max) {
                    max = arr[j];
                }
                else if(arr[j] < min) {
                    min = arr[j];
                }
            }
            boolean check = false;
             
            for(int j = 0; j < dump+1; j++) {
                int count = 0;
                int count1 = 0;
                int count2 = 0;
                boolean bmax = false;
                boolean bmin = false;
                while(count != 2) {
                    if(!check) {
                        for(int k = 0; k < 100; k++) {
                            if(arr[k] == max) {
                                arr[k]--;
                                bmax = true;
                                count1++;
                                check = true;
                                break;
                            }
                        }
                        if(!bmax) {
                            max--;
                        }
                    }
                    else {
                        for(int k = 0; k < 100; k++) {
                            if(check && arr[k] == min) {
                                arr[k]++;
                                count2++;
                                bmin = true;
                                check= false;
                                break;
                            }
                        }
                        if(!bmin){
                            min++;
                        }
                    }
                    count = count1 + count2;
                }
            }
            System.out.printf("#%d %d\n",i,max-min);
        }
    }
}

