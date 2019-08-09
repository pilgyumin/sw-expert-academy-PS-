package 부분수열의합_2817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static int n;
	private static int k;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] nk = br.readLine().split(" ");
				n = Integer.parseInt(nk[0]);
				k = Integer.parseInt(nk[1]);
				String[] s = br.readLine().split(" ");
				int[] ar = new int[n];
				for(int j = 0; j < n; j++) {
					ar[j] = Integer.parseInt(s[j]);
				}
				int z = 1;
				int cnt = 0;
				for(int j = 0; j < Math.pow(2, n); j++) {
					int sum = 0;
					for(int m = 0; m < n; m++) {
						if(sum > k) {
							break;
						}
						if((z & (1 << m)) != 0) {
							sum += ar[m];
						}
					}
					if(sum == k) {
						cnt++;
					}
					z++;
				}
				System.out.printf("#%d %d\n",i,cnt);
			}
		} catch (NumberFormatException | IOException e) {}
	}
}
