package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아바바바 {
	static long answer= 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc= 1; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long k =Integer.parseInt(st.nextToken());
			answer = (k/2) * (k/2);
			sb.append("#"+tc + " "+ answer +"\n");
			answer=0;
		}
		System.out.println(sb);
	}

}
