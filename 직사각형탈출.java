package 푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 직사각형탈출 {
	static int map[][],dir[][]= {{1,0},{-1,0},{0,1},{0,-1}};
	static int y,x,h,w,sx,sy,ex,ey,nx,ny,answer=-1;
	static boolean visit[][];
	public static void main(String[] args) throws IOException{
		input();
		BFS();
		System.out.println(answer);
		
	}
	public static void BFS() {
		ArrayDeque<int []> dq = new ArrayDeque<>();
		dq.add(new int[] {sy,sx,0});
		visit[sy][sx] = true;
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			if(now[0] == ey && now[1] ==ex) {
				answer = now[2];
				return;
			}
			for(int i =0; i < 4 ; i++) {
				ny = now[0] +dir[i][0];
				nx = now[1] +dir[i][1];
				if(ny >=1 && nx >=1 && ny <=y && nx <=x && go(ny,nx,i) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					dq.add(new int[] {ny,nx,now[2]+1});
				}
			}
		}
	}
	public static boolean go(int nexty, int nextx,int direction) {
		// y,x {{1,0},{-1,0},{0,1},{0,-1}}
		if(direction ==0) {
			if(nexty+(h-1) > y) return false;
			for(int i = nextx ; i < nextx+ w ; i ++) {
				if(map[nexty+(h-1)][i] == 1) return false;
			}
		}else if(direction == 1) {
			for(int i = nextx ; i < nextx + w ; i++) {
				if(map[nexty][i] == 1) return false;
			}
		}else if(direction == 2) {
			if(nextx+(w-1) > x) return false;
			for(int i = nexty ; i < nexty+h ; i++) {
				if(map[i][nextx+(w-1)]==1 )return false;
			}
		}else if(direction == 3) {
			for(int i = nexty ; i < nexty+h ; i++ ) {
				if(map[i][nextx] == 1) return false;
			}
			
		}
		return true;
	}
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y+1][x+1];
		visit= new boolean[y+1][x+1];
		for(int i = 1 ; i <= y ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <=x ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st= new StringTokenizer(br.readLine());
		
		h =Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		ex =Integer.parseInt(st.nextToken());
		
		
	}

}
