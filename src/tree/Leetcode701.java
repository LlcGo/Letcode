package tree;

/**
 * @Author Lc
 * @Date 2023/6/27
 * @Description 二叉搜索树中的插入操作
 */
public class Leetcode701 {

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode4.left = treeNode2;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode4.right = treeNode7;
        TreeNode treeNode = insertIntoBST(treeNode4, 5);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            //遍历到根节点返回要插入的值
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
