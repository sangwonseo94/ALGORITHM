package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class JUNGOL_미로탈출로봇 {
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
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int startx = Integer.parseInt(st.nextToken())-1;
		int starty = Integer.parseInt(st.nextToken())-1;
		int endx = Integer.parseInt(st.nextToken())-1;
		int endy = Integer.parseInt(st.nextToken())-1;
		int map[][]  = new int[y][x];
		boolean visit[][]  = new boolean[y][x];
		for(int dy = 0 ; dy < y ; dy++) {
			String t = br.readLine();
			for(int dx=0; dx < x ; dx++) {
				map[dy][dx] = t.charAt(dx) - '0';
			}
		}
		
		ArrayDeque<pos> dq = new ArrayDeque<>();
		dq.add(new pos(starty, startx,0));
		visit[starty][startx] = true;
		while(!dq.isEmpty()) {
			
			pos now = dq.poll();
			if(now.x == endx && now.y == endy) {
				ans = Math.min(ans , now.len);
				continue;
			}
			for(int index = 0 ; index <4 ; index++) {
				int ny = now.y + dir[index][0];
				int nx = now.x + dir[index][1];
				if(ny >= 0 && nx >= 0 && ny < y && nx < x && !visit[ny][nx] && map[ny][nx] == 0) {
					visit[ny][nx] = true;
					dq.add(new pos(ny,nx,now.len+1));
				}
			}
		
		}
		
		System.out.println(ans);
		ans =  Integer.MAX_VALUE;
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