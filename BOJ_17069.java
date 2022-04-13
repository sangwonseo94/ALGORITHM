package algorithm_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N+1][N+1];
		long memo[][][] = new long[N+1][N+1][3];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memo[1][2][0] =1;
		
		for(int i=1;i<=N;i++) {
			for(int j=2;j<=N;j++) {
				if((map[i][j]&1)==0) {
					memo[i][j][0] +=memo[i][j-1][1];
					memo[i][j][0] +=memo[i][j-1][0];
	
					if((map[i][j-1]&1)==0 && (map[i-1][j]&1)==0){
						memo[i][j][1] +=memo[i-1][j-1][0];
						memo[i][j][1] +=memo[i-1][j-1][1];
						memo[i][j][1] +=memo[i-1][j-1][2];
					}
	
					memo[i][j][2] +=memo[i-1][j][2];
					memo[i][j][2] +=memo[i-1][j][1];
				}
			}
		}
		System.out.println(memo[N][N][0]+memo[N][N][1]+memo[N][N][2]);
	}
	public static boolean inrange(int y,int x,int n) {
		return y>=1&&x>=1&&y<=n&&x<=n;
	}
}
