/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
*/

public class AddTwoNumbersAsLists {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode(0);
        ListNode placeIter = dummyHead;
        int carry = 0;

        while(a != null || b!=null || carry != 0){

            int val = carry + (a != null ? a.val : 0) +  (b != null ? b.val : 0);

            a = a != null ? a.next : null;
            b = b != null ? b.next : null;

            placeIter.next = new ListNode(val%10);

            carry = val / 10;
            placeIter = placeIter.next;
        }
        return dummyHead.next;
    }
}
