package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5525 {

	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int Correct = 2*N+1;
		int Sum =0;
		String order = br.readLine();
		int size = order.length();
	    int answer =0;
	    int isContinue = 0;
	    char before;
	    ArrayDeque<Character> dq = new ArrayDeque<>();
	    for(int i=0;i<size;i++) {
			char now = order.charAt(i);
			if(now =='I') {
				if(dq.isEmpty()) {
					dq.add(now);
				} else {
					if(dq.peekLast()=='O') {
						dq.add(now);
					    
					} else {
						dq.clear();
						dq.add(now);
					}
				}
			} else {
				if(!dq.isEmpty()) {
					if(dq.peekLast()=='I') {
						dq.add(now);
					} else {
					    if(dq.peek()==now) {
					    	dq.poll();
					    }
					}
				}
			}
			if(dq.size()==Correct) {
				answer++;
				isContinue++;
			}
		}
		
	}
}
