package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A109ConvertSortedLinkedListToBst {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode dummy = slow;
        int i = 0;
        while (temp.next != null) {
            temp = temp.next;
            i++;
            if (i == 2) {
                fast = fast.next;
                dummy = dummy.next;
                i = 0;
            }
        }

        TreeNode bst = new TreeNode(fast.val);
        dummy.next = null;
        bst.left = sortedListToBST(slow.next);
        bst.right = sortedListToBST(fast.next);
        return bst;
    }
}
