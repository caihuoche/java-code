package com.example.demo.list;

import org.junit.Test;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yanghaiyu
 * @date 2019/10/21
 **/
public class TwentyFour {
	public ListNode swapPairs(ListNode head) {
		ListNode l = null;
		ListNode next = null;
		while (head != null) {
			ListNode one = head;
			if (head.next != null) {
				ListNode two = head.next;
				head = two.next;
				if (l == null) {
					l = two;
					l.next = one;
				} else {
					next.next = two;
					next.next.next = one;
				}
				next = one;

			} else {
				if (l == null) {
					l = one;
				} else {
					next.next = one;
					next = null;
				}
				head = null;
			}
		}
		if (next != null) {
			next.next = null;
		}
		return l;
	}

	@Test
	public void t1() {
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode nod4 = new ListNode(4);
		node.next = node2;
		node.next.next = node3;
		//node.next.next.next = nod4;
		ListNode node1 = swapPairs(node);
		System.out.println(node1);
	}
}
