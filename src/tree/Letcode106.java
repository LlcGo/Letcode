package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lc
 * @Date 2023/6/14
 * @Description 中序与后续遍历构造二叉树
 */
public class Letcode106 {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int [] inorder = new int[]{9,3,15,20,7};
        int [] postorder = new int[]{9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }
        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
    }

    private static TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
//        System.out.println("中序左边开始数="+inBegin);
//        System.out.println("中序右边结束数="+inEnd);
//        System.out.println("后续左边开始数="+postBegin);
//        System.out.println("后续右边开始数="+postEnd);
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        System.out.println("后续的最后一个数 ="+postorder[postEnd - 1]);
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置

//        System.out.println("中序遍历要被切割的索引位置" + rootIndex);
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点

        System.out.println("构造树完成根节点为"+inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数

        System.out.println("postEnd= " + (lenOfLeft+postBegin));
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);

        System.out.println("inBegin="+(rootIndex+1) + " postBegin =" + (postBegin + lenOfLeft) + " postEnd =" + (postEnd-1));
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
