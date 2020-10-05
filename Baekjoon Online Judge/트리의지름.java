package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름 {

	public static ArrayList<int[]> node[];
	public static boolean visit[][];
	public static int answer=-1, answeri=-1;
	
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		node = new ArrayList[t+1];
		visit = new boolean[t+1][t+1];
		for (int i = 1 ; i <=t ; i++) node[i] = new ArrayList<>();
		String lines;
		while( null !=(lines=br.readLine())){
			try {
				st = new StringTokenizer(lines);
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				node[s].add(new int[] {e,w});
				node[e].add(new int[] {s,w});
			}catch (Exception e) {
				break;
			}
		}

		System.out.println("12");
		DFS(1,0);
		visit = new boolean[t+1][t+1];
		DFS(answeri,0);
		System.out.println(answer);
		
	}

	private static void DFS(int x, int total) {
		if(node[x].size() == 1) {
			// is leaf
			if(answer < total) {
				answer = total;
				answeri = x;
			}
			return;
		}
		for(int i = 0 ; i < node[x].size(); i++) {
			int n = node[x].get(i)[0];
			int c = node[x].get(i)[1];
			if(!visit[x][n]) {
				visit[x][n] = true;
				visit[n][x] = true;
				DFS(n,total+c);
			}
		}
	}

}
