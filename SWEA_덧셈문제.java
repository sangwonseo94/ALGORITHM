package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_덧셈문제 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc= 1; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			long n = Integer.parseInt(st.nextToken());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long answer =0;
			if( a > b)answer =0 ;
			else if( a != b && n ==1) answer =0;
			else if (a==b &&  n !=1 ) answer =0;
			else if( a== b && n ==1) answer =1;
			else {
				
				answer =(n-2)*b - (n-2)*a +1;
				
			}
			sb.append("#"+tc+" "+answer+"\n");
			
		}
		System.out.println(sb);
	}

}
