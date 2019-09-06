package 방향전환_8382;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static class Node{
		int x;
		int y;
		int dir;
		int count;
		
		public Node(int x, int y, int dir, int count) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + ", count=" + count + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		boolean[][][] visited = new boolean[250][250][2];
		
		Queue<Node> del = new LinkedList<>();
		for(int t = 1; t <= test; t++) {
			String[] s = br.readLine().split(" ");
			Node st1 = new Node(Integer.parseInt(s[0]) + 110,Integer.parseInt(s[1]) + 110,0,0);
			Node st2 = new Node(Integer.parseInt(s[0]) + 110,Integer.parseInt(s[1]) + 110,1,0);
			Node end = new Node(Integer.parseInt(s[2]) + 110,Integer.parseInt(s[3]) + 110,0,0);
			
			Queue<Node> qu = new LinkedList<>();
			qu.add(st1);
			qu.add(st2);
			
			del.add(st1);
			del.add(st2);
			
			visited[st1.x][st1.y][0] = true;
			visited[st2.x][st2.y][1] = true;
			
			int ans = Integer.MAX_VALUE;
			
			while(!qu.isEmpty()) {
				Node n = qu.poll();
				
				int x = n.x;
				int y = n.y;
				int d = n.dir;
				int c = n.count;
				
				if(x <= 0 || x >= 249 || y <= 0 || y >= 249) {
					continue;
				}
				
				if(x == end.x && y == end.y) {
					if(ans > c) {
						ans = c;
					}
					
					continue;
				}
				
				if(d == 0) {
					if(!visited[x-1][y][0]) {
						visited[x-1][y][0] = true;
						qu.add(new Node(x-1,y,1,c+1));
						del.add(new Node(x-1,y,1,c+1));
					}
					if(!visited[x+1][y][0]) {
						visited[x+1][y][0] = true;
						qu.add(new Node(x+1,y,1,c+1));
						del.add(new Node(x+1,y,1,c+1));
					}
				}
				else {
					if(!visited[x][y-1][1]) {
						visited[x][y-1][1] = true;
						qu.add(new Node(x,y-1,0,c+1));
						del.add(new Node(x,y-1,0,c+1));
					}
					if(!visited[x][y+1][1]) {
						visited[x][y+1][1] = true;
						qu.add(new Node(x,y+1,0,c+1));
						del.add(new Node(x,y+1,0,c+1));
					}
				}
			}
			
			bw.write("#"+t+" "+ans+"\n");
			
			while(!del.isEmpty()) {
				Node n = del.poll();
				
				int x = n.x;
				int y = n.y;
				int d = n.dir;
				
				visited[x][y][d] = false;
			}
		}
		bw.flush();
	}

}
