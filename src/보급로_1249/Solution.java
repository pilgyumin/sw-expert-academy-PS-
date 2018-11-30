package º¸±Þ·Î_1249;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
     
    static class Node{
        int x;
        int y;
         
        public Node(int x, int y) { 
            this.x = x;
            this.y = y;
        }
         
    }
     
    private static int[][] dist;
    private static int[][] map;
    private static boolean[][] check;
    private static int n;
     
    public static void dijkstra(int x, int y) {
        Node nx = new Node(x,y);
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(nx);
        dist[x][y] = 0;
        while(!qu.isEmpty()) {
            Node no = qu.poll();
            check[no.x][no.y] = true;
            for(int j = 0; j < 4; j++) {
                if(j == 0) {
                    if(no.x >= 1 && dist[no.x-1][no.y] > map[no.x-1][no.y] + dist[no.x][no.y]) {
                        dist[no.x-1][no.y] = map[no.x-1][no.y] + dist[no.x][no.y];
                        Node nw = new Node(no.x-1,no.y);
                        check[no.x-1][no.y] = true;
                        qu.add(nw);
                    }
                }
                
                else if(j == 1) {
                    if(no.x  < n - 1 && dist[no.x+1][no.y] > map[no.x+1][no.y] + dist[no.x][no.y]) {
                        dist[no.x+1][no.y] = map[no.x+1][no.y] + dist[no.x][no.y];
                        Node nw = new Node(no.x+1,no.y);
                        qu.add(nw);     
                    }
                }
                
                else if(j == 2) {
                    if(no.y < n - 1 && dist[no.x][no.y+1] > map[no.x][no.y+1] + dist[no.x][no.y]) {
                        dist[no.x][no.y+1] = map[no.x][no.y+1] + dist[no.x][no.y];
                        Node nw = new Node(no.x,no.y+1);
                        qu.add(nw);
                    }
                }
                
                else if(j == 3) {
                    if(no.y >= 1 && dist[no.x][no.y-1] > map[no.x][no.y-1] + dist[no.x][no.y]) {
                        dist[no.x][no.y-1] = map[no.x][no.y-1] + dist[no.x][no.y];
                        Node nw = new Node(no.x,no.y-1);
                        qu.add(nw);     
                    }
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            n = sc.nextInt();
            map = new int[n][n];
            dist = new int[n][n];
            check = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                String[] s = sc.next().split("");
                for (int k = 0; k < n; k++) {
                    dist[j][k] = 100000;
                    map[j][k] = Integer.parseInt(s[k]);
                }
            }
 
            dijkstra(0, 0);
            System.out.printf("#%d %d\n",i,dist[n-1][n-1]);
        }
    }
}
