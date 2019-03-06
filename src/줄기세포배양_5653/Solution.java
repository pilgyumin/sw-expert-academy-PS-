package 줄기세포배양_5653;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Cell {
		int x;
		int y;
		int life;
		int time;
		int active;
		
		public Cell(int x, int y, int life, int time, int active) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.time = time;
			this.active = active;
		}

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", life=" + life + ", time=" + time + ", active=" + active + "]";
		}


	}

	static class Area {
		int life;
		int dead;

		public Area(int life, int dead) {
			this.life = life;
			this.dead = dead;
		}

		@Override
		public String toString() {
			return "Area [life=" + life + ", dead=" + dead + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Cell> qu = new LinkedList<Cell>();
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			String[] nmk = br.readLine().split(" ");
			Area[][] map = new Area[500][500];
			
			int n = Integer.parseInt(nmk[0]);
			int m = Integer.parseInt(nmk[1]);
			int k = Integer.parseInt(nmk[2]);

			for (int i = 0; i < 500; i++) {
				for (int j = 0; j < 500; j++) {
					map[i][j] = new Area(0, 0);
				}
			}

			for (int i = 225; i < 225 + n; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(s[j]);
					if (num == 0) {
						continue;
					}
					qu.add(new Cell(i, 225 + j, num, num,0));
					map[i][225 + j] = new Area(num, 1);
				}
			}

			for (int i = 0; i < k; i++) {
				int size = qu.size();
				for (int j = 0; j < size; j++) {
					Cell cell = qu.poll();
					if (map[cell.x][cell.y].life == cell.life) {
						map[cell.x][cell.y].dead = 1;
						qu.add(cell);
					}
				}
				size = qu.size();
				for (int j = 0; j < size; j++) {
					Cell cell = qu.poll();
					if (cell.time > 0) {
						cell.time--;
						qu.add(cell);
					} 
					else {
						if(cell.active == 0) {
							if(cell.active < cell.life-1) {
								cell.active++;
								qu.add(cell);
							}
							if (map[cell.x - 1][cell.y].dead == 0) {
								if (map[cell.x - 1][cell.y].life < cell.life) {
									map[cell.x - 1][cell.y].life = cell.life;
									qu.add(new Cell(cell.x - 1, cell.y, cell.life, cell.life,0));
								}

							}
							if (map[cell.x + 1][cell.y].dead == 0) {
								if (map[cell.x + 1][cell.y].life < cell.life) {
									map[cell.x + 1][cell.y].life = cell.life;
									qu.add(new Cell(cell.x + 1, cell.y, cell.life, cell.life,0));
								}

							}
							if (map[cell.x][cell.y - 1].dead == 0) {
								if (map[cell.x][cell.y - 1].life < cell.life) {
									map[cell.x][cell.y - 1].life = cell.life;
									qu.add(new Cell(cell.x, cell.y - 1, cell.life, cell.life, 0));
								}
							}
							if (map[cell.x][cell.y + 1].dead == 0) {
								if (map[cell.x][cell.y + 1].life < cell.life) {
									map[cell.x][cell.y + 1].life = cell.life;
									qu.add(new Cell(cell.x, cell.y + 1, cell.life, cell.life, 0));
								}
							}
						}
						else if(cell.active < cell.life-1) {
							cell.active++;
							qu.add(cell);
						}
						
					}

				}
			}
			
			int size = qu.size();
			for (int j = 0; j < size; j++) {
				Cell cell = qu.poll();
				if (map[cell.x][cell.y].life == cell.life) {
					map[cell.x][cell.y].dead = 1;
					qu.add(cell);
					
				}
			}
			
			bw.write("#" + t + " " + qu.size() + "\n");
			qu.clear();
		}
		bw.flush();
	}
}
