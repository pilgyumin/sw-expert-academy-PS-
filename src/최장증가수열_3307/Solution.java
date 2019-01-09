package 최장증가수열_3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	
	private static ArrayList<Integer> list;
	
	private static int lowerbound(int s, int e, int k) {
		int start = s, end = e, mid;
		while(start <= end) {
			mid = (start + end) / 2;
			if(list.get(mid) > k) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				int num = Integer.parseInt(br.readLine());
				int[] ar = new int[num];
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < num; j++) {
					ar[j] = Integer.parseInt(s[j]);
				}
				list = new ArrayList<Integer>();
				list.add(ar[0]); 
				for(int j = 1; j < num; j++) {
					if(list.get(list.size()-1) < ar[j]) {
						list.add(ar[j]);
					}
					else {
						int idx = lowerbound(0,list.size()-1,ar[j]);
						list.add(idx, ar[j]);
						list.remove(idx+1);
					}
				}
				System.out.printf("#%d %d\n",i,list.size());
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
