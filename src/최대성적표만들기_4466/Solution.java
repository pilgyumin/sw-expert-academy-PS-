package 최대성적표만들기_4466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] nk = br.readLine().split(" ");
				int n = Integer.parseInt(nk[0]);
				int k = Integer.parseInt(nk[1]);
				ArrayList<Integer> ar = new ArrayList<Integer>();
				String[] num = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					ar.add(Integer.parseInt(num[j]));
				}
				Collections.sort(ar,Collections.reverseOrder());
				int sum = 0;
				for(int j = 0; j < k; j++) {
					sum += ar.get(j);
				}
				System.out.printf("#%d %d\n",i,sum);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
