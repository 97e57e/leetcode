package leetcode.linkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        //4 -> 3 - > 5
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        //2 - > 7 - > 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(6);

        ListNode ansewr = solve(list1, list2);

        while(ansewr != null) {
            System.out.print(ansewr.val);
            ansewr = ansewr.next;
        }
    }

    public static ListNode solve (ListNode p1, ListNode p2) {
        int carry = 0;
        ListNode answerList = new ListNode(0);
        ListNode list1 = p1, list2 = p2, list3 = answerList;

        while (list1 != null || list2 != null) {
            if (list1 != null) {
                carry += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                carry += list2.val;
                list2 = list2.next;
            }
            list3.next = new ListNode(carry%10);
            list3 = list3.next;
            carry /= 10;
        }

        if (carry == 1) list3.next = new ListNode(1);

        return answerList.next;
    }
}
