package ÇÏ³ª·Î_1251;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int p;
		int s;
		BigDecimal dist;
		
		public Node(int p, int s, BigDecimal dist) {
			this.p = p;
			this.s = s;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "Node [p=" + p + ", s=" + s + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Node n) {
			if(this.dist.compareTo(n.dist) == -1 ) {
				return -1;
			}
			else if(this.dist.compareTo(n.dist) == 1 ) {
				return 1;
			}
			return 0;
		}
	}
	
	public static void makeset(int a) {
		connect[a] = a;
	}
	
	public static int findset(int s) {
		if(connect[s] == s) {
			return s;
		}
		return findset(connect[s]);
	}
	
	public static void unionset(int p, int s) {
		connect[findset(s)] = connect[p];
	}

	private static int[] connect;
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++) {
			int n = sc.nextInt();
			Node[] ar = new Node[n * (n-1) / 2];
			int[] xar = new int[n];
			int[] yar = new int[n];
			connect = new int[n];
			for(int j = 0; j < n; j++) {
				xar[j] = sc.nextInt();
				makeset(j);
			}
			for(int j = 0; j < n; j++) {
				yar[j] = sc.nextInt();
			}
			String e = sc.next();
			int index = 0;
			for(int j = 0; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					BigDecimal b1 = new BigDecimal(String.valueOf(Math.abs(xar[j] - xar[k])));
					BigDecimal b2 = new BigDecimal(String.valueOf(Math.abs(yar[j] - yar[k])));
					b1 = b1.multiply(b1);
					b2 = b2.multiply(b2);
					b1 = b1.add(b2);
					Node no = new Node(j,k,b1);
					ar[index++] = no;
					System.out.println(no.hashCode());
				}
			}
			Arrays.sort(ar);
			BigDecimal sum = new BigDecimal("0");
			int count = 0;
			for(int j = 0; j < n * (n-1) / 2; j++) {
				if(count == n - 1) {
					break;
				}
				if(findset(ar[j].p) == findset(ar[j].s)) {
					continue;
				}
				unionset(ar[j].p, ar[j].s);
				BigDecimal dis = new BigDecimal(String.valueOf(ar[j].dist));
				sum = sum.add(dis);
				count++;
			}
			sum = sum.multiply(new BigDecimal(e));
			System.out.printf("#%d ",i);
			System.out.println(sum.setScale(0, RoundingMode.HALF_UP));
		}
	}
}
