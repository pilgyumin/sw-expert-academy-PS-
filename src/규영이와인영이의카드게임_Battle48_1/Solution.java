package 규영이와인영이의카드게임_Battle48_1;

import java.util.Scanner;

public class Solution {
	
	private static int[] gyu;
	private static int[] in;
	private static int gWin;
	private static int iWin;
	
	private static void fight(int num, int count, int g, int is) {
	
		if(count == 9) {
			if(g > is) {
				gWin++;
			}
			else if(g < is) {
				iWin++;
			}
			return ;
		}
		
		for(int i = 0; i < 9; i++) {
			if((num & (1 << i)) == 0) {
				if(gyu[count] > in[i]) {
					fight((num | (1 << i)),count+1,g+gyu[count]+in[i],is);
				}
				else {
					fight((num | (1 << i)),count+1,g,is+gyu[count]+in[i]);
				}
			}
		}
		
		return ;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 1; i <= test; i++) {
			gyu = new int[9];
			in = new int[9];
			gWin = 0;
			iWin = 0;
			boolean[] card = new boolean[19];
			card[0] = true;
			for(int j = 0; j < 9; j++) {
				int n = sc.nextInt();
				card[n] = true;
				gyu[j] = n;
			}
			int a = 0;
			for(int j = 0; j < 19; j++) {
				if(!card[j]) {
					in[a++] = j;
				}
			}
			fight(0,0,0,0);
			System.out.printf("#%d %d %d\n",i,gWin,iWin);
		}
	}
}
