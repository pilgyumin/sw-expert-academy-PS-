package auniquemagnet_4013;

import java.util.LinkedList;
import java.util.Scanner;
 
public class Solution {
     
    private static LinkedList<Integer> dq1;
    private static LinkedList<Integer> dq2;
    private static LinkedList<Integer> dq3;
    private static LinkedList<Integer> dq4;
     
    public static void Magnatic(int a, int b) {
        boolean check[] = new boolean[3];
        switch(a) {
        case 1:
            if(dq1.get(2) != dq2.get(6)) {
                check[0] = true;
                if(dq2.get(2) != dq3.get(6)) {
                    check[1] = true;
                    if(dq3.get(2) != dq4.get(6)) {
                        check[2] = true;
                    }
                }
            }
            // 시계 방향 회전
            if(b == 1) {
                if(check[0]) {
                    int num = dq1.remove(7);
                    dq1.addFirst(num);
                    num = dq2.removeFirst();
                    dq2.addLast(num);
                    if(check[1]) {
                        num = dq3.remove(7);
                        dq3.addFirst(num);
                        if(check[2]) {
                            num = dq4.removeFirst();
                            dq4.addLast(num);
                        }
                    }
                }
                else {
                    int num = dq1.remove(7);
                    dq1.addFirst(num);
                }
            }
            // 반시계 방향 회전
            else {
                if(check[0]) {
                    int num = dq1.removeFirst();
                    dq1.addLast(num);
                    num = dq2.removeLast();
                    dq2.addFirst(num);
                    if(check[1]) {
                        num = dq3.removeFirst();
                        dq3.addLast(num);
                        if(check[2]) {
                            num = dq4.removeLast();
                            dq4.addFirst(num);
                        }
                    }
                }
                else {
                    int num = dq1.removeFirst();
                    dq1.addLast(num);
                }
            }
            break;
        case 2:
            // 시계 방향 회전
            if(dq1.get(2) != dq2.get(6)) {
                check[0] = true;
            }
            if(dq2.get(2) != dq3.get(6)) {
                check[1] = true;
                if(dq3.get(2) != dq4.get(6)) {
                    check[2] = true;
                }
            }
            if(b == 1) {
                int num = dq2.removeLast();
                dq2.addFirst(num);
                if(check[0]) {
                    num = dq1.removeFirst();
                    dq1.addLast(num);
                }
                if(check[1]) {
                    num = dq3.removeFirst();
                    dq3.addLast(num);
                    if(check[2]) {
                        num = dq4.removeLast();
                        dq4.addFirst(num);
                    }
                }
            }
            else {
                int num = dq2.removeFirst();
                dq2.addLast(num);
                if(check[0]) {
                     num = dq1.removeLast();
                    dq1.addFirst(num);
                }
                if(check[1]) {
                    num = dq3.removeLast();
                    dq3.addFirst(num);
                    if(check[2]) {
                        num = dq4.removeFirst();
                        dq4.addLast(num);
                    }
                }
            }
            break;
        case 3:
            if(dq3.get(2) != dq4.get(6)) {
                check[2] = true;
            }
             
            if(dq2.get(2) != dq3.get(6)) {
                check[1] = true;
                if(dq1.get(2) != dq2.get(6)) {
                    check[0] = true;
                }
            }
            if(b == 1) {
                int num = dq3.removeLast();
                dq3.addFirst(num);
                if(check[2]) {
                    num = dq4.removeFirst();
                    dq4.addLast(num);
                }
                if(check[1]) {
                    num = dq2.removeFirst();
                    dq2.addLast(num);
                    if(check[0]) {
                        num = dq1.removeLast();
                        dq1.addFirst(num);
                    }
                }
            }
            else {
                int num = dq3.removeFirst();
                dq3.addLast(num);
                if(check[2]) {
                    num = dq4.removeLast();
                    dq4.addFirst(num);
                }
                if(check[1]) {
                    num = dq2.removeLast();
                    dq2.addFirst(num);
                    if(check[0]) {
                        num = dq1.removeFirst();
                        dq1.addLast(num);
                    }
                }
            }
            break;
        case 4:
            if(dq3.get(2) != dq4.get(6)) {
                check[2] = true;
                if(dq2.get(2) != dq3.get(6)) {
                    check[1] = true;
                    if(dq1.get(2) != dq2.get(6)) {
                        check[0] = true;
                    }
                }
            }
            if(b == 1) {
                int num = dq4.removeLast();
                dq4.addFirst(num);
                if(check[2]) {
                    num = dq3.removeFirst();
                    dq3.addLast(num);
                    if(check[1]) {
                        num = dq2.removeLast();
                        dq2.addFirst(num);
                        if(check[0]) {
                            num = dq1.removeFirst();
                            dq1.addLast(num);
                        }
                    }
                }
            }
            else {
                int num = dq4.removeFirst();
                dq4.addLast(num);
                if(check[2]) {
                    num = dq3.removeLast();
                    dq3.addFirst(num);
                    if(check[1]) {
                        num = dq2.removeFirst();
                        dq2.addLast(num);
                        if(check[0]) {
                            num = dq1.removeLast();
                            dq1.addFirst(num);
                        }
                    }
                }
            }
            break;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++) {
            int num = sc.nextInt();
            dq1 = new LinkedList<Integer>();
            dq2 = new LinkedList<Integer>();
            dq3 = new LinkedList<Integer>();
            dq4 = new LinkedList<Integer>();
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 8; k++) {
                    if(j == 0) {
                        dq1.add(sc.nextInt());
                    }
                    else if(j == 1) {
                        dq2.add(sc.nextInt());
                    }
                    else if(j == 2) {
                        dq3.add(sc.nextInt());
                    }
                    else if(j == 3) {
                        dq4.add(sc.nextInt());
                    }
                }
            }       
            for(int j = 0; j < num; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Magnatic(a,b);
            }
            int ans = 0;
            for(int j = 0; j <= 3; j++) {
                if(j == 0) {
                    if(dq1.getFirst() != 0) {
                        ans += 1;
                    }
                }
                else if(j == 1) {
                    if(dq2.getFirst() != 0) {
                        ans += 2;
                    }
                }
                else if(j == 2) {
                    if(dq3.getFirst() != 0) {
                        ans += 4;
                    }
                }
                else if(j == 3) {
                    if(dq4.getFirst() != 0) {
                        ans += 8;
                    }
                }
            }
            System.out.printf("#%d %d\n",i,ans);
        }
    }
}

