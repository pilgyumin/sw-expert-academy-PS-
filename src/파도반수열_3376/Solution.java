package 파도반수열_3376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Solution {
 
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int test = Integer.parseInt(br.readLine());
            for (int i = 1; i <= test; i++) {
                int num = Integer.parseInt(br.readLine());
                ArrayList<Long> ar = new ArrayList<Long>();
                ar.add((long) 1);
                ar.add((long) 1);
                ar.add((long) 1);
                ar.add((long) 2);
                ar.add((long) 2);
                while(ar.size() < num) {
                    ar.add(ar.get(ar.size()-1) + ar.get(ar.size()-5));
                }
                System.out.printf("#%d %d\n",i,ar.get(num-1));
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

