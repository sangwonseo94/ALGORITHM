import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class 결혼식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<int[]> map[] = new ArrayList[n]; for(int i = 0 ; i < n ; i ++) map[i] = new ArrayList<>();
		boolean visit[] = new boolean[n];
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for(int i= 0 ;i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			map[s].add(new int[] {e,0});
			map[e].add(new int[] {s,0});
		}
		visit[0] = true;
		ArrayDeque<int []> dq = new ArrayDeque<>();
		dq.add(new int[] {0,0});
		int answer = 0;
		while(!dq.isEmpty()) {
			int[] now = dq.poll();
			int nowpos = now[0];
			int nowcnt = now[1];
			if(nowcnt>1) continue;
			int size  =map[nowpos].size();
			for(int i =0 ; i <size ; i++) {
				int next[] = map[nowpos].get(i);
				if(!visit[next[0]]) {
					answer++;
					visit[next[0]] = true;
					dq.add(new int[] {next[0] , nowcnt+1});
				}
			}
		}
		if(answer == 0) System.out.println(0);
		else System.out.println(answer);
	}
}
