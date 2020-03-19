package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 초등학생 {
	static int N,num[];
	static int dp[][] = new int[100][21];	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1 ; tc<= T ; tc++) {
			N = sc.nextInt();
			num = new int[N];
			for(int y = 0; y < 100 ; y++) {
				for(int x = 0 ; x < 21 ; x++) {
					dp[y][x] = -1;
				}
			}
			for(int index = 0 ; index < N ; index++){ num[index] = sc.nextInt();}
			System.out.print("#"+tc +" "+dfs(num[0], 0)+"\n");
			
			//sb.append("#"+tc +" "+res+"\n");
		}
		//System.out.print(sb);
		
	}
	public static int dfs(int number, int index) {
		if(dp[index][number] >=0) return dp[index][number];
		if(index == (N-2)) {
			if(number == num[N-1]) {	
				dp[index][number] = 1;
				
			}
			else dp[index][number]=0;
			return dp[index][number];
		}
		int s= 0;
		if(( number+num[index+1]) <= 20) { s = (int)(((long)s +(long)dfs( number+num[index+1] ,  index+1 ))%1234567891);}
		if(( number-num[index+1]) >= 0)  { s = (int)(((long)s +(long)dfs( number-num[index+1] ,  index+1 ))%1234567891);}
		return dp[index][number] =s ;
	}
}
