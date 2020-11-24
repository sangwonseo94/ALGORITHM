package algorithm;

public class 가사검색 {

	public static void main(String[] args) {
		

	}

	
	public static class trie{
		
		
		
		static int nodesize = ('Z'-'A')+2;
		static class trienode{
			
			trienode child[] = new trienode[nodesize];
			int isCnt =0;
		}
		static trienode root;
		public trie() {
			root = new trienode();
		}
		
		public void insert(String t) {
			
			trienode pointer = root;
			for(int i =0 ; i < t.length(); i++) {
				char c = t.charAt(i);
				int index = 0;
				if(c=='?') {index = nodesize-1;}
				else {index = c-'a';}
				
				if(pointer.child[index]==null) {pointer.child[index] = new trienode();}
				
				
				pointer = pointer.child[index];
				pointer.isCnt+=1;
				
				
				
			}
			pointer.isCnt+=1;
		}
		
		
		public int search(String t) {
			trienode pointer = root;
		}
		
	}
	
	
	public static int[] solution(String[] words, String[] queries) {
		
        int[] answer = {};
        return answer;
    }
}
