package ªÔªÔ∆Æ∏Æ«√∞‘¿”_Codebattle47_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	static class Card implements Comparable<Card>{
		int num;
		int color;// 1 : R, 2 : G, 3 : B
		
		public Card(int num, int color) {
			this.num = num;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Card [num=" + num + ", color=" + color + "]";
		}

		@Override
		public int compareTo(Card o) {
			
			if(this.color < o.color) {
				return -1;
			}
			else if(this.color > o.color) {
				return 1;
			}
			else {
				if(this.num < o.num) {
					return -1;
				}
				else if(this.num > o.num){
					return 1;
				}
			}
			return 0;
		}
	}
	
	private static ArrayList<Card> ar;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				String[] n = br.readLine().split("");
				String[] c = br.readLine().split("");
				ar = new ArrayList<>();
				for(int j = 0; j < 9; j++) {
					switch(c[j]) {
					case "R":
						Card ca = new Card(Integer.parseInt(n[j]),1);
						ar.add(ca);
						break;
					case "G":
						Card ca1 = new Card(Integer.parseInt(n[j]),2);
						ar.add(ca1);
						break;
					case "B":
						Card ca2 = new Card(Integer.parseInt(n[j]),3);
						ar.add(ca2);
						break;
					}
					
				}
				
				Collections.sort(ar);
				for(int j = 0; j < 9; j++) {
					System.out.println(ar.get(j));
				}

				int count = 0;
				
				for(int j = 0; j < 9; j+=3) {
					if(ar.get(j).color == ar.get(j+1).color && ar.get(j+1).color == ar.get(j+2).color) {
						if(ar.get(j).num + 1 == ar.get(j+1).num && ar.get(j+1).num + 1 == ar.get(j+2).num) {
							count++;
						}
						else if(ar.get(j).num == ar.get(j+1).num && ar.get(j+1).num == ar.get(j+2).num) {
							count++;
						}
					}
				}
				if(count >= 3) {
					System.out.printf("#%d %s\n",i,"Win");
				}
				else {
					System.out.printf("#%d %s\n",i,"Continue");
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
