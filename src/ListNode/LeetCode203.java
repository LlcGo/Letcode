package ListNode;

/**
 * @Author Lc
 * @Date 2023/10/11
 * @PackageName: ListNode
 * @ClassName: LeetCode203
 * @Description: 203. 移除链表元素
 */

public class LeetCode203 { public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
        return head;
    }
    //因为涉及到了头节点所以我们需要建一个虚拟头节点方便如果头也要删除
    ListNode dummy =  new ListNode();
    dummy.next = head;
    //前一个指针
    ListNode pre = dummy;
    //当前指针
    ListNode cur = head;
    while(cur != null){
        if(cur.val == val){
            pre.next = cur.next;
            cur =cur.next;
        }else{
            pre = pre.next;
            cur = cur.next;
        }
    }
    return dummy.next;
}
}
