package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		double nn[] = new double[n];
		int answer =0;
		double max =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)nn[i] =Double.parseDouble(st.nextToken());Arrays.sort(nn);
 		for(int i=0;i<n;i++) {
			double now = nn[i];
			if(answer ==0) {
				answer =1;
				max = now - 0.5 + l;
				continue;
			}
			
			if(now + 0.5 >max) {
				answer ++;
				max = now-0.5+l;
			} 
		}System.out.println(answer);
	}

}
