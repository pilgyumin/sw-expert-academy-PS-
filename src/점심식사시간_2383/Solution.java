package 점심식사시간_2383;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	static class People{
		int x;
		int y;
		
		public People(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "People [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	private static int[][] map;
	private static int s1x;
	private static int s1y;
	private static int s2x;
	private static int s2y;

	private static ArrayList<Integer> sta1;
	private static ArrayList<Integer> sta2;
	private static ArrayList<People> people;
	private static int ans;
	private static int num;
	
	private static void permutation(int cnt, int n) {
		int num = n;
		
		if(cnt == people.size()) {
			findStair(num);
			return ;
		}
		
		for(int i = 0; i < 2; i++) {
			num |= (i << cnt);
			permutation(cnt+1,num);
		}
		
	}
	
	private static void findStair(int stair) {
		int idx = 0;

		sta1 = new ArrayList<Integer>();
		sta2 = new ArrayList<Integer>();
		
		for(int i = 0; i < people.size(); i++) {
			if((stair & (1 << i)) != 0) {
				int d2 = Math.abs(people.get(i).x - s2x) + Math.abs(people.get(i).y - s2y);
				sta2.add(d2+map[s2x][s2y]+1);
			}
			else {
				int d1 = Math.abs(people.get(i).x - s1x) + Math.abs(people.get(i).y - s1y);
				sta1.add(d1+map[s1x][s1y]+1);
			}
		}
		if(sta1.size() > 0) {
			Collections.sort(sta1);
		}
		if(sta2.size() > 0) {
			Collections.sort(sta2);
		}
		
		for(int i = 0; i < sta1.size(); i++) {
			if(i < 3) {
				continue;
			}
			else {
				int div = i / 3;
				int c = sta1.get(i) - map[s1x][s1y];
				int cc = sta1.get(i-3);
				int ins = 0;
				if(cc > c) {
					ins = cc + map[s1x][s1y];
				}
				else {
					ins = sta1.get(i);
				}
				sta1.set(i, ins);
			}
		}
		
		for(int i = 0; i < sta2.size(); i++) {
			if(i < 3) {
				continue;
			}
			else {
				int div = i / 3;
				int c = sta2.get(i) - map[s2x][s2y];
				int cc = sta2.get(i-3);
				int ins = 0;
				if(cc > c) {
					ins = cc + map[s2x][s2y];
				}
				else {
					ins = sta2.get(i);
				}
				sta2.set(i, ins);
			}
		}
		
		int max = 0;
		for(int i = 0; i < sta1.size(); i++) {
			if(max < sta1.get(i)) {
				max = sta1.get(i);
			}
		}
		
		for(int i = 0; i < sta2.size(); i++) {
			if(max < sta2.get(i)) {
				max = sta2.get(i);
			}
		}
		
		if(ans > max) {
			ans = max;
		}

	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			num = Integer.parseInt(br.readLine());
			map = new int[num][num];
			people = new ArrayList<>();
			boolean s2 = false;
			ans = 2000000000;
			s1x = 0;
			s1y = 0;
			s2x = 0;
			s2y = 0;
			for(int i = 0; i < num ; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < num; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					if(map[i][j] > 1) {
						if(!s2) {
							s1x = i;
							s1y = j;
							s2 = true;
						}
						else {
							s2x = i;
							s2y = j;
						}
					}
					else if(map[i][j] == 1) {
						people.add(new People(i,j));
					}
				}
			}
			permutation(0,0);
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}

}
