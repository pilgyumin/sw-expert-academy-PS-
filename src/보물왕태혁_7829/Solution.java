package º¸¹°¿ÕÅÂÇõ_7829;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			int num = Integer.parseInt(br.readLine());
			int[] ar = new int[num];
			String[] s = br.readLine().split(" ");
			
			for(int i = 0; i < num; i++) {
				ar[i] = Integer.parseInt(s[i]);
			}
			
			Arrays.sort(ar);
			
			int ans = 0;
			int n = num / 2;
			
			if(num % 2 == 0) {
				ans = ar[n] * ar[n-1];
			}
			else {
				ans = ar[n] * ar[n];
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
}
