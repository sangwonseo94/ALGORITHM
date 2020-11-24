package CodeForce0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			long answer=0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<n;i++) {arr[i] = Integer.parseInt(st.nextToken());}
			long cnt = 0 , sum=0;
			for(int i = 0 ; i < n ; i++) {
				int now = arr[i];
				if(sum==0&& now<0) {
					cnt += (-now);
					continue;
				}
				if(sum >=0 && now >=0) {
					sum+= now;
				} else if(sum >=0 && now<0){
					if(sum+now >0) {
						sum+=now;
					} else {
						cnt += -(sum+now);
						sum=0;
					}
				}
			}sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

}
