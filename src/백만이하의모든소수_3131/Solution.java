package 백만이하의모든소수_3131;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] ar = new boolean[1000001];
		ar[0] = true;
		ar[1] = true;
		for(int i = 0; i < 1000; i++) {
			if(!ar[i]) {
				for(int j = 2; j <= 1000000 / i; j++) {
					ar[i * j] = true;
				}
			}
		}
		for(int i  = 0; i < ar.length; i++) {
			if(!ar[i]) {
				try {
					bw.write(i + " ");
					bw.flush();
				} catch (IOException e) {
				}
			}
		}
	}
}
