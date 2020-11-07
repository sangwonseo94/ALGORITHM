package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기상청인턴신현수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer =0;
		for(int i=0;i<k;i++) {
			answer +=arr[i];
		}
		int result = answer;
		for(int s =k ;s < n ; s++) {
			answer +=arr[s];
			answer -=arr[s-k];
			result = result > answer ? result : answer;
		}
		if ( n==k) result = answer;
		System.out.println(result);
	}

}
