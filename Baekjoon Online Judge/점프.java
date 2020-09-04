package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken())+1;
		int map[][] = new int[N][N];
		int dp[][] = new int[N][N];
		dp[1][1] =1;
		for(int y = 1 ; y < N ; y++) {
			st = new StringTokenizer(br.readLine());
			for( int x = 1 ; x < N ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int y = 1 ; y < N ; y++) {
			for(int x = 1 ; x < N ; x++) {
				if(dp[y][x]==0 || (x==N-1 && y == N-1)) continue;
				
				if(y+map[y][x] <N)dp[y+map[y][x]][x]++;
				if(x+map[y][x] <N)dp[y][x+map[y][x]]++;
				
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}
}
