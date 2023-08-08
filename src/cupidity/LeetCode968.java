package cupidity;


import tree.TreeNode;

/**
 * @Author Lc
 * @Date 2023/8/8
 * @PackageName: cupidity
 * @ClassName: LeetCode968
 * @Description:
 */

public class LeetCode968 {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        //防止跟节点无覆盖状态
        if(min(root) == 0){
            res++;
        }
        return res;
    }

    public int min(TreeNode root){
        //1.根节点的父节点放摄像头，最大化，（因为叶子节点多）
        //2.每隔俩个节点放一个摄像头
        //3.状态分为 0）无覆盖  1）摄像头 2）覆盖
        //4.空节点是有覆盖的状态
        if(root == null){
            return 2;
        }
        //左右状态
        int left = min(root.left);
        int right = min(root.right);
        if(left == 2 && right ==2){
            //左右都有覆盖 父节点应该是无覆盖
            return 0;
        }else if(left == 0 || right == 0){
            //左节点或者右节点有一个为0 那父节点肯定是有摄像头
            res++;
            return 1;
        }else {
            //如果左右可能有一个摄像头有那父节点 肯定是有覆盖状态
            return 2;
        }
    }
}
