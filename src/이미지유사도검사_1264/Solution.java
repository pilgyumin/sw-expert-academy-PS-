package 이미지유사도검사_1264;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	static int[] ar;
	static int[] parent;
	static int[] idx;
	static int[] list;
	static ArrayList<Integer> ans;
	
	private static int lowerbound(int s, int e, int n) {
		int start = s, end = e, num = n, mid;
		while(start <= end) {
			mid = (start + end) / 2;
			if(list[mid] >= num) {
				end = mid - 1;
				
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	private static int arr(int i) {
		if(parent[i] < 0) {
			return ar[idx[i]];
		}
		int x = arr(parent[i]);
		ans.add(ar[x]);
		return ar[idx[i]];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ar = new int[num];
		parent = new int[num];
		idx = new int[num];
		list = new int[num];
		ans = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			ar[i] = sc.nextInt();
		}
		Arrays.fill(parent, -1);
		
		list[0] = ar[0];
		idx[0] = 0;
		int size = 1;
		
		for(int i = 1; i < num; i++) {
			if(ar[i] >= list[size-1]) {
				list[size] = ar[i];
				parent[i] = idx[size-1];
				idx[size] = i;
				size++;
			}
			else {
				int id = lowerbound(0,size-1,ar[i]);
				list[id] = ar[i];
				idx[id] = i;
				if(id > 0) {
					parent[i] = idx[id-1];
				}
			}
		}
		int x = idx[size-1];
		while(x != -1) {
			ans.add(ar[x]);
			x = parent[x];
		}

		Collections.sort(ans);
		for(int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

}
