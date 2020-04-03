package 풀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 극한청소작업 {
	public static long arr[] = new long[13]; 
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int  t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		arr[1] = 1; // 한자리에서 나올수 있는 4의 개수
		for(int i=2; i<13;i++) {
			// 점화식 생성 i 자리에서 나오는 4의 개수 저장
			arr[i] = (long) (9*arr[i-1] + Math.pow(10, i-1));
		}
		for(int tc=1 ;tc<= t ;tc++) {
			st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			long sabs = Math.abs(s);
			long eabs = Math.abs(e);
			long answer =0;
			if(s <0 && e > 0) { // 0을 거치는 경우
				 answer =(sabs-compute(sabs))+(eabs-compute(eabs));
				sb.append("#"+tc+" "+(answer-1)+"\n");
			} else {
				if(s > e) { answer = (sabs-compute(sabs)) -(eabs-compute(eabs));
				} else { answer = (eabs-compute(eabs)) - (sabs-compute(sabs)); }
				sb.append("#"+tc+" "+Math.abs(answer)+"\n");
			}
		}System.out.print(sb);
	}

	private static long compute(long abs) {
		// 4가 몇개 뜨는지?
		long re=0;
		while((int)Math.log10(abs) >0) { // 한자리가 될때까지 반복
			int n = (int)Math.log10(abs) ; // 자리수 계산
			int m = (int) ( abs/(Math.pow(10, n))); // 최고차항의 수 계산 
			if(m<4) {
				// 4보다작으면 m만큼 arr[n]값을 가질수있다.
				re += arr[n]*m;
			}else if(m>4){
				// 4보다 크면 m-1만큼 arr[n]을 가지고 10^(n-1)을 한번더 가질수있다.
				// 4는 10^(n-1)을가지니까..
				re +=arr[n]*(m-1);
				re += Math.pow(10, n);
			}
			abs%=(Math.pow(10,n));
		}
		return re = abs>3 ? re+1:re;
	}
}
