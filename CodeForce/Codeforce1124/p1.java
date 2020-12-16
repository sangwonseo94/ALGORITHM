package Codeforce1124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i < t ; i ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int num[] = new int[n];
			for(int j =0 ; j < n ; j++) {
				num[j] = (n-j);
			}
			if(n!=2) {
				int tt = num[n>>1];
				num[(n>>1)] = num[0];
				num[0] = tt;
			}
			for(int j=0;j<n;j++)sb.append(num[j]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
