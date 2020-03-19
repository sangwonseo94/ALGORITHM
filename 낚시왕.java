package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 낚시왕 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][][]= new int[r+1][c+2][3];
		int Copy_map[][][]= new int[r+1][c+2][3];
		int dirx[] = {0,0,0,1,-1};
		int diry[] = {0,-1,1,0,0};
		int res=0;
		ArrayDeque<int []> Coordi= new ArrayDeque<>();
		ArrayDeque<int []> Copy_Coordi= new ArrayDeque<>();
		for(int index = 0 ; index < m ; index++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			Coordi.add(new int[] {y,x});
			map[y][x][0] = Integer.parseInt(st.nextToken());
			map[y][x][1] = Integer.parseInt(st.nextToken());
			map[y][x][2] = Integer.parseInt(st.nextToken());
		}
		for(int person = 1 ; person < c+1 ; person++) {
			//이동완료
			//열에서 가장 가까운 상어를 잡음, 없다면 상어의 이동으로 넘어감
			for(int row = 1 ; row < r+1 ; row++) {
				if(map[row][person][2] != 0) {
					// 가장 가까운 상어를 발견
					res +=map[row][person][2];
					map[row][person][2] = 0;
					break;
				}
			}
			
			// 상어이동
			while(!Coordi.isEmpty()) {
				int now[] = Coordi.poll();
				int y = now[0], x = now[1];
				if(map[y][x][2]==0) continue;
				int time = map[y][x][0];
				int direction = map[y][x][1];
				int size = map[y][x][2];
				int ny , nx;
				for(int index = 0 ; index < time ; index++) {
					ny = y + diry[direction];
					nx = x + dirx[direction];
					if(ny == r+1 ||  ny == 0 || nx ==0 || nx == c+1) {
						if(direction ==1) direction =2;
						else if(direction==2) direction =1;
						else if(direction==3) direction =4;
						else if(direction==4) direction =3;
						y += diry[direction];
						x += dirx[direction];
					}
					else {
						y = ny ; x = nx;
					}
					
				}
				
				if(Copy_map[y][x][2] == 0) {
					Copy_map[y][x][0] = time;
					Copy_map[y][x][1] = direction;
					Copy_map[y][x][2] = size;
					Copy_Coordi.add(new int[] {y,x});
				}
				else {
					if(Copy_map[y][x][2] < size) {
						Copy_map[y][x][0] = time;
						Copy_map[y][x][1] = direction;
						Copy_map[y][x][2] = size;
						Copy_Coordi.add(new int[] {y,x});
					}
				}
			}
			while(!Copy_Coordi.isEmpty())Coordi.add(Copy_Coordi.poll());
			
			for(int z = 1 ; z < r+1 ; z++) {
				for(int y = 1 ; y < c+1 ; y++) {
					for(int x = 0 ; x <3 ; x++) {
						map[z][y][x] = Copy_map[z][y][x];
						Copy_map[z][y][x] = 0;
					}
				}
			}
		}
		System.out.println(res);
	}
}























