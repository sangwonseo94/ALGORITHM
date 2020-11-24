package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int num[] = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < w; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		int s = 0;
		int maxidx = 0;
		
		for(int i=1 ; i < w ; i++) {
			if(num[i] >= num[s]) {
				if(i==s+1) {
					s =i;
					continue;
				}
				// i 부터 s 까지
				for(int j = s ; j < i ; j++) {
					answer += (num[s]-num[j]);
					num[j] = num[s];
				}
				s = i;
			}
		}
		
		s = w-1;
		for(int i= w-2; i>=0 ; i--) {
			if(num[i] >= num[s]) {
				if(i==s-1) {
					s =i;
					continue;
				}
				for(int j = s ; j > i ; j--) {
					answer += (num[s]-num[j]);
					num[j] = num[s];
				}
				s = i;
			}
		}
		System.out.println(answer);
	}
}
