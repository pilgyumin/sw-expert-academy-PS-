package 보물상자비밀번호_5658;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			String[] nk = br.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			int div = n / 4;
			
			HashSet<Integer> hs = new HashSet<>();
			StringBuilder sb = new StringBuilder(br.readLine());
			
			for(int i = 0; i < div; i++) {
				String s1 = sb.substring(0, div);
				hs.add(Integer.parseInt(s1, 16));
				String s2 = sb.substring(div, div * 2);
				hs.add(Integer.parseInt(s2, 16));
				String s3 = sb.substring(div * 2, div * 3);
				hs.add(Integer.parseInt(s3, 16));
				String s4 = sb.substring(div * 3, n);
				hs.add(Integer.parseInt(s4, 16));
				
				String front = String.valueOf(sb.charAt(0));
				sb.deleteCharAt(0);
				sb.append(front);
			}
			
			ArrayList<Integer> ar = new ArrayList<>();
			
			Iterator<Integer> it = hs.iterator();
			while(it.hasNext()) {
				ar.add(it.next());
			}
			
			Collections.sort(ar,Collections.reverseOrder());

			bw.write("#"+t+" "+ar.get(k-1)+"\n");
		}
		bw.flush();
	}
}
