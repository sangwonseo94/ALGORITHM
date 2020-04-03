package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성수의프로그래밍강좌신청 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int []arr = new int[n]; st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i ++) {arr[i] = Integer.parseInt(st.nextToken());}
			Arrays.sort(arr);
			double ans =0;
			int start = n -k;
			for(;start<n;start++) {
				ans = ( (ans + arr[start]) / 2);
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
		
		
		
	}

}
