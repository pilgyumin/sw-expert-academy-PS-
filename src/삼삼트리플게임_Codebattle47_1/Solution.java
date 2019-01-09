package ªÔªÔ∆Æ∏Æ«√∞‘¿”_Codebattle47_1;

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
				String[] n = br.readLine().split("");
				String[] c = br.readLine().split("");
				int[][] map = new int[3][9];
				for(int j = 0; j < 9; j++) {
					switch(c[j]) {
					case "R":
						map[0][Integer.parseInt(n[j]) - 1]++;
						break;
					case "G":
						map[1][Integer.parseInt(n[j]) - 1]++;
						break;
					case "B":
						map[2][Integer.parseInt(n[j]) - 1]++;
						break;
					}
					
				}
				int count = 0;
				xx : for(int j = 0; j < 3; j++) {
					for(int k = 0; k < 9; k++) {
						if(map[j][k] != 0) {
							while(map[j][k] != 0) {
								if(map[j][k] >= 3) {
									map[j][k] -= 3;
									count++;
								}
								else {
									if(k < 7 && map[j][k+1] != 0
											&& map[j][k+2] != 0) {
										count++;
										map[j][k]--;
										map[j][k+1]--;
										map[j][k+2]--;
										continue;
									}
									break xx;
								}
							}
						}
					}
					
				}
				if(count >= 3) {
					System.out.printf("#%d %s\n",i,"Win");
				}
				else {
					System.out.printf("#%d %s\n",i,"Continue");
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
