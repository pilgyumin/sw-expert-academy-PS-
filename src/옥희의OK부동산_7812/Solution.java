package ¿ÁÈñÀÇOKºÎµ¿»ê_7812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	private static int[] ar;
	private static int m;
	private static int minus;
	
	private static boolean binarySearch(int start, int end) {
		
		if(start > end) {
			return false;
		}
		
		boolean find = false;
		
		int mid = (start + end) / 2;
		
		if(ar[mid]-minus > m) {
			find = binarySearch(start, mid-1);
		}
		
		else if(ar[mid]-minus < m) {
			find = binarySearch(mid+1, end);
		}
		
		else {
			find = true;
		}
		
		return find;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			String[] nm = br.readLine().split(" ");
			
			int n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			ar = new int[n+1];
			
			String[] s = br.readLine().split(" ");
			
			int add = 0;
			for(int i = 1; i <= n; i++) {
				add += Integer.parseInt(s[i-1]);
				ar[i] = add;
			}
			
			int ans = 0;
			for(int i = 1; i <= n; i++) {
				minus = ar[i-1];
				if(binarySearch(i, ar.length-1)) {
					ans++;
				}
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
