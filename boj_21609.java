package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_21609 {

	public static int ignore =0;
	public static class node{
		  int size;
		  int rainbow;
		  int RepreY;
		  int RepreX;
		  boolean isGroup;
		  ArrayList<int[]> coord;
		  public node() {
			  size=0; rainbow=0; RepreY=0; RepreX=0; isGroup=false;
			  coord = new ArrayList<>();
		 }
		
	}
	public static void main(String[] args) throws IOException {
		
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  
	  int N = Integer.parseInt(st.nextToken());
	  int M = Integer.parseInt(st.nextToken());
	  ignore = M+1;
	  boolean isContinue = true;
	  int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	  ArrayDeque<int []> dq = new ArrayDeque<>();
	  PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
		  @Override
		public int compare(node o1, node o2) {
			// 넓이,무지개 블록수, 대표블록의 행, 대표블록의 열
			if(o1.size>o2.size) return -1;
			else if(o1.size<o2.size) return 1;
			else {
				if(o1.rainbow>o2.rainbow) return -1;
				else if(o1.rainbow<o2.rainbow) return 1;
				else {
					if(o1.RepreY>o2.RepreY) return -1;
					else if(o1.RepreY<o2.RepreY) return 1;
					else {
						if(o1.RepreX>o2.RepreX) return -1;
						else if(o1.RepreX<o2.RepreX) return 1;
						else return 0;
					}
				}
			}
		}
	  });
	  int map[][] = new int[N][N];
	  int answer =0;
	  for(int y=0;y<N;y++) {st = new StringTokenizer(br.readLine()); for(int x=0;x<N;x++) {map[y][x] = Integer.parseInt(st.nextToken());}}
	  // end of input
	  while(isContinue) {
		  // 방문 체크
		  boolean isVisit[][] = new boolean[N][N];
		 
		  node n = new node();
		
		  
		  for(int y=0;y<N;y++) {
			  for(int x=0;x<N;x++) {
				  if(map[y][x]!=0 && map[y][x]!=-1&& !isVisit[y][x] && map[y][x]!=ignore) {
					 
					// bfs 
					n = new node();
					n.size=0;
					n.rainbow=0;
					n.RepreY = -1;
					n.RepreX = -1;
				    
					dq.clear();
				    dq.add(new int[] {y,x,map[y][x]});
				    isVisit[y][x] = true;
				    while(!dq.isEmpty()) {
				    	int now[] = dq.poll();
				    	int nowy = now[0];
				    	int nowx = now[1];
				    	int nowc = now[2];
				    	n.size++;
				    	if(n.size>=2&&!n.isGroup) {
				    		n.isGroup = true;
				    	} else if(n.size==1){
				    		// 작은것들이 기준블록의 대상이됨
				    	    n.RepreY=y;
				    	    n.RepreX=x;
				    	    n.coord.add(new int[] {y,x});
				    	}
				    	
				    	for(int i=0;i<4;i++) {
				    		int nexty=nowy +dir[i][0];
				    		int nextx=nowx +dir[i][1];
				    		if(nexty>=0&&nextx>=0&&nexty<N&&nextx<N) {
				    			if(map[nexty][nextx]!=-1 || map[nexty][nextx] !=ignore) {
				    				if(map[nexty][nextx]==0 && !isRainBow(n.coord,nexty,nextx)) {
				    					n.rainbow++;
				    					dq.add(new int[] {nexty,nextx,nowc});
					    				n.coord.add(new int[] {nexty,nextx});
				    				} else {
				    					if(!isVisit[nexty][nextx] && map[nexty][nextx] == nowc) {
				    						isVisit[nexty][nextx] = true;
				    						dq.add(new int[] {nexty,nextx,nowc});
						    				n.coord.add(new int[] {nexty,nextx});
						    				  if(n.RepreY > nexty) {
						    					  n.RepreY = n.RepreY > nexty ? nexty : n.RepreY;
				    		                      n.RepreX = nextx;
						    				  } else if(n.RepreY==nexty) {
						    					  n.RepreX = n.RepreX > nextx ? nextx : n.RepreX;
						    				  }
				    					}
				    				}
				    			}
				    		}
				    	}
				    }
				    
				    
				    if(n.isGroup) {
						  pq.add(n);
					  }
				  }
			  }
		  }
		 
		  if(pq.size()==0) {
			  isContinue = false;
			  break;
		  } else {
			  isContinue = true;
			  n =pq.poll();
			  // pq의 맨 처음하나를 ignore 처리하고 
			  answer += (n.size)*(n.size);
			  for ( int[] co : n.coord) {
				map[co[0]][co[1]] = ignore;
			  }
			  pq.clear();
		  }
		  map = gravity(map);
		  map = autoclockwise(map);
		  map = gravity(map);
	  }
	  
	  System.out.println(answer);
	}

	private static boolean isRainBow(ArrayList<int[]> coord, int nexty, int nextx) {
		for (int[] is : coord) {if(is[0]==nexty&&is[1]==nextx) return true;}
		return false;
	}

	public static int[][] gravity(int [][] map){
		// 검정블록은 움직이지 않는다.
		int len = map.length;
		int rMap[][] = new int[len][len];
		for(int y=0;y<len;y++) for(int x=0;x<len;x++) rMap[y][x] = ignore;
		
		for(int x=0;x<len;x++) {
			for(int y=len-1;y>=0;y--) {
				if(map[y][x]==ignore || map[y][x]== -1) {
					rMap[y][x] = map[y][x];
				} else {
				  // 일반이거나 무지개 
				  if(y==len-1) {
					  rMap[y][x] = map[y][x];
				  } else {
					  // 맨바닥이면, 그냥 넣고 
					  // 아니면, 검정을 만나거나 다른값을 만날때까지 현재에서 위로 찾음
					  int nexty = y+1;
					  for(;nexty<len;nexty++) {
						  if(rMap[nexty][x]!=ignore) {
							  break;
						  }
					  }
					  rMap[--nexty][x] = map[y][x];
				  }
				}
			}
		}
		return rMap;
	}
	
	public static int[][] autoclockwise(int [][]map){
		// 반시계
		int len = map.length;
		int rMap[][] = new int[len][len];
		
		for(int y=0;y<len;y++) {
			for(int x=0;x<len;x++) {
				rMap[len-1-x][y] = map[y][x];
			}
		}
		
		
		return rMap;
	}
}
