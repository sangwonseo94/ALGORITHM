package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_blackjack {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int card[] = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int index = 0 ; index < n ; index++) {
			card[index] = Integer.parseInt(st2.nextToken());
		}
		
		int ans = 0; int res =0;
		
		for(int i = 0 ; i < card.length ; i++) {
			for(int j = i +1 ; j < card.length ; j++) {
				for(int k = j+1 ; k < card.length ; k++) {
				 res = card[i] + card[j] + card[k];
					if( m - res >= 0 ) {
						ans = Math.max(ans, res);
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
