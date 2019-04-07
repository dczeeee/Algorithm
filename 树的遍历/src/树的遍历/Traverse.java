package 树的遍历;

import java.util.*;

public class Traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 二叉树数据结构
	public class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode() {
			
		}
		
		public TreeNode(int val) {
			this.val =val;
		}
	}
	
	// 1.1先序遍历，递归
	public static void PreOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.val + " -> ");
		PreOrder(root.left);
		PreOrder(root.right);
	}
	
	// 1.2先序非递归
	// 前序遍历，先打印当前节点在打印左子节点，然后再把右子节点加到栈中
	public static void PreOreder_No(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				System.out.println(cur.val + " -> ");
				cur = cur.left;
			}
			if(!stack.isEmpty()) { //栈非空，弹出栈顶
				cur = stack.pop(); //弹出最左节点
				cur = cur.right; //当前节点指向右子节点
			}
		}
	}
}
