package 푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ȣ�߰��ϱ� {
		static int len  , ans = Integer.MIN_VALUE;
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); len = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()); String str = st.nextToken();
		if(len ==1) System.out.println(Integer.parseInt(str));
		else{
			bracket(str , 0);
			System.out.println(ans);
		}
	}
		private static void bracket(String str , int index) {
			// str.size�� index �� ������ ���ó��!
			if(str.length()-1 <= index) {
				ans = Math.max(ans, result(str));
				return;
			}
			
			else {
				char oper[] = str.toCharArray();
				String com = compute(oper[index] , oper[index+1] , oper[index+2]);
				String str_left = str.substring(0, index);
				String str_right = str.substring(index+3, str.length());
				int add = com.length() +1; 
				bracket(str_left + com + str_right , index+add);
				bracket(str , index +2);
			}
		}
		
		private static int result(String str) {
			if(str.length()==1) return Integer.parseInt(str);
			
			int sum =0,num=0,index_ =0;
			char list[] = str.toCharArray() , op = 0;
			if('0' <= list[0] && list[0] <= '9') {
				if('0' <= list[1] && list[1] <= '9') {
					sum =(list[0]-'0')*10 +(list[1]-'0');
					index_=2;
				}
				else{
					sum =(list[0]-'0');
					index_=1;
				}	
			}
			else {
				sum = (-(list[1]-'0'));
				index_ =2;
			}
			
			for(int index= index_; index < str.length(); ) {
				boolean minus = false;
				if(list[index] =='*' || list[index]=='-' || list[index]=='+') {
					op = list[index];
					index++;
					if(list[index]=='-') {
						minus = true;
						index++;
					}
				}
				if('0' <= list[index] && list[index] <= '9') {	
					if( index +1 < str.length() && '0' <= list[index+1] && list[index+1] <= '9') {
						num =((int)(list[index]-'0'))*10 +((int)(list[index+1]-'0'));
						index+=2;
					}	
					else{
						num =(list[index]-'0');
						index+=1;
					}
				}
				if(minus) num = (-num);
				sum =compute2(sum,op,num);
			}
			return sum;
		}
		
		private static int compute2(int sum, char op, int num) {
			if(op=='+')return sum +num;
			if(op=='*')return sum*num;
			if(op=='-')return sum-num;
			return 0;
		}
		private static String compute(char c, char d, char e) {
			String res ="";
			if(d =='+') res = Integer.toString((c-'0') + (e -'0'));
			else if(d =='-') res = Integer.toString((c-'0') - (e -'0'));
			else if(d =='*') res = Integer.toString((int)(c-'0') * (int)(e -'0'));
			return res;
		}

}
 