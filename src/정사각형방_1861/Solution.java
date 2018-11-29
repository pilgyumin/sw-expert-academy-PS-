package 정사각형방_1861;

import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    private static int[][] ar;
    private static boolean[][] check;
    private static int ans = 1;
    private static int index;
    private static int count = 0;
    private static Stack<String> st;
    public static int find(int x, int y) {
        count++;
        if(ar[x-1][y]== ar[x][y] - 1) {
            find(x-1,y);
            return 1;
        }
        else if(ar[x+1][y] == ar[x][y] - 1) {
            find(x+1,y);
            return 1;
        }
        else if(ar[x][y-1]== ar[x][y] - 1) {
            find(x,y-1);
            return 1;
        }
        else if(ar[x][y+1]== ar[x][y] - 1) {
            find(x,y+1);
            return 1;
        }
         
        if(ans <= count) {       
                st.push(count + " " + ar[x][y]);
                ans = count;
            }
         
        count = 0;
        return 0;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            st = new Stack<String>();
            int num = sc.nextInt();
            ar = new int[num + 2][num + 2];
            check = new boolean[num + 2][num + 2];
            index = num * num;
            for(int j = 0; j < num+2; j++) {
                for(int k = 0; k < num+2; k++) {
                    if(j == 0 || j == num+1) {
                        ar[j][k] = -1;
                        check[j][k] = true;
                        continue;
                    }
                    if(k == 0 || k == num+1) {
                        ar[j][k] = -1;
                        check[j][k] = true;
                        continue;
                    }
                    ar[j][k] = sc.nextInt();
                }
            }
            for(int j = 1; j < num+1; j++) {
                for(int k = 1; k < num+1; k++) {
                    if(!check[j][k]) {
                        find(j,k);
                    }
                }
            }
            for(int j = 0; j < st.size(); j++) {
                String[] s = st.pop().split(" ");
                if(Integer.parseInt(s[0]) == ans) {
                    if(index > Integer.parseInt(s[1])) {
                        index = Integer.parseInt(s[1]);
                    }
                }
            }
            System.out.printf("#%d %d %d\n",i, index, ans);
            ans = 1;
            count = 0;
        }
    }
}

