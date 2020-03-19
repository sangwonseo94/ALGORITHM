package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달리기 {
	static int n,m;
	static int []needs;
	static long dp[],ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			needs = new int [n];
			dp = new long[(1<<n)];
			for(int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				needs[Integer.parseInt(st.nextToken())-1] |= (1<< (Integer.parseInt(st.nextToken())-1));
			}
			ans = dfs(0);
			sb.append("#"+tc+" "+ans+'\n');
			
		}
		System.out.println(sb);
	}
	private static long dfs(int flag) {
		if(dp[flag] > 0) {
			return dp[flag];
		}
		else if( flag == (1<<n)-1) {
			return 1;
		}
		else {
			for(int i = 0 ; i < n ; i ++) {
				if((flag & (1<<i)) == 0 && (flag & needs[i]) == needs[i]) {
					dp[flag] +=dfs(flag | (1<<i));
				}
			}
		}
		return dp[flag];
	}

}
