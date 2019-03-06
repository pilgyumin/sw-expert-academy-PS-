package 미생물격리_2382;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Micro {
		int x;
		int y;
		int num;
		int direct;

		public Micro(int x, int y, int num, int direct) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.direct = direct;
		}

		@Override
		public String toString() {
			return num + "," + direct;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= test; t++) {
			String[] nmk = br.readLine().split(" ");
			int n = Integer.parseInt(nmk[0]);
			int m = Integer.parseInt(nmk[1]);
			int k = Integer.parseInt(nmk[2]);
			Queue<Micro> qu = new LinkedList<>();
			
			Micro[][] map = new Micro[n][n];
			int[][] sum = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = new Micro(i, j, 0, 0);
				}
			}

			for (int i = 0; i < k; i++) {
				String[] s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				int num = Integer.parseInt(s[2]);
				int dir = Integer.parseInt(s[3]);
				Micro mi = new Micro(x, y, num, dir);
				qu.add(mi);
			}

			for (int i = 0; i < m; i++) {
				int size = qu.size();
						
				for (int j = 0; j < size; j++) {
					Micro mi = qu.poll();
					switch (mi.direct) {
					case 1:
						if (map[mi.x - 1][mi.y].num == 0) {
							if (mi.x - 1 == 0) {
								mi.num /= 2;
								if (mi.num == 0) {
									break;
								}
								map[mi.x - 1][mi.y].num = mi.num;
								sum[mi.x - 1][mi.y] += mi.num;
								map[mi.x - 1][mi.y].direct = 2;
							}
							else {
								map[mi.x - 1][mi.y].num = mi.num;
								sum[mi.x - 1][mi.y] += mi.num;
								map[mi.x - 1][mi.y].direct = mi.direct;
							}
						} 
						else {
							if (map[mi.x - 1][mi.y].num > mi.num) {
								sum[mi.x-1][mi.y] += mi.num;
							} else {
								sum[mi.x-1][mi.y] += mi.num;
								map[mi.x - 1][mi.y].num = mi.num;
								map[mi.x - 1][mi.y].direct = mi.direct;
							}
						}
						break;
					case 2:
						if (map[mi.x + 1][mi.y].num == 0) {
							if (mi.x + 1 == n - 1) {
								mi.num /= 2;
								if (mi.num == 0) {
									break;
								}
								map[mi.x + 1][mi.y].num = mi.num;
								sum[mi.x + 1][mi.y] += mi.num;
								map[mi.x + 1][mi.y].direct = 1;
							}
							else {
								map[mi.x + 1][mi.y].num = mi.num;
								sum[mi.x + 1][mi.y] += mi.num;
								map[mi.x + 1][mi.y].direct = mi.direct;
							}
							
						} 
						else {
							if (map[mi.x + 1][mi.y].num > mi.num) {
								sum[mi.x+1][mi.y] += mi.num;
							} else {
								sum[mi.x+1][mi.y] += mi.num;
								map[mi.x + 1][mi.y].num = mi.num;
								map[mi.x + 1][mi.y].direct = mi.direct;
							}
						}
						break;
					case 3:
						if (map[mi.x][mi.y - 1].num == 0) {
							if (mi.y - 1 == 0) {
								mi.num /= 2;
								if (mi.num == 0) {
									break;
								}
								map[mi.x][mi.y - 1].num = mi.num;
								sum[mi.x][mi.y - 1] += mi.num;
								map[mi.x][mi.y - 1].direct = 4;
							}
							else {
								map[mi.x][mi.y - 1].num = mi.num;
								sum[mi.x][mi.y - 1] += mi.num;
								map[mi.x][mi.y - 1].direct = mi.direct;
							}
							
						} 
						else {
							if (map[mi.x][mi.y-1].num > mi.num) {
								sum[mi.x][mi.y-1] += mi.num;
							} else {
								sum[mi.x][mi.y-1] += mi.num;
								map[mi.x][mi.y-1].num = mi.num;
								map[mi.x][mi.y-1].direct = mi.direct;
							}
						}
						break;
					case 4:

						if (map[mi.x][mi.y + 1].num == 0) {
							if (mi.y + 1 == n - 1) {
								mi.num /= 2;
								if (mi.num == 0) {
									break;
								}
								map[mi.x][mi.y + 1].num = mi.num;
								sum[mi.x][mi.y + 1] += mi.num;
								map[mi.x][mi.y + 1].direct = 3;
							}
							else {
								map[mi.x][mi.y + 1].num = mi.num;
								sum[mi.x][mi.y + 1] += mi.num;
								map[mi.x][mi.y + 1].direct = mi.direct;
							}

						} 
						else {
							if (map[mi.x][mi.y+1].num > mi.num) {
								sum[mi.x][mi.y+1] += mi.num;
							} else {
								sum[mi.x][mi.y+1] += mi.num;
								map[mi.x][mi.y+1].num = mi.num;
								map[mi.x][mi.y+1].direct = mi.direct;
							}
						}
						break;
					}
				}
				

				for (int e = 0; e < n; e++) {
					for (int r = 0; r < n; r++) {
						if (map[e][r].num > 0) {
							qu.add(new Micro(e, r, sum[e][r], map[e][r].direct));
							map[e][r].num = 0;
							map[e][r].direct = 0;
							sum[e][r] = 0;
						}
					}
				}

			}

			int ans = 0;
			int size = qu.size();
			for (int e = 0; e < size; e++) {
				ans += qu.poll().num;
			}
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
	}
}
