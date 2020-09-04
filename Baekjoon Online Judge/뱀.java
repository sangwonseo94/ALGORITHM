package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 뱀 {
	static class node{
		int time; char dir;
		public node(int time , char dir) {
			this.time = time ; 
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int  map[][] = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		int apple = Integer.parseInt(st.nextToken());
		for(int index = 1 ; index < apple+1 ; index++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int move_time = Integer.parseInt(st.nextToken());
		node move_coordinate[]= new node[move_time+1];
		for(int index = 1; index < move_time+1 ; index++) {
			st = new StringTokenizer(br.readLine());
			move_coordinate[index] = new node(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		ArrayDeque<int []> snake = new ArrayDeque<>();
		snake.add(new int [] {1,1});
		int dir = 3 ; // 상하좌우
		int diry[] = {-1,1,0,0};
		int dirx[] = {0,0,-1,1};
		int nowy = 0 , nowx =0;
	    int nexty = 0 , nextx = 0;
		map[1][1] = 2;
		int time = 0;
	    int index =1;
		while(true) {
	    	
	    	if(index <= move_time) {
		    	if(move_coordinate[index].time == time) {
		    		if(move_coordinate[index].dir=='D') {
		    			if(dir == 3) {dir =1;}
		    			else if(dir ==2) {dir =0;}
		    			else if(dir ==1) {dir =2;}
		    			else if(dir ==0) {dir =3;}
		    		}
		    		else if(move_coordinate[index].dir=='L') {
		    			if(dir == 3) {dir=0;}
		    			else if(dir ==2) {dir=1;}
		    			else if(dir ==1) {dir=3;}
		    			else if(dir ==0) {dir=2;}
		    		}
		    		index++;
		    	}
	    	}
	    	int now[] = snake.peek();
			nowy = now[0] ; nowx = now[1];
			
			nexty = nowy + diry[dir] ; nextx = nowx+ dirx[dir];
			if(nexty >=1 && nextx >=1 && nexty <=N && nextx <=N) {
				if(map[nexty][nextx] == 1) {
					snake.addFirst(new int[] {nexty, nextx});
					map[nexty][nextx] = 2;
				}
				else if(map[nexty][nextx] == 0) {
					int last[] =snake.pollLast();
					snake.addFirst(new int[] {nexty, nextx});
					map[last[0]][last[1]] = 0 ; map[nexty][nextx] =2;
				}
				else if(map[nexty][nextx] == 2) {
					break;
				}
			}
			else {
				break;
			}
		
			time++;
		}
		System.out.println(time+1);
	}
}
