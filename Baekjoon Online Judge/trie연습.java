package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class trie연습 {

	public static class trie{
		
		
		// 나올수있는 모든 경우의수는 Z에서 A사이입니다.
		static int childsize = 'Z'-'A'+1;
		
		// ROOT는 값을 가지지않고 오직 TrieNode하나만을 가집니다.
		static trienode root;
		
		// 생성자에서 Root에 TrieNode를 설정해줍니다.
		public trie() {
			root = new trienode();
		}
		
		static class trienode{
			
			trienode child[] = new trienode[childsize];
			
			boolean isfinish = false;
		}
		
		
		// Trie에 문자열을 넣는 과정
		public void insert(String wantInsert) {
			
			// 처음은 root에서 시작합니다.
			trienode pointer = root;
			
			for(int i = 0 ; i < wantInsert.length() ; i++) {
				
				// 입력받은 String을 단계적으로 처리하는 for를 돌리며 넣어줍니다.
				int index = wantInsert.charAt(i)-'A';
				
				// 만약에 index가 null이라면 처음가보는 곳입니다. 없다는 이야기니 trienode를 설정해주어 null이 아니니 현재문자가 존재합니다.
				if(pointer.child[index]==null) {
					pointer.child[index] = new trienode();
				}
				// 있다면은 child를 가리키는 주솟값을 업데이트해줍니다.
				pointer = pointer.child[index];
			}
			
			// 모든 for문이 끝나서 가리키고있는 주솟값에 마지막 글자를 표현해줍니다.
			pointer.isfinish=true;
		}
		
		// Trie에 넣어둔 문자열을 찾는 과정
		public boolean search(String target) {
			
			// 시작은 Root에서 시작합니다.
			trienode pointer = root;
			
			// 한글자씩 탐색합니다.
			for(int i = 0 ; i < target.length(); i++) {
				
				int index = target.charAt(i)-'0';
				
				// 만약 현재 글자에 해당하는 index가 null이라면 insert과정에서 그 단계에 없는 문자입니다.
				
				if(pointer.child[index]==null) {
					return false;
				} 
				
				// 있다면은 그 주솟값으로 이동해줍시다.
				pointer = pointer.child[index];
			}
			// 전체가 끝나서 pointer에 마지막 값을 저장했을때 null이라면 target의 마지막글자가 없는것입니다.
			// 또한 현재 pointer에 마지막글자를 뜻하는 isfinish가 true여야 글자수도맞고, 중간글자도 모두 맞게 검색합니다.
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
				str[i] = br.readLine().trim();
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
