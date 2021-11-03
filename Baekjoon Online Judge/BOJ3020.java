import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3020 {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int h1[] = new int[N>>1];
		int h2[] = new int[N>>1];
		for(int i=0;i<N;i++) {
			int h = Integer.parseInt(br.readLine());
			if(i%2==0) {
				h1[i/2] = h;
			} else {
				h2[i/2] = h;
			}
		}
		Arrays.sort(h1);
		Arrays.sort(h2);
		
		int H1[] = new int[H+1];
		int H2[] = new int[H+1];
		int cnt =0;
		int pos =(N>>1)-1;
		int j;
		for(j=H;j>=0 && pos >=0 ;j--) {
			while(pos>=0&&j==h1[pos]) {
				cnt++;pos--;
			}
			H1[j]=cnt;
		}
		
		while(j>=1) {
			H1[j--] = cnt;
		}
		
		cnt=0;pos=(N>>1)-1;
		for(j=H;j>=0&&pos>=0 ;j--) {
			while(pos>=0&&j==h2[pos]) {
				cnt++;pos--;
			}
			H2[j]=cnt;
		}
		while(j>=1) {
			H2[j--] = cnt;
		}
		int answer =987654321;
		int answercnt=0;
		for(int i=1;i<=H;i++) {
			int now = H1[i]+H2[H-i+1];
			if(answer > now) {
				answer = now;
				answercnt=1;
			} else if(answer == now){
				answercnt++;
			}
		}
		System.out.println(answer+" "+answercnt);
	}
}
