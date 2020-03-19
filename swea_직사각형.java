package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_���簢�� {
	static int answer= 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc= 1 ; tc<=t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			if(a1==a2 && a2==a3) answer = a1;
			else if( a1 == a2 && a1 != a3) answer = a3;
			else if( a2 == a3 && a1 != a2) answer = a1;
			else if(a1 == a3 && a1 != a2) answer =a2;
			
			sb.append("#"+tc+" "+answer+"\n");
			answer =0;
		}
		System.out.println(sb);
	}

}
