package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class SWEA_보물상자비밀번호{
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T= Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
			String str = br.readLine().trim(); int size = n/4;
			LinkedList<Integer> LL = new LinkedList<>();
			for(int i=0; i < size;i++) {
				for(int j=0; j < 4 ; j++ ) {
					int push = Integer.decode("#"+str.substring(j*size, (j+1)*size));
					int limit =  LL.size(); boolean check = false;
					for(int k1= 0 ; k1 < limit; k1++) {
						if(push == LL.get(k1)) {
							check = true;
							break;
						} 
					}
					if(!check) {LL.add(push);}
				}
				String temp = (String) str.subSequence(str.length()-1, str.length());
				str= str.substring(0, str.length()-1);
				str = temp +str;
			}
			
			int res[] = new int[LL.size()];
			int arr_size =  res.length;
			for(int index = 0 ; index < arr_size;index++) {
				res[index] = LL.get(index);
			}
			
			Arrays.sort(res);
			int index = res.length-k;
			System.out.println(res[index]);
			
			
		}
		
		
	}

}