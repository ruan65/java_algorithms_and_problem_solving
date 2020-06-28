package leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.

public class AddTwoNumsAsLinkedList {

    static String getNumAsString(ListNode node) {
        if (node.next == null) return "" + node.val;
        return getNumAsString(node.next) + node.val;
    }

    static BigInteger intFromNode(ListNode node) {
        return new BigInteger(getNumAsString(node));
    }

    static ListNode convertIntToLinkedList(String number) {
        String snum = new StringBuilder(number).reverse().toString();
        if (snum.length() == 1) return new ListNode(Integer.parseInt(snum));

        int firstDigit = Integer.parseInt(snum.substring(0, 1));

        String substring = new StringBuilder(snum.substring(1)).reverse().toString();

        return new ListNode(firstDigit, convertIntToLinkedList(substring));
    }

    public static BigInteger addTwoNumbersInt(ListNode l1, ListNode l2) {

        return intFromNode(l1).add(intFromNode(l2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger n1 = intFromNode(l1);
        BigInteger n2 = intFromNode(l2);

        return convertIntToLinkedList(n1.add(n2).toString());

    }


    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4, three);
        ListNode number = new ListNode(2, four);

        ListNode f2 = new ListNode(4);
        ListNode six = new ListNode(6, f2);
        ListNode number2 = new ListNode(5, six);

        ListNode result = addTwoNumbers(number, number2);

        System.out.println("result = " + result);
    }
}
