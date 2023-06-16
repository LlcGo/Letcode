package tree;

/**
 * @Author Lc
 * @Date 2023/6/16
 * @Description 最大二叉树
 */
public class Letcode654 {
    public static void main(String[] args) {
       int[] a  = new int[]{3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(a);

    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constur(nums,0,nums.length);
    }
    public static TreeNode constur(int[] nums,int leftIndex,int rightIndex){
        //没有元素了
        if(rightIndex - leftIndex < 1){
            return null;
        }
        //如果数组里面的值只有一个了，那就是到根节点了直接返回
        if(rightIndex - leftIndex  == 1){
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        //根节点
        TreeNode root = new TreeNode(maxVal);
        //开始切割递归 传入左边的 首先要判断他符合规则才进入至少有一个
        //左闭右开
        root.left = constur(nums,leftIndex,maxIndex);
        //切割右边同理
        root.right = constur(nums,maxIndex + 1,rightIndex);
        return root;
    }
}
