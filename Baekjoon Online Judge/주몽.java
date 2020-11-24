import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class 주몽 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int nn[]= new int[n];
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<n ;i++) {	nn[i] = Integer.parseInt(st.nextToken());	}
		Arrays.sort(nn); int answer=0;
		for(int s =0 ,e = n-1; s <e ;) {
			int mid = nn[s] + nn[e];
			if(mid >m ) {
				e--;
			} else if(m > mid) {
				s++;
			} else {
				answer++;
				s++;e--;
			}
		}System.out.println(answer);
	}

}
