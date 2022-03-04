package algorithm_2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {

	
	 public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder   sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> hm = new HashMap<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String val = st.nextToken();
			hm.put(key, val);
		}
		for(int i=0;i<M;i++) {sb.append(hm.get(br.readLine())+"\n");}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	 }
}
