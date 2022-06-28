import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_25307 {
	
	public static void main(String[] args) throws IOException {

			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		ArrayList<int []> node = new ArrayList<>();
 		int map[][] = new int[n][m];
		int sx=-987654321,sy=-987654321,ex=-987654321,ey=-987654321;
		for(int i=0;i<n;) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==4) {sx=j;sy=i;} 
				if(map[i][j] ==2) {ex=j;ey=i;} 
				if(map[i][j] ==3) {node.add(new int[] {i,j});} 
				++j;
			}
			++i;
		}
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		
		
		for(int aa=0;aa<node.size();aa++) {
			    int i = node.get(aa)[0];
			    int j = node.get(aa)[1];
				int r = k;
				dq.add(new int[] {i,j});
				map[i][j]=5;
				while(r-->0) {
					int now[] =dq.poll();
						for(int a=0;a<4;a++) {
							int nexty=now[0]+dir[a][0];
							int nextx=now[1]+dir[a][1];
							if(inRange(nexty,nextx,n,m)&&map[nexty][nextx]!=5) {
								map[nexty][nextx]=5; dq.add(new int[] {nexty,nextx});
							}
						}
					}
				 
			
		}
		dq.clear();
		int answer= -1;
		if(ex==-987654321&&ey==-987654321) {
			System.out.println("-1");
		} else {
			dq.add(new int[] {sy,sx,0});
			map[sy][sx] = 7; // visit
			while(!dq.isEmpty()) {
				int now[] = dq.poll();
				if(now[0]==ey && now[1] == ex) {
						answer = now[2];
						break;
				}
				for(int a=0;a<4;a++) {
					int nexty=now[0]+dir[a][0];
					int nextx=now[1]+dir[a][1];
					if(inRange(nexty,nextx,n,m)&&map[nexty][nextx]!=7 && map[nexty][nextx]!=1 &&map[nexty][nextx] !=5) {
						map[nexty][nextx]=7;
						dq.add(new int[] {nexty,nextx,now[2]+1});
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static boolean inRange(int yy, int xx, int n , int m) {
		return yy<n&&xx<m&&yy>=0&&xx>=0;
	}
}
