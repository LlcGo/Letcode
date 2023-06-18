package tree;

/**
 * @Author Lc
 * @Date 2023/6/18
 * @Description 合并二叉树
 */
public class Leetcode617 {
    public static void main(String[] args) {
        //root1
        TreeNode LtreeNode = new TreeNode(1);
        TreeNode LtreeNode3 = new TreeNode(3);
        TreeNode LtreeNode2 = new TreeNode(2);
        TreeNode LtreeNode5 = new TreeNode(5);
        LtreeNode.left = LtreeNode3;
        LtreeNode3.left = LtreeNode5;
        LtreeNode.right = LtreeNode2;
        //root2
        TreeNode rn2 = new TreeNode(2);
        TreeNode rn1 = new TreeNode(1);
        TreeNode rn4 = new TreeNode(4);
        TreeNode rn3 = new TreeNode(3);
        TreeNode rn7 = new TreeNode(7);
        rn2.left = rn1;
        rn2.right = rn3;
        rn1.right = rn4;
        rn3.right = rn7;
        TreeNode treeNode = mergeTrees(LtreeNode, rn2);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
           //如果root1的节点为null 返回 roo2的节点
            if(root1 == null) return root2;
            //如果root2的节点为null 返回root1的节点
            if(root2 == null) return root1;
            //先序处理每一个节点
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
            return root1;
    }
}
