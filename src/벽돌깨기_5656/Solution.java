package º®µ¹±ú±â_5656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	private static int[][] map;
	private static int[][] copy;
	private static int n;
	private static int w;
	private static int h;
	private static int ans;

	private static void marbleOrder(int cnt, int[] marble) {
		
		if (cnt == n) {
			for(int i = 0; i < w+2; i++) {
				for(int j = 0; j < h+2; j++) {
					map[i][j] = copy[i][j];
				}
			}
			for (int i = 0; i < marble.length; i++) {
				findMarble(1,marble[i]);
				mapOrder();
			}
			
			int cal = 0;
			for(int i = 1; i <= w; i++) {
				for(int j = 1; j <= h; j++) {
					if(map[i][j] != 0) {
						cal++;
					}
				}
			}
			
			if(ans > cal) {
				ans = cal;
			}
			return;
		}

		for (int i = 1; i <= h; i++) {
			marble[cnt] = i;
			marbleOrder(cnt + 1, marble);
		}
	}
	
	private static void mapOrder() {
		
		for(int j = 1; j <= h; j++) {
			for(int i = w-1; i >= 1; i--) {
				if(map[i][j] != 0) {
					if(map[i+1][j] == 0) {
						below(i,j,map[i][j]);
						map[i][j] = 0;
					}
				}
			}
		}
	}
	
	private static void below(int x, int y, int v) {

		if(map[x+1][y] != 0) {
			map[x][y] = v;
			return ;
		}
		
		below(x+1 , y , v);
	}

	private static void findMarble(int x, int y) {
		
		if (x == 0 || x == w + 1 || y == 0 || y == h + 1) {
			return;
		}

		if (map[x][y] == 0) {
			findMarble(x+1, y);
		} else {
			startMarble(x, y);
		}

	}

	private static void startMarble(int x, int y) {

		if (x == 0 || x == w + 1 || y == 0 || y == h + 1) {
			return;
		}
		
		if(map[x][y] == 1) {
			map[x][y] = 0;
			return ;
		}
		
		else if (map[x][y] > 1) {
			int k = map[x][y];
			map[x][y] = 0;
			
			breakMarble(x, y, 1, k-1 ,0);
			breakMarble(x, y, 2, k-1 ,0);
			breakMarble(x, y, 3, k-1 ,0);
			breakMarble(x, y, 4, k-1 ,0);
		}

	}

	private static void breakMarble(int x, int y, int dir, int my, int cnt) {
		
		if (x == 0 || x == w + 1 || y == 0 || y == h + 1) {
			return;
		}

		if(my == cnt) {
			map[x][y] = 0;
			return;
		}

		switch(dir) {
		case 1:
			if(map[x-1][y] > 1) {
				startMarble(x-1,y);
				map[x][y] = 0;
				breakMarble(x-1, y, dir, my, cnt+1);
			}
			else {
				map[x][y] = 0;
				breakMarble(x-1, y, dir, my, cnt+1);
			}
			break;
		case 2:
			if(map[x+1][y] > 1) {
				startMarble(x+1,y);
				map[x][y] = 0;
				breakMarble(x+1, y, dir, my, cnt+1);
			}
			else {
				map[x][y] = 0;
				breakMarble(x+1, y, dir, my, cnt+1);
			}
			break;
		case 3:
			if(map[x][y-1] > 1) {
				startMarble(x,y-1);
				map[x][y] = 0;
				breakMarble(x, y-1, dir, my, cnt+1);
			}
			else {
				map[x][y] = 0;
				breakMarble(x, y-1, dir, my, cnt+1);
			}
			break;
		case 4:
			if(map[x][y+1] > 1) {
				startMarble(x,y+1);
				map[x][y] = 0;
				breakMarble(x, y+1, dir, my, cnt+1);
			}
			else {
				map[x][y] = 0;
				breakMarble(x, y+1, dir, my, cnt+1);
			}
			break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			String[] nwh = br.readLine().split(" ");
			n = Integer.parseInt(nwh[0]);
			w = Integer.parseInt(nwh[2]);
			h = Integer.parseInt(nwh[1]);
			map = new int[w + 2][h + 2];
			copy = new int[w + 2][h + 2];
			ans = 300;
			int[] marble = new int[n];

			for (int i = 1; i <= w+1; i++) {
				for (int j = 0; j <= h+1; j++) {
					copy[i][j] = -1;
				}
			}
			for (int i = 1; i <= w; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 1; j <= h; j++) {
					copy[i][j] = Integer.parseInt(s[j - 1]);
				}
			}
			marbleOrder(0, marble);
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
