package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> node[] = new ArrayList[n+1];
		for(int i= 1 ; i<= n ; i++) {
			node[i] = new ArrayList<>();
		}
		int degree[] = new int[n+1];
		for(int i =0;  i < m ; i ++) {
			st=new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			node[s].add(e);
			degree[e] +=1;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		for(int i=1 ; i <=n;i++) {
			if(degree[i]==0) {
				pq.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			
			int now = pq.poll();
			sb.append(now +" ");
			
			int size = node[now].size();
			for(int i=0 ;i<size; i++) {
				int next = node[now].get(i);
				degree[next]--;
				if(degree[next]==0) {
					pq.add(next);
				}
			}
		}
		System.out.println(sb);
		
	}

}
