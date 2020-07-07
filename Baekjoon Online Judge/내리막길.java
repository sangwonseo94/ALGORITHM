package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {
	public static int n, m , map[][] , visit[][] , dir[][] = {{1,0},{-1,0},{0,1},{0,-1}} ,rvisit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		rvisit = new int[n][m];
		for(int i = 0 ;i < n ; i ++) {
			st=  new StringTokenizer(br.readLine());
			for(int j= 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Dfs(0,0));
	}
	private static int Dfs(int y, int x) {
		if(visit[y][x] > 0)  return visit[y][x];
		if(y==n-1 && x==n-1) return 1;
		for(int i = 0 ; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >=0 && nx >=0 && nx < m && ny < n) {
				if(map[ny][nx] < map[y][x] && rvisit[ny][nx] ==0) {
					rvisit[ny][nx] =1;
					visit[y][x] += Dfs(ny,nx);
				}
			}
		}
		return visit[y][x];
	}
}
