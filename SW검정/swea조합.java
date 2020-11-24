package 풀문제;

import java.util.Scanner;

public class swea조합 {
	static final int p = 1234567891;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); StringBuilder sb= new StringBuilder();
		for(int tc=1; tc<=t;tc++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			long fact[] = new long[n+1];
			fact[0]=1;
			for(int i = 1 ; i <= n ; i ++) {fact[i] = (fact[i-1] * i) % p;}
			sb.append("#"+tc+" "+ (fact[n] / ((fact[r]*fact[n-r])%p) +"\n"));
			//1234567889 승..
		}System.out.print(sb);
	}
}
