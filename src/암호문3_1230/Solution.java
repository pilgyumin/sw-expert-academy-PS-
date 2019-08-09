package 암호문3_1230;

import java.util.LinkedList;
import java.util.Scanner;
 
public class Solution {
  
 public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      LinkedList<Integer> li = new LinkedList<Integer>();
      for(int i = 1; i <= 10; i++) {
          int num = sc.nextInt();
          for(int j = 0; j < num ; j++) {
              li.add(sc.nextInt());
          }
          int command = sc.nextInt();
          for(int j = 0; j < command; j++) {
              String c = sc.next();
               
              switch(c) {
              case "I": case "i":
                  int index = sc.nextInt();
                  int amount = sc.nextInt();
                  for(int k = 0; k <amount; k++) {
                      li.add(index, sc.nextInt());
                      index++;
                  }
                  break;
              case "D": case "d":
                  int index1 = sc.nextInt();
                  int amount1 = sc.nextInt();
                  for(int k = 0 ; k < amount1 ; k++) {
                      li.remove(index1);
                  }
                  break;
              case "A": case "a":
                  int amount2 = sc.nextInt();
                  for(int k = 0 ; k < amount2 ; k++) {
                      li.addLast(sc.nextInt());
                  }
                  break;
              }
          }
          System.out.printf("#%d ",i);
          for(int j = 0; j < 10; j++) {
              System.out.printf("%d ",li.get(j));
          }
          System.out.println();
          li.clear();
        } 
    }
 }

