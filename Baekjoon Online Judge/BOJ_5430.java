package algorithm_2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
		    String order = br.readLine();
		    int size     = Integer.parseInt(br.readLine());
		    String number= br.readLine();
		    int arr[]    = new int[size];
		    int s=0,e=size-1,r=0;
		    String numberList[] = number.split(",");
			for(int j=0;j<size;j++) {
			    String now = numberList[j]; 
				if(j==0 || j==size-1) {
			    	 now = now.replace("[","");
			    	 now = now.replace("]","");
			    }
				arr[j] = Integer.parseInt(now);
			}
		    int len = order.length();
			for(int j=0;j<len;j++){
				char now = order.charAt(j);
				if(now=='D'){
				  if(r%2==0){
					 s++;
					}else {
					 e--;
					}				  
				} else {
				   r++;
				}
				
			}
			if(s>=size+1 || e < -1) {
			  sb.append("error");
			} else {
			  if(r%2==0) {
				 sb.append("[");
				 for(int ii=s;ii<=e;ii++) {
					 sb.append(arr[ii]);
					 if(ii!=e) {
						 sb.append(",");
					 }
				 }
				 sb.append("]");
			  } else {
				 sb.append("[");
					for(int ii=e;ii>=s;ii--) {
						 sb.append(arr[ii]);
						 if(ii!=s) {
							 sb.append(",");
						 }
					 }
				 sb.append("]");	  
			  }
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
