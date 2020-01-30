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
	static int arr_n[];
	static int arr_m[];
	static int n,m;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int stoi(String num) {
		return Integer.parseInt(num);
	}
	
	public static void input() {
		
		String str_n = br.readLine();

		for(int index = 0; index < n ; index++) {
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		String tc = br.readLine();
		int test = Integer.parseInt(tc);
		String nm =br.readLine();
		String num[] = nm.split(" ");
		n = stoi(num[0]);
		m = stoi(num[1]);
		arr_n = new int[n];
		arr_m = new int[m];
		
		input();
		
	}

}
