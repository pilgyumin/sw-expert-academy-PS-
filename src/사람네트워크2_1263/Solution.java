package 사람네트워크2_1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	private static int n;
	private static int map[][];

	private static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test;
		try {
			test = Integer.parseInt(br.readLine());
			for (int i = 1; i <= test; i++) {
				String s[] = br.readLine().split(" ");
				n = Integer.parseInt(s[0]);
				map = new int[n][n];
				int idx = 1;
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						map[j][k] = Integer.parseInt(s[idx]);
						if (map[j][k] == 0) {
							map[j][k] = 987654321;
						}
						idx++;
					}
				}

				floyd();
				PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

				for (int j = 0; j < n; j++) {
					int sum = 0;
					for (int k = 0; k < n; k++) {
						if(map[j][k] < 987654321) {
							sum += map[j][k];
						}
					}
					pq.add(sum);
				}

				System.out.printf("#%d %d\n", i, pq.poll());
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
