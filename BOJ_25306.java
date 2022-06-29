package algorithm_2022;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25306 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		System.out.println((XOR(n-1)
				 ^XOR(m)));
	}

	private static long XOR(long num) {
		long answer =0;
		if(num%2==1) {
			if( ((num+1)/2)%2==1) {answer++;}
		} else {
			if( ((num)/2)%2==1) {answer++;}
		}
		
	 for(long i=1;i<=num;i*=2) {
			if( (num%(i*2))>=i&&
					 (((num%(i*2))&1)==0) ) {
				answer ^=i;
			}
		
		}
		return answer;
	}
}
