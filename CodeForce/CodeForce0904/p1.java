package CodeForce0904;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class p1 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int answer = 0;
			int diff = Math.abs(b-a);
			if(diff==0) answer = 0;
			else if(diff<=10) answer = 1;
			else {
				int s = diff/10;
				answer = s;
				if(diff%10 !=0)answer++;
			}
			sb.append(answer+"\n");
				
		}
		

		System.out.println(sb);
	}

}
