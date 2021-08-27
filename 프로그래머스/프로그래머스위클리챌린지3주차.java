package 알고리즘잘하고싶다;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CORBA.INTERNAL;

public class 프로그래머스위클리챌린지3주차 {

	public static void main(String[] args) {

		
		 solution(new int[][] {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
				new int[][] {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}});
		 System.out.println(answer);
		 

			answer = -1;
		 solution(new int[][] {{0,0,0},{1,1,0},{1,1,1}},
				new int[][] {{1,1,1},{1,0,0},{0,0,0}});
		 System.out.println(answer);
		 

			answer = -1;
		 solution(new int[][] {{0,1,0},{1,1,1},{1,0,1}},
				new int[][] {{1,0,1},{0,0,0},{0,1,0}});
		 System.out.println(answer);
		 

			answer = -1;
		 solution(new int[][] {
			 {0,0,1,0,1,0,1,0,1,0,1,0,0,1,0,0,0,0},
			 {1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,1,1},
			 {0,1,1,1,0,0,1,0,1,0,0,1,1,0,1,0,0,0},
			 {0,0,0,0,1,1,0,0,1,1,0,1,0,0,1,0,0,0},
			 {0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,1,1},
			 {1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0},
			 {0,0,0,1,1,1,0,0,1,1,0,1,1,1,1,0,0,1},
			 {1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,1,0},
			 {0,0,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0}, 
			 {1,1,0,1,1,0,1,1,1,1,0,1,0,0,0,1,1,1},
			 {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1,0,1,0},
			 {1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0},
			 {0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0},
			 {1,0,1,1,0,1,1,0,0,0,1,0,0,0,1,0,0,1},
			 {1,0,0,1,1,0,0,1,1,1,0,1,1,1,0,1,1,0},
			 {0,1,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0},
			 {0,0,0,1,0,1,0,1,0,0,1,1,1,1,1,1,1,0}, 
			 {0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0}},
				new int[][] {
				 {1,1,1,1,1,1,0,1,0,1,1,1,0,1,0,0,1,0},
				 {0,0,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0},
				 {1,0,1,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1}, {1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,0,1}, {1,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,1}, {0,0,0,1,1,1,0,1,1,1,0,1,1,0,1,0,0,0}, {1,1,1,0,0,0,0,0,1,1,0,1,1,0,1,1,1,1}, {0,0,1,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0}, {1,0,1,0,0,0,0,1,0,1,1,0,1,1,0,1,1,1}, {1,0,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,0}, {1,1,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,0}, {0,0,1,1,1,1,0,1,1,0,1,0,0,0,1,1,0,1}, {1,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1}, {1,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,0,1}, {0,0,1,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0}, {1,1,1,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1}, {0,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,1}, {0,1,1,1,1,0,0,1,0,0,1,1,0,1,0,0,1,1}});
		 System.out.println(answer);
	}
	
	public static class Block{
		public ArrayList<int[]> Direction[];
		public boolean used = true;
		public int size = -1;
		public Block() {
			Direction = new ArrayList[4];
			for(int i=0;i<4;i++) {
				Direction[i] = new ArrayList<>();
			}
		}
	}
	
	public static int dir[][] = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static ArrayList<Block> Blocks;
	public static int answer = -1;
	public static HashMap<Integer, Integer> hm = new HashMap<>();
	public static int solution(int[][] game_board, int[][] table) {
	        
	        BFS(table , game_board);
	        DFS(game_board , 0, 0);
	        if(answer== -1) {
	        	answer = 0;
	        }
	        return answer;
	}
	private static void DFS(int[][] game_board, int Cnt , int Coo) {
		int size =  game_board.length;
	    for(int ccoo = Coo;ccoo < size*size ; ccoo++) {
				int yy = ccoo / size;
				int xx = ccoo % size;
				if(game_board[yy][xx]!=1) {
					for(int kk=0; kk<Blocks.size(); kk++) {
						if(Blocks.get(kk).used){
							for(int i=0;i<4;i++) {
								if(Cango(game_board , Blocks.get(kk).Direction[i],ccoo, Blocks.get(kk).size) ) {
									Blocks.get(kk).used = false;
									Cnt += Blocks.get(kk).size;
									answer = answer > Cnt ? answer : Cnt;
									Cover(game_board, Blocks.get(kk).Direction[i],ccoo,1);	
									
									DFS(game_board , Cnt , ccoo+1);
									Cover(game_board, Blocks.get(kk).Direction[i],ccoo,game_board[yy][xx]);
									
									Cnt -= Blocks.get(kk).size;
									Blocks.get(kk).used = true;
								}
							}		
						}
					}
				}
			}
	}
	
