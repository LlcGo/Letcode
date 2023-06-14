package tree;


/**
 * @Author Lc
 * @Date 2023/6/13
 * @Description  判断树的节点之和是否有 这个值
 */
public class Letcode112 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode LeftTreeNode4 = new TreeNode(4);
        TreeNode LeftTreeNode11 = new TreeNode(11);
        TreeNode LeftTreeNode7 = new TreeNode(7);
        TreeNode RightTreeNode2 = new TreeNode(2);
        treeNode.left = LeftTreeNode4;
        LeftTreeNode4.left = LeftTreeNode11;
        LeftTreeNode11.left = LeftTreeNode7;
        LeftTreeNode11.right = RightTreeNode2;
        boolean b = hasPathSum(treeNode, 22);
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        //回溯
        targetSum -= root.val;
        //到遍历到根节点了 判断是为0
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if(root.left != null){
            if(hasPathSum(root.left,targetSum)){
                return true;
            }
        }

        if(root.right != null){
            if(hasPathSum(root.right,targetSum)){
                return true;
            }
        }
        return false;
    }
}
