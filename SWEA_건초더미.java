package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int num[] = new int[N];
			st = new StringTokenizer(br.readLine());
			int sum  =0, ans = 0;
			for(int index = 0 ; index < num.length; index++) {
				num[index] = Integer.parseInt(st.nextToken());
				sum +=num[index];
			}
			for (int i : num) {
				ans += Math.abs(i - sum/N);
			}
			
			sb.append("#" + test_case + " " + (ans/2) + "\n");
		}
		System.out.println(sb.toString());
	}
}