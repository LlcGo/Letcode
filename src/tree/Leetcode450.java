package tree;

/**
 * @Author Lc
 * @Date 2023/6/28
 * @Description 二叉搜索树删除节点
 */
public class Leetcode450 {
    static TreeNode current = null;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode3;
        treeNode.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode6.right = treeNode7;
        TreeNode treeNode1 = deleteNode(treeNode, 3);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        //没有找到删的节点
        if(root == null){
            return null;
        }
        if(root.val == key){
            //如果这个节点是在根节点
            if(root.left == null && root.right == null){
                //让最后这个节点的父节点直接指向null
                return null;
                //左边不为null 右边为null
            }else if(root.left != null && root.right == null){
                return root.left;
                //如果左为null 右不为null
            }else if(root.left == null && root.right != null){
                return root.right;
            }else{
                //左右都不为null
                current = root.right;
                //找到右边子树的最小的数
                while(current.left != null){
                    current = current.left;
                }
                //让其最小的子树节点指向失去父节点的树
                current.left = root.left;
                return root.right;
            }
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
