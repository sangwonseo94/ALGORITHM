package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 미생물격리 {
	static class node{
		int y,x,quantity, dir;
		public node(int y,int x, int q,int d) {
			this.y = y;
			this.x = x;
			this.quantity = q;
			this.dir = d;
		}
	}
	
	static int dir[][]= {{0,0},{-1,0},{1,0},{0,-1},{0,1}};// 0이 y
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc =1 ; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			LinkedList<node> list = new LinkedList<>();
			for(int index = 0 ; index < k; index++) {
				
				st = new StringTokenizer(br.readLine());
				int y= Integer.parseInt(st.nextToken());
				int x= Integer.parseInt(st.nextToken());
				int q= Integer.parseInt(st.nextToken());
				int d= Integer.parseInt(st.nextToken());
				list.add(new node(y,x,q,d));
				
			}
		
			for(int index = 0; index < m ;index ++) {
				int t = list.size();
				for(int i = 0 ; i < t ; i++) {
					
					int d= list.get(i).dir;
					int ny= list.get(i).y+dir[d][0];
					int nx= list.get(i).x+dir[d][1];
					int q= list.get(i).quantity;
					if(ny == n-1 || nx == n-1 || nx == 0 || ny ==0) {
						q =q/2;
						
						int tempd=0;
						if(d ==1) tempd=2;
						if(d ==2) tempd=1;
						if(d ==3) tempd=4;
						if(d ==4) tempd=3;
						d = tempd;
					}
				
					list.get(i).x=nx;
					list.get(i).y=ny;
					list.get(i).quantity=q;
					list.get(i).dir=d;
				}
				
				int max[][]= new int[n][n];
				int dire[][] = new int[n][n];
				int sum[][] = new int[n][n];
				
				for(int i= 0 ; i < list.size();i++) {
					
					int x = list.get(i).x;
					int y = list.get(i).y;
					int d = list.get(i).dir;
					int q = list.get(i).quantity;
					
					if(max[y][x]==0) {
						max[y][x] = q;
						dire[y][x]= d;
						sum[y][x] += q;
						continue;
					}
					else if(max[y][x] >0) {
						if(max[y][x] < q){
							max[y][x] = q;
							dire[y][x]= d;
						}
						sum[y][x] = sum[y][x]+ q;
					}
					else sum[y][x] +=q;
				}
				
				list.clear();
				list= new LinkedList<>();
				for(int y= 0 ; y < n; y++) {
					for(int x= 0 ; x< n ;x++) {
					if(max[y][x] !=0) list.add(new node(y,x,sum[y][x],dire[y][x]));
						
					}
				}
				
			}
			long answer =0;
			for (node node : list) {
				answer += node.quantity;
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}

}
