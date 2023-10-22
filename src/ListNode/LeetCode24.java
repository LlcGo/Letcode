package ListNode;

/**
 * @Author Lc
 * @Date 2023/10/22
 * @PackageName: ListNode
 * @ClassName: LeetCode24
 * @Description: 俩俩交换链表中的节点
 */

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy =  new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while(curr.next != null && curr.next.next != null){
            temp = curr.next.next.next;
            firstnode = curr.next;
            secondnode = curr.next.next;
            curr.next = secondnode;
            secondnode.next = firstnode;
            firstnode.next = temp;
            curr = firstnode;
        }
        return dummy.next;

    }
}
