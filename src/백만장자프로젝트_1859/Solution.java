package 백만장자프로젝트_1859;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
			int test = sc.nextInt();
			for(int i = 1; i <= test; i++) {
				int num = sc.nextInt();
				ArrayList<Integer> ar = new ArrayList<Integer>();
				for(int j = 0; j < num; j++) {
					ar.add(sc.nextInt());
				}
				BigInteger sum = new BigInteger("0");
				int cal = ar.get(num-1);
				for(int j = num - 1; j >= 0; j--) {
					if(cal > ar.get(j)) {
						sum = sum.add(new BigInteger(String.valueOf(cal)).subtract(new 
								BigInteger(String.valueOf(ar.get(j)))));
					}
					else if(cal < ar.get(j)) {
						cal = ar.get(j);
					}
				} 
				System.out.printf("#%d ",i);
				System.out.println(sum.toString());
			}		
	}
}