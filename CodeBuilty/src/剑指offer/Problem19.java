package 剑指offer;

import java.awt.HeadlessException;

/**
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * @author caojuan 16-5-23
 *
 */
public class Problem19 {
	public void MirrorRecursively(BinaryTreeNode head) {
		if (head != null) {
			BinaryTreeNode tmpNode = new BinaryTreeNode();
			//交换左右子节点
			tmpNode = head.left;
			head.left = head.right;
			head.right = tmpNode;
			//交换左右子节点的子节点
			MirrorRecursively(head.left);
			MirrorRecursively(head.right);
		}
	}
	public void printTree(BinaryTreeNode node){
		if (node!=null) {
			printTree(node.left);
			System.out.print(node.data+" ");
			printTree(node.right);
		}
	}
	public static void main(String []args){
		Problem19 test=new Problem19();
		//      8
		//     / \
		//    6   10
		//   / \  / \
		//  5   7 9  11
		BinaryTreeNode root=new BinaryTreeNode();
		root.data=8;
		root.left=new BinaryTreeNode();
		root.left.data=6;
		root.left.left=new BinaryTreeNode();
		root.left.left.data=5;
		root.left.right=new BinaryTreeNode();
		root.left.right.data=7;
		root.right=new BinaryTreeNode();
		root.right.data=10;
		root.right.left=new BinaryTreeNode();
		root.right.left.data=9;
		root.right.right=new BinaryTreeNode();
		root.right.right.data=11;
		test.printTree(root);
		System.out.println();
		test.MirrorRecursively(root);
		test.printTree(root);
	}
}
