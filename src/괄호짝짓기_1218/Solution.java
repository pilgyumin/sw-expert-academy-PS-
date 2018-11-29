package °ýÈ£Â¦Áþ±â_1218;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<String>();
        HashMap<String,String> hm = new HashMap<String,String>();
        for(int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split("");
            int ans = 1;
            hm.put("}", "{");
            hm.put(")", "(");
            hm.put("]", "[");
            hm.put(">", "<");
            for(int j = 0; j < s.length; j++) {
                if(s[j].equals("{") || s[j].equals("[") ||
                        s[j].equals("(") ||s[j].equals("<")) {
                    st.push(s[j]);
                }
                if(s[j].equals("}") || s[j].equals("]") ||
                        s[j].equals(")") ||s[j].equals(">")){
                            if(!hm.get(s[j]).equals(st.pop())) {
                                ans = 0;
                                break;
                            }
                }
            }
            System.out.printf("#%d %d\n",i,ans);
        }   
    }
}

