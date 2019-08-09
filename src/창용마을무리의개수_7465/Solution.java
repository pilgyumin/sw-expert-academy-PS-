package 창용마을무리의개수_7465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	private static int[] parent;
	private static boolean[] count;
	private static int n;
	
	private static void init() {
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y) {
		if(x < y) {
			parent[find(y)] = find(x);
		}
		else if(x > y) {
			parent[find(x)] = find(y);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			parent = new int[n+1];
			count = new boolean[n+1];
			init();
			for(int i = 0; i < m; i++) {
				String[] s = br.readLine().split(" ");
				union(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			}
			int ans = 0;
			for(int i = 1; i <= n; i++) {
				int num = find(i);
				if(count[num]) {
					continue;
				}
				else {
					ans++;
					count[num] = true;
				}
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
