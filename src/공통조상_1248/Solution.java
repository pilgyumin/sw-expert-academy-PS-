package 공통조상_1248;

import java.util.Scanner;

public class Solution {
         
    private static int ans;
    private static int[] tree;
     
    public static void find(int n) {
        int count = 0;
        int n1 = 0;
        int n2 = 0;
        for(int a = 0; a < tree.length; a++) {
            if(tree[a] == n) {
                if(count == 0) {
                    n1 = a;
                }
                else if(count == 1) {
                    n2 = a;
                }
                count++;
                if(count == 2) {
                    break;
                }
            }
        }
        ans += count;
        if(count == 2) {
            find(n1);
            find(n2);
        }
        else if(count == 1) {
            find(n1);
        }
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int e = sc.nextInt();
            int v = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
             
            tree = new int[e+1];
            for(int j = 0; j < v; j++) {
                int z = sc.nextInt();
                int x = sc.nextInt();
                tree[x] = z;
            }
            String s1 = "";
            String s2 = "";
            for(int j = 0; j < 2; j++) {
                int com = 0;
                if(j == 0) {
                    com = a;
                }
                else {
                    com = b;
                }
                String s = "";
                while(com != 1) {
                    int k = tree[com];
                    s += k + " ";
                    com = k;
                }
                if(j == 0) {
                    s1 = s;
                }
                else {
                    s2 = s;
                }
            }
            String[] ss1 = s1.split(" ");
            String[] ss2 = s2.split(" ");
            int[] n1 = new int[ss1.length];
            int[] n2 = new int[ss2.length];
            for(int j = 0; j < ss1.length; j++) {
                n1[j] = Integer.parseInt(ss1[j]);
            }
            for(int j = 0; j < ss2.length; j++) {
                n2[j] = Integer.parseInt(ss2[j]);
            }
            String same = "";
            for(int j = 0; j < n1.length; j++) {
                for(int k = 0; k < n2.length; k++) {
                    if((n1[j] == n2[k])) {
                        same += n1[j] + " ";
                    }
                }
            }
            String[] ln = same.split(" ");
            find(Integer.parseInt(ln[0]));
            System.out.printf("#%d %d %d\n", i,Integer.parseInt(ln[0]), ans + 1);
            ans = 0;
        }
    }
}
