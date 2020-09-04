package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	static class node{
		int y,x,dir;
		ArrayList<Integer> up = new ArrayList<>();
		public node(int num,int y,int x,int dir) {
			up.add(num);
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[n+1][n+1];
		for(int y= 1 ; y <=n ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x =1 ; x<= n ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int dir[][] = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
		node node_list[] = new node[k+1];
		for(int index = 0 ; index < k ; index++) {
			st = new StringTokenizer(br.readLine());
			node_list[index+1] = new node(index+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int time =1;
		top :
		while(time <=1000) {
			for(int index=1; index<=k ; index++) {
				
				
				int nx = node_list[index].x+dir[node_list[index].dir][1];
				int ny = node_list[index].y+dir[node_list[index].dir][0];
				
				if(nx >= 1 && ny >=1 && ny <= n && nx <= n && map[ny][nx] !=2) {
					if(map[ny][nx]==0) {
						//흰색 = 좌표가 곂치는 것들중에서 현재 index의 up요소들을 전부 삭제해준다.
						for(int i = 1 ; i <= k ; i++) {
							if(i==index)continue;
							
							if(node_list[i].y == node_list[index].y && node_list[i].x == node_list[index].x) {
								// 좌표가 같은경우 index의 up요소를 가진 것들을 모두 삭제해줌.
								for(int a = 0 ; a < node_list[index].up.size();a++) {
									for(int b = 0 ; b < node_list[i].up.size(); b++) {
										if(node_list[index].up.get(a) == node_list[i].up.get(b)) {
											node_list[i].up.remove(b); b--;
										}
									}
								}
							}
						}
						
						for(int i = 1 ; i <= k ; i++) {
							if(i==index)continue;
							
							if(node_list[i].y == ny && node_list[i].x == nx) {
								for(int j = 0 ; j < node_list[index].up.size();j++) {
									node_list[i].up.add(node_list[index].up.get(j));
								}
							}
						}
						node_list[index].x = nx ;
						node_list[index].y = ny ;
					}
					else if(map[ny][nx]== 1) {
						
						// 빨강
						for(int i = 1 ; i <= k ; i++) {
							if(i==index)continue;
							if(node_list[i].y == node_list[index].y && node_list[i].x == node_list[index].x) {
								// 좌표가 같은경우 index의 up요소를 가진 것들을 모두 삭제해줌.
								for(int a = 0 ; a < node_list[index].up.size();a++) {
									for(int b = 0 ; b < node_list[i].up.size(); b++) {
										if(node_list[index].up.get(a) == node_list[i].up.get(b)) {
											node_list[i].up.remove(b); b--;
										}
									}
								}
							}
						}
						
						
						ArrayList<Integer> temp = new ArrayList<>();
						for(int a = node_list[index].up.size()-1 ; a >=0 ; a--) {
							temp.add(node_list[index].up.get(a));
						}
						node_list[index].up.clear();
						for(int a = 0 ; a < temp.size(); a++) {
							node_list[index].up.add(temp.get(a));
						}
						temp.clear();
						for(int i = 1 ; i <= k ; i++) {
							if(i==index)continue;
							if(node_list[i].y == ny && node_list[i].x == nx) {
								for(int j = 0 ; j < node_list[index].up.size();j++) {
									node_list[i].up.add(node_list[index].up.get(j));
								}
							}
						}
						node_list[index].x = nx ;
						node_list[index].y = ny ;
					}
				}
				else {
					int ndir = node_list[index].dir;
					
					if(ndir ==1) ndir = 2;
					else if(ndir==2) ndir =1;
					else if(ndir==3) ndir =4;
					else if(ndir==4) ndir =3;
					node_list[index].dir = ndir;
					
					
				}
			}
			
			time++;
		}
		if(time == 1001) System.out.println(-1);
		else System.out.println(time);
		
	}

}
