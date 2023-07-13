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

6/28
450.删除二叉搜索树中的节点
+ 首先要判断他是否是要全部遍历寻找，并不是我们只需要找到要求的那个节点就可以不用继续遍历了，所以找到节点之后里面的逻辑比较复杂
+ 有5种情况
  + 找到了个节点但是已经到最底了直接返回null就行
  + 没有找到匹配的值 直接返回null就行
  + 找到了节点的情况
     +  左边有树，右边没有树 直接返回 左节点
	 +  左边没有树，右边有树，直接返回 右节点
	 +  左边右边都有树，临时节点存储当前节点的右边节点，然后遍历到最左的位置，让其指向失去的父节点的节点  （也就是遍历到的节点左边节点）
+ 接下来就是递归遍历用roo.left 或者 root.right 来接	

7/1
669.修剪二叉搜索树
+ 当你修建一颗二叉搜索树的时候，这个节点不符合要求，但是他的子节点可能符合要求，需要返回
+ 所以这俩种情况分开判断并且递归

7/3
108.将有序数组转换为二叉搜索树
+ 要确认要自己的区间，是左闭右闭，还有是左闭右开
+ 左右俩数相除开始为分割点，持续切割



7/4
538.二叉搜索树转换为累加树
+ 首先二叉搜索树左中右（中序遍历）顺序就是从小打到排序
+ 其次，累加就是从最小的开始累加加到最大的，所以可以采用右中左开始遍历，然后累加即可


# 回溯算法

7/7
77.组合
使用回溯算法的经典案例
+ 首先把自己要取得的数抽象成一颗树，我们要取最底下的那个节点就是我们要的值
+ 我们要定义一个存值的链表，也就是说当我们的链表里的数量等于我们要收集的数量时候就退出递归
+ for循环的定义是 i 为 下一次的存放的值，也就是startIndex，遍历完一整个数组
+ 之后每次进来循环都把值放进去，,然后递归，递归的时候设置号下一次的值数是多少就是startIndex


7/8
216.组合的总和
+ 其实和组合差不多，只不过要多加一个sum来记录每次加的次数
+ 回溯的时候不仅要将之前的数去除，还要再减回去，不然会一致累加，无法得到想要的结果

7/9
17.电话号码的字母组合
+ 首先要解决电话号码映射的问题 可以把他们直接都映射成下标相对应的数组，没有值就直接空
+ 递归结束的条件为  当前的这个字符串的长度已经到达了指定的长度 就是当前这个数组下标的长度（也就是超过目标的数组长度+1）
+ 循环条件从0开始 到 零时的 string长度
+ 每次循环都加上一个 字母 递归结束 减去这个字母

7/10
39.组合总和
+ 由于可以重复使用一个数，所以下标可以锁定为i
+ 要取除和大于target的数

7/11
131.分割回文子串
+ 每次递归都是一次分割，分割线就是startIndex  所以当分割线大于等于这个字符串的时候就可以存储
+ 在循环里面每次都要检查一下他是否是回文子串

7/14
93.合法ip
+ 先确定分几次可以获得最后的结果 ，3次，需要一个数记录 到3直接取得结果，并且在做一次判断因为3次切割玩还有最后一次要做判断，是否合法ip
+ 递归之前都要判断是否为合法，合法的时候才开始递归并且加上.回溯的时候之前加的都删掉