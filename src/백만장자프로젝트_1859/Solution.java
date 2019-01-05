package 백만장자프로젝트_1859;

import java.math.BigInteger;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.LinkedList;
=======
import java.util.Scanner;
>>>>>>> branch 'master' of https://github.com/pilgyumin/sw-expert-academy-PS-.git

public class Solution {
<<<<<<< HEAD
	
	static ArrayList<Integer> ar;
	static BigInteger sum;
=======

>>>>>>> branch 'master' of https://github.com/pilgyumin/sw-expert-academy-PS-.git
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
			int test = sc.nextInt();
			for(int i = 1; i <= test; i++) {
<<<<<<< HEAD
				int num = Integer.parseInt(br.readLine());
				ar = new ArrayList<Integer>();
				String[] s  = br.readLine().split(" ");
=======
				int num = sc.nextInt();
				ArrayList<Integer> ar = new ArrayList<Integer>();
>>>>>>> branch 'master' of https://github.com/pilgyumin/sw-expert-academy-PS-.git
				for(int j = 0; j < num; j++) {
<<<<<<< HEAD
					ar.add(Integer.parseInt(s[j]));
=======
					ar.add(sc.nextInt());
>>>>>>> branch 'master' of https://github.com/pilgyumin/sw-expert-academy-PS-.git
				}
<<<<<<< HEAD
				sum = new BigInteger("0");
=======
				BigInteger sum = new BigInteger("0");
>>>>>>> branch 'master' of https://github.com/pilgyumin/sw-expert-academy-PS-.git
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