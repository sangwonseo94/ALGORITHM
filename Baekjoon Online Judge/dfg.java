package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class dfg {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); String temp;
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				 if (o1.length() == o2.length()) {
	                    return o1.compareTo(o2);
	                } else {
	                    return o1.length() - o2.length();
	                }}
		});
		for(int tc=1; tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int index = 0 ; index < n ; index++) {pq.add(br.readLine().trim());}
			System.out.print("#"+tc+"\n");
			String before ="";
			while(!pq.isEmpty()){
				String now = pq.poll();
				if(now.equals(before))continue;
				System.out.print(now+"\n");
				before = now;
			}
		}
		//System.out.print(sb);
	}

}
