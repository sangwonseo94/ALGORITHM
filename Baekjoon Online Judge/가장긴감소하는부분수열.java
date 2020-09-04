package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int arr[] = new int[t];
		int dp[] = new int[t];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < t ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		for(int i = 0 ; i < t ; i ++) {
			for(int j = 0 ; j < i ; j++) {
				if(arr[j] > arr[i]) {
					
				}
			}
		}
	
	}

}
