package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트리스게임 {
	public static int t;
	public static int[][]map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int index = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t =Integer.parseInt(st.nextToken());
			if(t==0) {
				System.out.print(sb);
				break;
			} else {
				map = new int[t][t];
				for(int i=0;i<t;i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0;j<t;j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				int max = -2147000000;
				for(int i=0;i<t;i++) {
					for(int j=0;j<t;j++) {
						for(int k=0;k<13;k++) {
							int res= sol(i,j,k);
							max = max > res ? max : res;
						}
					}
				}
				sb.append(index+". "+max+"\n");
				index++;
			}
		}
	}

	private static int sol(int y, int x, int k) {
		int impossible = Integer.MIN_VALUE;
		if(k==0) {
			if(x+3<t) {
				int res=0;
				for(int i=0;i<4;i++) {
					res += map[y][x+i];
				}
				return res;
			} else {
				return impossible;
			}
		} else if(k==1) {
			if(y+3<t) {
				int res =0;
				for(int i=0;i<4;i++) {
					res+=map[y+i][x];
				}
				return res;
			} else {
				return impossible;
			}
		} else if(k==2) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==3) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==4) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==5) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==6) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==7) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==8) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==9) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==10) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==11) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==12) {
			int res = map[y][x];
			if(x+2<t && y+1<t) {
				res+=map[y][x+1];
				res+=map[y+1][x+1];
				res+=map[y+1][x+2];
				return res;
			} else {
				return impossible;
			}
		} else if(k==13) {
			int res = map[y][x];
			if(x+1<t && y-2>=0) {
				res+=map[y][x+1];
				res+=map[y+1][x];
				res+=map[y+1][x+1];
				return res;
			} else {
				return impossible;
			}
		} 
		return impossible;
	}
}
