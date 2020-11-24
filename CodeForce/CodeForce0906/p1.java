package CodeForce0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st= new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n; i++)arr[i] = Integer.parseInt(st.nextToken());
			for(int i = n-1 ; i>=0; i--) {
			sb.append(arr[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
