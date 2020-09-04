package com.ssafy.array.fillcell;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class land_sep{
	static int count = 0;
	static int dx[] = {0,0,+1,-1,+1,+1,-1,-1};
	static int dy[] = {+1,-1,0,0,-1,+1,+1,-1};
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		Queue<coordinate> Q = new LinkedList<coordinate>();
		while(true) {
			
			int x = scan.nextInt();
			int y = scan.nextInt();
			if( x== 0 && y == 0) break;
			
			int map[][] = new int[51][51];
			boolean visit[][] = new boolean[51][51];
			
			for(int y_index = 0 ; y_index < y ; y_index ++) {
				for(int x_index = 0 ; x_index < x ; x_index++) {
					map[y_index][x_index] = scan.nextInt();
				}
			}
			
			for(int y_index = 0 ; y_index < y ; y_index ++) {
				for(int x_index = 0 ; x_index < x ; x_index++) {
					if(!visit[y_index][x_index] && map[y_index][x_index] == 1) {
						count++;
						visit[y_index][x_index]= true;
						Q.add(new coordinate(x_index , y_index));
						while(!Q.isEmpty()) {
							coordinate now = Q.poll();
							for(int index= 0 ; index < dx.length ; index++) {
								int nx = now.x + dx[index];
								int ny = now.y + dy[index];
								if(nx >= 0 &&  ny >= 0 && nx < x && ny < y && !visit[ny][nx] && map[ny][nx] ==1 ) {
									visit[ny][nx] = true;
									Q.add(new coordinate( nx, ny));
								}
							}
						}
					}
				}
			}
			
			System.out.println(count);
			count =0;
			
			
		}
	
	}

}
class coordinate{
	int x,y;
	coordinate(int x,int y){
		this.x = x;
		this.y = y;
	}
}

