package 무선충전_5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	static class User {
		int x;
		int y;

		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "User [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			String[] ma = br.readLine().split(" ");
			int m = Integer.parseInt(ma[0]);
			int a = Integer.parseInt(ma[1]);

			int[] userA = new int[m + 1];
			int[] userB = new int[m + 1];
			int[][] map = new int[12][12];
			int[] power = new int[a];
			int ans = 0;
			String[] sa = br.readLine().split(" ");
			String[] sb = br.readLine().split(" ");

			for (int i = 1; i <= m; i++) {
				userA[i] = Integer.parseInt(sa[i-1]);
				userB[i] = Integer.parseInt(sb[i-1]);
			}

			for (int i = 1; i <= a; i++) {
				String[] s = br.readLine().split(" ");
				int x = Integer.parseInt(s[1]);
				int y = Integer.parseInt(s[0]);
				int c = Integer.parseInt(s[2]);
				power[i - 1] = Integer.parseInt(s[3]);

				for (int j = x - c; j <= x + c; j++) {
					for (int k = y - c; k <= y + c; k++) {
						if (j < 1 || j > 10 || k < 1 || k > 10) {
							continue;
						}
						if (c >= (Math.abs(j - x) + (Math.abs(k - y)))) {
							map[j][k] |= (1 << i);
						}
					}
				}
			}

			User ua = new User(1, 1);
			User ub = new User(10, 10);

			for (int r = 0; r <= m; r++) {
				boolean[] range = new boolean[10];
				boolean same = false;
				int count = 0;
				int acnt = 0;
				int bcnt = 0;
				// 1. 사용자 이동
				switch (userA[r]) {
				case 1:
					ua.x -= 1;
					break;
				case 2:
					ua.y += 1;
					break;
				case 3:
					ua.x += 1;
					break;
				case 4:
					ua.y -= 1;
					break;
				}
				switch (userB[r]) {
				case 1:
					ub.x -= 1;
					break;
				case 2:
					ub.y += 1;
					break;
				case 3:
					ub.x += 1;
					break;
				case 4:
					ub.y -= 1;
					break;
				}
				
				// 2. 각 사용자별 충전 가능 확인
				for(int i = 1; i < 10; i++) {
					if((map[ua.x][ua.y] & (1 << i)) != 0) {
						range[i] = true;
						acnt++;
					}
					if((map[ub.x][ub.y] & (1 << i)) != 0) {
						if(range[i]) {
							same = true;
						}
						bcnt++;
						range[i] = true;
					}
				}
				for(int i = 1; i < 10; i++) {
					if(range[i]) {
						count++;
					}
				}
				
				// 3. 충전 용량 파악
				if(!same) {
					int amax = 0;
					int bmax = 0;
					for(int i = 1; i < 10; i++) {
						if((map[ua.x][ua.y] & (1 << i)) != 0) {
							if(amax < power[i-1]) {
								amax = power[i-1];
							}
						}
						if((map[ub.x][ub.y] & (1 << i)) != 0) {
							if(bmax < power[i-1]) {
								bmax = power[i-1];
							}
						}
					}
					ans += amax;
					ans += bmax;
				}
				else {
					if(count == 1) {
						for(int i = 1; i < 10; i++) {
							if(range[i]) {
								ans += power[i-1];
								break;
							}
						}
					}
					else if(count == 2) {
						for(int i = 1; i < 10; i++) {
							if(range[i]) {
								ans += power[i-1];
							}
						}
					}
					else if(count >= 3) {
						int max = 0;
						for(int i = 1; i < 10; i++) {
							if((map[ua.x][ua.y] & (1 << i)) != 0) {
								for(int j = 1; j < 10; j++) {
									if(i == j) {
										continue;
									}
									if((map[ub.x][ub.y] & (1 << j)) != 0) {
										if(max < power[i-1]+power[j-1]) {
											max = power[i-1]+power[j-1];
										}
									}
								}
							}
						}
						ans += max;
					}
				}
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}

}
