import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		long t = Long.parseLong(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			t -= (Long.parseLong(st.nextToken())*Long.parseLong(st.nextToken()));
		}
		System.out.println( (t==0) ?  "Yes": "No");
	}

}
