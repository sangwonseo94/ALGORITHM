import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1584 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		int maxsize = 501;
		
		boolean warning[][] = new boolean[maxsize][maxsize];
		boolean visit[][] = new boolean[maxsize][maxsize];
		int m =  Integer.parseInt(st.nextToken());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int temp = -1;
			if(x1>x2) {temp = x1;x1 = x2 ;x2 = temp;}
			if(y1>y2) {temp = y1;y1 = y2 ;y2 = temp;}
			for(int j=x1;j<=x2;j++) {
				for(int j2=y1;j2<=y2;j2++) {
					warning[j][j2] = true;
				}
			}
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int temp = -1;
			if(x1>x2) {temp = x1;x1 = x2 ;x2 = temp;}
			if(y1>y2) {temp = y1;y1 = y2 ;y2 = temp;}
			for(int j=x1;j<=x2;j++) {
				for(int j2=y1;j2<=y2;j2++) {
					visit[j][j2] = true;
				}
			}
		}

			
		int answer = -1;
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		warning[0][0] = false; visit[0][0] = true;
		dq.add(new int[] {0,0,0});
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			if(now[0]==500&&now[1]==500) {
				answer =now[2];
				break;
			}
			for(int i=0;i<4;i++) {
				int ny = now[0] + dir[i][0];
				int nx = now[1] + dir[i][1];
				if(ny>=0&&nx>=0&&ny<=500&&nx<=500) {
					if(!visit[ny][nx]) {
						if(warning[ny][nx]) {
							dq.addLast(new int[] {ny,nx,now[2]+1});
						} else {
							dq.addFirst(new int[] {ny,nx,now[2]});
						}
						visit[ny][nx] = true;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
