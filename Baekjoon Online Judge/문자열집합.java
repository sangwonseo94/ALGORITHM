package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열집합 {

	public static class trie{
		
		static trienode root;
		
		public trie() {
			root = new trienode();
		}
		
		class trienode{
			trienode child[] = new trienode['Z'-'A'+1];
			boolean isfinish=false;
		}
	
		public void insert(String t) {
			trienode pointer = root;
			for(int i = 0 ; i < t.length() ; i++) {
				int index = t.charAt(i)-'a';
				if(pointer.child[index]==null) {
					pointer.child[index] = new trienode();
				}
				pointer = pointer.child[index];
			}
			pointer.isfinish=true;
			return;
		}
		
		
		public boolean search(String t) {
			trienode pointer = root;
			for(int i = 0 ; i < t.length() ; i++) {
				int index = t.charAt(i)-'a';
				if(pointer.child[index]==null) {
					return false;
				}
				pointer = pointer.child[index];
			}
			boolean res = (pointer!=null)&&pointer.isfinish;
			return res ;
			
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		trie t = new trie();
		for(int i = 0 ; i < n;i++) {t.insert(br.readLine());}
		int answer =0;
		for(int i = 0 ; i < m ; i ++) {
			if(t.search(br.readLine())) {
				answer++;
			}
		}System.out.println(answer);
	}

}
