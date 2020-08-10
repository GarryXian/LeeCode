package AlgorithmBasics.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/12 9:56
 * 倒序删除链表元素
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head, 1);


    }

    /**
     * 使用map, 记录每个节点对应的序号
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer, ListNode> dictMap = new HashMap<Integer, ListNode>();
        Integer index = 0;
        ListNode point = head;
        while (point.next != null) {
            dictMap.put(index++, point);
            point = point.next;
        }
        dictMap.put(index++, point);

        int removeIndex = index - n;

        ListNode listNode = dictMap.get(removeIndex);
        if (dictMap.entrySet().size() == 1) {
            return null;
        } else if (listNode.next == null) {
            // 前一个节点的next 置空
            ListNode listNode1 = dictMap.get(removeIndex - 1);
            listNode1.next = null;
        } else {
            listNode.val = listNode.next.val;
            listNode.next = listNode.next.next;
        }
        return head;
    }
}
