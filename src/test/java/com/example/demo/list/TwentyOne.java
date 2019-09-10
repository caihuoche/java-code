package com.example.demo.list;

import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 * @author yanghaiyu
 * @date 2019/09/09
 **/
public class TwentyOne {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode result;
		ListNode no;
		if (l1.val < l2.val) {
			result = l1;
			no = result;
			l1 = l1.next;
		} else {
			result = l2;
			no = result;
			l2 = l2.next;
		}
		while (l2 != null && l1 != null) {
			if (l1.val < l2.val) {
				no.next = l1;
 				l1 = l1.next;
			} else {
				no.next = l2;
				l2 = l2.next;
			}
			no = no.next;
		}
		if (l1 != null) {
			no.next = l1;
		}
		if (l2 != null) {
			no.next = l2;
		}
		return result;
	}

	@Test
	public void t1() {
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		node.next = node2;
		node.next.next = node3;
		ListNode nod4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		nod4.next = node5;
		nod4.next.next = node6;
		ListNode node1 = mergeTwoLists(node, nod4);
		System.out.println(node1);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}