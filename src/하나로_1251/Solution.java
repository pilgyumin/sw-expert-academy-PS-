package ÇÏ³ª·Î_1251;

import java.util.Arrays;

import java.util.Scanner;

public class Solution {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++) {
			int n = sc.nextInt();
			int[] cal = new int[n * (n-1) / 2];
			Node[] ar = new Node[n];
			for(int j = 0; j < n; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				Node no = new Node(x,y);
				ar[j] = no;
			}
			double e = sc.nextDouble();
			int index = 0;
			for(int j = 0; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					cal[index++] = (ar[j].x - ar[k].x) + (ar[j].y - ar[k].y);
				}
			}
			for(int z = 0; z < cal.length;z++) {
				System.out.println(cal[z]);
			}
			Arrays.sort(cal);
			int sum = 0;
			for(int j = 0; j < n-1; j++) {
				System.out.println(cal[j]);
				sum += cal[j] * cal[j];
			}
			System.out.printf("#%d %d\n",i,(int)(sum*e));
		}

	}

}
