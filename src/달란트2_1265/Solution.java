package ¥ﬁ∂ı∆Æ2_1265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] np = br.readLine().split(" ");
				BigInteger n = new BigInteger(np[0]);
				BigInteger p = new BigInteger(np[1]);
				BigInteger num = n.divide(p);
				BigInteger[] ar = new BigInteger[Integer.parseInt(p.toString())];
				Arrays.fill(ar, num);
				n = n.subtract(num.multiply(p));
				int k = Integer.parseInt(n.toString());
				while(k > 0) {
					ar[k--] = ar[k].add(new BigInteger("1"));
				}
				BigInteger ans = new BigInteger("1");
				for(int j = 0; j < Integer.parseInt(p.toString()); j++) {
					ans = ans.multiply(ar[j]);
				}
				System.out.printf("#%d %s\n",i,ans.toString());
			}
		} catch (NumberFormatException | IOException e) {}
	}
}
