 package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합 {
	static long a,b,ans;
	static long deci[] = new long[15];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc= 1 ; tc<= T ;tc++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			deci[0] = (long) 45;
			for(int index = 1 ; index < 15; index++) {
				deci[index] = (long)Math.pow(10, index)*45 + (long)10*deci[index-1];
			}
			sb.append("#"+tc+" "+(compute(b)-compute(a-1))+"\n");
			
		}
		System.out.print(sb);
	}
	private static long compute(long num) {
		ans = 0;
		
		
		return ans;
	}
}
