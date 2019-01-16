package 혁진이의프로그램검증_1824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Solution {

	private static String[][] map;
	private static int r;
	private static int c;
	private static boolean arrive;
	private static boolean[][][][] check;
	// up down left right
	private static int[] updown = { -1, 1, 0, 0 };
	private static int[] leftright = { 0, 0, -1, 1 };

	private static boolean find(int inMem, int inX, int inY, int inDirection) {

		int mem = inMem;
		int x = inX;
		int y = inY;
		
		int direction = inDirection;
		
		if (mem < 0) {
			mem = 15;
		}
		if (mem > 15) {
			mem = 0;
		}
		
		if (x < 0) {
			x = r - 1;
		}
		if (x > r - 1) {
			x = 0;
		}
		if (y < 0) {
			y = c - 1;
		}
		if (y > c - 1) {
			y = 0;
		}
//		System.out.println(x + " " + y + " " + direction);
		int xcopy = x;
		int ycopy = y;

		if(check[x][y][mem][direction]) {
			return true;
		}
		
		check[x][y][mem][direction] = true;

		xx: while (arrive) {
			switch (map[x][y]) {
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "10":
			case "11":
			case "12":
			case "13":
			case "14":
			case "15":
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
			case "_":
				if (mem == 0) {
					direction = 3;
				} else {
					direction = 2;
				}
				break;
			case "|":
				if (mem == 0) {
					direction = 1;
				} else {
					direction = 0;
				}
				break;
			case "?":
				arrive = find(mem, x - 1, y, 0);
				if(!arrive) {
					return false;
				}
				arrive = find(mem, x + 1, y, 1);
				if(!arrive) {
					return false;
				}
				arrive = find(mem, x, y - 1, 2);
				if(!arrive) {
					return false;
				}
				arrive = find(mem, x, y + 1, 3);
				if(!arrive) {
					return false;
				}
				break;
			case "@":
				arrive = false;
//				System.out.println("find");
				break;
			case "-":
				mem--;
				break;
			case "+":
				mem++;
				break;
			}
			
			if (mem < 0) {
				mem = 15;
			}
			if (mem > 15) {
				mem = 0;
			}
			
			x += updown[direction];
			y += leftright[direction];
//			System.out.println(x + " " + y + " " + direction);
			if (x < 0) {
				x = r - 1;
			} 
			if (x > r - 1) {
				x = 0;
			}
			if (y < 0) {
				y = c - 1;
			}
			if (y > c - 1) {
				y = 0;
			}
			
			if(x == xcopy && y == ycopy) {
				continue;
			}
			
			if(check[x][y][mem][direction]) {
				break xx;
			}
			
			check[x][y][mem][direction] = true;
						
		}

		return arrive;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for (int i = 1; i <= test; i++) {
				String[] rc = br.readLine().split(" ");
				r = Integer.parseInt(rc[0]);
				c = Integer.parseInt(rc[1]);
				map = new String[r][c];
				check = new boolean[r][c][16][4];
				arrive = true;
				for (int j = 0; j < r; j++) {
					String[] s = br.readLine().split("");
					for (int k = 0; k < c; k++) {
						map[j][k] = s[k];
					}
				}
				if (!find(0, 0, 0, 3)) {
					System.out.printf("#%d %s\n", i, "YES");
				} else {
					System.out.printf("#%d %s\n", i, "NO");
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
