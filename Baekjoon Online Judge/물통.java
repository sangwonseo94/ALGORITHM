package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 물통 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		boolean visit[] = new boolean[201];
		visit[c] = true;
		dq.add(new int[] {0,0,c});
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			
			if(now[0]!=0) {
				
			} else if(now[1] !=0) {
				
			} else if(now[2] !=0) {
				
			}
			
			
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i < 201 ;i++) {
			if(visit[i]) sb.append(i+" ");
		}System.out.println(sb);
	}
}
