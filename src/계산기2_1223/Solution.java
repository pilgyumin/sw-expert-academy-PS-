package °è»ê±â2_1223;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<String>();
        HashMap<String,Integer> icp = new HashMap<String,Integer>();
        HashMap<String,Integer> isp = new HashMap<String,Integer>();
        icp.put("+", 2);
        icp.put("-", 2);
        icp.put("*", 3);
        icp.put("*", 3);
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            String[] postfix = new String[num];
            String[] s = sc.next().split("");
            sc.nextLine();
            int index = 0;
            for(int j = 0; j < num; j++) {
                try {
                    postfix[index] = String.valueOf(Integer.parseInt(s[j]));
                     
                }
                catch(NumberFormatException e) {
                    if(st.empty()) {
                        st.push(s[j]);
                        continue;
                    }
                    else {
                         if(icp.get(st.peek()) < icp.get(s[j])) {
                             st.push(s[j]);
                             continue;
                         }
                         else if(icp.get(st.peek()) >= icp.get(s[j])) {
                             while(!st.empty() && icp.get(st.peek()) >= icp.get(s[j])) {
                                 postfix[index] = st.pop();
                                 index++;
                             }
                             st.push(s[j]);
                             index--;
                         }
                    }
                }
                index++;
            }
            for(int j = 0; j <= st.size(); j++) {
                postfix[index] = st.pop();
                index++;
            }
         
            for(int j = 0; j < num; j++) {
                try {
                    st.push(String.valueOf(Integer.parseInt(postfix[j])));
                }
                catch(NumberFormatException e) {
                    if(postfix[j].equals("+")) {
                        int a = Integer.parseInt(st.pop());
                        int b = Integer.parseInt(st.pop());
                        st.push(String.valueOf(a+b));
                    }
                    else if(postfix[j].equals("*")) {
                        int a = Integer.parseInt(st.pop());
                        int b = Integer.parseInt(st.pop());
                        st.push(String.valueOf(a*b));
                    }
                    }
            }
            System.out.printf("#%d %s\n",i,st.pop());
        }   
    }
}

