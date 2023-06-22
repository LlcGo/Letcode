package tree;

/**
 * @Author Lc
 * @Date 2023/6/22
 * @Description 二叉搜索树最最小绝对值
 */
public class leetcode530 {

    //用来记录前一个节点
    static TreeNode pre = null;

    //用来存最小值
    static int min = Integer.MAX_VALUE;

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
        int minimumDifference = getMinimumDifference(root);
    }


    public static int getMinimumDifference(TreeNode root) {
        //如果根节点为null 直接返回0 递归返回的值不用接收只是走个过程
        if(root == null){
            return 0;
        }
        //开始中序遍历
        getMinimumDifference(root.left);
        //开始记录最小值
        if(pre != null){
            //当前的节点减去上一个节点   中序遍历二叉搜索树是从小到大的数值
            min = Math.min(min,root.val - pre.val);
        }
        //记录前一个节点
        pre = root;
        getMinimumDifference(root.right);

        return min;
    }

}
