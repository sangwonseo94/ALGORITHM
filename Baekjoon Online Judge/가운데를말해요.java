package 풀문제2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
public class 가운데를말해요 {

	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int now = Integer.parseInt(br.readLine());
			pq.add(now);
			int size = pq.size();
			if( (size&1) == 0) {size = ( size >>1)-1;}
			else {size = (size>>1);	}
			for(int j = 0 ; j < size ; j++) {dq.add(pq.poll());}
			int mid = pq.peek();
			sb.append(mid +"\n");
			while(!dq.isEmpty()) {pq.add(dq.poll());}
		}System.out.print(sb);
	}
}
