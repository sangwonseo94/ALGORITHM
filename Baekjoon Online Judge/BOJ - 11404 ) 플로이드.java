package com.ssafy.array.fillcell;

import java.util.Scanner;

public class Main {
	static int num;
	static int INF = 2147000000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		int graph[][] = new int[num+1][num+1];
		int bus = scan.nextInt();

		for(int y = 1 ; y <= num ; y++) {
			for(int x = 1 ; x <= num ; x++) {
				graph[y][x] = INF;
				if(y==x) graph[y][x] = 0;
			}
		}
	
		for(int index = 0 ; index < bus; index++) {
			int start , end  , cost ;
			start = scan.nextInt();
			end = scan.nextInt();
			cost = scan.nextInt();
			if(graph[start][end] > cost) graph[start][end] = cost;
			
		}
		
		
	
		
		for(int mid = 1;  mid<= num ;  mid++) {
			for(int start = 1 ; start <= num ; start++) {
				for(int end = 1 ; end <= num ; end ++) {
					if(graph[end][mid] != INF && graph[mid][start] != INF) {
						/// 중간거치는 값에서 INF가 나오면 업데이트가 안된다.
						if(graph[end][start] > graph[end][mid] + graph[mid][start]){
							graph[end][start] = graph[end][mid] + graph[mid][start];
						}
					}
				}
			}
		}
		for(int y = 1 ; y <= num ; y++) {
			for(int x = 1 ; x <= num ; x++) {
				if(graph[y][x] == INF) System.out.print(0+" ");
				else System.out.print(graph[y][x]+ " ");
			}
			System.out.println();
		}
		
	}

}
