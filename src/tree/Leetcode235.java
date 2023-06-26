package tree;

/**
 * @Author Lc
 * @Date 2023/6/26
 * @Description 二叉搜索树查找最近公共祖先
 */
public class Leetcode235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root6 = new TreeNode(6);
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root2.left = root1;
        root2.right = root3;
        root.right = root6;
        lowestCommonAncestor(root,root3,root6);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p.val < root.val && q.val < root.val){
            TreeNode left =  lowestCommonAncestor(root.left,p,q);
            if(left != null){
                return left;
            }
        }else if(p.val > root.val && q.val > root.val){
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(right != null){
                return right;
            }
        }
        return root;
    }
}
