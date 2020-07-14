package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요세푸스순열 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// n이되면 %n을 대입해주고, 유효한 k를 충족했을때에 그것을 sb에 넣고 true로 한다.
		int person[] = new int[n];
		for(int i = 0 ; i < n ; i++) person[i] = i;
		int cnt =0;
		int index =0;
		int vaild =0;
		sb.append("<");
		while(cnt < n) {
			index+=1;
			if(index == n) index =0;
			if(person[index] >=0) {
				vaild++;
			}
			if(person[index] <0) continue;
			if(vaild ==k) {
				
				cnt++;
				vaild = 0;
				if(person[index]==0) person[index] = n;
				if(cnt < n) sb.append(person[index]+", ");
				else sb.append(person[index]);
				person[index] = -1;
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
