package practice;

import java.awt.List;
import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class POKETMON {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String str_list[] = str.split(" ");
		int N = Integer.parseInt(str_list[0]);
		int M = Integer.parseInt(str_list[1]);
		
		Map<String, String> m = new HashMap<>();
		
		for(int index = 1 ; index <= N ; index++) {
			String poketmon = br.readLine();
			m.put(poketmon, Integer.toString(index));
			m.put(Integer.toString(index) , poketmon);
		}
		
		for(int index = 1; index <=M ; index++) {
			String Query = br.readLine();
			System.out.println(m.get(Query));
		}
		
		
		
	}

}
