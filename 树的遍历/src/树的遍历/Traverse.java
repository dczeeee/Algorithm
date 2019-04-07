package ���ı���;

import java.util.*;

public class Traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// ���������ݽṹ
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
	
	// 1.1����������ݹ�
	public static void PreOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.val + " -> ");
		PreOrder(root.left);
		PreOrder(root.right);
	}
	
	// 1.2����ǵݹ�
	// ǰ��������ȴ�ӡ��ǰ�ڵ��ڴ�ӡ���ӽڵ㣬Ȼ���ٰ����ӽڵ�ӵ�ջ��
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
			if(!stack.isEmpty()) { //ջ�ǿգ�����ջ��
				cur = stack.pop(); //��������ڵ�
				cur = cur.right; //��ǰ�ڵ�ָ�����ӽڵ�
			}
		}
	}
}
