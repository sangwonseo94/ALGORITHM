package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출2 {
	public static int n,m;
	public static char[][]map;
	public static int dir[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}} ; // 상하좌우
	public static int endy,endx,answer = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		int SX=0,SY=0,BY=0,BX=0;
		for(int i = 0 ; i < n ; i ++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < m ; j ++) {
				if(map[i][j] =='R') {
					SY = i; SX=j;
				} else if (map[i][j] =='B') {
					BY= i; BX=j;
				} else if (map[i][j] =='O') {
					endy = i ; endx = j;
				}
			}
		}
		DFS(SY,SX,BY,BX,0,0);
		System.out.print(answer+1);
	}
	private static void DFS(int sy, int sx, int by, int bx, int bdir, int time) {
		if(time==10) return;
		else {
			int bsy = sy , bsx = sx , bby = by , bbx =bx; // 이전 s b 좌표 기억
			for(int i = 1 ; i <=4 ; i ++) {
				if(bdir==i) continue;
				// i 방향으로 둘다 갈수 없을때까지 움직임 같이 움직여야 한다. == 벽을 만날때까지 움직임
				boolean cs = true, cb = true;
				boolean es = false, eb = false;
				while(cs || cb) {
					if(cs) { //s가 움직일수 있다면,
						int nsy = sy + dir[i][0];
						int nsx = sx + dir[i][1]; // 다음 좌표 계산
						if(nsy >=0 && nsx >=0 && nsy< n && nsx <m && (map[nsy][nsx] =='#' || map[nsy][nsx] =='B')) {
							// 벽이라면, 더이상 못움직임
							cs = false;
						} else if(nsy >=0 && nsx >=0 && nsy< n && nsx <m && map[nsy][nsx] =='.') { // 그냥 길이라면,
							map[sy][sx] ='.';
							sy = nsy; sx = nsx; 		// 좌표 업데이트
							map[sy][sx] ='R';
						} else if(nsy >=0 && nsx >=0 && nsy< n && nsx <m && map[nsy][nsx] =='O') { // 끝나는 지점이라면 answer 갱신
							map[sy][sx] ='.';
							es = true; cs= false;
						}
					} 
					if(cb) { //b가 움직일 수 있다면,
						int nby = by + dir[i][0];
						int nbx = bx + dir[i][1]; // 다음 좌표 계산
						if(nby >=0 && nbx >=0 && nby <n && nbx < m && (map[nby][nbx] =='#' || map[nby][nbx] =='R')) {
							// 벽이라면, 더이상 못움직임
							cb = false;
						} else if(nby >=0 && nbx >=0 && nby <n && nbx < m && map[nby][nbx] =='.') { // 그냥 길이라면,
							map[by][bx] ='.';
							by = nby; bx = nbx; 		// 좌표 업데이트
							map[by][bx] ='B';
						} else if(nby >=0 && nbx >=0 && nby <n && nbx < m && map[nby][nbx] =='O') { // 끝나는 지점이라면 answer 갱신
							map[by][bx] ='.';
							eb = true; cb = false;
						}
					}
					if(es && !eb) {
						if(answer >=0) answer = answer > time ? time : answer;
						else if(answer <0) answer = time;
						return;
					} else if(!es && eb) {
						map[sy][sx] ='.'; map[by][bx] ='.';
						map[bsy][bsx] ='S'; map[bby][bbx]='B';
						break;
					}
					else if(es && eb) {
						map[sy][sx] ='.'; map[by][bx] ='.';
						map[bsy][bsx] ='S'; map[bby][bbx]='B';
						break;
					} 
				}
				DFS(sy,sx,by,bx,i,time+1);
				map[sy][sx] ='.'; map[by][bx] ='.';
				map[bsy][bsx] ='S'; map[bby][bbx]='B';
			}
		}
	}
	
}
