package com.example.demo.list;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yanghaiyu
 * @date 2019/10/22
 **/
public class TwentyFive {


	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		int i = 0;
		ListNode l = null;
		ListNode result = null;
		ListNode temp = null;
		ListNode f = null;
		ListNode hou = null;
		while (head != null) {
			if (i == k) {
				i = 0;
				if (l == null) {
					l = result;
				} else {
					f.next = result;
				}
				result = null;
			}

			if (result != null) {
				temp = result;
				result = head;
				head = head.next;
				result.next = temp;
			} else {
				result = head;
				if (i == 0) {
					f = hou;
					hou = head;
				}
				head = head.next;
				result.next=null;
			}

			i++;


		}

		if (i == k) {
			if (l == null) {
				l = result;
			} else {
				f.next = result;
			}

		} else if (i < k) {
			ListNode tem = null;

			while (result != null) {
				if (tem == null) {
					tem = result;
					result = result.next;
					tem.next=null;
				} else {

					ListNode a = tem;
					tem = result;
					result = result.next;
					tem.next = a;
				}

			}
			result =tem;
			if (l != null && f != null) {
				f.next = result;
			} else {
				return result;
			}
		}
		return l;
	}

	@Test
	public void t1() {
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode nod4 = new ListNode(4);
		ListNode nod5 = new ListNode(5);
		node.next = node2;
		node.next.next = node3;
		node.next.next.next = nod4;
		node.next.next.next.next = nod5;
		ListNode node1 = reverseKGroup(node, 2);
		System.out.println(node1);
	}
}
