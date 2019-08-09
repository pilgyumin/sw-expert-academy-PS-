package 최장공통부분수열_3304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] ab = br.readLine().split(" ");
				
				String[] a = ab[0].split("");
				String[] b = ab[1].split("");
				System.out.println(a.length);
				System.out.println(b.length);
				int[][] map = new int[a.length + 1][b.length + 1];
	
				for(int j = 1; j < a.length + 1 ; j++) {
					for(int k = 1; k < b.length + 1; k++) {
						if(a[j-1].equals(b[k-1])) {
							map[j][k] = map[j-1][k-1] + 1;
						}
						else {
							map[j][k] = Math.max(map[j-1][k], map[j][k-1]);
						}
					}
				}
				System.out.printf("#%d %d\n",i,map[a.length][b.length]);
			}
		} catch (NumberFormatException | IOException e) {
		}	
	}
}
