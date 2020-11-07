package algorithm;

import java.util.Arrays;

public class 쿼드압축후개수세기 {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(
						solution(new int[][] 	{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})
				)
		);
	}


	public static int zero =0;
	public static int one =0;
	public static int[] solution(int arr[][]) {
		depth(0,0,arr.length,arr);
		return new int[] {one,zero};
	}
	
	public static void depth(int y,int x,int size, int[][] arr) {
		int cntz =0;
		int cnto =0;
		
		for(int i=y;i<y+size ; i++) {for(int j=x; j<x+size ;j++) {if(arr[i][j]==0) cntz++;	else cnto++;}}
		
		if(cnto==size*size) {
			one++;
			return;
		} else if(cntz==size*size) {
			zero++;
			return;
		} else {
			int yy = size>>1;
		    int xx = size>>1;
		    int ssize = size >>1;
			depth(y,x,ssize,arr);
			depth(y,x+xx,ssize,arr);
			depth(y+yy,x,ssize,arr);
			depth(y+yy,x+xx,ssize,arr);
		}
		return;
	}
}
