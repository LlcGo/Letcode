package tree;

/**
 * @Author Lc
 * @Date 2023/6/21
 * @Description 验证搜索二叉树
 */
public class Leetcode98 {

    private static TreeNode pre = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root4 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        TreeNode root6 = new TreeNode(6);
        root.left = root1;
        root.right = root4;
        root4.left = root3;
        root4.right = root6;
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    public static boolean isValidBST(TreeNode root){
        //如果是空节点那一定是二叉搜索树
        if(root == null){
            return true;
        }
        //中序遍历
        boolean left = isValidBST(root.left);
        //如果前面一个节点比后面一个节点大或者相等那一定不是二叉搜索树
        if(pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return right && left;
    }
}
