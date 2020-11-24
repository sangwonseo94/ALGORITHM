package 프로그래머스스킬체크테스트;

public class p2 {
	public static int solution(int[][] board) {
		 int answer = 0;
		 int size = board.length;
	        boolean isChange = true;
	        while(isChange) { isChange = false;
	        // 2줄을 내림
	        for(int i=0;i<size;i++) {
	        	int y=0;while(y<size && board[y][i]==0)y++;
	        	if(1<y&&y<size) {y--;board[y][i]=-1;board[y-1][i]=-1;} 
	        	else if(y==1){y--;board[y][i]=-1;} }
	         for(int i=0;i<size;i++)for(int j=0;j<size;j++) {
	        	// ㅡ ㅣ 이모양의 -1개 같은숫자4개가이루어지면 변경가능 ischange = true로 해주고 그 값없애고 다끝나면 -1제거작업
	        	int mcnt=0;  int bcnt =0; int fnum = 0; boolean impossible= false;
	        	top :
	        	for(int y=i;y<i+3&&y<size;y++) {
	        		for(int x=j;x<j+2&&x<size;x++) {
	        			if(board[y][x]==-1)mcnt++;
	        			else if(board[y][x]!=0&&fnum==0) {fnum=board[y][x];bcnt++;}
	        			else if(board[y][x]!=0&&fnum==board[y][x]) bcnt++;
	        			else {
	        				impossible=true;break top;
	        			}
	        		}
	        	}
	        	if(!impossible&&mcnt==2&&bcnt==4) {
	        		answer++; isChange = true;
	        		for(int y=i;y<i+3;y++) {for(int x=j;x<j+2;x++) {board[y][x]=0;}}}
	        	if(isChange) continue;
	        	mcnt=0;   bcnt =0;  fnum = 0; impossible= false;
	        	stop :
	        	for(int y=i;y<i+2&&y<size;y++) {
	        		for(int x=j;x<j+3&&x<size;x++) {
	        			if(board[y][x]==-1)mcnt++;
	        			else if(board[y][x]!=0&&fnum==0) {fnum=board[y][x];bcnt++;}
	        			else if(board[y][x]!=0&&fnum==board[y][x]) bcnt++;
	        			else {
	        				impossible=true;break stop;
	        			}
	        		}
	        	}
	        	if(!impossible&&mcnt==2&&bcnt==4) {
	        		isChange = true; answer++;
	        		for(int y=i;y<i+2;y++) {for(int x=j;x<j+3;x++) {board[y][x]=0;}}}
	          }
	        	if(isChange) for(int i=0;i<size;i++)for(int j=0;j<size;j++)if(board[i][j]==-1)board[i][j]=0;
	        }
	        return answer;
    }
	
	
		
	
	
	public static void main(String[] args) {
		int[][] board =
			{{0,0,0,0,0,0,0,0,0,0}
			,{0,0,0,0,0,0,0,0,0,0}
			,{0,0,0,0,0,0,0,0,0,0}
			,{0,0,0,0,0,0,0,0,0,0}
			,{0,0,0,2,2,0,0,0,0,0}
			,{0,0,0,2,1,0,0,0,0,0}
			,{0,0,0,2,1,0,0,0,0,0}
			,{0,0,0,0,1,1,0,0,0,0}
			,{0,0,0,0,0,0,0,0,0,0}
			,{0,0,0,0,0,0,0,0,0,0}};
		
		int[][] board2=
		{{0, 0, 0, 0, 0}, {1, 0, 0, 2, 0}, {1, 2, 2, 2, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
		System.out.println(
				solution(	board2));
	}

}
