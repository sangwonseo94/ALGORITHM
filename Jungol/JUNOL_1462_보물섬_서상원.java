package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class JUNOL_1462_보물섬_서상원 {
	static class node{
		int y,  x , time;
		public node(int y, int x ,int time) {
			this.time = time;
			this.y = y;
			this.x =x ;
		}
	}
	static int answer= 0,n,m;
	static int dir[][]= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static char map[][];
	static ArrayDeque<node> dq = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int y= 0 ; y < n ; y++) {
			String t = br.readLine();
			for(int x= 0 ; x< m ; x++) {
				map[y][x] = t.charAt(x);
			}
		}
		
		
		for(int y= 0 ; y < n ; y++) {
			for(int x= 0 ; x< m ; x++) {
				if(map[y][x] == 'L') {
					BFS(y,x);
				}
			}
		}
		System.out.println(answer);
		
	}
	public static void BFS(int y, int x) {
		boolean visit[][] =  new boolean[n][m];
		visit[y][x] = true;
		dq.add(new node(y,x,0));
		while(!dq.isEmpty()) {
			node now = dq.poll();
			answer = Math.max(answer, now.time);
			for(int index = 0 ; index < 4 ;index++) {
				
				int ny = now.y+dir[index][0];
				int nx = now.x+dir[index][1];
				if(ny >= 0 && nx >= 0 && nx < m && ny <n) {
					if(!visit[ny][nx] && map[ny][nx] == 'L') {
						visit[ny][nx] = true;
						dq.add(new node(ny,nx,now.time+1));
					}
				}
			}
			
		}
		
	}

}
