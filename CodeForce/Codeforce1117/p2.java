package Codeforce1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int num[] = new int[n*k];
			st = new StringTokenizer(br.readLine());
			for(int i=0 ; i < n*k ; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int res = 0;
			int step = (int) Math.ceil(n>>1);
			for(int i = (n*k-1)-step, j = k; j >0 ; i-=(step+1) , j--) {
				res +=num[i];
			}
			sb.append(res+"\n");
		}
		
		System.out.print(sb);
	}

}
