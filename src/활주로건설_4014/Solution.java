package 활주로건설_4014;

import java.util.Scanner;

public class Solution {
	
	private static int[][] map;
	private static int n;
	private static int x;
	private static int[][] slope1;
	private static int[][] slope2;
	private static boolean[][] runway;
	
	public static boolean moveLeft(int i, int j, int cnt) {
		if(cnt == x) {
			runway[i][j] = true;
			return true;
		}
		if(j - 1 >= 0 && slope1[i][j-1] == 11 && !runway[i][j-1]) {
			return false;
		}
		if(j - 1 >= 0 && slope1[i][j-1] == 10 && !runway[i][j-1]) {
			runway[i][j] = moveLeft(i,j-1,cnt+1);
			return runway[i][j];
		}
		return false;
	}
	
	public static boolean moveRight(int i, int j, int cnt) {
		if(cnt == x) {
			runway[i][j] = true;
			return true;
		}
		if(j <= n -2 &&(slope1[i][j] == 12 ) && !runway[i][j+1]) {
			return false;
		}
		if(j <= n -2 &&( slope1[i][j] == 10 ) && !runway[i][j+1]) {
			runway[i][j] = moveRight(i,j+1,cnt+1);
			return runway[i][j];
		}
		return false;
	}
	
	public static boolean moveDown(int i, int j, int cnt) {
		if(cnt == x) {
			runway[i][j] = true;
			return true;
		}
		if(i <= n - 2 &&(slope2[i][j] == 12 )&& !runway[i+1][j]) {
			return false;
		}
		if(i <= n - 2 &&( slope2[i][j] == 10  )&& !runway[i+1][j]) {
			runway[i][j] = moveDown(i+1,j,cnt+1);
			return runway[i][j];
		}
		return false;
	}
	
	public static boolean moveUp(int i, int j, int cnt) {
		if(cnt == x) {
			runway[i][j] = true;
			return true;
		}
		if(i - 1 >= 0 && ( slope2[i-1][j] == 11 ) && !runway[i-1][j]) {
			return false;
		}
		if(i - 1 >= 0 && ( slope2[i-1][j] == 10) && !runway[i-1][j]) {
			runway[i][j] = moveUp(i-1,j,cnt+1);
			return runway[i][j];
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++) {
			n = sc.nextInt();
			x = sc.nextInt();
			map = new int[n][n];
			slope2 = new int[n-1][n];
			slope1 = new int[n][n-1];
			runway = new boolean[n][n];
			int count = 0;
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n-1; k++) {
					if(map[j][k] == map[j][k+1]) {
						slope1[j][k] = 10;
					}
					else if(map[j][k] == map[j][k+1] + 1) {
						slope1[j][k] = 12;
					}
					else if(map[j][k] + 1 == map[j][k+1]) {
						slope1[j][k] = 11;
					}
					else {
						slope1[j][k] = 13;
					}
				}
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n-1; k++) {
					if(map[k][j] == map[k+1][j]) {
						slope2[k][j] = 10;
					}
					else if(map[k][j] == map[k+1][j] + 1) {
						slope2[k][j] = 12;
					}
					else if(map[k][j] + 1 == map[k+1][j]) {
						slope2[k][j] = 11;
					}
					else {
						slope2[k][j] = 13;
					}
				}
			}
			
			for(int j = 0; j < n; j++) {
				boolean check = true;
				for(int k = 0; k < n-1; k++) {
					if(slope1[j][k] == 12) {
						check = moveRight(j,k+1,1);
						if(!check) {
							break;
						}
					}
					else if(slope1[j][k] == 11) {
						check = moveLeft(j,k,1);
						if(!check) {
							break;
						}
					}
					else if(slope1[j][k] == 13) {
						check = false;
						break;
					}
				}
				if(check) {
					count++;
				}
			}
			
			runway = new boolean[n][n];
			
			for(int j = 0; j < n; j++) {
				boolean check = true;
				for(int k = 0; k < n-1; k++) {
					if(slope2[k][j] == 12) {
						check = moveDown(k+1,j,1);
						if(!check) {
							break;
						}
					}
					else if(slope2[k][j] == 11) {
						check = moveUp(k,j,1);
						if(!check) {
							break;
						}
					}
					else if(slope2[k][j] == 13) {
						check = false;
						break;
					}
				}
				if(check) {
					count++;
				}
			}
			
			System.out.printf("#%d %d\n",i,count);
		}
	}
}
