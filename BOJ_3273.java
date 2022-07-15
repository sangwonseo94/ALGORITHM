package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for(int i=0;i<N;) {
			arr[i] = Integer.parseInt(st.nextToken());
			++i;
		}
		
		Arrays.sort(arr);
		
		int Target = Integer.parseInt(br.readLine());
		
		int s = 0 ;
		int e = N-1;
		int answer = 0;
		while(s<e) {
			
			int now = arr[s] + arr[e];
			if(now == Target) {
				answer++;
				s++;
				continue;
			} else if(now >Target) {
				e--;
			
			} else {
				s++;
			}
		}
		System.out.println(answer);
		
	}

}
