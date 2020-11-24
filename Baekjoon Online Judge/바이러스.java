package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int map[][] = new int[n+1][n+1];
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <=n; j++) {
				map[i][j] = 987654321;
			}
		}
		for(int i= 0 ;  i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			map[a][b] =1;
			map[b][a] =1;
		}
		for(int mid = 1 ; mid <= n; mid++) {
			for(int start = 1; start <= n ; start++) {
				for(int end = 1 ; end <=n ; end++) {
					if(map[start][end] > map[start][mid] + map[mid][end]) {
						map[start][end] = map[start][mid] + map[mid][end];
					}
				}
			}
		}
		
		int ans =-1;
		for(int i = 1 ; i <= n ; i++) {
			if(map[1][i] != 987654321) ans++;
		}
		System.out.println(ans);
	}

}
