package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_원자소멸시뮬레이션 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static int map[][] = new int[4001][4001];
	static boolean visit[][] = new boolean[4001][4001];
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			ArrayList<int []> atom = new ArrayList<>();
			for(int index = 0 ; index < n ; index++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken())*2 +2000;
				int x = Integer.parseInt(st.nextToken())*2 +2000;
				int dir = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				map[y][x] = e; 
				atom.add(new int[] {y,x,dir,e});
			}
			while(atom.size() != 0) {
				for(int index = 0 ; index < atom.size() ; index++) {
					int y = atom.get(index)[0];
					int x = atom.get(index)[1];
					map[y][x] = 0; // �ʱ�ȭ
					atom.get(index)[0] += dy[atom.get(index)[2]];
					atom.get(index)[1] += dx[atom.get(index)[2]];
					 y = atom.get(index)[0];
					 x = atom.get(index)[1];
					if(y >=0 && x>= 0 && y < 4001 && x < 4001 ) {
						map[y][x] += atom.get(index)[3];
					}
					else {
						atom.remove(index);
						index--;
					}
				}
				
				
				for(int index = 0 ; index < atom.size() ; index++) {
					int y = atom.get(index)[0];
					int x = atom.get(index)[1];
					if(visit[y][x]) {
						map[y][x] -= atom.get(index)[3];
						answer += atom.get(index)[3];
						atom.remove(index);
						index--;
						if(map[y][x] == 0) {
							/
							visit[y][x] = false;
						}
					}
					else if(map[y][x] > atom.get(index)[3] && !visit[y][x]){ //ó���浹
						visit[y][x] = true;
						map[y][x] -= atom.get(index)[3];
						answer += atom.get(index)[3];
						atom.remove(index);
						index--;
						
					}
				}
			}
			sb.append("#"+tc+" "+answer+"\n");
			answer =0;
		}
		System.out.print(sb);
	}

}
