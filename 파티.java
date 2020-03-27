package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파티 {
	// 플로이드워셜
	// 모든 최단거리중 가장 많이 시간을 소비하는 사람 출력
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n+1][n+1];
		for(int i= 1 ; i <=n ; i++) {
			for(int j = 1 ; j <=n ; j ++) {
				map[i][j] =987654321;
			}
			map[i][i] =0;
		}
		for(int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		for(int mid = 1 ; mid <= n ;mid++) {
			for(int start =1 ; start <=n ; start++) {
				for(int end=1; end<=n ; end++) {
					{
						if(map[start][end] > map[start][mid] + map[mid][end]) {
							map[start][end] = map[start][mid] + map[mid][end];
						}
					}
				}
			}
		}
		int ans = -1;
		
		for(int i= 1 ; i <=n ; i++) {
			for(int j =1 ; j <=n ; j++) {
				System.out.print(map[i][j] +" ");
			}System.out.println();
		}
		System.out.println(ans);
		
	}
}
