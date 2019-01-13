package 최대부분배열_3819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private static int[] ar;
	private static int[] tree;
	
	private static int init(int i, int j, int node) {
		int start = i, end = j, mid;
		if(start == end) {
			return tree[node] = ar[start];
		}
		mid = (start + end) / 2;
		return tree[node] = init(start,mid,node * 2) + init(mid+1,end,node * 2 + 1);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				int n = Integer.parseInt(br.readLine());
				ar = new int[n];
				tree = new int[4 * n];
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					ar[j] = Integer.parseInt(s[j]);
				}
				init(0,ar.length-1,1);
				int ans = 0;
				for(int j = 0; j < tree.length; j++) {
					if(tree[j] > ans) {
						ans = tree[j];
					}
				}
				System.out.printf("#%d %d\n",i,ans);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
		}
	}
}
