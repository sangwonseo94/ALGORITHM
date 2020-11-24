package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int n =Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push")) {
				dq.add(Integer.parseInt(st.nextToken()));
			} else if(order.equals("front")) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.peekFirst()+"\n");
			} else if(order.equals("back")) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.peekLast()+"\n");
			} else if(order.equals("empty")) {
				if(dq.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			} else if(order.equals("size")) {
				sb.append(dq.size()+"\n");
			} else if(order.equals("pop")) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.poll()+"\n");
			}
				
		} System.out.println(sb);
		
	}
}
