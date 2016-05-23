package 剑指offer;

/**
 * 题目：输入两颗二叉树A和B，判断B是不是A的子结构
 * @author caojuan 16-5-20
 *
 */
public class Problem18 {
	/**
	 * 判断A中是否有与B中根节点值相同的节点
	 * @param root1 二叉树A
	 * @param root2 二叉树B
	 * @return
	 */
	public boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
		boolean result=false;
		if (root1==null) {
			return false;
		}
		if (root2==null) {
			return true;
		}
		if (root1.data==root2.data) {
			result=DoseTree1HavaTree2(root1, root2);
		}
		if (result) {
			return true;
		}
		return hasSubTree(root1.left, root2)||hasSubTree(root1.right, root2);
	}
	/**
	 * 判断A中和B中具有相同值得节点是否具有B中的子结构
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean DoseTree1HavaTree2(BinaryTreeNode root1,BinaryTreeNode root2){
		if (root1==root2) {
			return true;
		}
		if (root1==null) {
			return false;
		}
		if (root2==null) {
			return true;
		}
		//如果两个节点的值相等，则分别判断左子节点和右子节点
		if (root1.data==root2.data) {
			return DoseTree1HavaTree2(root1.left, root2.left)&&DoseTree1HavaTree2(root1.right, root2.right);
		}
		return false;
	}
	public static void main(String []args){
		Problem18 test=new Problem18(); 
		BinaryTreeNode head=new BinaryTreeNode();
		BinaryTreeNode root2=new BinaryTreeNode();
		head.data=8;
		head.left=new BinaryTreeNode();
		head.left.data=8;
		head.left.left=new BinaryTreeNode();
		head.left.left.data=9;
		head.left.right=new BinaryTreeNode();
		head.left.right.data=2;
		head.left.right.left=new BinaryTreeNode();
		head.left.right.left.data=4;
		head.left.right.right=new BinaryTreeNode();
		head.left.right.right.data=7;
		head.right=new BinaryTreeNode();
		head.right.data=7;
		
		root2.data=8;
		root2.left=new BinaryTreeNode();
		root2.left.data=9;
		root2.right=new BinaryTreeNode();
		root2.right.data=2;
		System.out.println(test.hasSubTree(head, root2));
		System.out.println(test.hasSubTree(root2, head));
		System.out.println(test.hasSubTree(root2, root2));
		System.out.println(test.hasSubTree(null, root2));
		System.out.println(test.hasSubTree(root2, null));
	}
}
