package 반장선출_7792;

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
		for(int t = 1; t <= test; t++) {
			int num = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			int max = 0;
			int len = 0;
			for(int i = 0; i < num; i++) {
				boolean[] already = new boolean[26];
				String iinput = br.readLine();
				
				String[] input = iinput.split(" ");
				StringBuilder sbb = new StringBuilder();
				for(int j = 0; j < input.length; j++) {
					sbb.append(input[j]);
				}
			
				String s = sbb.toString();
				int count = 0;
				for(int j = 0; j < s.length(); j++) {
					int n = s.charAt(j)-65;
					if(!already[n]) {
						already[s.charAt(j)-65] = true;
						count++;
					}					
				} 
				if(count >= max) {
					if(max == 0) {
						max = count;
						len = s.length();
						sb.append(iinput);
					}
					else {
						if(count > max) {
							sb = new StringBuilder(iinput);
							len = iinput.length();
							max = count;
						}
						else {
							int flen = len;
							int blen = s.length();
							int ffirst = 0;
							int llen = 0;
							if(flen < blen) {
								ffirst = 1;
								llen = flen;
							}
							else {
								ffirst = 2;
								llen = blen;
							}
							String[] sss = sb.toString().split(" ");
							StringBuilder sbbs = new StringBuilder();
							
							for(int j = 0; j < sss.length; j++) {
								sbbs.append(sss[j]);
							}
							
							for(int k = 0; k < llen; k++) {
								if(sbbs.charAt(k) < s.charAt(k)) {
									ffirst = 1;
									break;
								}
								else if(sbbs.charAt(k) > s.charAt(k)) {
									ffirst = 2;
									break;
								}
							}
							if(ffirst == 2) {
								sb = new StringBuilder(iinput);
							}	
						}
						
					}
				
				}
			}
			bw.write("#"+t+" "+sb.toString()+"\n");
		}
		bw.flush();
	}
}
