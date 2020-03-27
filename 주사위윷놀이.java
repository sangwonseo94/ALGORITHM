package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위윷놀이 {
	public static int map[][];
	public static int step[] = new int[10];
	public static int horse[][] = new int[4][2]; // 0은 맵 1은 맵에서의 위치
	public static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 10 ; i++) step[i] = Integer.parseInt(st.nextToken());
		map= new int[5][];
		map[0] = new int[] {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0};
		map[1] = new int[] {10,13,16,19};
		map[2] = new int[] {20,22,24};
		map[3] = new int[] {30,28,27,26};
		map[4] = new int[] {25,30,35,40,0};
		dfs(0,0); System.out.println(answer);
	}
	private static void dfs(int depth, int score) {
		if(depth ==10) {
			answer = answer > score ? answer : score;
			return;
		} else {
			top :
			for(int i = 0 ; i < 4 ; i++) {
				int nowmap = horse[i][0];
				int nowpos = horse[i][1];
				int nextmap = nowmap;
				int nextpos = nowpos+step[depth]; //다음 이동할 위치
				
				if(nowpos == map[nowmap].length-1) {
					// 도착한 말
					continue;
				}
				
				if(nextmap==0) {
					if(nextpos==5) {
						nextmap=1; nextpos=0;
					} else if(nextpos==10) {
						nextmap=2; nextpos=0;
					} else if(nextpos==15) {
						nextmap=3; nextpos=0;
					} 
				
				} else if(nowmap < 4) {
					if(nextpos >= map[nowmap].length) {
					 // 넘어가는경우 4로보내고 차이만큼 이동해주어야함	
						nextmap=4;
						nextpos -= map[nowmap].length  ;
					}
				} else if(nowmap==4) {
					if(nextpos >= map[4].length) {
						nextpos = map[4].length-1;
						// 0으로 보낸다.
					}
				}
				
				// 업데이트된 next map,pos에 다른말이있다면, 갈수없음
				for(int j = 0; j < 4 ; j++) {if(j!=i && horse[j][0] == nextmap && horse[j][1] ==nextpos && nextpos<map[nextmap].length-1) {continue top;}}
				
				// 다음 dfs 호출
				horse[i][0] = nextmap;
				horse[i][1] = nextpos;
				dfs(depth+1, score+map[nextmap][nextpos]);
				horse[i][0] = nowmap;
				horse[i][1] = nowpos;
				
			}
		}
		
	}

}
