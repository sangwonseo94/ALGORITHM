package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_절댓값힙 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(1,new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			int n = Math.abs(o1);
			int m = Math.abs(o2);
			if( n < m ) {
				return -1;
			}
			else if( n > m) {
				return 1;
			}
			else {
				if( o1 < o2 ) {
					return -1;
				} else if( o1 > o2) {
					return 1;
				}
				else {
					return 0;
				}
			}
			
		}
		});
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
