package tree;

/**
 * @Author Lc
 * @Date 2023/7/1
 * @Description 修剪二叉搜索树
 */
public class leetcode669 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode.left = treeNode0;
        treeNode.right = treeNode4;
        treeNode0.left = treeNode2;
        treeNode2.left = treeNode1;
        TreeNode result = trimBST(treeNode, 1, 3);
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        //如果遍历到的值比最小值小的那他不符合要求
        //但是他的右子树可能符合要求
        if(root.val < low ){
            TreeNode right = trimBST(root.right,low,high);
            return right;
        }
        //如果遍历到的值是比现在的根节点大的
        //那么他不符合要求 但是他的左子树比他小可能符合要求
        if(root.val > high){
            TreeNode left = trimBST(root.left,low,high);
            return left;
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;

    }
}
