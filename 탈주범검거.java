package practice;


import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class info{
	int y,x,time;
	public info(int y,int x, int time) {
		this.y = y;
		this.x =x;
		this.time = time;
	}
}
class Å»ÁÖ¹ü°Ë°Å{
	static int n,m,r,c,l;
	static int map[][];
	static boolean visit[][];
	static int answer=1;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++){
		st = new StringTokenizer(br.readLine());
		
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 r = Integer.parseInt(st.nextToken());
		 c = Integer.parseInt(st.nextToken());
		 l = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int y = 0 ;y < n ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x < m ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		visit[r][c] = true;
		BFS(new info(r,c,1));
		System.out.println("#"+test_case+" "+answer);
		answer =1;
		}
	}
	public static void BFS(info frist) {
		ArrayDeque<info> dq = new ArrayDeque<>();
		dq.add(frist);
		while(!dq.isEmpty()) {
			
			info now = dq.poll();
			int y = now.y;
			int x = now.x;
			int time = now.time;
			if(time ==l) {
				continue;
			}
			if(map[y][x] == 1) {
				int ny = y + dy[0];
				int nx = x + dx[0];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==5 || map[ny][nx] ==6) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[1];
				 nx = x + dx[1];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==4 || map[ny][nx] ==7) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[2];
				 nx = x + dx[2];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==4 || map[ny][nx] ==5) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[3];
				 nx = x + dx[3];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==6 || map[ny][nx] ==7) {
						
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					continue;
				}}
			}
			else if(map[y][x]== 2) {
				int ny = y + dy[0];
				int nx = x + dx[0];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==5 || map[ny][nx] ==6) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[1];
				 nx = x + dx[1];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==4 || map[ny][nx] ==7) {
						
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					continue;
					}
				}
			}else if(map[y][x]== 3) {
				int ny = y + dy[2];
				int nx = x + dx[2];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==4 || map[ny][nx] ==5) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[3];
				 nx = x + dx[3];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==6 || map[ny][nx] ==7) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					continue;
					}
				}
			}else if(map[y][x]== 4) {
				
				int ny = y + dy[0];
				int nx = x + dx[0];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==5 || map[ny][nx] ==6) {
						visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[3];
				 nx = x + dx[3];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==6 || map[ny][nx] ==7) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					continue;
					}
				}
			}else if(map[y][x]== 5) {
				{
					int ny = y + dy[1];
					int nx = x + dx[1];
					if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
						if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==4 || map[ny][nx] ==7) {
							
						visit[ny][nx] = true;
						dq.add(new info(ny,nx,time+1));
						answer++;
						}
					}
					 ny = y + dy[3];
					 nx = x + dx[3];
					if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
						if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==6 || map[ny][nx] ==7) {
						visit[ny][nx] = true;
						dq.add(new info(ny,nx,time+1));
						answer++;
						continue;}
					}
				}
			}else if(map[y][x]== 6) {
				{
					int ny = y + dy[1];
					int nx = x + dx[1];
					if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
						if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==4 || map[ny][nx] ==7) {
							
						visit[ny][nx] = true;
						dq.add(new info(ny,nx,time+1));
						answer++;
						}
					}
					 ny = y + dy[2];
					 nx = x + dx[2];
					if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
						if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==4 || map[ny][nx] ==5) {
						visit[ny][nx] = true;
						dq.add(new info(ny,nx,time+1));
						answer++;
						continue;
					}}
				}
			}else if(map[y][x]== 7) {
				int ny = y + dy[0];
				int nx = x + dx[0];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] ==2 || map[ny][nx]==5 || map[ny][nx] ==6) {
						
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					}
				}
				 ny = y + dy[2];
				 nx = x + dx[2];
				if(ny>= 0 && nx>=0 && nx <m && ny < n && !visit[ny][nx] && map[ny][nx]!=0) {
					if(map[ny][nx] ==1 ||map[ny][nx] == 3 || map[ny][nx]==4 || map[ny][nx] ==5) {
					visit[ny][nx] = true;
					dq.add(new info(ny,nx,time+1));
					answer++;
					continue;
				}}
			}
			else continue;
			
			
		}
	}
}





















