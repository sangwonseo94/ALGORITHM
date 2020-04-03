package 풀문제;

import java.util.Scanner;

public class swea조합2 {
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
			sb.append("#"+tc+" "+ ((fact[n] * compute((fact[r]*fact[n-r])%p,p-2) )%p) +"\n");
			//1234567889 승..
		}System.out.print(sb);
	}
	// fact[r] * fact[n-r] 의 p -2승 계산..
	private static long compute(long down, int up) {
		if(up==0) return 1;
		if((up&1) == 1) {
			//odd
			long temp = compute(down,up/2);
			return (((temp * temp ) %p)*down)%p;
		}else {
			//even
			long temp = compute(down,up/2);
			return ((temp * temp ) %p);
		}
	}
	
}
