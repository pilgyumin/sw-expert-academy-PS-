package 백만장자프로젝트_1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	
	static int[] ar;
	static BigInteger sum;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				int num = Integer.parseInt(br.readLine());
				ar = new int[num];
				String[] s  = br.readLine().split(" ");
				for(int j = 0; j < num; j++) {
					ar[j] = Integer.parseInt(s[j]);
				}
				sum = new BigInteger("0");
				int cal = ar[num-1];
				for(int j = num - 1; j >= 0; j--) {
					if(cal > ar[j]) {
						sum = sum.add(new BigInteger(String.valueOf(cal)).subtract(new 
								BigInteger(String.valueOf(ar[j]))));
					}
					else if(cal < ar[j]) {
						cal = ar[j];
					}
				}
				System.out.printf("#%d %s\n",i,sum.toString());
			}		
		} catch (NumberFormatException | IOException e) {}
	}
}
