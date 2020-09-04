package 푼문제;

import java.util.Scanner;

public class ils {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int num[] = new int[n];
		int dp[] = new int[n];
		int ans = 0;
		for(int index= 0; index <n ; index++) {
			num[index] = sc.nextInt();
			dp[index] =1;
		}
		if(n==1) System.out.println(1);
		else {
		for(int i = 1 ; i < n ; i ++) {
			for(int j = 0 ; j <= i ; j++) {
				if(num[j] < num[i]) {
					dp[i] = Math.max(dp[j] +1, dp[i]);
				}
			}
			
			ans = Math.max(ans, dp[i]);
			
		}
		
		System.out.println(ans);
		}
	}

}
