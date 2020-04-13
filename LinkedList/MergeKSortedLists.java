package leetcode.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        // 1 - > 4 - > 5
        // 1 - > 3 - > 4
        // 2 - > 6
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] nodes = {list1, list2, list3};

        ListNode answer = solve(nodes);
        while(answer!=null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    public static ListNode solve(ListNode[] nodes) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode newHead = new ListNode(0);
        ListNode headPointer = newHead;

        for (ListNode node : nodes) {
            if (node != null)
                pq.offer(node);
        }

        while(!pq.isEmpty()) {
            ListNode tmpNode = pq.poll();
            headPointer.next = tmpNode;
            headPointer = headPointer.next;

            if (tmpNode.next != null)
                pq.offer(tmpNode.next);
        }

        return newHead.next;
    }
}
