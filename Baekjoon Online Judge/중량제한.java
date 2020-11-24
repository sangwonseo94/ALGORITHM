package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 중량제한 {

	public static ArrayList<int[]> node[] ;
	public static int flow,start,end,step=1;
	public static int visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		node =new ArrayList[n];
		visit = new int[n];
		for(int i =0;i<n;i++)node[i] = new ArrayList<>();
		int max = -1;
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			max = max > c ? max : c;
			node[s].add(new int[] {e,c});
			node[e].add(new int[] {s,c});
		}
		st = new StringTokenizer(br.readLine());
		 start = Integer.parseInt(st.nextToken())-1;
		 end = Integer.parseInt(st.nextToken())-1;
		int min = 0;
		int answer = 0;
		while(min <= max) {
			
			 flow = ((min+max)>>1);
			
			if(bfs()) {
				answer = flow;
				min = flow+1;
			} else {
				max = flow-1;
			}
			step++;
			
		}System.out.println(answer);
	}

	private static boolean bfs() {
		// flow로 bfs가 가능한지?
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {start,0});
		visit[start] = step;
		while(!dq.isEmpty()) {
			int [] now = dq.poll();
			int ss = now[0];
			if(ss==end) {
				return true;
			} else {
				for(int i =0;i< node[ss].size();i++) {
					int next = node[ss].get(i)[0];
					int cc =  node[ss].get(i)[1];
					if(flow<= cc && visit[next]< step){
						visit[next]= step;
						dq.add(new int[] {next,cc});
					}
				}
			}
		}
		return false;
	}
}
