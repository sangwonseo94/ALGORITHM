package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_수열의합_미해결 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int res =0; int order =0;
		// 이동합 
		
		for(int window_size = L ; window_size < 100 ; window_size++) {
			res =0;
			int moving_cell =0;
			
			for(int i = 1; i < window_size +1 ; i ++) {
				moving_cell +=i;
			}
			
			for(; moving_cell <= N ;moving_cell +=window_size) {
				res++;
				
			}
			if(moving_cell == (N +window_size)) {
				order =window_size;
				break;
			}
			
		}
		
		if(order == 0) {
			System.out.println(-1);
		}
		else {
			for(int index = 0 ; index < order ; index++) {
				System.out.print(res + " ");
				res++;
			}
		}
		
	}

}
