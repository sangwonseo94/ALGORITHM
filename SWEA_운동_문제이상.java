package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_운동_문제이상 {
	static final int max = Integer.MAX_VALUE;
	static int tc,N,M , map[][] ,ans = max;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)  throws Exception{
		
		int cnt =0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tc = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		for (int row[] : map) {
			Arrays.fill(row, max);
		}
		
		for(int index= 0 ; index < M ;index++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
		}
		
		top:
		for(int mid = 1 ; mid <= N ; mid++) {
			for(int start = 1 ; start<= N ; start++) {
				for(int end = 1; end <= N ; end++) {
					if(map[start][mid] != max && map[mid][end] != max) {
						int temp = map[start][mid] + map[mid][end];
						if(map[start][end] >temp) {
							map[start][end] = temp;
						}
						if(start == end) {
							ans = Math.min(ans, map[start][start]);
							cnt++;
							if(cnt == N) break top;
						}
					}		
				}
			}	
		}
		
	
		if(ans != max)System.out.println(ans);
		else System.out.println(-1);
		ans = max;
		
		
		
	}

}
