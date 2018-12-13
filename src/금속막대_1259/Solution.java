package 금속막대_1259;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static class Screw {
		int front;
		int back;

		public Screw(int front, int back) {
			this.front = front;
			this.back = back;
		}

		@Override
		public String toString() {
			return front + " " + back;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 1; i <= test; i++) {
			int num = sc.nextInt();
			int f = 0;
			int b = 0;
			ArrayList<Screw> ar = new ArrayList<Screw>();
			ArrayList<Screw> arr = new ArrayList<Screw>();
			for (int j = 0; j < num; j++) {
				int a = sc.nextInt();
				int x = sc.nextInt();
				ar.add(new Screw(a, x));
				if (a > f) {
					f = a;
				}
				if (x > b) {
					b = x;
				}
			}
			int[] countf = new int[f + 1];
			int[] countb = new int[b + 1];
			for (int j = 0; j < num; j++) {
				countf[ar.get(j).front]++;
				countb[ar.get(j).back]++;
			}
			boolean check = false;
			if (countf.length > countb.length) {
				for (int j = 0; j < countb.length; j++) {
					if (countf[j] == countb[j]) {
						int size = ar.size();
						if (!check) {
							for (int z = 0; z < ar.size(); z++) {
								if (ar.get(z).back == j) {
									arr.add(ar.get(z));
									ar.remove(z);
									check = true;
								}
							}
						} 
						if(check) {
							for (int z = 0; z < ar.size(); z++) {
								if (ar.get(z).front == j) {
									arr.add(ar.get(z));
									ar.remove(z);
								}
							}
						}

					}
				}
			} 
			else {
				for (int j = 0; j < countf.length; j++) {
					if (countf[j] == countb[j]) {
						int size = ar.size();
						if (!check) {
							for (int z = 0; z < ar.size(); z++) {
								if (ar.get(z).back == j) {
									arr.add(ar.get(z));
									ar.remove(z);
									check = true;
								}
							}
						} 
						if(check) {
							for (int z = 0; z < ar.size(); z++) {
								if (ar.get(z).front == j) {
									arr.add(ar.get(z));
									ar.remove(z);
								}
							}
						}

					}
				}
			}
			System.out.printf("#%d ", i);
			for (int j = 0; j < arr.size(); j++) {
				System.out.print(arr.get(j).toString() + " ");
			}
			System.out.println();
		}
	}
}
