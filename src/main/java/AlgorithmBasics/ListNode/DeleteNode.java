package AlgorithmBasics.ListNode;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/6/12 9:42
 *
 * 删除链表中指定元素, 移除当前节点
 */
public class DeleteNode {


    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
