package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head==null) return null;

        List<Integer> integers = linkedToArrListReversed(head);


        return listToLinked(integers);
    }

    public static List<Integer> linkedToArrListReversed(ListNode linkedList) {
        if (null == linkedList) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        result.add(linkedList.val);

        ListNode current = linkedList;

        while (current.next != null) {
            result.add(current.next.val);
            current = current.next;
        }
        return result;
    }

    public static ListNode listToLinked(List<Integer> list) {
        if(list.isEmpty()) return new ListNode();


        ListNode result = new ListNode(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            result = new ListNode(list.get(i), result);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4, three);
        ListNode number = new ListNode(2, four);

        ListNode reversed = reverseList(number);

        System.out.println(AddTwoNumsAsLinkedList.intFromNode(reversed));
    }
}
