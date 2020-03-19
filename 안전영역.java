package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �������� {
	static int map[][];
	static int max_h = Integer.MIN_VALUE;
	static int n;
	static int copy[][];
	static boolean visit[][];
	static int ans=0;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		for(int y = 0 ; y< n ; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x= 0; x<n ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				max_h = Math.max(map[y][x], max_h);
			}
		}
		max_h+=1;
		copy = new int[n][n];
		visit = new boolean[n][n];
	}
	public static void main(String[] args) throws Exception{
		input();
		for(int h = 0 ; h < max_h; h++) {
			copy_map(h);
			int cnt=0;
			for(int y= 0 ; y < n ; y++) {
				for(int x = 0; x < n ;x++) {
					if(!visit[y][x] && copy[y][x] ==0) {
						visit[y][x] = true;
						dfs(y,x);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
			for(int y= 0 ; y < n ; y++) {
				for(int x = 0 ; x< n ; x++) {
					visit[y][x] = false;
					copy[y][x] = 0;
				}
			}
		}
		System.out.println(ans);
	}
	public static void copy_map(int h) {
		for(int y = 0 ; y < n ; y++) {
			for(int x= 0 ; x< n ; x++) {
				if(map[y][x] <= h) copy[y][x] = 1;
			}
		}
	}
	public static void dfs(int y, int x) {
		
		for(int index = 0 ; index < 4 ; index++) {
			int nx = dx[index] + x;
			int ny = dy[index] + y;
			if(nx >= 0 && ny >= 0 && nx <n && ny <n) {
				if(copy[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx]= true;
					dfs(ny,nx);
				}
			}
		}
		
	}
}
