package 파이프연결_4340;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static class Node{
		int x;
		int y;
		int count;
		int dir;
		
		public Node(int x, int y, int count, int dir) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + ", dir=" + dir + "]";
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int[][] map = new int[n+2][n+2];
			int[][][] visited = new int[4][n+2][n+2];
			int ans = 2501;
			Queue<Node> qu = new LinkedList<>();
			
			for(int i = 1; i <= n; i++) {
				String[] s = sc.nextLine().split(" ");
				for(int k = 0; k < 4; k++) {
					Arrays.fill(visited[k][i], 2501);
				}
				for(int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(s[j-1]);
				}
			}
			map[n][n+1] = 1;
			qu.add(new Node(1,1,1,1));
			visited[0][1][1] = 1;
			visited[1][1][1] = 1;
			visited[2][1][1] = 1;
			visited[3][1][1] = 1;
			
			while(!qu.isEmpty()) {
				Node no = qu.poll();
				
				int nx = no.x;
				int ny = no.y;
				int nc = no.count;
				int nd = no.dir;
				
				if(nx == n && ny == n + 1) {
					if(ans > nc) {
						ans = nc;
					}
					continue;
				}
				
				if(ans <= nc) {
					continue;
				}

				
				if(0 < map[nx][ny] && map[nx][ny] <= 2) {
					switch(nd) {
					case 0:
						if(visited[0][nx-1][ny] > nc + 1 && map[nx-1][ny] != 0) {
							visited[0][nx-1][ny] = nc + 1;
							qu.add(new Node(nx-1,ny,nc+1,0));
						}
						break;
					case 1:
						if(visited[1][nx][ny+1] > nc + 1 && map[nx][ny+1] != 0) {
							visited[1][nx][ny+1] = nc + 1;
							qu.add(new Node(nx,ny+1,nc+1,1));
						}
						break;
					case 2:
						if(visited[2][nx+1][ny] > nc + 1 && map[nx+1][ny] != 0) {
							visited[2][nx+1][ny] = nc + 1;
							qu.add(new Node(nx+1,ny,nc+1,2));
						}
						break;
					case 3:
						if(visited[3][nx][ny-1] > nc + 1 && map[nx][ny-1] != 0) {
							visited[3][nx][ny-1] = nc + 1;
							qu.add(new Node(nx,ny-1,nc+1,3));
						}
						break;
					}
				}
				else if(3 <= map[nx][ny] && map[nx][ny] <= 6){
					int left = nd-1;
					if(left < 0) {
						left += 4;
					}
					int right = (nd+1) % 4;
					
					switch(left) {
					case 0:
						if(visited[0][nx-1][ny] > nc + 1 && map[nx-1][ny] != 0) {
							visited[0][nx-1][ny] = nc + 1;
							qu.add(new Node(nx-1,ny,nc+1,0));
						}
						break;
					case 1:
						if(visited[1][nx][ny+1] > nc + 1 && map[nx][ny+1] != 0) {
							visited[1][nx][ny+1] = nc + 1;
							qu.add(new Node(nx,ny+1,nc+1,1));
						}
						break;
					case 2:
						if(visited[2][nx+1][ny] > nc + 1 && map[nx+1][ny] != 0) {
							visited[2][nx+1][ny] = nc + 1;
							qu.add(new Node(nx+1,ny,nc+1,2));
						}
						break;
					case 3:
						if(visited[3][nx][ny-1] > nc + 1 && map[nx][ny-1] != 0) {
							visited[3][nx][ny-1] = nc + 1;
							qu.add(new Node(nx,ny-1,nc+1,3));
						}
						break;
					}
					switch(right) {
					case 0:
						if(visited[0][nx-1][ny] > nc + 1 && map[nx-1][ny] != 0) {
							visited[0][nx-1][ny] = nc + 1;
							qu.add(new Node(nx-1,ny,nc+1,0));
						}
						break;
					case 1:
						if(visited[1][nx][ny+1] > nc + 1 && map[nx][ny+1] != 0) {
							visited[1][nx][ny+1] = nc + 1;
							qu.add(new Node(nx,ny+1,nc+1,1));
						}
						break;
					case 2:
						if(visited[2][nx+1][ny] > nc + 1 && map[nx+1][ny] != 0) {
							visited[2][nx+1][ny] = nc + 1;
							qu.add(new Node(nx+1,ny,nc+1,2));
						}
						break;
					case 3:
						if(visited[3][nx][ny-1] > nc + 1 && map[nx][ny-1] != 0) {
							visited[3][nx][ny-1] = nc + 1;
							qu.add(new Node(nx,ny-1,nc+1,3));
						}
						break;
					}
				}

			}
			System.out.println("#"+t+" "+(ans - 1)+"\n");
		}
	}
}
