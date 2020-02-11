package practice;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TreeNode {
	char data;
	int idx , num;
	TreeNode left;
	TreeNode right;
	public TreeNode(int idx) {this.idx = idx;}
	public TreeNode(int idx , int data) {
		this.idx = idx;
		this.num = data;
 	}
	public TreeNode(int idx , char data) {
		this.idx = idx;
		this.data = data;
 	}
	public TreeNode(int idx , char data , int lnode , int rnode) {
		this.data = data;
		this.idx = idx;
		this.left = new TreeNode(lnode);
		this.right= new TreeNode(rnode);
	}
}

class Binary_Linked_Tree{
	TreeNode root;
	public void Make_Tree(char ch, int idx){
		 if(root== null) {
			 root = new TreeNode(ch,idx); 
			 return;
		 }
		 MakeTree(root, ch);
	}
	
	
	private void MakeTree(TreeNode root, char ch) {
		if(root !=null) {
			TreeNode now = new TreeNode(ch);
			if(root.left == null){
				root.left = now;
				return;
			}
			if (root.right == null) { 
				root.right=now;
				MakeTree(root.right , ch);
				return;
			}
			
			MakeTree(root.left , ch);
			
		}
		
		
	}
	
	
	public void postorder(TreeNode node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			// 구현
		}
	}
}


class SWEA_사칙연산유효성검사{
	public static void main(String args[]) throws Exception{
		
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= T; test_case++){
			int n = Integer.parseInt(br.readLine());
			int str_cnt = 0 , int_cnt=0; 
			for(int index = 0 ; index < n ; index++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
			}
			

		}
	}
}