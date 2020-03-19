package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금속막대 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1 ;tc<=T ;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int map[][] = new int[n][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < map.length; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			int now =0;
			for(int i = 0 ; i < n ; i ++) {
				now = map[i][0];
				int j = 0;
				for(; j < n ; j ++) {
					if(i==j)continue;
					if(now == map[j][1]) {
						break;
					}
				}
				if( j == n) {
					now = i;
					break;
				}
			}
			
			// now가 제일 먼저오는 나사
			System.out.print("#"+tc+" "+map[now][0] +" "+ map[now][1]);
			int start = now;
			boolean visit[] = new boolean[n];
			visit[now] = true;
			while((go(visit))) {
			
				for(int i = 0 ; i < n ; i ++) {
					if(visit[i]) continue;
					if(map[i][0] == map[start][1]) {
						start = i;
						visit[i] = true;
						System.out.print(" "+map[i][0]+" "+map[i][1]);
						continue;
					}
				}
			}
			System.out.println();
		}
	}

	private static boolean go(boolean[] visit) {
		for (boolean b : visit) {
			if(!b) return true;
		}
		return false;
	}

}
