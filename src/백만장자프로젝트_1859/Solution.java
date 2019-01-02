package 백만장자프로젝트_1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
	
	static ArrayList<Integer> ar;
	static BigInteger sum;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				int num = Integer.parseInt(br.readLine());
				ar = new ArrayList<Integer>();
				String[] s  = br.readLine().split(" ");
				for(int j = 0; j < num; j++) {
					ar.add(Integer.parseInt(s[j]));
				}
				sum = new BigInteger("0");
				int cal = ar.get(num-1);
				for(int j = num - 1; j >= 0; j--) {
					if(cal > ar.get(j)) {
						sum = sum.add(new BigInteger(String.valueOf(cal)).subtract(new 
								BigInteger(String.valueOf(ar.get(j)))));
					}
					else if(cal < ar.get(j)) {
						cal = ar.get(j);
					}
				}
				System.out.printf("#%d %s\n",i,sum.toString());
			}		
		} catch (NumberFormatException | IOException e) {}
	}
}
