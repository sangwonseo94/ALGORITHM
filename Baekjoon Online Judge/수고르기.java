package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int num[]= new int[n];
		int answer = 2147000000;
		for(int i = 0 ; i < n ; i++) {
			st= new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int i = 0 , ii = 0;
		for( ; ii < n && i < n ; ) {
			if(num[ii] - num[i] >= m ) {
				answer = answer > num[ii] - num[i] ? num[ii] - num[i] : answer; 
				i++;
			}
			else ii++;
		}
		System.out.println(answer);
	}

}
