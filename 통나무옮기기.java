package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 통나무옮기기 {
	static class tree{
		int y,x,shape,time;
		public tree(int y, int x, int shape, int time) {
			this.y = y;
			this.x = x;
			this.shape = shape;
			this.time = time;
		}
		
	}
	public static char map[][];
	public static boolean visit[][][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		map = new char[n+1][n+1];
		int centerx=0 , centery=0,shape =0,endx =0,endy=0,endshape=0;
		for(int i = 1 ; i <=n ; i++) {
			char temp[] = br.readLine().toCharArray();
			for(int j =1 ; j <=n ; j++) {
				map[i][j] = temp[j-1];
			}
		}
		for(int i = 1 ; i <=n ; i++) {
			for(int j=1 ; j <= n; j++) {
				if(map[i][j] =='B') {
					if(i-1 >0 && i+1 <=n) {
						if(map[i-1][j] =='B' && map[i+1][j]=='B') {
							map[i-1][j] ='0'; map[i+1][j]='0'; map[i][j]='0';
							centerx = j ; centery=i ; shape =1;
						} 
					}
					if(j-1 >0 && j+1 <=n) {
						if(map[i][j-1]=='B' && map[i][j+1]=='B') {
							map[i][j-1]='0'; map[i][j+1]='0'; map[i][j]='0';
							centerx = j ; centery=i ; shape =2;
						}
					}	
				} else if(map[i][j]=='E') {
					if(i-1 >0 && i+1 <=n ) {
						if(map[i-1][j] =='E' && map[i+1][j]=='E') {
							map[i-1][j] ='0' ; map[i+1][j]='0'; map[i][j]='0';
							endx = j ;endy=i ; endshape =1;
						} 
					}
					if (j-1 > 0 && j+1 <=n) {
						if(map[i][j-1]=='E' && map[i][j+1]=='E') {
							map[i][j-1]='0';map[i][j+1]='0'; map[i][j]='0';
							endx = j ; endy=i ; endshape =2;
						}
					}
				}
			}
		}
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,1},{-1,-1}};
		int answer =0;
		visit = new boolean[3][n+1][n+1];
		ArrayDeque<tree> dq = new ArrayDeque<tree>();
		dq.add(new tree(centery, centerx, shape,0));
		visit[shape][centery][centerx] = true;
		while(!dq.isEmpty()) {
			tree now = dq.poll();
			
			int y = now.y;
			int x = now.x;
			int nowshape = now.shape;
			int time = now.time;
			if(y==endy && x == endx && nowshape == endshape) {
				answer = time;
				break;
			}
			for(int index = 0 ; index < 4 ; index++) {
				if(nowshape == 1) {
					int ny = y +dir[index][0];
					int nx = x +dir[index][1];
					if(ny>0 && nx >0 && nx<= n && ny<=n && ny+1 <=n && ny-1>0) {
						if(map[ny][nx]=='0' && map[ny+1][nx]=='0' && map[ny-1][nx] =='0') {
							if(!visit[nowshape][ny][nx]) {
								visit[nowshape][ny][nx] = true;
								dq.add(new tree(ny,nx,nowshape,time+1));
							}
						}
					}
				} else if(nowshape==2){
					int ny = y +dir[index][0];
					int nx = x +dir[index][1];
					if(ny>0 && nx >0 && nx<= n && ny<=n && nx+1 <=n && nx-1>0) {
						if(map[ny][nx]=='0' && map[ny][nx+1]=='0' && map[ny][nx-1] =='0') {
							if(!visit[nowshape][ny][nx]) {
								visit[nowshape][ny][nx] = true;
								dq.add(new tree(ny,nx,nowshape,time+1));
							}
						}
					}
				}
			}
			// 회전연산 cnt가 6이고 visit처리가 안되있으면 go
			int cnt = 0;
			for(int index = 0 ; index < 8 ; index++) {
				int ny = y + dir[index][0];
				int nx = x + dir[index][1];
				if(ny>0 && nx>0 && nx <=n && ny<=n) {
					if(map[ny][nx]=='0') cnt++;
				}
			}
			if(cnt==8) {
				if(nowshape==1 && !visit[2][y][x]) {
					visit[2][y][x] = true;
					dq.add(new tree(y,x,2,time+1));
				}else if(nowshape==2 && !visit[1][y][x]) {
					visit[1][y][x] = true;
					dq.add(new tree(y,x,1,time+1));
				}
			}
		}System.out.print(answer);
	}
}
