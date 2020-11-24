package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨거리 {
	static int map[][],n,m,tmp,cnt,ny,nx,mindist,res ,ans = 987654321,index=0;
	static ArrayList<int []> Home = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int Chicken[][] = new int[13][2];
		
		for(int y = 0 ; y< n ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x< n ; x++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp ==1) {
					Home.add(new int[] {y,x});
				
				}else if(tmp == 2) { 
					
					Chicken[index][0] = y;
					Chicken[index][1] = x;
					index++;
				}
			}
		}
		int Chicken_Co[][] = new int[index][2];
		for(int y = 0 ; y< index ; y++) {
			for(int x= 0 ; x < 2 ;x++) {
				Chicken_Co[y][x] =Chicken[y][x];
			}
		}
		int choice[] = new int[index];
		for(int i = 1 ,size = (1<<index) ; i < size ; i++) {
			cnt = 0; 
			for(int j = 0 ; j < index ; j ++) {
				if((i & (1<<j)) != 0 ) {
					choice[j] =1;
					cnt++;
				}
				else choice[j]= 0;
			}
			if(cnt > 0 && cnt <= m) {
				int hsize = Home.size();
				for(int k = 0 ; k < hsize ;  k++) {
					ny = Home.get(k)[0];
					nx = Home.get(k)[1];
					mindist = 987654321;
					for(int j = 0 ; j < index ; j++) {
						if(choice[j] ==1) {
							int temp = distance(nx, ny, Chicken_Co[j][1], Chicken_Co[j][0]);
							mindist = mindist > temp ? temp : mindist;
						}
					}
					res +=mindist;
					if(ans < res) break;
				}
			}
			if(res != 0 && ans > res) ans = res;
			res = 0;
		}
		
		System.out.print(ans);
	
	}
	public static int distance(int x1,int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
