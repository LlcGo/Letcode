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

7/14
78.子集
+ 主要考虑什么时候退出这个循环，需要找一个值来记录，退出的情况

7/16
491.递增子序列
+ 如果一个数不能让你排序，并且还要你去重的这种组合问题，可以使用set来记录
+ 判断之前的数是否比你现在的数小就直接用path来获得前一个数，前提是path不为null

7/17
46.全排列
+ 跟组合的区别是可以取数组里面的所有数，但是不能取每一个递归下去的重复的值
+ 用boolean 数组来记录 是否使用过 如果 是ture 那就是使用过了直接跳过

7/18
47.全排列Ⅱ
1.这次主要去重的是当你取到的第二个数的时候跟第一个相等的时候我们就直接不用继续往下面递归
2.所以只需要当这个值和上一个值相同，并且上一个值已经使用过的情况下我们直接return

7/20
51.N皇后
+ 要先确认每次循环哪里是行哪里是列
+ 当行等于棋盘最大的行数的时候就放入
+ 如果是符合情况的时候就进行放入

# 贪心算法
7/22
455.分发饼干
+ 确定思路每次遇到符合饼干的大小 大于等于 孩子的胃口就直接+1 然后 下标往前移动一位

7/23
376.摆动序列
+ 摆动一共三种情况要处理，一种是一直上下摆动，一种是平的时候的坡度，一种是单调向上的坡度
+ 上下摆动我们只需要记录前一个值和后一个值是否符合题目要求就行
+ 平坡我们只需要在前一个值的时候加一个等于就行
+ 递增的话，我们只需要在符合的情况下我们在改变前一个值就可以

7/23
53.最大子数组和
+ 每个字数和跟下一个数相加的时候如果是负数就直接跳过这个数从下一个数开始加

7/25
122.买卖股票最佳时机Ⅱ
+ 每次只要整的数，正的利润然后总和相加，当前的减去前一天。从二天开始才能卖出

7/26
55.跳跃游戏
+ 重点不在于跳，而在于，你现在在的这个索引上面的数能够最大覆盖到哪里，如果超过了数组的长度那就是可以
+ 每次遍历的长度都只能在范围内，范围可以在遍历中增加

7/27
45.跳跃游戏Ⅱ
+ 每次取的时候我们要选择下一步的最大覆盖范围
+ 如果现在已经走到了当前的覆盖范围了我们就要做判断，如果是覆盖范围没有到终点，我们就要继续跳下一步，下一步是我们之前记录的下一个的最大覆盖范围

7/28
1005 K 次取反后最大化的数组和
+ 首先要按照绝对值的大小来进行排序
+ 最后如果还有k的话，只有是奇数我们就进行一次转换就行

7/29
134 加油站
+ 看当前剩余的油量是否为负数
+ 看最后油量总和是否大于0
+ 当油量是负数的时候重新开始选择起点

7/30
135 分发糖果
+ 遇到左右俩边都要判断的题目，我们要分别来判断左边和右边的情况
+ 先有一个跟之前一样的新数组，来记录第一次右边比左边大的情况
+ 第二次遍历从后往前遍历，得出前一个比后面一个大的情况取最大值就是最后我们想要的值

7/31
860 柠檬水找零
+ 每一个面值都可以抽象为拥有的个数
+ 分好策略然后进行判断

8/1
406,根据身高重建队列
+ 首先要根据升高来排序，如果升高从大到小排序，如果升高相等，就按后面的人数从小到大排序
+ 之后遍历将后面的值拍到他们第二个位置的值的位置即可

8/2
452.用最少数量的箭引爆气球
+ 首先根据二维数组左边的数进行排序
+ 如果这个气球的右边的值，比下一个左边的值大那就肯定要一支箭
+ 如果不是这个情况那就需要来设更新有边界为俩个右边的最小有边界

8/3
435.无重叠区域
+ 找去间重叠的计数加1的题目，首先判断什么情况下不重叠
+ 接下来就是重叠的区域，需要更改当前的区间的尾巴，如果下一个是在这个更新的区间的以内肯定是重叠了

8/4
763.划分字母区间
+ 用int hash【27】来存储每个字母最长距离
+ 每次遍历的时候去最大的距离，如果i到了最大距离了就获取值，并且左边的位置+1

8/6
56.合并区间
+ 先排序
+ 放第一个数据入链表集合
+ 如果是需要合并的区间那就选择删除前一个然后取上一个的头一个值，和下一个的尾巴和上一个的尾巴取一个最大的作为新的结尾

8/7
738,单调递增数字
+ 将n转为string方便操作
+ 如果现在的数字不是单调递增的那就将前一个-1
+ 最后标记的全都设置为9

8/8
968.监控二叉树
+ 根节点的父节点放摄像头，最大化，（因为叶子节点多）
+ 每隔俩个节点放一个摄像头
+ 状态分为 0）无覆盖  1）摄像头 2）覆盖
+ 空节点是有覆盖的状态
+ 分析各个节点什么状态下返回有无摄像头，或者需要装摄像头，最后要判断根节点有没有覆盖到 


# 动态规划
8/10
509.斐波那契数列
+ 可以直接根据给的规律来进行动态规划

8/11
70.爬楼梯
+ 等于斐波那契数