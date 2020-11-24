package Codeforce1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c0 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int num0 = 0;
			int num1 = 0;
			char c[] = br.readLine().toCharArray();
			for(int i=0;i<c.length;i++) {
				if(c[i]=='0') {
					num0++;
				} else {
					num1++;
				}
			}
			int answer = c0*num0+c1*num1;
			
			for(int i = num0 , j= num1 ,cnt=0; i >= 0 ; i-- , j++,cnt++) {
				int now = i*c0 + j*c1 + h*cnt;
				answer = answer > now ? now : answer;
			}
			
			for(int i = num1 , j= num0 ,cnt=0; i >= 0 ; i-- , j++,cnt++) {
				int now = i*c1 + j*c0 + h*cnt;
				answer = answer > now ? now : answer;
			}
			
			sb.append(answer +"\n");
		}
		
		System.out.print(sb);
	}

}
