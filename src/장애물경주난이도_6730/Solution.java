package 장애물경주난이도_6730;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int test = Integer.parseInt(br.readLine());
			for (int i = 1; i <= test; i++) {
				int n = Integer.parseInt(br.readLine());
				String[] s = br.readLine().split(" ");
				int up = 0;
				int down = 0;
				int a = Integer.parseInt(s[0]);
				for (int j = 1; j < n; j++) {
					int b = Integer.parseInt(s[j]);
					int c = a-b;
					if (down < c) {
						down = c;
					}
					else if (up < -c) {
						up = -c;
					}
					a = b;
				}
				bw.write("#"+ i + " " + up + " " + down + "\n");
				bw.flush();
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
