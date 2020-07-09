package solvedClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int index[] = new int['z'-'a'+1];
		Arrays.fill(index, -1);
		for(int i = 0 ; i < str.length() ; i++) {
			if(index[str.charAt(i)-'a']==-1)
			index[str.charAt(i)-'a']=i;}
		for(int i = 0 ; i < 'z'-'a'+1 ; i++) {System.out.print(index[i]+" ");}
	}
}
