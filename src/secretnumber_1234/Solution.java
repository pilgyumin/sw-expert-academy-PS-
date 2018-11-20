package secretnumber_1234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
 
public class Solution {
 
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int test = 10;
            for (int i = 1; i <= test; i++) {
                String[] num = br.readLine().split(" ");
                String[] s = num[1].split("");
                Stack<String> st = new Stack<String>();
                st.push(s[0]);
                for(int j = 1; j < s.length; j++) {
                    if(st.empty()) {
                        st.push(s[j]);
                        continue;
                    }
                    if(st.peek().equals(s[j])) {
                        st.pop();
                        continue;
                    }
                    st.push(s[j]);
                }
                int go = st.size();
                String ans = "";
                for(int j = 0; j < go; j++) {
                    ans = st.pop() + ans;
                }
                System.out.printf("#%d %s\n",i,ans);
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

