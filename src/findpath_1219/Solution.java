package findpath_1219;

import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<Integer>();
         
        for(int i = 1; i <= 10; i++) {
            int[] ar1 = new int[100];
            int[] ar2 = new int[100];
            boolean[] check = new boolean[100];
            int test = sc.nextInt();
            int num = sc.nextInt();
            for(int j = 0; j < num; j++) {
                if(j % 2 == 0) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    ar1[a] = b;
                }
                else {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    ar2[a] = b;
                }
            }
            st.push(0);
            int ans = 0;
            while(!st.isEmpty()) {
                int current = st.peek();
                check[current] = true;
                if(current == 99) {
                    ans = 1;
                    break;
                }
                if(!check[ar1[current]] && ar1[current] != 0) {
                    st.push(ar1[current]);
                    continue;
                }
                if(!check[ar2[current]] && ar2[current] != 0) {
                    st.push(ar2[current]);
                    continue;
                }
                if(check[ar1[current]] && check[ar2[current]] ) {
                    st.pop();
                }
                if(ar1[current] == 0 || ar2[current] == 0) {
                    st.pop();
                }
            }
            System.out.printf("#%d %d\n",test,ans);
            st.clear();
        }   
    }
}

