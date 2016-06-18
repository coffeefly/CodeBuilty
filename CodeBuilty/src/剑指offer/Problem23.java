package ��ָoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ���������´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ������ҵ�˳���ӡ
 * @author caojuan 2016-06-18
 *
 */
public class Problem23 {
	public void printFromTopToButtom(BinaryTreeNode root){
		//���������Ϊ��
		if (root==null) {
			System.out.println("the Tree is nulll.");
			return ;
		}
		//����һ��������������ֵĽڵ�
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		//��������е�Ԫ��û��ȫ����������һֱѭ��
		while(!queue.isEmpty()){
			//��ǰ���Ϊ���е�ͷ�ڵ�
			BinaryTreeNode tmpNode=queue.peek();
			//����ǰ��������
			queue.poll();
			System.out.print(tmpNode.data+" ");
			//�����ǰ�������ڵ㣬����ڵ�������
			if (tmpNode.left!=null) {
				queue.add(tmpNode.left);
			}
			//�����ǰ������ҽڵ����ҽڵ�������
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
