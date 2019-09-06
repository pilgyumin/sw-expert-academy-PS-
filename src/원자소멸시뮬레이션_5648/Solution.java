package 원자소멸시뮬레이션_5648;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Atom {
		int x;
		int y;
		int dir;
		int energy;

		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}

		@Override
		public String toString() {
			return "Atom [x=" + x + ", y=" + y + ", dir=" + dir + ", energy=" + energy + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(br.readLine());

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		int[][] visited = new int[4001][4001];
		
		for (int t = 1; t <= test; t++) {
			int n = Integer.parseInt(br.readLine());
			Queue<Atom> move = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int ax = (Integer.parseInt(s[0]) * 2) + 2000 ;
				int ay = (Integer.parseInt(s[1]) * 2) + 2000 ;
				int ad = Integer.parseInt(s[2]);
				int ae = Integer.parseInt(s[3]);
				move.add(new Atom(ax, ay, ad, ae));
			}

			int ans = 0;

			Queue<Atom> cal = new LinkedList<>();

			for (int i = 0; i <= 2001; i++) {
				int size = move.size();
				Queue<Atom> dd = new LinkedList<>();
				for (int j = 0; j < size; j++) {
					Atom at = move.poll();

					int x = at.x;
					int y = at.y;
					int d = at.dir;
					int e = at.energy;
					
					if(x + dx[d] > 4000 || x + dx[d] < 0 || y + dy[d] > 4000 || y+dy[d] < 0) {
						continue;
					}
					
					visited[x][y] = 0;
					
					if(e > 0) {
						visited[x+dx[d]][y+dy[d]]++;
					}
					
					cal.add(new Atom(x + dx[d], y + dy[d], d, e));
					
				}
			
				
				while (!cal.isEmpty()) {
					Atom at2 = cal.poll();

					int x = at2.x;
					int y = at2.y;
					int d = at2.dir;
					int e = at2.energy;

					if (visited[x][y] > 1) {
						ans += e;
					}
					
					else {
						move.add(at2);	
					}
					
					dd.add(at2);
				}
				
				while (!dd.isEmpty()) {
					Atom at2 = dd.poll();

					int x = at2.x;
					int y = at2.y;
					int d = at2.dir;
					int e = at2.energy;

					visited[x][y] = 0;
				}

			}
			
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
	}

}
