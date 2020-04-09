package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class king {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		char[] x = {'A','B','C','D','E','F','G','H'};
		char[] y = {'8','7','6','5','4','3','2','1'};
		int n = Integer.parseInt(temp[temp.length-1]);
		String[] move = new String[n];
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
		String order[] = {"R","L","B","T","RT","LT","RB","LB"};
		for(int i = 0 ; i <n; i++) {move[i] = br.readLine();}
		int kx=0,ky=0,sx=0,sy=0;
		
		for(int i =0; i < 8 ; i ++) {
			if(x[i]==temp[0].charAt(0)) {kx = i;} 
			if(y[i]==temp[0].charAt(1)) {ky = i;}
			if(x[i]==temp[1].charAt(0)) {sx = i;}
			if(y[i]==temp[1].charAt(1)) {sy = i;}
		}
		
		for(int i = 0 ; i < n; i++) {
			
			int index=0;
			for(int j=0;j < 8 ; j++) {
				if(move[i].equals(order[j])) {
					index = j;
				}
			}
			
			int ny=ky+dir[index][0];
			int nx=kx+dir[index][1];
			if(ny < 0 && nx <0 && ny >=8 && nx >= 8) continue;
			else if(ny >= 0 && nx>=0 && ny <8 && nx <8) {
				if(kx+dir[index][1] == sx && ky+dir[index][0] == sy) {
					int nny = sy+dir[index][0];
					int nnx = sx+dir[index][1];
					if(nny < 0 && nnx <0 && nny >=8 && nnx >= 8) continue;
					else if(nny >= 0 && nnx>=0 && nny <8 && nnx <8) {
						kx = nx;
						ky = ny;
						sx = nnx;
						sy = nny; 
					}
				} else {
					kx = nx;
					ky = ny;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(x[kx]).append(y[ky]).append("\n").append(x[sx]).append(y[sy]);
		System.out.println(sb);
		
	}
}
