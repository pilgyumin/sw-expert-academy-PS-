package 프로세서연결하기_1767;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";

		}
	}

	private static int edgecore;
	private static int lineans;
	private static int coreans;
	private static ArrayList<Node> ar;
	private static int n;

	private static void find(int aridx, int core, int line,int[][] map) {
		if(aridx == ar.size()) {
			if(coreans <= core + edgecore) {
				if(coreans < core+ edgecore) {
					lineans = 2000000000;
					coreans = core + edgecore;
				}
				
				if(lineans > line) {
					lineans = line;
				}
			}
			return ;
		}
		
		int x = ar.get(aridx).x;
		int y = ar.get(aridx).y;

		
		// 0 : 위, 1 : 아래, 2 : 왼쪽, 3 : 오른쪽
		for(int i = 0; i < 4; i++) {
			int cal = -1;

			cal = path(x,y,i,0,map);
			
			if(cal == 0) {
				find(aridx+1,core,line,map);
			}
			else if(cal > 0) {
				find(aridx+1,core+1,line+cal,map);
			}
		}
	}
	
	private static int path(int i, int j, int dir, int count,int[][] map) {
		int c = count;
		
		switch(dir) {
		case 0:
			if(map[i-1][j] == 1) {
				return 0;
			}
			else if(map[i-1][j] == 0) {
				map[i-1][j] = 3;
				c = path(i-1,j,0,count+1,map);
				if(c == 0) {
					map[i-1][j] = 0;
					return 0;
				}
			}
			else if(map[i-1][j] == 2) {
				return count;
			}
			else if(map[i-1][j] == 3) {
				return 0;
			}
			break;
		case 1:
			if(map[i+1][j] == 1) {
				return 0;
			}
			else if(map[i+1][j] == 0) {
				map[i+1][j] = 3;
				c = path(i+1,j,1,count+1,map);
				if(c == 0) {
					map[i+1][j] = 0;
					return 0;
				}
			}
			else if(map[i+1][j] == 2) {
				return count;
			}
			else if(map[i+1][j] == 3) {
				return 0;
			}
			break;
		case 2:
			if(map[i][j-1] == 1) {
				return 0;
			}
			else if(map[i][j-1] == 0) {
				map[i][j-1] = 3;
				c = path(i,j-1,2,count+1,map);
				if(c == 0) {
					map[i][j-1] = 0;
					return 0;
				}
			}
			else if(map[i][j-1] == 2) {
				return count;
			}
			else if(map[i][j-1] == 3) {
				return 0;
			}
			break;
		case 3:
			if(map[i][j+1] == 1) {
				return 0;
			}
			else if(map[i][j+1] == 0) {
				map[i][j+1] = 3;
				c = path(i,j+1,3,count+1,map);
				if(c == 0) {
					map[i][j+1] = 0;
					return 0;
				}
			}
			else if(map[i][j+1] == 2) {
				return count;
			}
			else if(map[i][j+1] == 3) {
				return 0;
			}
			break;
		}
		return c;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			edgecore = 0;
			lineans = 2000000000;
			coreans = 0;
			int[][] mapp = new int[n + 2][n + 2];
			ar = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < n + 2; j++) {
					if (j > 0 && j < n + 1) {
						mapp[i][j] = Integer.parseInt(s[j - 1]);
						if (mapp[i][j] == 1) {
							if (i == 1 || i == n || j == 1 || j == n) {
								edgecore++;
							} else {
								ar.add(new Node(i, j));
							}
						}
						continue;
					}
					mapp[i][j] = 2;
				}
			}
			Arrays.fill(mapp[0], 2);
			Arrays.fill(mapp[n + 1], 2);
			
			
			find(0,0,0,mapp);
			bw.write("#"+t+" "+lineans+"\n");


		}
		bw.flush();
	}
}
