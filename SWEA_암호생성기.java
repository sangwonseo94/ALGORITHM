package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = 2;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index < 8 ; index++) dq.add(Integer.parseInt(st.nextToken()));
			
			while(true) {
				
				int now = dq.poll();
				
				if(now-1 <= 0) break;
				dq.add(now-1);
				now = dq.poll();
				if(now-2 <= 0) break;
				dq.add(now-2);
				now = dq.poll();
				if(now-3 <= 0) break;
				dq.add(now-3);
				now = dq.poll();
				if(now-4 <= 0) break;
				dq.add(now-4);
				now = dq.poll();
				if(now-5 <= 0) break;
				dq.add(now-5);
			}
			dq.add(0);
			System.out.print("#" + test_case+" ");
			while(!dq.isEmpty()) {
				System.out.println(dq.poll() +" ");
			}
		}
	}
}