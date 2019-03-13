package PuyoPuyo_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static class Puyo {
		int x;
		int y;

		public Puyo(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Puyo [x=" + x + ", y=" + y + "]";
		}

	}

	private static int[][] map;
	private static boolean[][] visited;
	private static boolean[][] copy;
	private static Deque<Puyo> dq;
	private static int ans;
	private static boolean remove;

	private static void find(int x, int y) {
		Deque<Puyo> same = new ArrayDeque<>();
		same.add(new Puyo(x, y));
		dq.add(new Puyo(x, y));
		visited[x][y] = false;
		int comp = map[x][y];

		while (!same.isEmpty()) {
			Puyo p = same.poll();
			if (visited[p.x + 1][p.y] && map[p.x + 1][p.y] == comp) {
				visited[p.x + 1][p.y] = false;
				same.add(new Puyo(p.x + 1, p.y));
				dq.add(new Puyo(p.x + 1, p.y));
			}
			if (visited[p.x - 1][p.y] && map[p.x - 1][p.y] == comp) {
				visited[p.x - 1][p.y] = false;
				same.add(new Puyo(p.x - 1, p.y));
				dq.add(new Puyo(p.x - 1, p.y));
			}
			if (visited[p.x][p.y + 1] && map[p.x][p.y + 1] == comp) {
				visited[p.x][p.y + 1] = false;
				same.add(new Puyo(p.x, p.y + 1));
				dq.add(new Puyo(p.x, p.y + 1));
			}
			if (visited[p.x][p.y - 1] && map[p.x][p.y - 1] == comp) {
				visited[p.x][p.y - 1] = false;
				same.add(new Puyo(p.x, p.y - 1));
				dq.add(new Puyo(p.x, p.y - 1));
			}
		}

		if (dq.size() >= 4) {
			int size = dq.size();
			remove = true;
			for (int i = 0; i < size; i++) {
				Puyo p = dq.poll();
				map[p.x][p.y] = 0;
			}
		} else {
			dq.clear();
		}

	}

	private static void below(int x, int y, int v) {

		if (map[x + 1][y] != 0) {
			map[x][y] = v;
			return;
		}

		below(x + 1, y, v);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[14][8];
		visited = new boolean[14][8];
		copy = new boolean[14][8];
		dq = new ArrayDeque<>();
		ans = 0;
		remove = true;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = -1;
			}
		}
		for (int i = 1; i <= 12; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= 6; j++) {
				switch (s[j - 1]) {
				case ".":
					map[i][j] = 0;
					break;
				case "R":
					map[i][j] = 1;
					copy[i][j] = true;
					break;
				case "G":
					map[i][j] = 2;
					copy[i][j] = true;
					break;
				case "B":
					map[i][j] = 3;
					copy[i][j] = true;
					break;
				case "P":
					map[i][j] = 4;
					copy[i][j] = true;
					break;
				case "Y":
					map[i][j] = 5;
					copy[i][j] = true;
					break;
				}
			}
		}
		
		while (remove) {
			remove = false;
			for (int i = 1; i <= 12; i++) {
				for (int j = 1; j <= 6; j++) {
					visited[i][j] = copy[i][j];
				}
			}
			
			for (int i = 11; i >= 0; i--) {
				for (int j = 1; j <= 6; j++) {
					if (visited[i][j] && map[i][j] != 0) {
						find(i, j);
					}
				}
			}
			if (remove) {
				for (int j = 1; j <= 6; j++) {
					for (int i = 11; i >= 1; i--) {
						if (map[i][j] != 0) {
							if (map[i + 1][j] == 0) {
								below(i, j, map[i][j]);
								map[i][j] = 0;
							}
						}
					}
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
}
