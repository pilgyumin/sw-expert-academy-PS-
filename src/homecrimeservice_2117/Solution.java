package homecrimeservice_2117;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static class Node{
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
	
	private static int n;
	private static int m;
	private static int[][] map;
	private static int house;
	private static ArrayList<Node> ar;
	private static int ans;
	private static int operate;
	
	public static void find() {
		for(int j = 0; j < n; j++) {
			for(int k = 0; k < n; k++) {
				if(map[j][k] == 1) {
					int count = 0;
					for(int i = 0; i < ar.size(); i++) {
						Node comp = ar.get(i);
						int x = j + (comp.x);
						int y = k + (comp.y);
						if(x < 0 || x >= n || y < 0 || y >= n) {
							continue;
						}
						if(map[x][y] == 1) {
							count++;
							System.out.println(x + " " + y);
						}
					}
					if(count * m > operate) {
						ans = count;
					}
					System.out.println("*********************");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][n];
			house = 0;
			ans = 0;
			ar = new ArrayList<Node>();
			int z = 2;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					map[j][k] = sc.nextInt();
					if(map[j][k] == 1) {
						house++;
					}
				}
			}
		
			while(house * m > (z * z)-((z-1)*(z-1))) {
				for(int j = 0; j < z+1; j++) {
					for(int k = z-j; k >= -(z-j); k--) {
						if(j == 0) {
							Node no = new Node(j,k);
							ar.add(no);
						}
						else {
							Node no = new Node(j,k);
							ar.add(no);
							Node no1 = new Node(-j,k);
							ar.add(no1);
						}
					}
				}
				for(int v = 0; v < ar.size(); v++) {
					System.out.println(ar.get(v));
				}
				
				operate = ar.size();
				System.out.println(z+"-------------");
				find();
				
//				System.out.println("---------------------");
//				z++;
			}
			System.out.printf("#%d %d\n",i,ans);
		}
	}
}
