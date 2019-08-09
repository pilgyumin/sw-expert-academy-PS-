package 치즈도둑_7733;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int taste;
		
		public Node(int x, int y, int taste) {
			this.x = x;
			this.y = y;
			this.taste = taste;
		}

		@Override
		public int compareTo(Node o) {
			return this.taste - o.taste;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", taste=" + taste + "]";
		}
		
		

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			int num = Integer.parseInt(br.readLine());
			int[][] map = new int[num + 2][num + 2];
			int max = 0;
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			for(int i = 1; i <= num; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 1; j <= num; j++) {
					map[i][j] = Integer.parseInt(s[j-1]);
					pq.add(new Node(i,j,map[i][j]));
					
					if(max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			
			int ans = 1;
			ArrayList<Node> ar = new ArrayList<>();
			
			for(int time = 1; time <= max; time++) {
				
				int count = 0;
				boolean[][] visited = new boolean[num+2][num+2];
				
				while(!pq.isEmpty() && pq.peek().taste == time) {
					ar.add(pq.poll());
				}
				
				for(int i = 0; i < ar.size(); i++) {
					Node n = ar.get(i);
					visited[n.x][n.y] = true;
				}
			
				
				for(int i = 1; i <= num; i++) {
					for(int j = 1; j <= num; j++) {
						if(!visited[i][j]) {
							count++;
							Queue<Node> qu = new LinkedList<>();
							qu.add(new Node(i,j,0));

							while(!qu.isEmpty()) {
								
								Node n = qu.poll();
								
								int x = n.x;
								int y = n.y;
								
								if(map[x-1][y] > time && !visited[x-1][y]) {
									qu.add(new Node(x-1,y,0));
									visited[x-1][y] = true;
								}
								
								if(map[x+1][y] > time && !visited[x+1][y]) {
									qu.add(new Node(x+1,y,0));
									visited[x+1][y] = true;
								}
								
								if(map[x][y-1] > time && !visited[x][y-1]) {
									qu.add(new Node(x,y-1,0));
									visited[x][y-1] = true;
								}
								
								if(map[x][y+1] > time && !visited[x][y+1]) {
									qu.add(new Node(x,y+1,0));
									visited[x][y+1] = true;
								}
							}
						}
					}
				}
				
				if(count > ans) {
					ans = count;
				}
				
			}
						
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
