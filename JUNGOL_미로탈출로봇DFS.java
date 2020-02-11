package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class JUNGOL_미로탈출로봇DFS {
	static class pos{
		int y, x, len;
		public pos(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
			
			// TODO Auto-generated constructor stub
		}
	}
	static int dir[][] = {
			{1,0},
			{-1,0},
			{0,-1},
			{0,1}
	};
	static int ans = Integer.MAX_VALUE;
	static int x,y ,endx,endy, map[][];
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int startx = Integer.parseInt(st.nextToken())-1;
		int starty = Integer.parseInt(st.nextToken())-1;
		endx = Integer.parseInt(st.nextToken())-1;
		endy = Integer.parseInt(st.nextToken())-1;
		map  = new int[y][x];
		visit  = new boolean[y][x];
		for(int dy = 0 ; dy < y ; dy++) {
			String t = br.readLine();
			for(int dx=0; dx < x ; dx++) {
				map[dy][dx] = t.charAt(dx) - '0';
			}
		}
		visit[starty][startx] = true;
		DFS(starty ,  startx, 0);
		System.out.println(ans);
		ans =  Integer.MAX_VALUE;
	}
	public static void DFS(int starty, int startx, int len) {
		if(len > ans) {
			return;
		}
		if( startx == endx && starty == endy) {
			ans = Math.min(ans,len);
			return;
		}
		
		for(int index= 0 ; index< 4 ; index++) {
			
			int ny = starty + dir[index][0];
			int nx = startx + dir[index][1];
			if(ny >=0 && nx >= 0 && nx < x && ny < y) {
				if(map[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					DFS(ny,nx,len+1);
					visit[ny][nx] = false;
				}
			}
		}
		
	}
	

}


//

//8 7
//1 2 7 5
//11111111
//00000111
//10110011
//10111001
//10111101
//10000001
//11111111