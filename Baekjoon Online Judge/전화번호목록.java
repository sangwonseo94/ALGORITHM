package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전화번호목록 {

	public static class trie{
		
		
		static int childsize = 10;
		static trienode root;
		
		static class trienode{
			
			trienode child[] = new trienode[childsize];
			boolean isfinish = false;
		}
		
		
		public trie() {
			
			 root = new trienode();
		}
		
		
		public void insert(String wantInsert) {
			
			trienode pointer = this.root;
			for(int i = 0 ; i < wantInsert.length() ; i++) {
				int index = wantInsert.charAt(i)-'0';
				if(pointer.child[index]==null) {
					pointer.child[index] = new trienode();
				}
				pointer = pointer.child[index];
			}
			pointer.isfinish=true;
		}
		
		public boolean search(String target) {
			
			
			trienode pointer = this.root;
			
			for(int i = 0 ; i < target.length(); i++) {
				int index = target.charAt(i)-'0';
				if(pointer.child[index]==null) {
					return false;
				}
				
				pointer = pointer.child[index];
				
				// 길이가 끝가지 안갔는데 isfinish가 발견되면 중간길이의 다른문자가 있는것.
				
				if(i < target.length()-1 && pointer.isfinish) {
					
					return false;
				}
				
			}
			return (pointer!=null)&&pointer.isfinish;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			trie trie = new trie();
			
			String str[] = new String[m];
			for(int i = 0 ; i < m ; i ++) {
				str[i] = br.readLine();
				trie.insert(str[i]);
			}
			
			boolean isContiune = true;
			
			for(int i = 0 ; i < m ; i ++) {
				if(trie.search(str[i])) {
					continue;
				} else {
					isContiune =false;
					break;
				}
			}
			String answer = isContiune ? "YES" :"NO";
			sb.append(answer+"\n");
		}System.out.println(sb);
	
	}

}
