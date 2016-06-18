package 剑指offer;

import java.util.Stack;

/**
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中节点的值得和
 * 为输入整数的所有路径，从树的根节点开始往下一直到叶节点所经过的节点
 * 形成一条路径
 * @author caojuan 2016-06-18
 *
 */
public class Problem25 {
	/**
	 * 
	 * @param root 二叉树
	 * @param expectedSum 整数
	 */
	public void FindPath(BinaryTreeNode root,int expectedSum){
		if (root==null) {
			System.out.println("the tree is null.");
			return;
		}
		//定义一个栈来保存已经访问过的节点值
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		//当前路径上的节点值总和
		int currentSum=0;
		FindPath(root, expectedSum, stack, currentSum);
	}
	public void FindPath(BinaryTreeNode node,int expectedSum,Stack<BinaryTreeNode> stack,int currentSum){
		currentSum+=node.data;
		stack.push(node);
		//如果当前结点是叶节点，并且路径上节点值的和等于输入的值，则打印出这条路径
		if (node.left==null&&node.right==null&&currentSum==expectedSum) {
			int i=0;
			while(i<stack.size()){
				System.out.print(stack.get(i).data+" ");
				i++;
			}
			System.out.println();
		}
		//如果当前结点不是叶子节点，则遍历它的子节点
		if (node.left!=null) {
			FindPath(node.left, expectedSum, stack, currentSum);
		}
		if (node.right!=null) {
			FindPath(node.right, expectedSum, stack, currentSum);
		} 
		//在返回父节点之前，在路径上删除当前子节点，currentSum减去当前结点的值
		currentSum-=node.data;
		stack.pop();
	}
	public static void main(String []args){
		Problem25 test=new Problem25();
		BinaryTreeNode root=new BinaryTreeNode();
		root.data=10;
		root.left=new BinaryTreeNode();
		root.left.data=5;
		root.left.left=new BinaryTreeNode();
		root.left.left.data=4;
		root.left.right=new BinaryTreeNode();
		root.left.right.data=7;
		root.right=new BinaryTreeNode();
		root.right.data=12;
		test.FindPath(root, 22);
		System.out.println("test2:");
		test.FindPath(null, 8);
		System.out.println("test3:");
		test.FindPath(root, 25);
	}
}
