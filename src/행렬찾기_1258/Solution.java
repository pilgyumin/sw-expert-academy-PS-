package 행렬찾기_1258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int w;
		int h;
		int area;
		
		public Node(int w, int h) {
			this.w = w;
			this.h = h;
			this.area = w*h;
		}

		@Override
		public String toString() {
			return  w + " " + h;
		}

		@Override
		public int compareTo(Node o) {
			if(this.area < o.area) {
				return -1;
			}
			else if(this.area > o.area) {
				return 1;
			}
			else if(this.area == o.area) {
				if(this.w < o.w) {
					return -1;
				}
				else if(this.w > o.w) {
					return 1;
				}
			}
			return 0;
		}
		
		
	}
	
	private static int count;
	private static int[][] map;
	private static boolean[][] visited;
	private static int wid;
	private static int hei;
	private static ArrayList<Node> ar;
	private static int n;
	
	public static int findright(int x, int y) {
		
		if(map[x][y] == 0) {
			return 0;
		}
		if(y <= n-2 && map[x][y+1] != 0) {
			hei++;
			findright(x,y+1);
		}
		
		return 0;
	}
	
public static int finddown(int x, int y) {
		
		if(map[x][y] == 0) {
			return 0;
		}
		if(x <= n-2 && map[x+1][y] != 0) {
			wid++;
			finddown(x+1,y);
		}
		
		return 0;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				n = Integer.parseInt(br.readLine());
				map = new int[n][n];
				visited = new boolean[n][n];
				ar = new ArrayList<Node>();
				count = 0;
				for(int j = 0; j < n; j++) {
					String[] s = br.readLine().split(" ");
					for(int k = 0; k < n; k++) {
						map[j][k] = Integer.parseInt(s[k]);
					}
				}
				
				for(int j = 0; j < n; j++) {
					for(int k = 0; k < n; k++) {
						if(map[j][k] != 0 && !visited[j][k]) {
							count++;
							wid = 1;
							hei = 1;
							findright(j,k);
							finddown(j,k);
							ar.add(new Node(wid,hei));
							for(int m = j; m < j+wid; m++) {
								for(int n = k; n < k+hei; n++) {
									visited[m][n] = true;
								}
							}
						}
					}
				}
				
				Collections.sort(ar);
				
				System.out.printf("#%d %d ",i,count);
				for(int j = 0; j < ar.size(); j++) {
					System.out.print(ar.get(j) + " ");
				}
				System.out.println();
				
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
