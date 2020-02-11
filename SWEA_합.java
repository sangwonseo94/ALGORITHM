package practice;


import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWEA_합
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			int dp[] =  new int[N];
			
			boolean minus = true;
			st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index < N; index++) {
				arr[index] = Integer.parseInt(st.nextToken());
				if(arr[index] > 0) minus = false;
			}
			if(minus) {
				System.out.println("#" + test_case + " "+ check(arr));
			}
			
			else {
			int res = 0;
				for(int i = 0 ; i < N ; i++) {
					boolean com = true;
					int sum = 0;
					if( arr[i] <= 0) continue;
					for(int j = i ; j < N ; j++) {
						sum += arr[j];
						if(sum <= 0) {
							i =j;
							com = false;
							break;	
						}
						if(com)dp[i] = Math.max(dp[i], sum);
						
					}
					
				}
				for (int i : dp) {
					res = Math.max(i, res);
				}
			System.out.println("#" + test_case + " "+ res);
			}
		}
	}

	private static int check(int[] arr) {
		int min= Integer.MIN_VALUE;
		for(int index = 0 ; index < arr.length ; index++) {
			min = Math.max(min, arr[index]);
		}
		return min;
	}
}