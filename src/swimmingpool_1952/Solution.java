package swimmingpool_1952;

import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    private static int[] price = new int[4];
    private static int[] month = new int[12];
    private static Stack<Integer> st;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        st = new Stack<Integer>();
        int test = sc.nextInt();
         
        for(int i = 1; i <= test; i++) {
            int first = 0;
            int low = 1095000;
            for(int j = 0; j < 4; j++) {
                price[j] = sc.nextInt();
                if(j == 3) {
                    st.push(price[3]);
                }
            }
            for(int j = 0; j < 12; j++) {
                month[j] = sc.nextInt();
            }
            cal(first,0);
            while(!st.empty()){
                if(st.peek() < low) {
                    low = st.peek();
                }
                if(!st.isEmpty()) {
                st.pop();
                }
            }
            System.out.printf("#%d %d\n",i,low);
        }
    }
     
    private static int cal(int first, int sum) {
        int start = first;
        int end = 11;
        int ans = 0;
         
        if(start > end) {
            st.push(sum);
            return 0;
        }
     
        for(int i = 0; i < 3 ; i++) {
            if(i == 0) {
                ans = month[start] * price[0];
                start++;
                sum += ans;
                cal(start,sum);
                start--;
                sum -= ans;
            }
            else if(i == 1) {
                ans = price[1];
                start++;
                sum += ans;
                cal(start,sum);
                start--;
                sum -= ans;
            }
            else if(i == 2) {
                ans = price[2];
                start += 3;
                sum += ans;
                cal(start,sum);
                start -= 3;
                sum -= ans;
            }
        }
        return 0;
    }
}

