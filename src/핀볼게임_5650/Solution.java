package «…∫º∞‘¿”_5650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	
	static class Wormhole implements Comparable<Wormhole>{
		int x;
		int y;
		int num;
		
		public Wormhole(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Wormhole [x=" + x + ", y=" + y + ", num=" + num + "]";
		}

		@Override
		public int compareTo(Wormhole arg0) {
			return this.num - arg0.num;
		}

	}
	
	static class Ball{
		int x;
		int y;
		int count;
		int dir;
		
		public Ball(int x, int y, int count, int dir) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Ball [x=" + x + ", y=" + y + ", count=" + count + ", dir=" + dir + "]";
		}

	}
	
	private static int ans;
	private static int[][] map;
	private static boolean[][] wormmap;
	private static ArrayList<Wormhole> wm;
	
	private static void playgame(int x, int y) {
		ArrayDeque<Ball> qu = new ArrayDeque<>();
		qu.add(new Ball(x,y,0,0));
		qu.add(new Ball(x,y,0,1));
		qu.add(new Ball(x,y,0,2));
		qu.add(new Ball(x,y,0,3));
		
		while(!qu.isEmpty()) {
			Ball b = qu.poll();
			int bx = b.x;
			int by = b.y;
			int bc = b.count;
			int bd = b.dir;
			
			if(bc > 0 && map[bx][by] == -1) {
				if(ans < bc) {
					ans = bc;
				}
				continue;
			}
			
			switch(bd){
			case 0 :
				if(map[bx-1][by] == 0) {
					qu.add(new Ball(bx-1,by,bc,bd));
					continue;
				}
				if(map[bx-1][by] == -1) {
					if(ans < bc) {
						ans = bc;
					}
					continue;
				}
				if(wormmap[bx-1][by]) {
					Wormhole wh = null;
					for(int i = 0; i < wm.size(); i++) {
						wh = wm.get(i);
						if(wh.num == map[bx-1][by] && (wh.x != bx-1 || wh.y != by)) {
							break;
						}
					}
					qu.add(new Ball(wh.x,wh.y,bc,bd));
					continue;
				}
				if((map[bx-1][by] & (1 << 0)) != 0 && !wormmap[bx-1][by]) {
					qu.add(new Ball(bx-1,by,bc+1,(bd+2) % 4));
					continue;
				}
				if(map[bx-1][by] > 0 && map[bx-1][by] < 100 && (map[bx-1][by] & (1 << bd)) == 0 && !wormmap[bx-1][by]) {
					int idx = 0;
					for(int i = 0; i < 4; i++) {
						if(i == bd) {
							continue;
						}
						if((map[bx-1][by] & (1 << i)) == 0) {
							idx = i;
							break;
						}
					}
					if(idx == 1) {
						qu.add(new Ball(bx-1,by,bc+1,3));
					}
					else {
						qu.add(new Ball(bx-1,by,bc+1,1));
					}
					continue;
				}
				
				break;
			case 1:
				if(map[bx][by+1] == 0) {
					qu.add(new Ball(bx,by+1,bc,bd));
					continue;
				}
				if(map[bx][by+1] == -1) {
					if(ans < bc) {
						ans = bc;
					}
					continue;
				}

				//ø˙»¶
				if(wormmap[bx][by+1]) {
					Wormhole wh = null;
					for(int i = 0; i < wm.size(); i++) {
						wh = wm.get(i);
						if(wh.num == map[bx][by+1] && (wh.x != bx || wh.y != by+1)) {
							break;
						}
					}
					qu.add(new Ball(wh.x,wh.y,bc,bd));
					continue;
				}
				//∫Æ ∫Œµ˙
				if((map[bx][by+1] & (1 << bd)) != 0 && !wormmap[bx][by+1]) {
					qu.add(new Ball(bx,by+1,bc+1,(bd+2) % 4));
					continue;
				}
				// ±º¿˝ ∫Œµ˙
				if(map[bx][by+1] > 0 && map[bx][by+1] < 100 &&(map[bx][by+1] & (1 << bd)) == 0 && !wormmap[bx][by+1]) {
					int idx = 0;
					for(int i = 0; i < 4; i++) {
						if(i == bd) {
							continue;
						}
						if((map[bx][by+1] & (1 << i)) == 0) {
							idx = i;
							break;
						}
					}
					if(idx == 2) {
						qu.add(new Ball(bx,by+1,bc+1,0));
					}
					else {
						qu.add(new Ball(bx,by+1,bc+1,2));
					}
					continue;
				}
				
				break;
			case 2:
				if(map[bx+1][by] == 0) {
					qu.add(new Ball(bx+1,by,bc,bd));
					continue;
				}
				if(map[bx+1][by] == -1) {
					if(ans < bc) {
						ans = bc;
					}
					continue;
				}

				//ø˙»¶
				if(wormmap[bx+1][by]) {
					Wormhole wh = null;
					for(int i = 0; i < wm.size(); i++) {
						wh = wm.get(i);
						if(wh.num == map[bx+1][by] && (wh.x != bx+1 || wh.y != by)) {
							break;
						}
					}
					qu.add(new Ball(wh.x,wh.y,bc,bd));
					continue;
				}
				//∫Æ ∫Œµ˙
				if((map[bx+1][by] & (1 << 2)) != 0 && !wormmap[bx+1][by]) {
					qu.add(new Ball(bx+1,by,bc+1,(bd+2) % 4));
					continue;
				}
				// ±º¿˝ ∫Œµ˙
				if(map[bx+1][by] > 0 && map[bx+1][by] < 100 && (map[bx+1][by] & (1 << 2)) == 0 && !wormmap[bx+1][by]) {
					int idx = 0;
					for(int i = 0; i < 4; i++) {
						if(i == bd) {
							continue;
						}
						if((map[bx+1][by] & (1 << i)) == 0) {
							idx = i;
							break;
						}
					}
					if(idx == 1) {
						qu.add(new Ball(bx+1,by,bc+1,3));
					}
					else {
						qu.add(new Ball(bx+1,by,bc+1,1));
					}
					
					continue;
				}
				
				break;
			case 3:
				if(map[bx][by-1] == 0) {
					qu.add(new Ball(bx,by-1,bc,bd));
					continue;
				}
				if(map[bx][by-1] == -1) {
					if(ans < bc) {
						ans = bc;
					}
					continue;
				}

				//ø˙»¶
				if(wormmap[bx][by-1]) {
					Wormhole wh = null;
					for(int i = 0; i < wm.size(); i++) {
						wh = wm.get(i);
						if(wh.num == map[bx][by-1] && (wh.x != bx || wh.y != by-1)) {
							break;
						}
					}
					qu.add(new Ball(wh.x,wh.y,bc,bd));
					continue;
				}
				//∫Æ ∫Œµ˙
				if((map[bx][by-1] & (1 << bd)) != 0 && !wormmap[bx][by-1]) {
					qu.add(new Ball(bx,by-1,bc+1,(bd+2) % 4));
					continue;
				}
				// ±º¿˝ ∫Œµ˙
				if(map[bx][by-1] > 0 && map[bx][by-1] < 100 && (map[bx][by-1] & (1 << bd)) == 0 && !wormmap[bx][by-1]) {
					int idx = 0;
					for(int i = 0; i < 4; i++) {
						if(i == bd) {
							continue;
						}
						if((map[bx][by-1] & (1 << i)) == 0) {
							idx = i;
							break;
						}
					}
					if(idx == 2) {
						qu.add(new Ball(bx,by-1,bc+1,0));
					}
					else {
						qu.add(new Ball(bx,by-1,bc+1,2));
					}
					continue;
				}
				
				break;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			ans = 0;
			int n = Integer.parseInt(br.readLine());
			map = new int[n+2][n+2];
			wormmap = new boolean[n+2][n+2];
			
			wm = new ArrayList<>();
			
			for(int i = 0; i < n+2; i++) {
				Arrays.fill(map[i], 15);
			}
			
			for(int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 1; j <= n; j++) {
					int a = Integer.parseInt(s[j-1]);
					switch(a) {
					case -1:
						map[i][j] = -1;
						break;
						
					case 0:
						map[i][j] = 0;
						break;
					case 1:
						map[i][j] = 3;
						break;
						
					case 2:
						map[i][j] = 6;
						break;
						
					case 3:
						map[i][j] = 12;
						break;
						
					case 4:
						map[i][j] = 9;
						break;
						
					case 5:
						map[i][j] = 15;
						break;
						
					case 6: case 7: case 8: case 9: case 10:
						map[i][j] = a+20;
						wm.add(new Wormhole(i,j,a+20));
						wormmap[i][j] = true;
						break;
					}
				}
			}
			
			Collections.sort(wm);

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] == 0) {
						map[i][j] = -1;
						playgame(i,j);
						map[i][j] = 0;

					}
				}
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
