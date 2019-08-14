package com.example.demo.leetcode;

import java.math.BigInteger;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Two {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String aa = null;
		String bb = null;
		if (l1 != null) {
			aa = aa(l1, l1.val + "");
		}
		if (l2 != null) {
			bb = aa(l2, l2.val + "");
		}
		System.out.println(aa);
		System.out.println(bb);
		BigInteger a = new BigInteger(aa);
		BigInteger b = new BigInteger(bb);
		BigInteger add = a.add(b);
		String i = add + "";
		char[] chars = i.toCharArray();
		ListNode listNode = null;
		for (int j = chars.length - 1; j >= 0; j--) {
			int i1 = Integer.parseInt(String.valueOf(chars[j]));
			if (listNode == null) {
				listNode = new ListNode(i1);
			} else {
				bb(listNode, i1);
			}
		}

		return listNode;
	}

	private void bb(ListNode listNode, int i1) {
		if (listNode.next == null) {
			ListNode listNode2 = new ListNode(i1);
			listNode.next = listNode2;
		} else {
			bb(listNode.next, i1);
		}
	}

	private String aa(ListNode listNode, String a) {
		ListNode node = listNode.next;
		if (node != null) {
			a = node.val + a;
			return aa(node, a);
		} else {
			return a;
		}

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static void main(String[] args) {
		BigInteger bigInteger = new BigInteger("1000000000000000000000000000001");
		System.out.println(bigInteger);
	}
}
