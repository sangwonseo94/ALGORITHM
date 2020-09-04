package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {

	public static int map[][],n,m;
	public static void main(String[] args)throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+3];
		for(int i = 1 ; i < n+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int i = 1 ; i< n+1 ; i++) {
			for(int j=0; j < m ; j++) {
				for(int k = 0 ; k < 19 ; k++) {
					int res = result(k,i,j);
					answer = answer > res ? answer : res;
				}
			}
		}
		System.out.println(answer);
	}

	private static int result(int k, int i, int j) {
		int resV = map[i][j];
		int ii=0,jj=0;
		if(k==0) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+2;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i; jj=j+3;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==1) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+2; jj=j;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+3; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==2) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==3) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+2; jj=j;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+2; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==4) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i; jj=j+2;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==5) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+2; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==6) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+2;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==7) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+2; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==8) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i-1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i-1; jj=j+2;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==9) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+1; jj=j-1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+2; jj=j-1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==10) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+2;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==11) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+2;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==12) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i-1; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==13) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+2;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i-1; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==14) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+2; jj=j;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==15) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+2;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+2;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==16) {
			ii = i+1; jj=j;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i+2; jj=j;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==17) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i-1; jj=j+1;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i-2; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		} else if(k==18) {
			ii = i; jj=j+1;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			
			ii = i; jj=j+2;
			
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			 ii = i+1; jj=j+2;
			if(!isRange(ii, jj)) {
				return 0;
			} else {
				resV+= map[ii][jj];
			}
			return resV;
		}
		
		else {
			return 0;
		}
	}
	private static boolean isRange(int i,int j) {
		return (i<n+1&&i>=1&&j<m&&j>0);
	}

}
