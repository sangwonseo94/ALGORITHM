package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][]   = new int[N][N];
		int space[][] = new int[N][N];
		int order[]  = new int[N*N];
		int like[][] = new int[N*N+1][4];
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		// init space 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt = 0;
				for(int k=0;k<4;k++) {
					int ny = i+dir[k][0];
					int nx = j+dir[k][1];
					if(ny>=0&&nx>=0&&ny<N&&nx<N) {
						cnt++;
					}
				}
				space[i][j]= cnt;
			}
		}
		// input start
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			order[i] = one;
			for(int j=0;j<4;j++) {
				like[one][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		ArrayList<int[]> al = new ArrayList<>();
		for(int i=0;i<N*N;i++) {
			int now = order[i];
			int max = -1;
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x]>0)continue;
					int cnt = 0;
					for(int k=0;k<4;k++) {
						int ny=y+dir[k][0];
						int nx=x+dir[k][1];
						if(ny>=0&&nx>=0&&ny<N&&nx<N) {
							if(map[ny][nx]!=0) {
								for(int z=0;z<4;z++) {
									if(like[now][z]==map[ny][nx])cnt++; 
								}
							}
						}
					}
					if(cnt>max) {
						max = cnt;
						al.clear();
						al.add(new int[] {y,x});
					} else if(cnt==max) {
						al.add(new int[] {y,x});
					}
				}
			} 
			// step one 
			if(al.size()==1) {
				// 후처리
				int nowz[] = al.get(0);
				map[nowz[0]][nowz[1]] = now;
				space[nowz[0]][nowz[1]] = -1;
				for(int ii=0;ii<4;ii++) {
					int ny= nowz[0] + dir[ii][0];
					int nx= nowz[1] + dir[ii][1];
					if(ny>=0&&nx>=0&&ny<N&&nx<N) {
						if(space[ny][nx]>0) {
							space[ny][nx]--;
						}
					}
				}
				continue;
			} else {
				max = -1;
				ArrayList<int[]> al2 = new ArrayList<>();
				//step two
				for(int ii=0;ii<al.size();ii++) {
					int y = al.get(ii)[0];
					int x = al.get(ii)[1];
					int now2 = space[y][x];
					if(now2>max) {
						max = now2;
						al2.clear();
						al2.add(new int[] {y,x});
					} else if(now2==max) {
						al2.add(new int[] {y,x});
					}
				}
				
				al.clear();
				for(int ii=0;ii<al2.size();ii++) {
					al.add(al2.get(ii));
				}
				
				if(al.size()!=1) {
					// step3 check
					PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							if(o1[0]<o2[0]) {
								return 1;
							} else if(o1[0]==o2[0]) {
								if(o1[1]>o2[1]) {
									return 1;
								} else if(o1[1]<o2[1]) {
									return -1;
								} else {
									return 0;
								}
							} else {
								return 0;
							}
						}
					});
					
					int size = al.size();
					for(int ii=0;ii<size;ii++) {
						pq.add(al.get(ii));
					}
					
					int fin[] = pq.peek();

					map[fin[0]][fin[1]] = now;
					space[fin[0]][fin[1]] = -1;

					for(int ii=0;ii<4;ii++) {
						int ny= fin[0] + dir[ii][0];
						int nx= fin[1] + dir[ii][1];
						if(ny>=0&&nx>=0&&ny<N&&nx<N) {
							if(space[ny][nx]>0) {
								space[ny][nx]--;
							}
						}
					}
					
				} else {
					// 후처리
					int nowz[] = al.get(0);
					map[nowz[0]][nowz[1]] = now;
					space[nowz[0]][nowz[1]] = -1;
					for(int ii=0;ii<4;ii++) {
						int ny= nowz[0] + dir[ii][0];
						int nx= nowz[1] + dir[ii][1];
						if(ny>=0&&nx>=0&&ny<N&&nx<N) {
							if(space[ny][nx]>0) {
								space[ny][nx]--;
							}
						}
					}
					continue;
				}
				
			}
		}
		
		// map은 완성되었고 
		// 만족도를 구하면된다.
		int answer =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int now = map[i][j];
				int cnt= 0;
				for(int k=0;k<4;k++) {
					int ny =i+dir[k][0];
					int nx =j+dir[k][1];
					if(ny>=0&&nx>=0&&ny<N&&nx<N) {
						if(map[ny][nx]!=0) {
							for(int z=0;z<4;z++) {
								if(like[now][z]==map[ny][nx])cnt++; 
							}
						}
					}
				}
				if(cnt==0)answer +=0;
				else if(cnt==1)answer +=1;
				else if(cnt==2)answer +=10;
				else if(cnt==3)answer +=100;
				else if(cnt==4)answer +=1000;
			}
		}
		System.out.println(answer);
	}
}
