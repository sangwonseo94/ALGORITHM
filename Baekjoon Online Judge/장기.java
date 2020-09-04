package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 장기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		if(n==3) {
			bw.write("-1");
		} else if((n&1)==1){
			bw.write(n-2+"\n");
			for(int i = 1 ; i < n-2 ; i++) bw.write(i+"\n");
			bw.write(n+"\n");
			bw.write(n-1 +"\n");
		} else {
			bw.write( (n>>1) +"\n");
			for(int i = 1 ; i < (n>>1) ; i++) bw.write(i+"\n");
			for(int i = (( n>>1 )+2 ) ; i<=n  ; i++)bw.write(i+"\n");
			bw.write(((n>>1)+1) + "\n");
		}bw.close();
	}

}
