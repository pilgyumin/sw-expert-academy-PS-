package 디저트카페_2105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	private static int ans;
	private static int[][] map;
	private static int startI;
	private static int startJ;
	private static int n;
	
	private static void find(int i, int j, int dir, int cnt, boolean[] visited) {
		
		if(i == 0 || i == n+1 || j == 0 || j == n+1) {
			return;
		}
		
		if(i == startI && j == startJ && cnt > 0) {
			if(ans < cnt) {
				ans = cnt;
			}
			return;
		}

		switch(dir) {
		case 1:
			if(map[i+1][j-1] == 0 && !visited[map[i+1][j+1]]) {
				visited[map[i+1][j+1]] = true;
				find(i+1,j+1,2,cnt+1,visited);
				visited[map[i+1][j+1]] = false;
			}
			else {
				if(!visited[map[i+1][j-1]] && map[i+1][j-1] != 0) {
					visited[map[i+1][j-1]] = true;
					find(i+1,j-1,1,cnt+1,visited);
					visited[map[i+1][j-1]] = false;
				}
				if(!visited[map[i+1][j+1]] && map[i+1][j+1] != 0) {
					visited[map[i+1][j+1]] = true;
					find(i+1,j+1,2,cnt+1,visited);
					visited[map[i+1][j+1]] = false;
				}
			}
			break;
		case 2:
			if(map[i+1][j+1] == 0  && !visited[map[i-1][j+1]]) {
				visited[map[i-1][j+1]] = true;
				find(i-1,j+1,3,cnt+1,visited);
				visited[map[i-1][j+1]] = false;
			}
			else {
				if(!visited[map[i-1][j+1]] && map[i-1][j+1] != 0) {
					visited[map[i-1][j+1]] = true;
					find(i-1,j+1,3,cnt+1,visited);
					visited[map[i-1][j+1]] = false;
				}
				if(!visited[map[i+1][j+1]] && map[i+1][j+1] != 0) {
					visited[map[i+1][j+1]] = true;
					find(i+1,j+1,2,cnt+1,visited);
					visited[map[i+1][j+1]] = false;
				}
			}
			break;
		case 3:
			if(map[i-1][j+1] == 0 && !visited[map[i-1][j-1]]) {
				visited[map[i-1][j-1]] = true;
				find(i-1,j-1,4,cnt+1,visited);
				visited[map[i-1][j-1]] = false;
			}
			else {
				if(!visited[map[i-1][j-1]] && map[i-1][j-1] != 0) {
					visited[map[i-1][j-1]] = true;
					find(i-1,j-1,4,cnt+1,visited);
					visited[map[i-1][j-1]] = false;
				}
				if(visited[map[i-1][j-1]] && (i-1) == startI && (j-1) == startJ) {
					find(i-1,j-1,4,cnt+1,visited);
				}
				if(!visited[map[i-1][j+1]] && map[i-1][j+1] != 0) {
					visited[map[i-1][j+1]] = true;
					find(i-1,j+1,3,cnt+1,visited);
					visited[map[i-1][j+1]] = false;
				}
			}
			break;
		case 4:
			if(map[i-1][j-1] == 0) {
				return ;
			}
			else {
				if(!visited[map[i-1][j-1]] && map[i-1][j-1] != 0) {
					visited[map[i-1][j-1]] = true;
					find(i-1,j-1,4,cnt+1,visited);
					visited[map[i-1][j-1]] = false;
				}
				if(visited[map[i-1][j-1]] && (i-1) == startI && (j-1) == startJ) {
					find(i-1,j-1,4,cnt+1,visited);
				}
			}
			break;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n+2][n+2];
			ans = -1;
			int max = 0;
			for(int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(s[j-1]);
					if(map[i][j] > max) {
						max = map[i][j];
					}
				}
			}

			for(int j = 2; j <= n-1; j++) {
				for(int i = 1; i <= n-2; i++) {
					boolean[] b = new boolean[max+1];
					startI = i;
					startJ = j;
					b[map[i][j]] = true;
					find(i,j,1,0,b);
					b[map[i][j]] = false;
				}
			}

			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
