package tree;

/**
 * @Author Lc
 * @Date 2023/7/3
 * @Description
 */
public class Leetcode108 {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length-1);
    }

    public static  TreeNode createTree(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,left,mid-1);
        root.right = createTree(nums,mid+1,right);
        return root;
    }
}
