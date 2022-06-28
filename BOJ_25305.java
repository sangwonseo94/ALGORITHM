import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_25305 {

public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;) {
			arr[i] = Integer.parseInt(st.nextToken());
			++i;
		}

		Arrays.sort(arr);
		
		System.out.println(arr[N-K]);
	}
}
