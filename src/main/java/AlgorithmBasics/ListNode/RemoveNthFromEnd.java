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
        head.next.next = new ListNode(3);
        removeNthFromEnd(head, 2);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer, ListNode> dictMap = new HashMap<Integer, ListNode>();
        Integer index = 0;
        ListNode point = head;
        while (point.next != null){
            dictMap.put(index++, point);
            point = point.next;
        }
        dictMap.put(index, point);

        return null;
    }
}
