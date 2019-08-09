package 이미지유사도검사_1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for (int i = 1; i <= test; i++) {
				
				int num = Integer.parseInt(br.readLine().trim());
				
				int[][] map = new int[num+1][num+1];
				
				String[] x = br.readLine().split("");
				String[] y = br.readLine().split("");
				for(int j = 1; j < num+1; j++) {
					for(int k = 1; k < num+1; k++) {
						if(x[j-1].equals(y[k-1])) {
							map[j][k] = map[j-1][k-1] + 1;
						}
						else {
							map[j][k] = Math.max(map[j-1][k], map[j][k-1]);
						}
					}
				}
				System.out.printf("#%d %.2f\n",i,map[num][num]/(double)num * 100);
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
