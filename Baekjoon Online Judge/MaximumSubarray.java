package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarray {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		for(int i=0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int num[] = new int[t];
			st = new StringTokenizer(br.readLine());
			for(int ii=0;ii<t;ii++) {
				num[ii] = Integer.parseInt(st.nextToken());
			}
			int answer = -987654321;
			int dp[] = new int[t];
			dp[0] = num[0];
			for(int ii=1 ; ii<t; ii++) {
				dp[ii] = Math.max(dp[ii-1], 0) + num[ii];
				answer = answer > dp[ii] ? answer : dp[ii];
			}

			answer = answer > dp[0] ? answer : dp[0];
			sb.append(answer+"\n");
		}System.out.println(sb);
	}

}
