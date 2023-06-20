package tree;

/**
 * @Author Lc
 * @Date 2023/6/20
 * @Description
 */
public class Leetcode700 {

    public static void main(String[] args) {
        TreeNode root4 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root7 = new TreeNode(7);
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        root4.left = root2;
        root2.left = root1;
        root2.right = root3;
        root4.right = root7;
        TreeNode treeNode = searchBST(root4, 2);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        //因为是二叉搜索树，所以树的左边肯定比树的根节点的数值小，树的右边肯定比树的根节点的数值大
        if(root == null || root.val == val){
            return root;
        }
        TreeNode result =  new TreeNode();
        if(root.val > val){
            result = searchBST(root.left,val);
        }
        if(root.val < val){
            result = searchBST(root.right,val);
        }
        return result;
    }
}
