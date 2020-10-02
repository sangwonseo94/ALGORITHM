import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] board, int r, int c) {
       int answer = 0;
	        int y =r;
	        int x =c;
	        int visit[][] = new int[4][4];
	        int card =-1;
	        int step =1;
	        int max = 0;
	        
	        for(int i=0;i<4;i++)for(int j=0;j<4;j++) {if(board[i][j]!=0)max++;}
	        max= max>>1;
	        ArrayDeque<int[]>dq = new ArrayDeque<>();
	        ArrayDeque<int[]>selected=new ArrayDeque<>();
	        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	        dq.add(new int[] {y,x,step,0});
	        visit[y][x] = step;
	        if(board[y][x]!=0) {
	        	card = board[y][x];
	        	answer+=1;
                board[y][x]=0;
	        	selected.add(new int[] {y,x,step,0});
	        }
	        while(max>0) {
	        top :
	        while(!dq.isEmpty() && selected.isEmpty()) {
	        	
	        	int []now = dq.poll();
	        	
	        	for(int i=1;i<=4;i++) {
	        		for(int j=1;j<4;j++) {
	        			int ny =now[0] +dir[i-1][0]*j;
	        			int nx =now[1] +dir[i-1][1]*j;
	        			int nny = now[0] +dir[i-1][0]*(j+1);
	        			int nnx = now[1] +dir[i-1][1]*(j+1);
	        			if(ny>=0&&nx>=0&&ny<4&&nx<4) {
	        				if(j==1) {
	        					if(board[ny][nx]!=0) {
	        						card=board[ny][nx];
	        						board[ny][nx]=0;
	        						// 이동횟수 + 엔터
	        						answer += now[3]+2;
	        						selected.add(new int[] {ny,nx,now[2]+2,0});
	        						break top;
	        					} else {
	        						// 큐에 넣음
	        						if(visit[ny][nx] < now[2]) {
	        							visit[ny][nx] = now[2];
	        							dq.add(new int[] {ny,nx,now[2]+1,now[3]+1});
	        						}
	        					}
	        				} else {
	        					if(board[ny][nx]==0 && ( (i==1 && nny <0) || (i==2 && nny >=4) || (i==3 && nnx <0) || (i==4 && nnx>=4) )) {
	        						if(visit[ny][nx]< now[2]) {
	        							visit[ny][nx]=now[2];
	        							dq.add(new int[] {ny,nx,now[2]+1,now[3]+1});
	        						}
	        					}
	        					else if(board[ny][nx]==0) {
	        						continue;
	        					} else {
	        						// 카드발견
	        						card=board[ny][nx];
	        						board[ny][nx]=0;
	        						answer += now[3]+2;
	        						selected.add(new int[] {ny,nx,now[2]+1,0});
	        						break top;
	        					}
	        				}
	        			} else {
	        				break;
	        			}
	        		}
	        	}
	        }
	      
	        visit[selected.peek()[0]][selected.peek()[1]]= step;
	       
	        dq.clear();
	         stop:
		        while(!selected.isEmpty()) {
		        	// card 까지 간다.
		         	int []now = selected.poll();
		        	
		        	for(int i=1;i<=4;i++) {
		        		for(int j=1;j<4;j++) {
		        			int ny = now[0] +dir[i-1][0]*j;
		        			int nx = now[1] +dir[i-1][1]*j;
		        			int nny = now[0] +dir[i-1][0]*(j+1);
		        			int nnx = now[1] +dir[i-1][1]*(j+1);
		        			
		        			if(ny>=0&&nx>=0&&ny<4&&nx<4) {
		        				if(j==1) {
		        					if(board[ny][nx]==card) {
		        						board[ny][nx]= 0;
		        						max--;
		        						answer += now[3]+2;
		        					
		        						dq.add(new int[] {ny,nx,now[2]+2,0});
		        						break stop;
		        					} else {
		        						// 큐에 넣음
		        						if(visit[ny][nx] < now[2]) {
		        							visit[ny][nx] = now[2];
		        							selected.add(new int[] {ny,nx,now[2]+1,now[3]+1});
		        						}
		        					}
		        				} else {
		        					if(board[ny][nx] != card && ( (i==1 && nny <0) || (i==2 && nny >=4) || (i==3 && nnx <0) || (i==4 && nnx>=4) )) {
		        						if(visit[ny][nx]< now[2]) {
		        							visit[ny][nx]=now[2];
		        							selected.add(new int[] {ny,nx,now[2]+1,now[3]+1});
		        						}
		        					}
		        					else if(board[ny][nx]==0 || board[ny][nx] != card) {
		        						continue;
		        					} else  {
		        						// 같은 카드를 찾은경우
		        						board[ny][nx]= 0;
		        						max--;
		        						answer += now[3]+2;
		        						
		        						dq.add(new int[] {ny,nx,now[2]+2,0});
		        						break stop;
		        					}
		        				}
		        			} else {
		        				break;
		        			}
		        		}
		        	}
		        	
		        }
		    	selected.clear();
	        }
	        return answer;
    }
}