	private static void Cover(int[][] game_board, ArrayList<int[]> direction, int coo, int change) {
		int size =  game_board.length;
		int y = coo / size;
		int x = coo % size;
		
		if(change== 1) {
			for(int i=0;i<direction.size();i++) {
				int yy = y+direction.get(i)[0];
				int xx = x+direction.get(i)[1];
				game_board[yy][xx] = 1;
			}
		} else {
			for(int i=0;i<direction.size();i++) {
				int yy = y+direction.get(i)[0];
				int xx = x+direction.get(i)[1];
				game_board[yy][xx] = change;
			}
		}
		
	}
	
	private static boolean Cango(int[][] game_board, ArrayList<int[]> direction, int coo, int ssize) {
		int size =  game_board.length;
		int y = coo / size;
		int x = coo % size;
		
		if(game_board[y][x]!=1&&hm.get(game_board[y][x]) != ssize){
			return false;
		}
		for(int i=0;i<direction.size();i++) {
			int yy = y+direction.get(i)[0];
			int xx = x+direction.get(i)[1];
			if(yy<0  || xx<0 || yy >= size || xx >= size ) {
				return false;
			}
			if(game_board[yy][xx] ==1) {
				return false;
			}
		
		}
		
		return true;
	}
	private static void BFS(int[][] table, int[][] game_board) {
		// table에 해당되는 Blocks를 완성시켜준다.
		int size = table.length;
		Blocks = new ArrayList<>();
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		int index = 2;
		for(int i=0;i<size;++i) {
			for(int j=0;j<size;++j) {
				if(game_board[i][j]==0) {
					dq.add(new int[]{i,j});
					game_board[i][j] =index;
					int ssize = 1;
					while(!dq.isEmpty()) {
						int now[] = dq.poll();
						for(int k=1;k<5;k++) {
							int ny= now[0] + dir[k][0];
							int nx= now[1] + dir[k][1];
							if(ny>=0&&nx>=0&&ny<size&&nx<size) {
								if(game_board[ny][nx]==0) {
									game_board[ny][nx] = index;
									dq.add(new int[] {ny,nx});
									ssize++;
								}
							}
						}
					}
					index++;
					hm.put(index-1, ssize);
				}
				
			}
		}
		
		for(int i=0;i<size;++i) {
			for(int j=0;j<size;++j) {
				if(table[i][j]==1) {
					dq.add(new int[] {i,j});
					table[i][j] =0;
					ArrayList<int []> t = new ArrayList<>();
					t.add(new int[] {0,0});
					while(!dq.isEmpty()) {
						int now [] = dq.poll();
						for(int k=1;k<5;k++) {
							int nexty = now[0]+dir[k][0];
							int nextx = now[1]+dir[k][1];
							if(nexty < size && nextx < size && nexty >=0 && nextx >=0) {
								if(table[nexty][nextx]==1) {
									table[nexty][nextx] = 0;
									t.add(new int[] {nexty-i , nextx-j});
									dq.add(new int[] {nexty,nextx});
								}
							}
						}
					}
					// 블럭 한덩이 찾음
					// 블럭 *4 해주자 90도씩
					Block B = new Block();
					int[][] ddir = new int[][]{{-1,-1},{1,-1},{-1,1}};
					B.Direction[0] = t;
					for(int k=1;k<4;k++) {
						ArrayList<int []>tt = new ArrayList<>();
						for(int kk=0;kk<t.size();kk++) {
							int now[] = B.Direction[0].get(kk);
							if(now[0]==0&&now[1]==0) {
								tt.add(new int[] {now[1] ,now[0]});
							}
							else if(now[0]==0||now[1]==0  ) {
								if(k==1) {
									tt.add(new int[] {now[1] ,now[0]});
								} else if(k==2) {
									if(now[0]==0) {
										tt.add(new int[] {now[0] ,-now[1]});
									} else {
										tt.add(new int[] {-now[0] ,now[1]});
									}
								} else {
									if(now[0]==0) {
										tt.add(new int[] {-now[1] ,now[0]});
									} else {
										tt.add(new int[] { now[1],-now[0]});
									}
								}
							} else {
								tt.add(new int[] {now[0]*ddir[k-1][0] ,now[1]*ddir[k-1][1]});
							}
						}
						B.Direction[k] = tt;
					}
					
					B.size = t.size();
					Blocks.add(B);
					
				}
			}
		}
		
	}
}
