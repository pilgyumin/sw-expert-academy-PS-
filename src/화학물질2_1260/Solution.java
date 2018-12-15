package 화학물질2_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	static class Node implements Comparable<Node> {
		int w;
		int h;
		int area;

		public Node(int w, int h) {
			this.w = w;
			this.h = h;
			this.area = w * h;
		}

		@Override
		public String toString() {
			return w + " " + h;
		}

		@Override
		public int compareTo(Node o) {
			if (this.area < o.area) {
				return -1;
			} else if (this.area > o.area) {
				return 1;
			} else if (this.area == o.area) {
				if (this.w < o.w) {
					return -1;
				} else if (this.w > o.w) {
					return 1;
				}
			}
			return 0;
		}

	}

	private static int[][] map;
	private static boolean[][] visited;
	private static int wid;
	private static int hei;
	private static LinkedList<Node> ar;
	private static int n;

	public static int findright(int x, int y) {
		if (map[x][y] == 0) {
			return 0;
		}

		if (y <= n - 2 && map[x][y + 1] != 0) {
			hei++;
			findright(x, y + 1);
		}

		return 0;
	}

	public static int finddown(int x, int y) {

		if (map[x][y] == 0) {
			return 0;
		}
		if (x <= n - 2 && map[x + 1][y] != 0) {
			wid++;
			finddown(x + 1, y);
		}

		return 0;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for (int i = 1; i <= test; i++) {
				n = Integer.parseInt(br.readLine());
				map = new int[n][n];
				visited = new boolean[n][n];
				ar = new LinkedList<Node>();
				Deque<Node> dq = new LinkedList<Node>();
				for (int j = 0; j < n; j++) {
					String[] s = br.readLine().split(" ");
					for (int k = 0; k < n; k++) {
						map[j][k] = Integer.parseInt(s[k]);
					}
				}

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (map[j][k] != 0 && !visited[j][k]) {
							wid = 1;
							hei = 1;
							findright(j, k);
							finddown(j, k);
							ar.add(new Node(wid, hei));
							for (int m = j; m < j + wid; m++) {
								for (int n = k; n < k + hei; n++) {
									visited[m][n] = true;
								}
							}
						}
					}
				}
				Collections.sort(ar);
				dq.add(ar.get(0));
				ar.remove(0);
				while (ar.size() > 0) {
					for (int z = 0; z < ar.size() + 1; z++) {
						if (dq.peekFirst().w == ar.get(z).h) {
							dq.addFirst(ar.get(z));
							ar.remove(z);
							break;
						}
						if (dq.peekLast().h == ar.get(z).w) {
							dq.addLast(ar.get(z));
							ar.remove(z);
							break;
						}
					}
				}
				int size = dq.size();
				for (int j = 0; j < size; j++) {

					ar.add(dq.poll());
				}
				for (int j = 0; j < size; j++) {
					System.out.println(ar.get(j));
				}
				int sum = 0;
				while (ar.size() > 1) {
					int sizear = ar.size();
					int min = Integer.MAX_VALUE;
					int index = -1;
					for (int k = 0; k < sizear - 1; k++) {
						if (min > ar.get(k).w * ar.get(k).h * ar.get(k + 1).h) {
							min = ar.get(k).w * ar.get(k).h * ar.get(k + 1).h;
							index = k;
						}
					}
					sum += min;
					Node no = new Node(ar.get(index).w, ar.get(index + 1).h);
					ar.add(index, no);
					ar.remove(index + 1);
					ar.remove(index + 1);
				}
				System.out.println(ar.size());

				System.out.printf("#%d %d\n", i, sum);
				// for(int j = 0; j < ar.size(); j++) {
				// System.out.print(ar.get(j) + " ");
				// }
				// System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
