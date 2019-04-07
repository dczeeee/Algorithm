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
	
	// 2.1中序遍历，递归
	public static void InOrder(TreeNode root) {
		if(root == null)
			return;
		InOrder(root.left);
		System.out.println(root.val + " -> ");
		InOrder(root.right);
	}
	
	// 2.2中序遍历，非递归
	public static void InOrder_No(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>(); // 辅助栈
	    TreeNode cur = root;
	    while(cur != null || !stack.isEmpty()) {
	    	while(cur != null) { // 不断将左子节点入栈，直到cur为空
	    		stack.push(cur);
	    		cur = cur.left;
	    	}
	    	if(!stack.isEmpty()) {// 栈不为空，弹出栈元素
	    		cur = stack.pop();// 此时弹出最左边的节点
	    		System.out.println(cur.val + " -> ");// 中序遍历，先打印左子节点在打印当前节点，然后再把右子节点加到栈中
	    		cur = cur.right;// 令当前节点为右子节点
	    	}
	    }
	}
	
	// 3.1后序遍历，递归
	public static void PostOrder(TreeNode root) {
		if(root == null)
			return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.println(root.val + " -> ");
	}
	
	// 3.2后序遍历，非递归，双栈法
	public static void PostOrder_No(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>(); // 保存树节点
	    Stack<TreeNode> stack2 = new Stack<>(); // 保存后序遍历的结果
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
	// 4.层次遍历
	//思路：分层遍历二叉树（按层次从上到下，从左到右）迭代，相当于广度优先搜索，使用队列实现。队列初始化，
	//将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点，访问，若左子节点或右子节点不为空，将其压入队列。
	public static void levelTraversal(TreeNode root){
	    if(root == null) {
	        return;
	    }
	    Queue<TreeNode> queue = new LinkedList<>(); // 对列保存树节点
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        TreeNode temp = queue.poll();
	        System.out.print(temp.val + "->");
	        if (temp.left != null) { // 添加左右子节点到对列
	            queue.add(temp.left);
	        }
	        if (temp.right != null) {
	            queue.add(temp.right);
	        }
	    }
	}
	
	// 求二叉树中的节点个数
	/*
	 * 递归解法： O(n)
		如果二叉树为空，节点个数为0
		如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
	 */
	public static int getNodeNumRec(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
	}
	
	/*
	 * 求二叉树的深度（高度）
		递归解法： O(n)
		如果二叉树为空，二叉树的深度为0
		如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
	 */
	public static int getDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
	}
	
	/*
	 * 求二叉树第k层的节点个数
		递归解法： O(n)
		思路：求以root为根的k层节点数目，等价于求以root左孩子为根的k-1层（因为少了root）节点数目 加上以root右孩子为根的k-1层（因为 少了root）节点数目。即：
		
		如果二叉树为空或者k<1，返回0
		如果二叉树不为空并且k==1，返回1
		如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
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
	 * 求二叉树中叶子节点的个数
		递归解法：
		
		如果二叉树为空，返回0
		如果二叉树是叶子节点，返回1
		如果二叉树不是叶子节点，二叉树的叶子节点数 = 左子树叶子节点数 + 右子树叶子节点数
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
	 * 判断两棵二叉树是否相同的树
		递归解法：
		
		如果两棵二叉树都为空，返回真
		如果两棵二叉树一棵为空，另外一棵不为空，返回假
		如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
	 */
	public static boolean isSameRec(TreeNode r1, TreeNode r2) {
	    if (r1 == null && r2 == null) { // 都是空
	        return true;
	    } else if (r1 == null || r2 == null) { // 有一个为空，一个不为空
	        return false;
	    }
	    if (r1.val != r2.val) { // 两个不为空，但是值不相同
	        return false;
	    }
	    return isSameRec(r1.left, r2.left) && isSameRec(r1.right, r2.right); // 递归遍历左右子节点
	}
	

	 
}
