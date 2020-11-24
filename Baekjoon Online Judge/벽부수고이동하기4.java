package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 벽부수고이동하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		char map[][] = new char[n][m];
		for(int i = 0 ; i < n ; i++) { map[i] = br.readLine().toCharArray();}
		HashMap<Integer , Integer> hs = new HashMap<>();
		int area = 1;
		int visit[][] =new int[n][m];
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		ArrayDeque<int []> dq = new ArrayDeque<>();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(visit[i][j] ==0 && map[i][j]=='0') {
					int size = 1;
					dq.add(new int[] {i,j});
					visit[i][j] = area;
					while(!dq.isEmpty()) {
						int now[] = dq.poll();
						for(int k = 0 ; k < 4 ; k++) {
							int ny = now[0] + dir[k][0];
							int nx = now[1] + dir[k][1];
							if(ny >=0 && nx>=0 && nx < m && ny <n) {
								if(map[ny][nx]=='0'&&visit[ny][nx] ==0) {
									visit[ny][nx] = area;
									size++;
								}
							}
						}
					}
					hs.put(area, size);
					area++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j]=='0')sb.append("0");
				else {
					int size = 1;
					boolean check[] = new boolean[area+1];
					for(int k = 0 ; k < 4 ; k++) {
						int ny = i + dir[k][0];
						int nx = j + dir[k][1];
						if(ny >=0 && nx >=0 && ny < n && nx < m && visit[ny][nx] !=0) {
							int next = visit[ny][nx];
							if(!check[next]) {
								check[next] = true;
								size += hs.get(visit[ny][nx]);
							}
						}
					}
					sb.append(size%10);
				}
			}
			sb.append("\n");
		}System.out.println(sb);
	}
}
