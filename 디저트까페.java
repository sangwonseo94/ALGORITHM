package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 디저트까페 {
	static int answer = 0,n;
	static int dir[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/ans/디저트까페.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc= 1 ; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			 n = Integer.parseInt(st.nextToken());
			int map[][] = new int[n][n];
			boolean visit[][] = new boolean[n][n];
			for(int y = 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0 ; x< n ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			ArrayList<Integer> Visited_Menu = new ArrayList<>();
			for(int y= 0  ; y < n ; y++) {
				for(int x = 0 ; x < n ; x++) {
					if( (y==0 && x ==0) || (y ==0 && x == (n-1))|| (x == (n-1) && y==(n-1) ) || (x == 0 && y ==(n-1))) continue;
					// 돌아올수 없는 경우가 아니라면,
					Visited_Menu.add(map[y][x]);
					DFS(y,x,y,x,map,visit,0,Visited_Menu,0);
					Visited_Menu.clear();
				}
			}
			sb.append("#"+ tc + " " + answer+ "\n");
			answer =0;
		}
		System.out.println(sb);
	}
	public static void DFS(int y, int x, int starty, int startx ,int[][] map, boolean[][] visit , int res, ArrayList<Integer> visited_Menu , int direction) {
		if( y == starty && x == startx && visited_Menu.size()!=1) {
			answer = Math.max(answer, res);
			return;
		}
		
		int ny = y + dir[direction][0];
		int nx = x + dir[direction][1];
		if(ny < 0 || nx < 0 || ny >=n || nx >=n) {
			ny = y + dir[(direction+1) % 4][0];
			nx = x + dir[(direction+1) % 4][1];
			
			int size = visited_Menu.size();
			for(int index = 0 ; index < size ; index++) {
				if(visited_Menu.get(index) == map[ny][nx]) {
					return;
				}
			}
			visited_Menu.add(map[ny][nx]);
			visit[ny][nx] = true;
			System.out.println(ny + " " + nx);
			DFS(ny,nx,starty,startx,map,visit,res+1,visited_Menu, (direction+1) % 4);
			visit[ny][nx] = false;
			visited_Menu.remove(size -1);
		}
		else {
			// 왔던 방향 그대로 경로 진행
			if(!visit[ny][nx]) {
				int size = visited_Menu.size();
				for(int index = 0 ; index < size ; index++) {
					if(visited_Menu.get(index) == map[ny][nx]) {
						return;
					}
				}
				visited_Menu.add(map[ny][nx]);
				visit[ny][nx] = true;
				System.out.println(ny + " " + nx);
				DFS(ny,nx,starty,startx,map,visit,res+1,visited_Menu, direction);
				visit[ny][nx] = false;
				visited_Menu.remove(size -1);
		
			}
		}
		
	}

}
