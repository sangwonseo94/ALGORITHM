package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 어른상어 {
	
	public static class shark {
		int y,x,dir,num;
		boolean isLive;
		int priority[][];
		public shark(int y, int x, int dir, int num, boolean isLive, int[][] priority) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.num = num;
			this.isLive = isLive;
			this.priority = priority;
		}
	}
	public static class gas{
		int y, x;
		int num , time;
		 public gas(int y, int x, int num, int time) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.time = time;
		}

	

		
		 
	}

	public static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		int s_codi[][] = new int[m+1][2];
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					// 0은 y좌표
					s_codi[map[i][j]][0] = i;
					s_codi[map[i][j]][1] = j;
				}
			}
		}
		int s_dir[] = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i < m +1 ; i++ ) s_dir[i] = Integer.parseInt(st.nextToken());
		shark[] list = new shark[m+1];
		for(int i = 0 ; i < m ; i ++) {
			int s_prior[][] = new int[5][5];
			for(int j = 1 ; j < 5 ; j ++) {
				st = new StringTokenizer(br.readLine());
				for(int z = 1 ; z < 5 ; z++) {
					s_prior[j][z] = Integer.parseInt(st.nextToken());
				}
			}
			list[i+1] = new shark(s_codi[i+1][0], s_codi[i+1][1], s_dir[i+1], i+1, true, s_prior);
		}
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		gas gasmap [][] = new gas[n][n];
		int s_cnt = 0;
		ArrayDeque<gas> dq = new ArrayDeque<>();
		for(int i = 0 ; i <= 1000 ; i ++) {
			s_cnt = 0;
		
			int size = dq.size();
			while(size > 0) {
				size--;
				gas now = dq.poll();
				now.time -=1;
				if(now.time >0) {
					dq.add(now);
				}
				
			}
			
			for(int j = 1 ; j <= m ; j++) {
				if(list[j].isLive) {
					// 상어 냄새뿌림
					gas t = new gas(list[j].y, list[j].x, list[j].num, k);
					gasmap[list[j].y][list[j].x] = t;
					dq.add(t);
				}
			}
			
			for(int j = 1 ; j <= m ; j ++) {
				if(!list[j].isLive) continue;
				s_cnt++;
				shark now = list[j];
				
				boolean GoAnother = true;
				for(int a = 0 ; a < 4 ; a++) {
					int ny = now.y + dir[now.priority[now.dir][a+1] -1][0];
					int nx = now.x + dir[now.priority[now.dir][a+1] -1][1];
					if( ny < n && nx < n && nx >= 0 && ny >=0) {
						if(gasmap[ny][nx] == null || gasmap[ny][nx].time ==0) {
							GoAnother = false;
							list[j].y = ny;
							list[j].x = nx;
							list[j].dir = now.priority[now.dir][a+1];
							break;
						}
					}
				}
				
				if(GoAnother) {
					for(int a = 0 ; a < 4 ; a++) {
						int ny = now.y + dir[now.priority[now.dir][a+1] -1][0];
						int nx = now.x + dir[now.priority[now.dir][a+1] -1][1];
						if( ny < n && nx < n && nx >= 0 && ny >=0) {
							if(gasmap[ny][nx].num ==now.num) {
								list[j].y = ny;
								list[j].x = nx;
								list[j].dir = now.priority[now.dir][a+1];
								break;
							}
						}
					}
				}
			}
			
			// 상어 중복검사
			ArrayList<Integer> al = new ArrayList<>();
			for(int j = 1 ; j <= m ; j ++) {
				if(list[j].isLive && al.contains( list[j].y*n + list[j].x)) {
					list[j].isLive=false;
				} else if(list[j].isLive) {
					al.add( list[j].y*n + list[j].x);
				}
			}
			// 냄새카운트 down
		
	
			
			
			// debug
//			for(int z = 0 ; z < n ; z ++) {
//				for(int j = 0 ; j < n ; j ++) {
//					if( gasmap[z][j] == null) System.out.print(" N");
//					else System.out.print(" "+gasmap[z][j].time);
//				}
//				System.out.println();
//			}
//			System.out.println("-----");
//			System.out.println("step" + answer );
//			System.out.println("--남은 상어수 --- : " + s_cnt);
//			
//			
			
			
			
			answer++;
			if(s_cnt==1) break;
		}System.out.println(answer = s_cnt >1 ? -1 : answer-1);
		
	}

}
