package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 휴게소세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int num[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		int dist[] = new int[n+1];
		int distmax = -1;
		int distmin = 1001;
		for(int i = 0 ; i < n ; i ++) {
			if(i == 0) {
				dist[0] = num[0];
				distmax = distmax > dist[0] ? distmax : dist[0];
				distmin = distmin < dist[0] ? distmin : dist[0];
 			} else {
				dist[i] = num[i] - num [i-1];
				distmax = distmax > dist[i] ? distmax : dist[i];
				distmin = distmin < dist[i] ? distmin : dist[i];
			}
		}
		dist[n] = l-num[n-1];
		distmax = distmax > dist[n] ? distmax : dist[n];
		distmin = distmin < dist[n] ? distmin : dist[n];
		int answer = 0;
		for(int i = distmin ; i <= distmax ; i++) {
			int cnt = 0;
			boolean impossible = false;
			for(int j = 0 ; j <= n ; j++) {
				int number = dist[j];
				if(number <= i ) continue;
				if(number%i!=0) {
					cnt += (number/i);
				} else {
					cnt += (number/i)-1;
				}
				if(cnt >m) {
					impossible = true;
					break;
				} 
			}
			if(!impossible) {
				answer =i;
				break;
			}
		}
		System.out.println(answer);
	
	}

}
