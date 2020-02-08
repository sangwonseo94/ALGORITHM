package practice;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 보물상자비밀번호
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int size = n/4;
			String str_ = br.readLine();
			int res[] = new int[n];
			for(int i = 0 ; i <= size-1 ; i++) {
				for(int j= 0 ; j < 4 ; j ++) {
					res[i*4+j] = Integer.decode("#"+str_.substring(j*size , (j+1)*size));
				}
				String temp = str_.substring(str_.length()-1, str_.length());
				str_.replace(temp, "");
				str_ = temp + str_;
			}
			
			
			System.out.println(res[k]);
			
			
            
		}
	}
	
}