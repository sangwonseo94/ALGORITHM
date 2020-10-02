package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모노미노도미노 {


	public static int blue[][] = new int[4][6];
	public static int green[][] = new int[6][4];
	public static boolean isContinue;
	public static class block{
		int t,x,y;
		public block(int t, int y, int x) {
			super();
			this.t = t;
			this.x = x;
			this.y = y;
		}
	}
	public static int score=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		block num[] = new block[n];
		for(int i = 0 ; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			num[i] = new block(t, y, x);
		}
		
		for(int i = 0 ; i < n ; i++) {
			block now = num[i];
			BlueDown(now,i+1);
			GreenDown(now,i+1);
			GreenCheckAndDestoryAndDown();
			BlueCheckAndDestoryAndDown();
			SpecialGreen();
			SpecialBlue();
		}
		System.out.println(score);
		System.out.println(cnt());
		
		
		
	}
	private static void SpecialBlue() {
		// TODO Auto-generated method stub
		int sblue =0;
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(blue[j][i]!=0) {
					sblue+=1;break;
				}
			}
		}
		if(sblue==0) return;
		if(sblue ==1) {
			for(int i = 0 ; i < 4 ;i++) { 
				blue[i][5] =0;
			}
			 for(int i = 3 ; i >=0 ; i--) {
				 for(int j = 5 ; j >0 ; j--) {
					 blue[i][j] = blue[i][j-1];
				 }
			 }
			 for(int i = 0 ; i < 4 ;i++) {
				 blue[i][0] =0;
			 }
		} else {
			 for(int j = 0 ; j < 2 ; j++) {
				 for(int i = 0 ; i < 4 ;i++) { 
					 blue[i][5-j] =0;
					}
			 }
			 for(int i = 3 ; i >=0 ; i--) {
				 for(int j = 5 ; j >1 ; j--) {
					 blue[i][j] = blue[i][j-2];
				 }
			 }
			 for(int j = 0 ; j < 2 ; j++) {
				 for(int i = 0 ; i < 4 ;i++) { 
					 blue[i][j] =0;
					}
			 }
		}
	
	}
	private static void SpecialGreen() {
		int sgreen =0;
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(green[i][j]!=0) {
					sgreen+=1;break;
				}
			}
		}
		if(sgreen==0) return;
		if(sgreen ==1) {
			for(int i = 0 ; i < 4 ;i++) {
				green[5][i] =0;
			}
			 for(int i = 5 ; i >0 ; i--) {
				 for(int j = 0 ; j < 4 ; j++) {
					 green[i][j] = green[i-1][j];
				 }
			 }
			 for(int i = 0 ; i < 4 ;i++) {
				 green[0][i] =0;
			 }
		} else {
			 for(int j = 0 ; j < 2 ; j++) {
				 for(int i = 0 ; i < 4 ;i++) { 
					 green[5-j][i] =0;
				 }
			 }
			 for(int i = 5 ; i >=2 ; i--) {
				 for(int j = 0 ; j < 4 ; j++) {
					 green[i][j] = green[i-2][j];
				 }
			 }
			 for(int j = 0 ; j < 2 ; j++) {
				 for(int i = 0 ; i < 4 ;i++) { 
					 green[j][i] =0;
				}
			 }
		}
	
	}
	private static void GreenCheckAndDestoryAndDown() {
		int y= 5;
		while(true) {
			boolean ischange =false;
			for(;y>=0;y--) {
				int Notzerocnt =0;
				int x=0;
				for(;x<4;x++) {
					if(green[y][x] !=0) {
						Notzerocnt++;
					} else break;
				}
				if(Notzerocnt==4) {
					// 해당 y를 전부 0 으로만들고 위에거 다내림
					
					for(int tx= 0;tx<4;tx++) {
						green[y][tx]=0;
					}
					score++;
					ischange = true;
					for(int yy= y-1; yy>=0;yy--) {
						green[yy+1] = green[yy].clone();
					}
					
				for(int tx= 0;tx<4;tx++) {
						green[0][tx]=0;
					}
				y++;
				}
			}
			
			if(ischange) {
				for(int xx=0 ;xx<3;xx++){
					int yy=5;
					for( ; yy>=0 ; yy--) {
						while(yy>0 && yy<5 && green[yy][xx] !=0 && green[yy+1][xx]==0 &&(green[yy][xx]!= green[yy][xx+1])){
							if(xx>0 && green[yy][xx-1]==green[yy][xx]) break;
							boolean doublet = false;
							if(green[yy-1][xx]== green[yy][xx]) {
								doublet= true;
							}
							
							if(!doublet) {
								green[yy+1][xx] = green[yy][xx];
								green[yy][xx]=0;
							}
							if(doublet) {
								
								green[yy][xx] = green[yy-1][xx];
								green[yy+1][xx] = green[yy][xx];
								green[yy-1][xx]=0;
							}
							
							yy++;
						}
					}
				}
				int yy=5;
				for( ; yy>=0 ; yy--) {
					while(yy>0 && yy<5 && green[yy][3] !=0 && green[yy+1][3]==0 &&(green[yy][3]!= green[yy][2])){
						
						boolean doublet = false;
						if(green[yy-1][3]== green[yy][3]) {
							doublet= true;
						}
						
						if(!doublet) {
							green[yy+1][3] = green[yy][3];
							green[yy][3] =0;
						}
						if(doublet) {
							green[yy][3] = green[yy-1][3];
							green[yy+1][3] = green[yy][3];
							green[yy-1][3]=0;
						}
						yy++;
					}
				}
				y=5;
			}
			if(y<0) break;
		}
	}
	private static void BlueCheckAndDestoryAndDown() {
		int x= 5;
		while(true) {
			boolean ischange = false;
			for(;x>=0;x--) {
				int Notzerocnt =0;
				int y=0;
				for(;y<4;y++) {
					if(blue[y][x] !=0) {
						Notzerocnt++;
					} else break;
				}
				if(Notzerocnt==4) {
					// 해당 y를 전부 0 으로만들고 위에것을 못내릴 때까지 다내림
					
					for(int ty= 0;ty<4;ty++) {
						blue[ty][x]=0;
					}
					score++;
					ischange = true;
					for(int xx= x-1; xx>=0;xx--) {
						for(int yy =0 ; yy<4 ; yy++) {
							blue[yy][xx+1] = blue[yy][xx];
						}
					}
					
					for(int ty= 0;ty<4;ty++) {
						blue[ty][0]=0;
					}
					x++;
				}
			}
			if(ischange) {
				for(int yy=0 ;yy<3;yy++) {
					int xx=5;
					for( ; xx>=0 ; xx--) {
						while(xx>0 && xx<=4 && blue[yy][xx] !=0 && blue[yy][xx+1]==0 &&(blue[yy][xx]!= blue[yy+1][xx])){
							if(yy>0 && blue[yy-1][xx]==blue[yy][xx]) break;
							boolean doublet = false;
							if(blue[yy][xx-1]== blue[yy][xx]) {
								doublet= true;
							}
							
							if(!doublet) {
								blue[yy][xx+1] = blue[yy][xx];
								blue[yy][xx]=0;
							} else {

								blue[yy][xx+1]=blue[yy][xx];
								blue[yy][xx] = blue[yy][xx-1];
								blue[yy][xx-1] =0;
							}
							xx++;
						}
					}
				}
				int xx=5;
				for( ; xx>=0 ; xx--) {
					while(xx<=4 && blue[3][xx] !=0 && blue[3][xx+1]==0 &&(blue[3][xx]!= blue[2][xx])){
						boolean doublet = false;
						if(blue[3][xx]== blue[3][xx-1]) {
							doublet= true;
						}
						blue[3][xx] = blue[3][xx-1];
						if(!doublet) {
							blue[3][xx] =0;
						}
						if(doublet) {
							blue[3][xx] = blue[3][xx-1];
							blue[3][xx-1]=0;
						}
						xx++;
					}
				}
				x=5;
			}
			if(x<0) break;
		}
		
	}
	private static void GreenDown(block now, int order) {
		if(now.t == 1 || now.t == 2) {
			int x = now.x;
			int y = 0;
			for(;;) {
				if( y+1<6 && green[y+1][x] ==0 ) {
					y++;
				} else {
					break;
				}
			}
			green[y][x] = order;
			if(now.t==2) green[y-1][x] = order;
		} else {
			// 3인경우
			int x = now.x;
			int nx = x+1;
			int y =0;
			for(;;) {
				if( y+1<6&& green[y+1][x]==0 && green[y+1][nx]==0 ) {
					y++;
				} else {
					break;
				}
			}
			green[y][x] =order;
			green[y][nx] =order;
		}
		
	}
	private static void BlueDown(block now, int order) {
		if(now.t==1 || now.t==3) {
			int y = now.y;
			int x = 0;
			for(;;) {
				if(x+1<6 &&blue[y][x+1] ==0) {
					x++;
				} else {
					break;
				}
			}
			blue[y][x] = order;
			if(now.t==3) blue[y][x-1] = order;
		} else {
			// 2인경우
			int y = now.y;
			int ny = y+1;
			int x =0;
			for(;;) {
				if( x+1<6&& blue[y][x+1]==0 && blue[ny][x+1]==0 ) {
					x++;
				} else {
					break;
				}
			}
			blue[y][x] =order;
			blue[ny][x] =order;
		}
	}
	private static int cnt() {
		int res =0;
		for(int i = 0 ; i < 6 ; i ++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(blue[j][i] != 0) {
					res++;
				}
				if(green[i][j] !=0) {
					res++;
				}
			}
		}
		return res;
	}

}
