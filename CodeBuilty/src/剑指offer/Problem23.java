package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：从上往下打印出二叉树的每个节点，同一层的节点按照从左往右的顺序打印
 * @author caojuan 2016-06-18
 *
 */
public class Problem23 {
	public void printFromTopToButtom(BinaryTreeNode root){
		//如果二叉树为空
		if (root==null) {
			System.out.println("the Tree is nulll.");
			return ;
		}
		//定义一个队列来存放树种的节点
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		//如果队列中的元素没有全部出队列则一直循环
		while(!queue.isEmpty()){
			//当前结点为队列的头节点
			BinaryTreeNode tmpNode=queue.peek();
			//将当前结点出队列
			queue.poll();
			System.out.print(tmpNode.data+" ");
			//如果当前结点有左节点，则将左节点加入队列
			if (tmpNode.left!=null) {
				queue.add(tmpNode.left);
			}
			//如果当前结点有右节点则将右节点加入队列
			if (tmpNode.right!=null) {
				queue.add(tmpNode.right);
			}
		}
	}
	public static void main(String []args){
		Problem23 test=new Problem23();
		//     8
		//   /   \
		//  6    10
		// / \   / \
		//5   7 9  11
		BinaryTreeNode root=new BinaryTreeNode();
		BinaryTreeNode node1=new BinaryTreeNode();
		BinaryTreeNode node2=new BinaryTreeNode();
		BinaryTreeNode node3=new BinaryTreeNode();
		BinaryTreeNode node4=new BinaryTreeNode();
		BinaryTreeNode node5=new BinaryTreeNode();
		BinaryTreeNode node6=new BinaryTreeNode();
		root.left=node1;
		root.right=node2;
		root.left.left=node3;
		root.left.right=node4;
		root.right.left=node5;
		root.right.right=node6;
		root.data=8;
		node1.data=6;
		node2.data=10;
		node3.data=5;
		node4.data=7;
		node5.data=9;
		node6.data=11;
		test.printFromTopToButtom(root);
		//test2
		//		  1
		//		 /
		// 		3
		//     /
		//    5
		//	 /
		//  7
		// /
		//9
		System.out.println();
		BinaryTreeNode root2=new BinaryTreeNode();
		root2.data=1;
		root2.left=new BinaryTreeNode();
		root2.left.data=3;
		root2.left.left=new BinaryTreeNode();
		root2.left.left.data=5;
		root2.left.left.left=new BinaryTreeNode();
		root2.left.left.left.data=7;
		root2.left.left.left.left=new BinaryTreeNode();
		root2.left.left.left.left.data=9;
		test.printFromTopToButtom(root2);
		System.out.println();
		test.printFromTopToButtom(null);
	}
}
