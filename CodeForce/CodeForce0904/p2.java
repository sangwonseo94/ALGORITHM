package CodeForce0904;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class p2 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			long answer = Long.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			
			// 둘다 깎는 경우
			if(a-n >= x && b-n>=y && a-n >0 && b-n>0) {
				answer = Math.min((a-n)*b, a*(b-n));
			} else if(a-n>=x && a-n >0 && b-n>0) {
				// 한쪽만 다 깍을 수 있는 경우
				n = n-(b-y);
				answer = (a-n)*y;
				anser = Math.min(anwser, a*(b-n));
			} else if(b-n>=y && a-n >0 && b-n>0) {
				n = n-(a-x);
				answer = (b-n)*x;
			}
			sb.append(answer +"\n");
		}
		

		System.out.println(sb);
	}

}
