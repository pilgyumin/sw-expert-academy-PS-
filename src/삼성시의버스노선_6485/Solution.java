package 삼성시의버스노선_6485;

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
			for(int i = 1; i <= test; i++) {
				int n = Integer.parseInt(br.readLine());
				int[] ar = new int[5001];
				for(int j = 0; j < n; j++) {
					String[] ab = br.readLine().split(" ");
					int a = Integer.parseInt(ab[0]);
					int b = Integer.parseInt(ab[1]);
					for(int k = a; k <= b; k++) {
						ar[k]++;
					}
				}
				int p = Integer.parseInt(br.readLine());
				int[] ans = new int[p];
				int sum = 0;
				for(int j = 0; j < p; j++) {
					ans[j] = ar[Integer.parseInt(br.readLine())];
				}
				String an = "#"+i;
				for(int j = 0; j < p; j++) {
					an += " " + ans[j];
				}
				an += "\n";
				bw.write(an);
				bw.flush();
			}
			br.close();
			bw.close();
		} catch (NumberFormatException | IOException e) {}
	}
}
