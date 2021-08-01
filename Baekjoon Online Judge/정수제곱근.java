import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정수제곱근 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		long half = (long) Math.sqrt(num);
		if(pow(half) == num) {
			System.out.println(half);
		} else {
			System.out.println(half+1);
		}
	}

	private static long pow(long half) {
		return half*half;
	}

}
