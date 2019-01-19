package ¥ﬁ∂ı∆Æ2_1265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static int n;
	private static int num;
	private static int p;
	private static int[] ar;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] np = br.readLine().split(" ");
				n = Integer.parseInt(np[0]);
				p = Integer.parseInt(np[1]);
				num = n / p;
				ar = new int[p];
				for(int j = 0; j < p; j++) {
					if(j == p-1) {
						ar[j] = n;
						break;
					}
					ar[j] = num;
					n -= num;
				}
				int ans = 1;
				for(int j = 0; j < p; j++) {
					ans *= ar[j];
				}
				System.out.printf("#%d %d\n",i,ans);
			}
		} catch (NumberFormatException | IOException e) {}
	}
}
