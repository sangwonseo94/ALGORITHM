package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_23747 {
	
	public static int r=0,c=0;
	public static char[][] result;
	
	public static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		result = new char[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				result[i][j] = '#';
			}
		}
		
		char[][] map = new char[r][c];
		for(int i=0;i<r;i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
	
		int sy,sx;
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken())-1;
		sx = Integer.parseInt(st.nextToken())-1;
		
		String move = br.readLine(); 
		// end of input

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		for(int i=0;i<move.length();i++) {
			char now = move.charAt(i);
			if(now=='D') {
				sy++;
			} else if(now=='U') {
				sy--;
			} else if(now=='L') {
				sx--;
			} else if(now=='R') {
				sx++;
			} else {
				// w 인경우
				if(result[sy][sx]=='#') {
					// 이미 체크를 한경우는 안가도됨
					dq.add(new int[] {sy,sx});
					result[sy][sx] = '.';
					char nowchar = map[sy][sx];
					while(!dq.isEmpty()) {
						int nowxy[] = dq.poll();
						int nowy = nowxy[0];
						int nowx = nowxy[1];
						for(int j=0;j<4;j++) {
							int ny = nowy+dir[j][0];
							int nx = nowx+dir[j][1];
							if(isRange(ny, nx)&& result[ny][nx]=='#' && nowchar==map[ny][nx]) {
								result[ny][nx] = '.';
							    dq.add(new int[] {ny,nx});
							}
						}
					}
				}
			}
		}
		for(int i=0;i<4;i++) {
			int ny = sy+dir[i][0];
			int nx = sx+dir[i][1];
			if(isRange(ny, nx)) {
				result[ny][nx] ='.';
			}
		}
		result[sy][sx] ='.';
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean isRange(int y,int x) {
		return (y<r&&y>=0&&x>=0&&x<c);
	}
	
}
