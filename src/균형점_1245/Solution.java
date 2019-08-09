package 균형점_1245;

import java.math.BigDecimal;
import java.util.Scanner;

public class Solution {

	private static BigDecimal[] pos;
	private static int[] weight;
	private static BigDecimal[] ans;
	private static int index = 0;
	private static BigDecimal x;
	private static BigDecimal y;

	public static void cal(BigDecimal x1, BigDecimal y1, int j) {
		BigDecimal xx = x1;
		BigDecimal yy = y1;
		boolean check = false;
		BigDecimal mmid = new BigDecimal(0);
		
		while (!check) {
			BigDecimal mid = yy.add(xx).divide(new BigDecimal(2)).setScale(13, BigDecimal.ROUND_DOWN);
			BigDecimal d1 = ((y.subtract(mid)).multiply((y.subtract(mid)).multiply(new BigDecimal(weight[j - 1]))))
					.setScale(13, BigDecimal.ROUND_DOWN);
			BigDecimal d2 = (mid.subtract(x).multiply(mid.subtract(x)).multiply(new BigDecimal(weight[j]))).setScale(13,
					BigDecimal.ROUND_DOWN);
			if (d1.setScale(10, BigDecimal.ROUND_DOWN).compareTo(d2.setScale(10, BigDecimal.ROUND_DOWN)) == 0) {
				check = true;
				mmid = mid;
			} 
			else if (d1.compareTo(d2) == -1) {
				yy = mid;
			} 
			else if (d1.compareTo(d2) == 1) {
				xx = mid;
			}
		}
		ans[index] = mmid.setScale(10, BigDecimal.ROUND_DOWN);
        index++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 1; i <= test; i++) {
			int num = sc.nextInt();
			pos = new BigDecimal[num];
			weight = new int[num];
			ans = new BigDecimal[num - 1];
			for (int j = 0; j < num; j++) {
				pos[j] = new BigDecimal(sc.nextInt());
			}
			for (int j = 0; j < num; j++) {
				weight[j] = sc.nextInt();
			}
			for (int j = 1; j < num; j++) {
				x = pos[j - 1];
				y = pos[j];
				cal(pos[j - 1], pos[j], j);
			}
			System.out.printf("#%d ", i);
			for (int j = 0; j < ans.length; j++) {
				System.out.print(ans[j].toString() + " ");
			}
			System.out.println();
			index = 0;
		}
	}
}
