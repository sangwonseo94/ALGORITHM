package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n+1]; st= new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
			arr[i+1] +=arr[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e =Integer.parseInt(st.nextToken());
			if ( s > e) {
				int t = s;
				s = e;
				e = t;
			}
			sb.append(arr[e]-arr[s-1]+"\n");
		}System.out.println(sb);
	}

}
