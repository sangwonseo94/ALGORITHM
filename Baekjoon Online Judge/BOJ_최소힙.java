package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_최소힙 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(1,(Integer num1 , Integer num2)-> num1 < num2 ? -1 : 1);
		for(int index = 0 ; index < n ; index++) {
			st = new StringTokenizer(br.readLine());
			int  k = Integer.parseInt(st.nextToken());
			if( pq.isEmpty() && k ==0) {
				System.out.println(0);
			}
			else if( k != 0 ) {
				pq.add(k);
			}
			else if ( k == 0) {
				System.out.println(pq.poll());
			}
			
		}
	}

}
