package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다항식계산 {
	public final static long P =998244353;
	public static int[][] info;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			info = new int[n+1][3];
			for(int i = 0 ; i < n-1; i++) {
				st = new StringTokenizer(br.readLine());
				info[i+2][0] = Integer.parseInt(st.nextToken());
				info[i+2][1] = Integer.parseInt(st.nextToken());
				info[i+2][2] = Integer.parseInt(st.nextToken());
			}
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < m ; i++) {
				int x = Integer.parseInt(st.nextToken());
				long dp[] = new long[n+1];
				dp[0] = 1; dp[1] = (x%P);
				for(int j = 2 ; j < n+1;j++) {
					if(info[j][0]==1) {
						dp[j] = ((dp[info[j][1]] + dp[info[j][2]])%P);
					} else if(info[j][0]==2) {
						dp[j] = ((info[j][1] * dp[info[j][2]])%P);
					} else if(info[j][0]==3) {
						dp[j] = ((dp[info[j][1]]* dp[info[j][2]])%P);
					}
				}
				sb.append(dp[n]%P+" ");
			}sb.append("\n");
		}System.out.print(sb);
	}	
}
