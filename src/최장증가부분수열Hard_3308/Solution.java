package 최장증가부분수열Hard_3308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
	
	private static BigInteger[] ar ;
	private static ArrayList<BigInteger> list;
	
	private static int lowerbound(int i, int j, BigInteger num) {
		int start = i, end = j, mid;
		while(start <= end) {
			mid = (start + end) / 2;
			if(list.get(mid).compareTo(num) == 1) {
				end = mid - 1;
			}
			else if(list.get(mid).compareTo(num) == -1){
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test;
		try {
			test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				int num = Integer.parseInt(br.readLine());
				String[] s = br.readLine().split(" ");
				ar = new BigInteger[num];
				list = new ArrayList<BigInteger>();
				for(int j = 0; j < num; j++) {
					ar[j] = new BigInteger(s[j]);
				}
				list.add(ar[0]);
				for(int j = 1; j < num; j++) {
					if(ar[j].compareTo(list.get(list.size()-1)) == 1) {
						list.add(ar[j]);
					}
					else if(ar[j].compareTo(list.get(list.size()-1)) == -1){
						int idx = lowerbound(0,list.size()-1,ar[j]);
						if(list.size() > 0) {
							list.add(idx, ar[j]);
							list.remove(idx + 1);
						}
					}
				}
				System.out.printf("#%d %d\n",i,list.size());
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
