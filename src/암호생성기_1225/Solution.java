package 암호생성기_1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
public class Solution {
  
 public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Queue<Integer> qu = new LinkedList<Integer>();
      for(int i = 1; i <= 10; i++) {
           
          int z = sc.nextInt();
          for(int j = 0; j < 8; j++) {
              qu.add(sc.nextInt());
          }
          int num = 1;
          while(qu.peek() - num > 0) {
              int a = qu.poll();
               a -= num;
               qu.add(a);
               num++;
               if(num >= 6) {
                   num = 1;
               }
          }
          qu.poll();
          qu.add(0);
          System.out.printf("#%d ",z);
          for(int j = 0; j < 8; j++) {
              System.out.printf("%d " ,qu.poll());
          }
          System.out.println();
        } 
    }
 }

