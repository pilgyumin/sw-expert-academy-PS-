package 보호필름_2112;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	static int comp;
	static int d;
	static int w;
	static int k;
	static int[][] map;
	static int[][] change;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test ; t++) {
			String[] dwk = br.readLine().split(" ");
			d = Integer.parseInt(dwk[0]);
			w = Integer.parseInt(dwk[1]);
			k = Integer.parseInt(dwk[2]);

			map = new int[d][w];
			change = new int[d][w];

			for(int i = 0 ; i < d; i++) {
				String[] s  = br.readLine().split(" ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					change[i][j] = map[i][j];
				}
			}
			
			int ans = 0;
			for(int i = 0; i <= d; i++) {
				ans = i;
				comp = i;

				if(testQuality(0,0)) {
					break;
				}
				
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();

	}

	static boolean testQuality(int start, int count) {
		if(count == comp) {

			boolean noK = true;
			for(int i = 0; i < w; i++) {
				int cnt = 1;
				int num = change[0][i];
				for(int j = 1 ; j < d; j++) {
					if(cnt == k) {
						break;
					}
					if(num == change[j][i]) {
						++cnt;
					}
					else {
						cnt = 1;
						num = change[j][i];
					}
				}
				if(cnt < k) {
					noK = false;
					break;
				}
			}

			return noK;
		}
		
		boolean ret = false;
		
		for(int i = start; i < d; i++) {
			Arrays.fill(change[i], 1);
			ret = testQuality(i+1,count+1);

			if(ret) {
				return ret;
			}
			
			Arrays.fill(change[i], 0);
			ret = testQuality(i+1,count+1);
			
			for(int j = 0; j < w; j++) {
				change[i][j] = map[i][j];
			}

			if(ret) {
				return ret;
			}
		}
		return ret;
	}

}
