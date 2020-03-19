package 푼문제;

import java.util.Scanner;

public class ī�屸���ϱ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n+1];
		int[] dp = new int[n+1];
		for(int index = 1 ; index <= n ; index++) {
			
			num[index] = sc.nextInt();
		}
		dp[1] = num[1];
		int ans =0;
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + num[j]);
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);

	}

}
