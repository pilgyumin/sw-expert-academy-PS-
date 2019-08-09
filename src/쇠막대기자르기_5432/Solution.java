package 쇠막대기자르기_5432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> st = new Stack<String>();
        try {
            int test = Integer.parseInt(br.readLine());
            for (int i = 1; i <= test; i++) {
                String[] s = br.readLine().replace("()", ".").split("");
                int ans = 0;
                int count = 0;
                for (int j = 0; j < s.length; j++) {
                    if(s[j].equals("(")) {
                        count++;
                    }
                    else if(s[j].equals(".")) {
                        ans += count;
                    }
                    else if(s[j].equals(")")) {
                        count--;
                        ans++;
                    }
                     
                }
                System.out.printf("#%d %d\n", i, ans);
            }
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
 
        }
    }
}

