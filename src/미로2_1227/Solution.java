package ¹Ì·Î2_1227;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
public class Solution {
  
 public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Queue<String> qu = new LinkedList<String>();
      for(int i = 1; i <= 10; i++) {
          int num = sc.nextInt();
          sc.nextLine();
          int[][] arr = new int[100][100];
          boolean[][] check = new boolean[100][100];
          String start = "";
          String end = "";
          for(int j = 0; j < 100; j++) {
              String[] line = sc.next().split("");
              for(int k = 0; k < 100; k++) {
                  arr[j][k] = Integer.parseInt(line[k]);
                  if(arr[j][k] == 2) {
                      start = j + " " + k;
                      qu.add(start);
                  }
                  else if(arr[j][k] == 3) {
                      end = j + " " + k;
                  }
              }
          }
          int ans = 0;
          while(!qu.isEmpty()) {
              String[] s = qu.peek().split(" ");
              int x = Integer.parseInt(s[0]);
              int y = Integer.parseInt(s[1]);
              check[x][y] = true;
               
              if(arr[x][y + 1] == 3 || arr[x][y - 1] == 3 ||
                      arr[x + 1][y] == 3 || arr[x-1][y] == 3) {
                  ans= 1;
                  break;
              }
              if(arr[x][y + 1] == 0 && !check[x][y + 1]) {
                  String next = x + " " + (y+1);
                  qu.add(next);
              }
              if(arr[x][y - 1] == 0 && !check[x][y - 1]) {
                  String next = x + " " + (y-1);
                  qu.add(next);
              }
              if(arr[x + 1][y] == 0 && !check[x+1][y]) {
                  String next = (x+1) + " " + y;
                  qu.add(next);
              }
              if(arr[x - 1][y] == 0 && !check[x-1][y]) {
                  String next = (x-1) + " " + y;
                  qu.add(next);
              }
              qu.poll();
          }
          System.out.printf("#%d %d\n",num,ans);
          qu.clear();
        } 
    }
 }

