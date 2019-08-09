package 현주의상자바꾸기_5789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test;
		try {
			test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] nq = br.readLine().split(" ");
				int n = Integer.parseInt(nq[0]);
				int q = Integer.parseInt(nq[1]);
				int[] ar = new int[n];
				for(int j = 1; j <= q; j++) {
					String[] lr = br.readLine().split(" ");
					int l = Integer.parseInt(lr[0]) - 1;
					int r = Integer.parseInt(lr[1]) - 1;
					for(int k = l; k <= r; k++) {
						ar[k] = j;
					}
				}
				System.out.print("#" + i + " ");
				for(int j = 0; j < n; j++) {
					System.out.print(ar[j] + " ");
				}
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {}
	}
}
