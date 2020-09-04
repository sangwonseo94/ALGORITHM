package practice;


import java.util.Scanner;
import java.util.Arrays;

class Solution
{
    static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
   	    int max =10001;
        int N,M , map[][] ,ans = max;
	
        int T =  sc.nextInt();
			
		for(int test_case = 1; test_case <= T; test_case++)
		{
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		
		for (int row[] : map) {
			Arrays.fill(row, max);
		}
            
		for(int index= 0 ; index < M ;index++) {
			map[sc.nextInt()][sc.nextInt()] = sc.nextInt(); 
		}
            
		for(int mid = 1 ; mid <= N ; mid++) {
			for(int start = 1 ; start<= N ; start++) {
				for(int end = 1; end <= N ; end++) {
					if(map[start][mid] != max && map[mid][end] != max) {
						if(map[start][end] > map[start][mid] + map[mid][end]) {
							map[start][end] = map[start][mid] + map[mid][end];
						}
                        if(start == end) {
							ans = Math.min(ans, map[start][start]);
						}
					}		
				}
			}	
		}
		
		if(ans != max) System.out.println("#" + test_case +" "+ans);
     	else System.out.println("#" + test_case +" "+(-1));
		ans = max;
        
        }
	}
}