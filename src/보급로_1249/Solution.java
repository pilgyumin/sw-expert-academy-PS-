package º¸±Þ·Î_1249;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {	
			this.x = x;
			this.y = y;
		}
		
	}
	
	private static int[][] dist;
	private static int[][] map;
	private static boolean[][] check;
	private static int n;
	
	public static void dijkstra(int x, int y) {
		Node n = new Node(x,y);
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(n);
		dist[x][y] = 0;
		while(!qu.isEmpty()) {
			Node no = qu.poll();
			if(check[no.x][no.y]) {
				continue;
			}
			check[no.x][no.y] = true;
			if(!check[no.x-1][no.y]) {
				Node nw = new Node(no.x-1,no.y);
				qu.add(nw);
				if(dist[no.x-1][no.y] > map[no.x-1][no.y] + dist[no.x][no.y]) {
					dist[no.x-1][no.y] = map[no.x-1][no.y] + dist[no.x][no.y];
				}
				
			}
			if(!check[no.x+1][no.y]) {
				Node nw = new Node(no.x+1,no.y);
				qu.add(nw);
				if(dist[no.x+1][no.y] > map[no.x+1][no.y] + dist[no.x][no.y]) {
					dist[no.x+1][no.y] = map[no.x+1][no.y] + dist[no.x][no.y];
				}
			
			}
			if(!check[no.x][no.y-1]) {
				Node nw = new Node(no.x,no.y-1);
				qu.add(nw);
				if(dist[no.x][no.y-1] > map[no.x][no.y-1] + dist[no.x][no.y]) {
					dist[no.x][no.y-1] = map[no.x][no.y-1] + dist[no.x][no.y];
				}
			
			}
			if(!check[no.x][no.y+1]) {
				Node nw = new Node(no.x,no.y+1);
				qu.add(nw);
				if(dist[no.x][no.y+1] > map[no.x][no.y+1] + dist[no.x][no.y]) {
					dist[no.x][no.y+1] = map[no.x][no.y+1] + dist[no.x][no.y];
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 1; i <= test; i++) {
			n = sc.nextInt();
			map = new int[n+2][n+2];
			dist = new int[n+2][n+2];
			check = new boolean[n+2][n+2];
			for (int j = 0; j < n + 2; j++) {
				String[] s;
				if (j == 0 || j == n + 1) {
					Arrays.fill(check[j], true);
					Arrays.fill(dist[j], 100000);
					continue;
				} else {
					s = sc.next().split("");
				}
				for (int k = 0; k < n + 2; k++) {
					if (k == 0 || k == n + 1) {
						check[j][k] = true;
						dist[j][k] = 100000;
						continue;
					}
					dist[j][k] = 100000;
					map[j][k] = Integer.parseInt(s[k - 1]);
				}
			}
			dijkstra(1, 1);
			for(int j = 0; j < n+2; j++) {
				for(int k = 0 ; k < n+2; k++) {
					System.out.print(dist[j][k] + " ");
				}
				System.out.println();
			}
			System.out.printf("#%d %d\n",i,dist[n][n]);
		}
	}
}
