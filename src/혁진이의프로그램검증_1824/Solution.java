package 혁진이의프로그램검증_1824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Solution {

	private static String[][] map;
	private static int[][] comp;
	private static int r;
	private static int c;
	private static boolean arrive;
	private static boolean[] left;
	private static boolean[] right;
	private static boolean[] up;
	private static boolean[] down;
	// up down left right
	private static int[] updown = { -1, 1, 0, 0 };
	private static int[] leftright = { 0, 0, -1, 1 };

	private static boolean find(int inMem, int inX, int inY, int inDirection,boolean check
			,int prevdi) {
		if(!check) {
			return false;
		}
		int mem = inMem;
		int x = inX;
		int y = inY;
		int direction = inDirection;
		int prevdir = prevdi;
		if (x < 0) {
			x = r - 1;
		} else if (x > r - 1) {
			x = 0;
		}
		if (y < 0) {
			y = c - 1;
		} else if (y > c - 1) {
			y = 0;
		}
		
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
				if(direction == 0) {
					prevdir = 1;
				}
				else if(direction == 1) {
					prevdir = 0;
				}
				else if(direction == 2) {
					prevdir = 3;
				}
				else if(direction == 3) {
					prevdir = 2;
				}
				switch (prevdir) {
				case 0:
					arrive = find(mem, x - 1, y, 0,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x, y - 1, 2,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x, y + 1, 3,arrive,direction);
					if(!arrive) {
						return false;
					}
					break;
					
				case 1:
					arrive = find(mem, x - 1, y, 1,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x, y - 1, 2,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x, y + 1, 3,arrive,direction);
					if(!arrive) {
						return false;
					}
					break;
				case 2:
					arrive = find(mem, x - 1, y, 0,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x + 1, y, 1,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x, y - 1, 2,arrive,direction);
					if(!arrive) {
						return false;
					}
					break;
				case 3:
					arrive = find(mem, x - 1, y, 0,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x + 1, y, 1,arrive,direction);
					if(!arrive) {
						return false;
					}
					arrive = find(mem, x, y + 1, 3,arrive,direction);
					if(!arrive) {
						return false;
					}
					break;
				}
				break;
			case "@":
				arrive = false;
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
			} else if (mem > 15) {
				mem = 0;
			}
			comp[x][y] = mem;
			

			x += updown[direction];
			y += leftright[direction];
			
			if (x < 0) {
				x = r - 1;
			} else if (x > r - 1) {
				x = 0;
			}
			if (y < 0) {
				y = c - 1;
			} else if (y > c - 1) {
				y = 0;
			}
			
			if(comp[x][y] == mem) {
				return true;
			}
			
			if (x == r - 2 && y == c - 1) {
				if (!left[mem]) {
					left[mem] = true;
				} else {
					break xx;
				}
			} else if (x == 0 && y == c - 1) {
				if (!right[mem]) {
					right[mem] = true;
				} else {
					break xx;
				}
			} else if (x == r - 1 && y == c - 2) {
				if (!up[mem]) {
					up[mem] = true;
				} else {
					break xx;
				}
			} else if (x == r - 1 && y == 0) {
				if (!down[mem]) {
					down[mem] = true;
				} else {
					break xx;
				}
			}
			
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
				comp = new int[r][c];
				arrive = true;
				left = new boolean[16];
				right = new boolean[16];
				up = new boolean[16];
				down = new boolean[16];
				for (int j = 0; j < r; j++) {
					String[] s = br.readLine().split("");
					Arrays.fill(comp[j], -1);
					for (int k = 0; k < c; k++) {
						map[j][k] = s[k];
					}
				}
				if (!find(0, 0, 0, 3,arrive,2)) {
					System.out.printf("#%d %s\n", i, "YES");
				} else {
					System.out.printf("#%d %s\n", i, "NO");
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
