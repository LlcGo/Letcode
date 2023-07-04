package tree;

/**
 * @Author Lc
 * @Date 2023/7/4
 * @Description 二叉搜索树转换为累加树
 */
public class Leetcode538 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode0 = new TreeNode(0);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode.right = treeNode6;
        treeNode6.left = treeNode5;
        treeNode6.left = treeNode7;
        treeNode7.left = treeNode8;
        convertBST(treeNode);
    }
    static TreeNode pre = null;
    public static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        convertBST(root.right);
        if(pre != null){
            root.val = root.val + pre.val;
        }
        pre = root;
        convertBST(root.left);
        return root;
    }
}
