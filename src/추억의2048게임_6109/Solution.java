package 추억의2048게임_6109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static int n;
	private static int[][] map;
	private static boolean[][] visited;

	private static void up(int x, int y, boolean check, int value) {
		if(check && map[x][y] != 0) {
			map[x][y] += value;
			visited[x][y] = true;
			return ;
		}
		if(x > 0 && !visited[x-1][y] && map[x-1][y] == value ) {
			up(x-1,y,true,value);
			map[x][y] = 0;
			return;
		}
		if(x > 0  && map[x-1][y] == 0) {
			up(x-1,y,false,value);
			map[x][y] = 0;
			return;
		}
		if(x > 0 && visited[x-1][y] && map[x][y] == 0) {
			map[x][y] = value;
			return ;
		}
		if(map[x][y] == 0) {
			map[x][y] += value;
			return;
		}
	}

	private static void down(int x, int y, boolean check, int value) {
		if(check && map[x][y] != 0) {
			map[x][y] += value;
			visited[x][y] = true;
			return ;
		}
		if(x < n-1 && !visited[x+1][y] && map[x+1][y] == value ) {
			down(x+1,y,true,value);
			map[x][y] = 0;
			return;
		}
		if(x < n-1 && map[x+1][y] == 0) {
			down(x+1,y,false,value);
			map[x][y] = 0;
			return;
		}
		if(x < n-1 && visited[x+1][y] && map[x][y] == 0) {
			map[x][y] = value;
			return ;
		}
		if(map[x][y] == 0) {
			map[x][y] += value;
			return;
		}
	}

	private static void left(int x, int y, boolean check, int value) {
		if(check && map[x][y] != 0) {
			map[x][y] += value;
			visited[x][y] = true;
			return ;
		}
		if(y > 0 && !visited[x][y-1] && map[x][y-1] == value ) {
			left(x,y-1,true,value);
			map[x][y] = 0;
			return;
		}
		if(y > 0 && map[x][y-1] == 0) {
			left(x,y-1,false,value);
			map[x][y] = 0;
			return;
		}
		if(y > 0 && visited[x][y-1] && map[x][y] == 0) {
			map[x][y] = value;
			return ;
		}
		if(map[x][y] == 0) {
			map[x][y] += value;
			return;
		}
	}

	private static void right(int x, int y, boolean check, int value) {
		if(check && map[x][y] != 0) {
			map[x][y] += value;
			visited[x][y] = true;
			return ;
		}
		if(y < n-1 && !visited[x][y+1] && map[x][y+1] == value ) {
			right(x,y+1,true,value);
			map[x][y] = 0;
			return;
		}
		if(y < n-1 && map[x][y+1] == 0) {
			right(x,y+1,false,value);
			map[x][y] = 0;
			return;
		}
		if(y < n-1 && visited[x][y+1] && map[x][y] == 0) {
			map[x][y] = value;
			return ;
		}
		if(map[x][y] == 0) {
			map[x][y] += value;
			return;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for (int i = 1; i <= test; i++) {
				String[] ns = br.readLine().split(" ");
				n = Integer.parseInt(ns[0]);
				map = new int[n][n];
				visited = new boolean[n][n];
				for (int j = 0; j < n; j++) {
					String[] s = br.readLine().split(" ");
					for (int k = 0; k < n; k++) {
						map[j][k] = Integer.parseInt(s[k]);
					}
				}
				switch (ns[1]) {
				case "up":
					for (int j = 1; j < n; j++) {
						for (int k = 0; k < n; k++) {
							up(j,k,false,map[j][k]);
						}
					}
					break;
				case "down":
					for (int j = n-1; j >= 0; j--) {
						for (int k = 0; k < n; k++) {
							down(j,k,false,map[j][k]);
						}
					}
					break;
				case "left":
					for (int j = 1; j < n; j++) {
						for (int k = 0; k < n; k++) {
							left(k,j,false,map[k][j]);
						}
					}
					break;
				case "right":
					for (int j = n-1; j >= 0; j--) {
						for (int k = 0; k < n; k++) {
							right(k,j,false,map[k][j]);
						}
					}
					break;
				}
				System.out.println("#"+i);
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						System.out.print(map[j][k] + " ");
					}
					System.out.println();
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
