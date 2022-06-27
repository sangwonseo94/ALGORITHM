package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

	public static void main(String[] args) throws IOException {
		
		int a = -100;
		int b = -200;
		System.out.println(a-b);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int now= 0;
		int answer=-987654321;
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;) {arr[i] = Integer.parseInt(st.nextToken());++i;}
		for(int i=0;i<N;) {
			if(i<K-1) {
				now+=arr[i];
			} else {
				now+=arr[i];
				answer = answer > now ? answer : now;
				now-=arr[i-K+1];
				
			}
			++i;
		}
		System.out.println(answer);
		 
	}

}
