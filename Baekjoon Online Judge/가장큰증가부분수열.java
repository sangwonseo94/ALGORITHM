package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int arr[] = new int[t];
		int max[] = new int[t];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < t ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max[i] =arr[i];
		}
		int answer = -1;
		for(int i = 0 ; i < t ; i++) {
			for(int j = i +1 ; j < t ; j++) {
				if(arr[i] < arr[j]) {
					if(max[j] < max[i] + arr[j]) {
						max[j] = max[i] + arr[j];
					}
				}
			}
			answer = answer > max[i] ? answer : max[i];
		}System.out.println(answer);
		
	}

}
