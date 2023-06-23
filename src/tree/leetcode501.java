package tree;

import java.util.ArrayList;

/**
 * @Author Lc
 * @Date 2023/6/23
 * @Description 二叉搜索树求众树
 */
public class leetcode501 {
    static ArrayList<Integer> resList;//返回值
    static int maxCount; //最大的出现频率
    static int count;  //当前的次数
    static TreeNode pre; //前一个值


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);
        treeNode.right = treeNode2;
        treeNode2.left = treeNode22;
        int[] mode = findMode(treeNode);
    }





    public static int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int [] res = new int[resList.size()];
        for(int i = 0; i< resList.size();i++){
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void findMode1(TreeNode root){
        if(root == null){
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        //第一次到中 或者 当前的值不等于前面的值 计数为1
        if(pre == null || rootValue != pre.val){
            count = 1;
        }else{
            //反之++
            count++;
        }
        //更新结果集和maxCount 如果俩个数相同了 就清理里面的数值重新加入
        if(count > maxCount){
            //清空数组
            resList.clear();
            //加入新的数
            resList.add(rootValue);
            maxCount = count;
        }else if(count == maxCount){
            //如果值是相等的也更新
            resList.add(rootValue);
        }
        pre = root;
        findMode1(root.right);
    }
}
