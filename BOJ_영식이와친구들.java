package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_영식이와친구들 {
	static int N,M,L,answer =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 L = Integer.parseInt(st.nextToken());
		
		int count[] = new int[N+1];
		int seat[] = new int[N+1];
		for(int index = 1; index <= N; index++) {
			seat[index] = index;
		}
		int order =1;
		
		while(check(count)) {
			
			count[order]++;
			
			if(count[order]/2 ==0) {
				//짝수
				if((order - L) >=1) {
					order -=L;
				}
				else {
					order = ( order - L) +N;
				}
			}
			else {
				//홀수 
				if((order + L)%(N) == 0) {
					order = N;
				}
				else {
					order = (order + L)%(N);
				}
			}
			answer++;
		}
		System.out.println(answer-1);
	}

	private static boolean check(int[] count) {
		for (int i : count) {
			if(i == M) return false;
		}
		return true;
	}
}
