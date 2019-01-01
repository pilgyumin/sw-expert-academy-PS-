package 희성이의원근법_6718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				int d = Integer.parseInt(br.readLine());
				if(d < 100) {
					System.out.printf("#%d %d\n",i,0);
				}
				else if(d< 1000) {
					System.out.printf("#%d %d\n",i,1);
				}
				else if(d< 10000) {
					System.out.printf("#%d %d\n",i,2);
				}
				else if(d< 100000) {
					System.out.printf("#%d %d\n",i,3);
				}
				else if(d< 1000000) {
					System.out.printf("#%d %d\n",i,4);
				}
				else {
					System.out.printf("#%d %d\n",i,5);
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
