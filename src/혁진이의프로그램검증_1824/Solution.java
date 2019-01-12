package 혁진이의프로그램검증_1824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Solution {
	
	private static String[][] map;
	private static boolean[] left;
	private static boolean[] right;
	private static boolean[] up;
	private static boolean[] down;
	private static int r;
	private static int c;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] rc = br.readLine().split(" ");
				r = Integer.parseInt(rc[0]);
				c = Integer.parseInt(rc[1]);
				map = new String[r][c];
				left = new boolean[16];
				right = new boolean[16];
				up = new boolean[16];
				down = new boolean[16];
				// up down left right
				int[] updown = {-1,1,0,0};
				int[] leftright = {0,0,-1,1};
				for(int j = 0; j < r; j++) {
					String[] s = br.readLine().split("");
					for(int k = 0; k < c; k++) {
						map[j][k] = s[k];
					}
				}
				int mem = 0;
				int x = 0;
				int y = 0;
				int direction = 3;
				boolean arrive = false;
				while(true) {
					switch(map[x][y]) {
					case "0":case "1":case "2":case "3":case "4":case "5":case "6":
					case "7":case "8":case "9":case "10":case "11":case "12":
					case "13":case "14":case "15":
						mem = Integer.parseInt(map[x][y]);
						break;
					case "<":
						direction = 2;
						break;
					case ">":
						direction = 3;
						break;
					case "v":
						direction = 1;
						break;
					case "^":
						direction = 0;
						break;
					case "_" :
						if(mem == 0) {
							direction = 3;
						}
						else {
							direction = 2;
						}
						break;
					case "|" :
						if(mem == 0) {
							direction = 1;
						}
						else {
							direction = 0;
						}
						break;
					case "?" :
						direction = new Random().nextInt(3);
						break;
					case "@" :
						arrive = true;
						break;
					}
					
					x += updown[direction];
					y += leftright[direction];
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
