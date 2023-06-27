# Leetcode

617.合并二叉树
+ 合并树的时候最好是先序遍历来考虑
  对中间节点的处理可以换到开始递归的任意位置都是可以的
+ 可以直接再一颗二叉树上变动
+ 合并二叉树最主要的就是当一个根节点为null的时候返回另一个二叉树的节点
  因为他们是同步遍历的
+ 当左右俩颗二叉树都为null的时候他们然会返回null
+ 每一层往上翻的值早就在先序遍历的时候就已经确定了

# 二叉搜索树的魅力
6/18
700.二叉树搜索树中的搜索
+ 因为二叉搜索树，左边的节点的值肯定比根节点小，右边反之，所以我们可以利用这个特性进行判断纸大小来选择遍历哪一边
+ 此题递归的出口在于当遍历到节点为null时候或者节点与输入的值相等，直接返回这个节点
+ 递归回来的时候你需要的这个值一定要有一个数据类型接住，不然就没了，也不知道返回什么，
+ 因为返回的是树，所以本来就有左右节点，在算法中不需要管他的left 和 right
+ 二叉搜索树搜索的时候直接迭代方便一点，因为他已经给你确定了方向

6/21
98.验证二叉搜索树
+ 如果节点是null那肯定是二叉搜索树
+ 二叉搜索树中序遍历节点的值一定是从小到大
+ 如何记录他的上一个节点，然后根他的上一个节点比较？（先定义一棵空手，然后一开始中序的适合条件就是非空）

6/22
530.二叉搜索树最最小绝对值
+ 搜索二叉树要知道俩个数的绝对值只需要记录前一个节点的值和后一节点的值相见就行了（因为中序遍历就是从小到大的顺序）

6/23
501.二叉树中的众数
主要是中间的逻辑处理 如何能找到这个值并且次数的最多的呢？
+ 如果是第一次到中序的时候我们就记录为1或者前面的数不等于现在的数值的时候也记录为1
+ 如果不是前面俩个情况那一定是相等了那就原来的计数++
+ 比较一下最大值和现在的值如果是现在的值大于最大值的话，就清理一下这个数组之前存的值，然后再将他他加入这个数组，如果是等于的话那就直接加入这个数组
+ 里面最关键的就是第二步的判断中如果第二次的count数大于第一次的count数那么就是直接进入清空重新放入这个值

6/24
236.二叉树的公共祖先
+ 从下往上查找使用回溯，要使用回溯就要用后续遍历
+ 到最后开始回溯的时候顺序判断的逻辑是 如果到底了还是都没有找到任何一个节点直接返回null，如果找到了左节点，直接返回左节点，如果找到了右节点直接返回右节点，如果都找到了那就直接返回root节点
+ 后续遍历回溯最主要的就是理清楚左右俩边递归完了如何判断需要的数然后进行直接返回

6/26
235.二叉搜索树的最近公共祖先
+ 因为是二叉搜索树所以如果你要查找的节点都小于根节点的值的话直接去左边遍历，如果是大于的话直接去右边遍历
+ 如果俩边都不是的话那一定是已经在左右俩边了这俩个节点，直接返回即可

6/27
701.二叉搜索树的插入
+ 一颗二叉搜索树插入操作主要是，根据节点和给的值判断出最后是在左子树还是在右子树
+ 当遍历到最后的节点为null的时候就可以插入到这个位置