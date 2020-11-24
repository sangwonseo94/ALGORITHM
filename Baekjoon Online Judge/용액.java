package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int num[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) num[i] = Integer.parseInt(st.nextToken());
		int s = 0 , e = n-1;
		int answers  = 0 , answere = 0;
		int answer = 2147000000;
		for( ; s< e;) {
			if(Math.abs(num[s] + num[e]) < answer ) {
				answer = Math.abs(num[s] + num[e]);
				answers = s; answere = e;
				continue;
			} 
			if(num[s] + num[e] > 0) {
				e--;
			}  else {
				s++;
			}
		}
		System.out.println(num[answers] + " "+ num[answere]);
	}
	
}
