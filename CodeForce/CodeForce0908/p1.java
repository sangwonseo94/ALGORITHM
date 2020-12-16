package CodeForce0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1 {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int arr[]=new int[n];
			int sum=0;
			Stack<Integer> s = new Stack<>();
			for(int i = 0 ; i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(i%2==0)sum+=(arr[i]);
				else sum -=arr[i];
				s.add(arr[i]);
			}
			
			
		}System.out.println(sb);
		
	}
	 public static int solution(int n, int s, int a, int b, int[][] fares) {
		 
	        int answer = 0;
	        
	        int map[][] = new int[n+1][n+1];
	        for(int i =0;i<n+1;i++)for(int j=0;j<n+1;j++) {
	        	map[i][j] = 2147000000;
	        	
	        }
	        for(int i = 0 ; i < fares.length; i++) {
	        	map[fares[i][1]][fares[i][0]] = fares[i][2];
	        	map[fares[i][0]][fares[i][1]] = fares[i][2];
	        }
	        
	     
	      
	        
	        for(int mid = 0 ; mid < n+1 ; mid++) {
	        	for(int star = 0 ; star< n+1; star++) {
	        		for(int end=0; end<n+1 ; end++) {
	        			if(map[star][mid]!=2147000000 && map[mid][end]!= 2147000000){
	        				if(map[star][end] > map[star][mid] + map[mid][star]) {
	        					map[star][end] = map[star][mid] + map[mid][star];
	        				}
	        			}
	        		}
	        	}
	        }
	        
	        int min = map[n][a] + map[n][b];
	        
	        for(int i = 0 ; i < n+1 ; i++) {
	        	if(min > map[n][i] + map[i][a] + map[n][i]+ map[i][n]) {
	        		min=map[n][i] + map[i][a] + map[n][i]+ map[i][n];
	        	}
	        }
	        
	        
	        return min;
	    }
}
