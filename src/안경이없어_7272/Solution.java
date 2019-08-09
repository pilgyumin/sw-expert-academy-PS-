package 안경이없어_7272;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		int[] comp = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
		for(int t = 1; t <= test; t++) {
			String[] s = br.readLine().split(" ");
			StringBuilder sb1 = new StringBuilder(s[0]);
			StringBuilder sb2 = new StringBuilder(s[1]);
			int l1 = sb1.length();
			int l2 = sb2.length();
			if(l1 != l2) {
				bw.write("#"+t+" DIFF\n");
			}
			else {
				boolean same = true;
				for(int i = 0; i < l1; i++) {
					if(comp[sb1.charAt(i) - 65] != comp[sb2.charAt(i) - 65]) {
						same = false;
						break;
					}
				}
				if(same) {
					bw.write("#"+t+" SAME\n");
				}
				else {
					bw.write("#"+t+" DIFF\n");
				}
			}
		}
		bw.flush();
	}
}
