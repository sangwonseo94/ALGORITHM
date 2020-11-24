package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_디저트까페 {
	static int n = 0;
	static int res = -1;
	static int map[][];
	static int diry[] = {1 , 1,-1,-1};
	static int dirx[] = {1 , -1,-1,1};
	static int startx , starty;
	static ArrayList<Integer> m = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc= 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for(int y= 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0 ; x < n ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int y = 0 ; y < n ; y++) {
				for(int x= 0 ; x < n ; x++) {
					
					starty = y;
					startx = x;
					m.add(map[y][x]);
					DFS(0,y,x,1);
					m.clear();
				}
			}
			
			sb.append("#"+tc+" "+ res +"\n");
			res = -1;
		}
		System.out.println(sb);
	}
	public static void DFS(int dir,int y,int x, int cnt) {
		int ny = y + diry[dir];
		int nx = x + dirx[dir];
		if( dir == 3 && ny == starty && nx == startx) {
			res = res > cnt ? res : cnt;
			return;
		} 
		if(ny >= 0 && nx >= 0 && nx <  n && ny < n && !m.contains(map[ny][nx])){
			m.add(map[ny][nx]);
			DFS(dir,ny,nx,cnt+1);
			m.remove(m.size()-1);
		}
		
		ny = y + diry[(dir+1)%4];
		nx = x + dirx[(dir+1)%4];
		if( dir == 3 && ny == starty && nx == startx) {
			res = res > cnt ? res : cnt;
			return;
		} 
		if(ny >= 0 && nx >= 0 && nx < n && ny < n && !m.contains(map[ny][nx])){
			m.add(map[ny][nx]);
			DFS((dir+1)%4, ny,nx,cnt+1);
			m.remove(m.size()-1);
		}
	}

}
