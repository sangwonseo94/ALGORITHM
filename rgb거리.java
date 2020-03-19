package 푼문제;

import java.util.Scanner;

public class rgb�Ÿ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int map[][] = new int[n][3];
		for(int index=0; index < n ; index++) {
			for(int in =0 ; in < 3 ; in ++) {
				
				map[index][in] = sc.nextInt();
				
			}
		}
		int dp[][] = new int[1001][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for(int index =1; index < n ; index ++) {
			
			dp[index][0] += (map[index][0] +Math.min(dp[index-1][1], dp[index-1][2])); 
			dp[index][1] += (map[index][1] + Math.min(dp[index-1][0], dp[index-1][2]));
			dp[index][2] += (map[index][2] +Math.min(dp[index-1][0], dp[index-1][1]));
			
		}
		
		System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
		
	}
}
