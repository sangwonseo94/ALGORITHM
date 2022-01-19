package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13463 {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al[] = new ArrayList[c+1];
		for(int i=1;i<=c;i++) {al[i] = new ArrayList<>();}
		for(int i=0;i<p;i++) {
			st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			al[e].add(s); al[s].add(e);
		}
		int line[] = new int[c+1];
		int count[] = new int[c+1];
		boolean leave[] = new  boolean[c+1];
		for(int i=1;i<=c;i++) {
			line[i] = al[i].size();
		} // count of connected lines
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(l);
		leave[l] = true;
		while(!dq.isEmpty()) {
			int now = dq.poll();
			int size = al[now].size();
			for(int i=0;i<size;i++) {
				int next = al[now].get(i);
				count[next]++;
				if(2*count[next] >=line[next] && !leave[next]) {
					dq.add(next);
					leave[next] = true;
				}
			}
		}
		
		System.out.println(leave[x] ? "leave":"stay");
	}
}
