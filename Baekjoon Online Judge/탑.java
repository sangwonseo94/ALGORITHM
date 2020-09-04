package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n+1];
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i <= n ; i++) {
			if(s.isEmpty()) {
				sb.append(0+" ");
				s.add(i);
			} else {
				int now = arr[i];
				if(arr[s.peek()] > now) {
					sb.append(s.peek()+" ");
					s.add(i);
				} else {
					while(!s.isEmpty() && arr[s.peek()] < now) {
						s.pop();
					}
					if(s.isEmpty()) {
						sb.append(0+" ");
						s.add(i);
					} else {
						sb.append(s.peek()+" ");
						s.add(i);
					}
				}
			}
		} System.out.println(sb);
	}

}
