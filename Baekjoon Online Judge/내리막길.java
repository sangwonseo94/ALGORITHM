package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {
	public static int n, m , map[][] , visit[][][] , dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[2][n][m];
		for(int i = 0 ;i < n ; i ++) {
			st=  new StringTokenizer(br.readLine());
			for(int j= 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		int answer = Dfs(0,0);
		System.out.println(answer);
	}
	private static int Dfs(int y, int x) {
		if(y==n-1 && x == m-1) {
			return 1;
		}
		if(visit[1][y][x] < 0) return 0;
		else if(visit[1][y][x] ==0) {
			visit[1][y][x] =1;
			for(int i = 0 ; i < 4 ; i ++) {
				int ny = y+dir[i][0] , nx = x +dir[i][1];
				if(ny>=0&&nx>=0&&ny<n&&nx<m&&map[y][x]>map[ny][nx]) {
					visit[0][y][x] += Dfs(ny,nx);
				}
			}
			return visit[0][y][x];
		} else {
			return visit[0][y][x];
		}
	}
}