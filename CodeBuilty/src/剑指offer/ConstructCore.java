package 剑指offer;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历构建二叉树
 * 
 * @author caojuan 16-5-4
 *
 */
public class ConstructCore {
	public BinaryTreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
		boolean isHave = false;
		if (preorder == null || inorder == null||preorder.length==0) {
			System.out.println("输入序列为空！");
			return null;
		}
		if (preorder.length != inorder.length) {
			System.out.println("长度不一样－非法输入!");
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode();
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				isHave = true;
				root.data = inorder[i];
				System.out.println(root.data);
				root.left = constructCore(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
				root.right = constructCore(Arrays.copyOfRange(preorder, i + 1, preorder.length),
						Arrays.copyOfRange(inorder, i + 1, inorder.length));
			}
		}
		if (!isHave) {
			throw new Exception("不包含根节点－非法输入");
		}
		return root;
	}

	public static void main(String args[]) throws Exception {
		ConstructCore test = new ConstructCore();
		int[] pre = { 1, 2, 4, 7,3,5,6,8};
		int[] in = { 4, 7,2, 1,5, 3,8,6};
		int[] pre1={1};
		int[] in1={};
		BinaryTreeNode root = test.constructCore(pre1, in1);
	}
}
