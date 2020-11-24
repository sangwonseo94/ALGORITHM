package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i = 1 ;i <= n ; i++) dq.add(i);
		ArrayList<Integer> answer = new ArrayList<>();
		while(!dq.isEmpty()) {
			for(int i = 1 ; i < k ;i++) {
				int head = dq.poll();
				dq.add(head);
			}
			answer.add(dq.poll());
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0 ; i < n-1; i++) {
			sb.append(answer.get(i)+", ");
		}
		sb.append(answer.get(n-1)+">");
		System.out.println(sb);
	}

}
