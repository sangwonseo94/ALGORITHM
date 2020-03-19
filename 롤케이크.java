package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ������ũ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int L_list [] = new int [L+1];
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int answer =0; int res = 0; int i =0; int j =0;
		for(int index = 0 ; index < n ; index++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int count = 0; 
			if( answer < end - start) {
				answer = end - start;
				j = index+1;
			}
			for( ;start <= end; start++) {
				if(L_list[start] == 0) {
					L_list[start] = index +1;
					count++;
				}
				
			}
			if(res < count ) {
				i = index + 1;
				res = count;
			}
			
		}
		System.out.println(j);
		System.out.println(i);
	}

}
