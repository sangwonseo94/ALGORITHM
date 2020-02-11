package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_벽부수고이동하기 {
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int n,m;
	static int map[][];
	static boolean visit[][];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in ));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int y = 0 ; y < n ; y++) {
			char str[] = br.readLine().trim().toCharArray();
			for(int x= 0 ; x < m ; x++) {
				map[y][x] = str[x] -'0';
			}
		}
		boolean breakOr= false;
		visit[0][0]= true;
		Dfs(0,0,1,breakOr);
		System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
	}
	public static void Dfs(int y, int x, int len, boolean breakOr) {
		if(y == n-1 && x == m-1) {
			ans = Math.min(ans, len);
			return;
		}
		for(int index = 0 ; index <4 ; index++) {
			int ny = y + dy[index];
			int nx = x + dx[index];
			if(ny >= 0 && nx >=0 && nx < m && ny < n) {
				if(!visit[ny][nx] && map[ny][nx] ==0) {
					visit[ny][nx] = true;
					Dfs(ny,nx,len+1,breakOr);
					visit[ny][nx] = false;
				}
				else if(!visit[ny][nx] && !breakOr && map[ny][nx] == 1) {
					breakOr = true;
					visit[ny][nx] = true;
					Dfs(ny,nx,len+1,breakOr);
					visit[ny][nx] = false;
					breakOr = false;
				}
			}
		}
	}
}
