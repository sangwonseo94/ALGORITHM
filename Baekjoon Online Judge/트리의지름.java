import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<int []> node[] = new ArrayList[n];
		for(int i=0;i<n;i++) node[i] = new ArrayList<>();
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			node[s].add(new int[] {e,c});
			node[e].add(new int[] {s,c});
		}
		
		int s = 0;
		int cost[] = new int[n];
		boolean visit[] = new boolean[n];
		
		cost[s] = 0; visit[s] = true;
		ArrayDeque<int []> dq = new ArrayDeque<>();
		dq.add(new int[] {s,0});
		while(!dq.isEmpty()) {
			int [] now = dq.poll();
			for(int i=0; i< node[now[0]].size() ; i++) {
				int next[] = node[now[0]].get(i);
				if(!visit[next[0]]) {
					visit[next[0]] = true;
					cost[next[0]] = now[1] + next[1];
					dq.add(new int[] {next[0], now[1]+ next[1]});
					
				}
			}
		}

		int max_idx = -1;
		int max_val = -1;
		
		for(int i=0;i<n;i++) {
			if(cost[i] > max_val) {
				max_val = cost[i];
				max_idx =i;
			}
		}
		
		cost = new int[n];
		visit = new boolean[n];
		
		cost[max_idx] = 0; visit[max_idx] = true;
		
		dq.add(new int[] {max_idx,0});
		while(!dq.isEmpty()) {
			int [] now = dq.poll();
			for(int i=0; i< node[now[0]].size() ; i++) {
				int next[] = node[now[0]].get(i);
				if(!visit[next[0]]) {
					visit[next[0]] = true;
					cost[next[0]] = now[1] + next[1];
					dq.add(new int[] {next[0], now[1]+ next[1]});
					
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(cost[i] > max_val) {
				max_val = cost[i];
				max_idx =i;
			}
		}
		System.out.println(max_val);
	}
}
