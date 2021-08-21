package 알고리즘잘하고싶다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 스타트링크 {

	public static void main(String[] args) throws IOException {
		String stair = "use the stairs";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		ArrayDeque<int []> dq = new ArrayDeque<>();
		// int [] = 0 번째에는 내위치, 1번째에는 횟수 
		boolean visit[] = new boolean[f+1];
		int answer = -1;
		visit[s] = true;
		dq.add(new int[] {s,0});
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			
			if(now[0]+u <= f && !visit[now[0]+u]) {
				if(now[0]+u==g) {
					answer = now[1]+1;
					break;
				}
				visit[now[0]+u] = true;
				dq.add(new int[] {now[0]+u, now[1]+1});
			} 
			
			if(now[0]-d >=1 && !visit[now[0]-d]) {
				if(now[0]-d==g) {
					answer = now[1]+1;
					break;
				}
				visit[now[0]-d] = true;
				dq.add(new int[] {now[0]-d, now[1]+1});
			}
		}
		if(s==g) answer= 0;
		System.out.println(answer == -1 ? stair : answer);
	}

}
