package 금속막대_1259;

import java.util.Deque;
import java.util.LinkedList;
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
			LinkedList<Screw> ar = new LinkedList<Screw>();
			Deque<Screw> dq = new LinkedList<Screw>();
			for (int j = 0; j < num; j++) {
				int a = sc.nextInt();
				int x = sc.nextInt();
				ar.add(new Screw(a, x));
			}
			dq.add(ar.get(0));
			ar.remove(0);
			while(ar.size() > 0) {
				for(int z = 0; z < ar.size()+1; z++) {
					if(dq.peekFirst().front == ar.get(z).back) {
						dq.addFirst(ar.get(z));
						ar.remove(z);
						break;
					}
					if(dq.peekLast().back == ar.get(z).front) {
						dq.addLast(ar.get(z));
						ar.remove(z);
						break;
					}
				}
			}
			System.out.printf("#%d ", i);
			int size = dq.size();
			for (int j = 0; j < size; j++) {
				System.out.print(dq.poll().toString() + " ");
			}
			System.out.println();
		}
	}
}
