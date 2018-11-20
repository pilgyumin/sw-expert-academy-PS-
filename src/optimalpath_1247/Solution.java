package optimalpath_1247;

import java.util.Scanner;

public class Solution {
 
    private static int[] posx;
    private static int[] posy;
    private static int dist;
    private static int min;
 
    public static int find(int i, int[] x, int[] y, boolean[] bx, boolean[] by) {
        if(i == posx.length - 1) {
            String s = "";
            s+= x[0];
            for(int j = 1; j < posx.length; j++) {
                s += " " + x[j];
                dist += Math.abs(x[j] - x[j-1]);
                dist += Math.abs(y[j] - y[j-1]);
            }
            if(min > dist) {
                min = dist;
            }
            dist= 0;
            return 0;
        }
        for (int j = 1; j < posx.length - 1; j++) {
            if(bx[j] && by[j]) {
                continue;
            }
            x[i] = posx[j];
            y[i] = posy[j];
            bx[j] = true;
            by[j] = true;
            find(i+1,x,y,bx,by);
            bx[j] = false;
            by[j] = false;
        }
        return 1;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int num = sc.nextInt();
            posx = new int[num + 2];
            posy = new int[num + 2];
            int arX[] = new int[num + 2];
            int arY[] = new int[num + 2];
            boolean bX[] = new boolean[num + 2];
            boolean bY[] = new boolean[num + 2];
            int l = posx.length - 1;
            dist = 0;
            min = 1000000;
            for (int j = 0; j < posx.length; j++) {
                posx[j] = sc.nextInt();
                posy[j] = sc.nextInt();
                if (j == l) {
                    int temp = posx[l];
                    posx[l] = posx[1];
                    posx[1] = temp;
                    temp = posy[l];
                    posy[l] = posy[1];
                    posy[1] = temp;
                }
            }
            arX[0] = posx[0];
            arY[0] = posy[0];
            arX[l] = posx[l];
            arY[l] = posy[l];
            bX[0] = true;
            bX[l] = true;
            bY[0] = true;
            bY[l] = true;
            find(1, arX, arY,bX,bY);
            System.out.printf("#%d %d\n",i,min);
        }
    }
}

