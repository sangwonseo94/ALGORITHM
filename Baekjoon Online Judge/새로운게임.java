package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 새로운게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[n+1][n+1];
		ArrayList<Integer> posmap[][] = new ArrayList[n+1][n+1];
		for(int i=1; i<= n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				posmap[i][j] = new ArrayList<>();
			}
		}
		int kpos[][] = new int[k+1][5];
		int dir[][] = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
		for(int i=1; i<=k;i++) {
			st = new StringTokenizer(br.readLine());
			kpos[i][0] =Integer.parseInt(st.nextToken()) ; // y
			kpos[i][1] =Integer.parseInt(st.nextToken()) ; // x
			kpos[i][2] =Integer.parseInt(st.nextToken()) ; // d
			kpos[i][3] =i ; // 몇번째
			kpos[i][4] =0;  // index
			posmap[kpos[i][0]][kpos[i][1]].add(i);
		}
		// 말이 k 개 쌓이면 종료
		int answer = -1;
		top :
		for(int i=1 ; i<=1000 ; i++) {
			for(int j=1;j<=k;j++) {
				int y = kpos[j][0];
				int x = kpos[j][1];
				int d = kpos[j][2];
				int index = kpos[j][4];
				if(index !=0) continue;
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if( isrange(ny,nx,n) && map[ny][nx] == 0) {
					ArrayList<Integer> temp = new ArrayList<>();
					for(int ii= index ; ii < posmap[y][x].size() ; ii++) {
						temp.add(posmap[y][x].get(ii));
						posmap[y][x].remove(index);
						ii--;
					}
					// temp를 ny , nx에 add 하면서 kpos update
					for(int ii=0; ii < temp.size() ;ii++) {
						int now = temp.get(ii);
						posmap[ny][nx].add(now);
						kpos[now][0] = ny;
						kpos[now][1] = nx;
						kpos[now][4] = posmap[ny][nx].size()-1;
					}
				} else if( isrange(ny,nx,n) && map[ny][nx] == 1) {
					
					ArrayList<Integer> temp = new ArrayList<>();
					for(int ii= index ; ii < posmap[y][x].size() ; ii++) {
						temp.add(posmap[y][x].get(ii));
						posmap[y][x].remove(index);
						ii--;
					}
					// temp를 ny , nx에 add 하면서 kpos update
					for(int ii=temp.size()-1; ii >=0  ;ii--) {
						int now = temp.get(ii);
						posmap[ny][nx].add(now);
						kpos[now][0] = ny;
						kpos[now][1] = nx;
						kpos[now][4] = posmap[ny][nx].size()-1;
					}
				} else {
					// blue
					if(d==1) d=2;
					else if(d==2) d=1;
					else if(d==3) d=4;
					else if(d==4) d=3;
					ny = y + dir[d][0];
					nx = x + dir[d][1];
					if(!isrange(ny, nx, n) || map[ny][nx]==2) {
						kpos[j][2]=d;
					} else {
						if(map[ny][nx]==0) {
							ArrayList<Integer> temp = new ArrayList<>();
							for(int ii= index ; ii < posmap[y][x].size() ; ii++) {
								temp.add(posmap[y][x].get(ii));
								posmap[y][x].remove(index);
								ii--;
							}
							for(int ii=0; ii < temp.size() ;ii++) {
								int now = temp.get(ii);
								posmap[ny][nx].add(now);
								kpos[now][0] = ny;
								kpos[now][1] = nx;
								kpos[now][4] = posmap[ny][nx].size()-1;
							}
							kpos[j][2] = d;
						} else if(map[ny][nx]==1) {
							ArrayList<Integer> temp = new ArrayList<>();
							for(int ii= index ; ii < posmap[y][x].size() ; ii++) {
								temp.add(posmap[y][x].get(ii));
								posmap[y][x].remove(index);
								ii--;
							}
							for(int ii=temp.size()-1; ii >=0  ;ii--) {
								int now = temp.get(ii);
								posmap[ny][nx].add(now);
								kpos[now][0] = ny;
								kpos[now][1] = nx;
								kpos[now][4] = posmap[ny][nx].size()-1;
							}
							kpos[j][2] = d;
						}
					}
				}
				
				
				
				if(posmap[kpos[j][0]][kpos[j][1]].size() >=4) {
					answer =i;
					break top;
				}
			}
		}System.out.println(answer);
		
	}

	private static boolean isrange(int ny, int nx, int n) {
		
		return ny>=1&&nx>=1&&ny<=n&&nx<=n;
	}

}
