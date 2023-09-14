package tree;

/**
 * @Author Lc
 * @Date 2023/9/14
 * @PackageName: tree
 * @ClassName: LeetCode222
 * @Description: 二叉树总结点个数
 */

public class LeetCode222 {

    public int countNodes(TreeNode root) {
        return getCount(root);
    }

    int getCount(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getCount(root.left);
        int right = getCount(root.right);
        return left + right + 1;
    }
}
