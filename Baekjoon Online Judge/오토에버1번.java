package 푼문제;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ���信��1�� {
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int map[][] = {
			{3,2,3,2,},
			{2,1,1,2},
			{1,1,2,1},
			{4,1,1,1}
	};
	static int map2[][] = {
			{4,2,3,2},
			{2,1,2,4},
			{1,2,3,1},
			{4,1,4,3}
	};
	static int answer = 0;
	static boolean visit[][] = new boolean[4][4];
	static int res =0;
	public static void main(String[] args) throws Exception {
		System.out.println(Solution());
	}
	
	public static int Solution() {
		answer =0; res=0;
		
		for(int y = 0 ; y < 4 ; y++) {
			for(int x=0; x < 4 ; x++) {
				visit[y][x] = true;
				DFS(y,x,1);
				visit[y][x] = false;
				answer = Math.max(answer, res);
			}
		}
		
		return answer == 1 ? -1 : answer;
	}
	
	public static void DFS(int y, int x, int len) {
		// depth�� �ְ���̸� ã�´�
		res = Math.max(res,len);
		for(int index = 0 ; index < 4 ; index++) {
			int ny= y + dir[index][0];
			int nx= x + dir[index][1];
			if(ny>=0 && nx >=0 && ny<4 && nx<4) {
				// ���� �ȿ� �ְ�,�湮���� �ʾҰ�, ���������� ���ȣ��
				if(!visit[ny][nx] && map2[y][x] == map2[ny][nx]) {
					visit[ny][nx] = true;
					DFS(ny,nx,len+1);
					visit[ny][nx] = false;
				}
			}
			
		}
		
	}

}
