package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knapsack {
	public static int dp[][],N,K;
	public static int[] value;
	public static int[] volumn;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc<= T ;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			dp = new int[K+1][N+1]; // n번째 최대가치를 저장
			value = new int[N+1];
			volumn = new int[N+1];
			for(int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine());
				volumn[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			dfs(K,N);
			System.out.println("#"+tc+" "+dp[K][N]);
		}
	}
	public static int dfs(int spare_weight, int num) {
		if(dp[spare_weight][num] > 0) {
			//System.out.println( spare_weight +" 남고" + num +" 인덱스" +" 에서 dp 실행");
			return dp[spare_weight][num];
		}
		if(spare_weight == 0 || num==0) {
			return dp[spare_weight][num] = 0;
		}
		else {
			int c1=0,c2=0;
			if(spare_weight >= volumn[num]) {
				// 뺼수 있다.
				c1 = dfs(spare_weight-volumn[num],num-1)+value[num];
			}
			c2 = dfs(spare_weight,num-1);
			return dp[spare_weight][num]  = Math.max(c1, c2);
		}
		
		
		
	}

}
