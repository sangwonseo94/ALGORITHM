package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 현주가좋아하는제곱근놀이2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=t ; tc++) {
			long n = sc.nextLong();
			long ans =0;
			while( n !=2) {
				double k =(long)Math.sqrt(n);
				if(n-(k*k) !=0) {
					k = (long) k +1;
					ans += (k*k)-n;
					n = (long) (k*k);
				}
				else {
					n = (long)Math.sqrt(n);
					ans++;
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}System.out.print(sb);
	}
}
