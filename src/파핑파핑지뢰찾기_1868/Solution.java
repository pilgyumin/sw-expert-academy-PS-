package 파핑파핑지뢰찾기_1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
 
public class Solution {
 
    private static int[][] ar;
    private static boolean[][] check;
 
    private static int count;
    private static LinkedList<String> li;
    public static void find(int x, int y) {
        if (ar[x][y] != 1 && ar[x][y - 1] != 1 && ar[x - 1][y - 1] != 1
                && ar[x - 1][y] != 1 && ar[x - 1][y + 1] != 1
                && ar[x][y + 1] != 1 && ar[x + 1][y + 1] != 1
                && ar[x + 1][y] != 1 && ar[x + 1][y - 1] != 1) {
            count++;
            String s = x + " " + y;
            li.add(s);
        }
    }
 
    public static int bfs(String c) {
            String[] s = c.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
             
            check[x][y] = true;
             
            if(ar[x][y] == 1) {
                check[x][y] = true;
                return 0;
            }
             
            if(ar[x][y-1] == 1 || ar[x-1][y-1] == 1 || ar[x-1][y] == 1
                    || ar[x-1][y+1] == 1  || ar[x][y+1] == 1
                    || ar[x+1][y+1] == 1 || ar[x+1][y] == 1 || ar[x+1][y-1] == 1) {
                return 0;
            }
 
     
            if(ar[x][y - 1] == 2 && !check[x][y - 1]) {
                String ss = x + " " + (y-1);
                bfs(ss);
            }
             
            if(ar[x-1][y - 1] == 2 && !check[x-1][y - 1]) {
                String ss = (x-1) + " " + (y-1);
                bfs(ss);
            }
             
            if(ar[x-1][y] == 2 && !check[x-1][y]) {
                String ss = (x-1) + " " + y;
                bfs(ss);
            }
             
            if(ar[x-1][y+1] == 2 && !check[x-1][y+1]) {
                String ss = (x-1) + " " + (y+1);
                bfs(ss);
            }
             
            if(ar[x][y+1] == 2 && !check[x][y+1]) {
                String ss = x + " " + (y+1);
                bfs(ss);
            }
             
            if(ar[x+1][y+1] == 2 && !check[x+1][y+1]) {
                String ss = (x+1) + " " + (y+1);
                bfs(ss);
            }
             
            if(ar[x+1][y] == 2 && !check[x+1][y]) {
                String ss = (x+1) + " " + y;
                bfs(ss);
            }
             
            if(ar[x+1][y-1] == 2 && !check[x+1][y-1]) {
                String ss = (x+1) + " " + (y-1);
                bfs(ss);
            }
            return 0;
    }
 
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int test = Integer.parseInt(br.readLine());
            for (int i = 1; i <= test; i++) {
                li = new LinkedList<String>();
                int num = Integer.parseInt(br.readLine());
                ar = new int[num + 2][num + 2];
                check = new boolean[num + 2][num + 2];
                for (int j = 0; j < num + 2; j++) {
                    String[] s = {};
                    if (j != 0 && j != num + 1) {
                        s = br.readLine().split("");
                    }
                    for (int k = 0; k < num + 2; k++) {
                        if (j == 0 || j == num + 1) {
                            ar[j][k] = 3;
                            continue;
                        }
                        if (k == 0 || k == num + 1) {
                            ar[j][k] = 3;
                            continue;
                        }
                        if (s[k - 1].equals(".")) {
                            ar[j][k] = 2;
                        } 
                        else if (s[k - 1].equals("*")) {
                            ar[j][k] = 1;
                            check[j][k] = true;
                        }
                    }
                }
                for (int j = 1; j < num + 1; j++) {
                    for (int k = 1; k < num + 1; k++) {
                        find(j, k);
                    }
                }   
                for(int j = 0; j < li.size(); j++) {
                    String[] s = li.get(j).split(" ");
                    int x = Integer.parseInt(s[0]);
                    int y = Integer.parseInt(s[1]);
                    if(!check[x][y]) {
                        bfs(li.get(j));
                        continue;
                    }
                    count--;
                }
                
                for (int j = 1; j < num + 1; j++) {
                    for (int k = 1; k < num + 1; k++) {
                        if(!check[j][k]) {
                            count++;
                        }
                    }
                }
                System.out.printf("#%d %d\n",i,count);
                count = 0;
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
}

