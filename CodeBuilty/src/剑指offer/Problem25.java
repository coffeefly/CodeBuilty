package ��ָoffer;

import java.util.Stack;

/**
 * ��Ŀ������һ�Ŷ�������һ����������ӡ���������нڵ��ֵ�ú�
 * Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ�
 * �γ�һ��·��
 * @author caojuan 2016-06-18
 *
 */
public class Problem25 {
	/**
	 * 
	 * @param root ������
	 * @param expectedSum ����
	 */
	public void FindPath(BinaryTreeNode root,int expectedSum){
		if (root==null) {
			System.out.println("the tree is null.");
			return;
		}
		//����һ��ջ�������Ѿ����ʹ��Ľڵ�ֵ
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		//��ǰ·���ϵĽڵ�ֵ�ܺ�
		int currentSum=0;
		FindPath(root, expectedSum, stack, currentSum);
	}
	public void FindPath(BinaryTreeNode node,int expectedSum,Stack<BinaryTreeNode> stack,int currentSum){
		currentSum+=node.data;
		stack.push(node);
		//�����ǰ�����Ҷ�ڵ㣬����·���Ͻڵ�ֵ�ĺ͵��������ֵ�����ӡ������·��
		if (node.left==null&&node.right==null&&currentSum==expectedSum) {
			int i=0;
			while(i<stack.size()){
				System.out.print(stack.get(i).data+" ");
				i++;
			}
			System.out.println();
		}
		//�����ǰ��㲻��Ҷ�ӽڵ㣬����������ӽڵ�
		if (node.left!=null) {
			FindPath(node.left, expectedSum, stack, currentSum);
		}
		if (node.right!=null) {
			FindPath(node.right, expectedSum, stack, currentSum);
		} 
		//�ڷ��ظ��ڵ�֮ǰ����·����ɾ����ǰ�ӽڵ㣬currentSum��ȥ��ǰ����ֵ
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
