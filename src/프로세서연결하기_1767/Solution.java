package 프로세서연결하기_1767;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Solution {
 
    static class Node {
        int x;
        int y;
 
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + "]";
 
        }
    }
 
    private static int edgecore;
    private static int lineans;
    private static int coreans;
    private static ArrayList<Node> ar;
    private static int n;
 
    private static void find(int aridx, int core, int line,int[][] mapp) {
     
        if(aridx >= ar.size()) {
            if(coreans <= core) {
                if(coreans < core) {
                    lineans = 500;
                    coreans = core;
                }
                 
                if(lineans > line) {
                    lineans = line;
                }
            }
            return ;
        }
 
        int x = ar.get(aridx).x;
        int y = ar.get(aridx).y;
         
        // 0 : ��, 1 : �Ʒ�, 2 : ����, 3 : ������
        for(int i = 0; i < 4; i++) {
            int cal = 0;
            boolean np = false;
            switch(i) {
            case 0:
                for(int j = 1; j < x; j++) {
                    if(mapp[j][y] != 0) {
                        np = true;
                        break;
                    }
                }
                if(!np) {
                    for(int j = 1; j < x; j++) {
                        mapp[j][y] = 3;
                        cal++;
                    }
                }
                break;
            case 1:
                for(int j = x+1; j <= n; j++) {
                    if(mapp[j][y] != 0) {
                        np = true;
                        break;
                    }
                }
                if(!np) {
                    for(int j = x+1; j <= n; j++) {
                        mapp[j][y] = 3;
                        cal++;
                    }
                }
                break;
            case 2:
                for(int j = 1; j < y; j++) {
                    if(mapp[x][j] != 0) {
                        np = true;
                        break;
                    }
                }
                if(!np) {
                    for(int j = 1; j < y; j++) {
                        mapp[x][j] = 3;
                        cal++;
                    }
                }
                break;
            case 3:
                for(int j = y+1; j <= n; j++) {
                    if(mapp[x][j] != 0) {
                        np = true;
                        break;
                    }
                }
                if(!np) {
                    for(int j = y+1; j <= n; j++) {
                        mapp[x][j] = 3;
                        cal++;
                    }
                }
                break;
            }
             
            if(np) {
                find(aridx+1,core,line,mapp);
            }
            else {
                find(aridx+1,core+1,line+cal,mapp);
            }
             
            switch(i) {
            case 0:
                if(!np) {
                    for(int j = 1; j < x; j++) {
                        mapp[j][y] = 0;
                    }
                }
                break;
            case 1:
                if(!np) {
                    for(int j = x+1; j <= n; j++) {
                        mapp[j][y] = 0;
                        cal++;
                    }
                }
                break;
            case 2:
                if(!np) {
                    for(int j = 1; j < y; j++) {
                        mapp[x][j] = 0;
                        cal++;
                    }
                }
                break;
            case 3:
                if(!np) {
                    for(int j = y+1; j <= n; j++) {
                        mapp[x][j] = 0;
                        cal++;
                    }
                }
                break;
            }
        }
    }
     
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int test = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= test; t++) {
            n = Integer.parseInt(br.readLine());
            edgecore = 0;
            lineans = 500;
            coreans = 0;
            int[][] map = new int[n + 2][n + 2];
            ar = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n + 2; j++) {
                    if (j > 0 && j < n + 1) {
                        map[i][j] = Integer.parseInt(s[j - 1]);
                        if (map[i][j] == 1) {
                            if (i == 1 || i == n || j == 1 || j == n) {
                                edgecore++;
                            } else {
                                ar.add(new Node(i, j));
                            }
                        }
                        continue;
                    }
                    map[i][j] = 2;
                }
            }
            Arrays.fill(map[0], 2);
            Arrays.fill(map[n + 1], 2);     
            find(0,edgecore,0,map); 
            bw.write("#"+t+" "+lineans+"\n");
        }
        bw.flush();
    }
}
