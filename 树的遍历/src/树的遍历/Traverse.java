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
	
	// 2.1����������ݹ�
	public static void InOrder(TreeNode root) {
		if(root == null)
			return;
		InOrder(root.left);
		System.out.println(root.val + " -> ");
		InOrder(root.right);
	}
	
	// 2.2����������ǵݹ�
	public static void InOrder_No(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>(); // ����ջ
	    TreeNode cur = root;
	    while(cur != null || !stack.isEmpty()) {
	    	while(cur != null) { // ���Ͻ����ӽڵ���ջ��ֱ��curΪ��
	    		stack.push(cur);
	    		cur = cur.left;
	    	}
	    	if(!stack.isEmpty()) {// ջ��Ϊ�գ�����ջԪ��
	    		cur = stack.pop();// ��ʱ��������ߵĽڵ�
	    		System.out.println(cur.val + " -> ");// ����������ȴ�ӡ���ӽڵ��ڴ�ӡ��ǰ�ڵ㣬Ȼ���ٰ����ӽڵ�ӵ�ջ��
	    		cur = cur.right;// �ǰ�ڵ�Ϊ���ӽڵ�
	    	}
	    }
	}
	
	// 3.1����������ݹ�
	public static void PostOrder(TreeNode root) {
		if(root == null)
			return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.println(root.val + " -> ");
	}
	
	// 3.2����������ǵݹ飬˫ջ��
	public static void PostOrder_No(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>(); // �������ڵ�
	    Stack<TreeNode> stack2 = new Stack<>(); // �����������Ľ��
	    stack1.add(root);
	    while(!stack1.isEmpty()) {
	    	TreeNode temp = stack1.pop();
	    	stack2.push(temp);
	    	if(temp.left != null) {
	    		stack1.push(temp.left);
	    	}
	    	if(temp.right != null) {
	    		stack1.push(temp.right);
	    	}
	    }
	    while (!stack2.isEmpty()) {
	        System.out.print(stack2.pop().val + " -> ");
	    }
	}
	// 4.��α���
	//˼·���ֲ����������������δ��ϵ��£������ң��������൱�ڹ������������ʹ�ö���ʵ�֡����г�ʼ����
	//�����ڵ�ѹ����С������в�Ϊ�գ��������²���������һ���ڵ㣬���ʣ������ӽڵ�����ӽڵ㲻Ϊ�գ�����ѹ����С�
	public static void levelTraversal(TreeNode root){
	    if(root == null) {
	        return;
	    }
	    Queue<TreeNode> queue = new LinkedList<>(); // ���б������ڵ�
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        TreeNode temp = queue.poll();
	        System.out.print(temp.val + "->");
	        if (temp.left != null) { // ��������ӽڵ㵽����
	            queue.add(temp.left);
	        }
	        if (temp.right != null) {
	            queue.add(temp.right);
	        }
	    }
	}
	
	// ��������еĽڵ����
	/*
	 * �ݹ�ⷨ�� O(n)
		���������Ϊ�գ��ڵ����Ϊ0
		�����������Ϊ�գ��������ڵ���� = �������ڵ���� + �������ڵ���� + 1
	 */
	public static int getNodeNumRec(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
	}
	
	/*
	 * �����������ȣ��߶ȣ�
		�ݹ�ⷨ�� O(n)
		���������Ϊ�գ������������Ϊ0
		�����������Ϊ�գ������������ = max(��������ȣ� ���������) + 1
	 */
	public static int getDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
	}
	
	/*
	 * ���������k��Ľڵ����
		�ݹ�ⷨ�� O(n)
		˼·������rootΪ����k��ڵ���Ŀ���ȼ�������root����Ϊ����k-1�㣨��Ϊ����root���ڵ���Ŀ ������root�Һ���Ϊ����k-1�㣨��Ϊ ����root���ڵ���Ŀ������
		
		���������Ϊ�ջ���k<1������0
		�����������Ϊ�ղ���k==1������1
		�����������Ϊ����k>1������root��������k-1��Ľڵ������root������k-1��ڵ����֮��
	 */
	public static int getNodeNumKthLevelRec(TreeNode root, int k) {
	    if (root == null || k < 1) {
	        return 0;
	    }
	    if (k == 1) {
	        return 1;
	    }
	    return getNodeNumKthLevelRec(root.left, k - 1) + getNodeNumKthLevelRec(root.right, k - 1);
	}
	
	/*
	 * ���������Ҷ�ӽڵ�ĸ���
		�ݹ�ⷨ��
		
		���������Ϊ�գ�����0
		�����������Ҷ�ӽڵ㣬����1
		�������������Ҷ�ӽڵ㣬��������Ҷ�ӽڵ��� = ������Ҷ�ӽڵ��� + ������Ҷ�ӽڵ���
	 */
	public static int getNodeNumLeafRec(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    if (root.left == null && root.right == null) {
	        return 1;
	    }
	    return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
	}
	
	/*
	 * �ж����ö������Ƿ���ͬ����
		�ݹ�ⷨ��
		
		������ö�������Ϊ�գ�������
		������ö�����һ��Ϊ�գ�����һ�ò�Ϊ�գ����ؼ�
		������ö���������Ϊ�գ������Ӧ������������������ͬ�������棬�������ؼ�
	 */
	public static boolean isSameRec(TreeNode r1, TreeNode r2) {
	    if (r1 == null && r2 == null) { // ���ǿ�
	        return true;
	    } else if (r1 == null || r2 == null) { // ��һ��Ϊ�գ�һ����Ϊ��
	        return false;
	    }
	    if (r1.val != r2.val) { // ������Ϊ�գ�����ֵ����ͬ
	        return false;
	    }
	    return isSameRec(r1.left, r2.left) && isSameRec(r1.right, r2.right); // �ݹ���������ӽڵ�
	}
	

	 
}
