package com.example.demo.list;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author yanghaiyu
 * @date 2019/09/08
 **/
public class Nineteen {
	/**
	 * 先扫描俩次
	 */

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int a = 1, b = 0;
		ListNode next = head;
		while (next.next != null) {
			a++;
			next = next.next;
		}
		next = head;
		if (a - n == 0)
			return head.next;
		while (next.next != null) {
			b++;
			if (b == a - n) {
				next.next = next.next.next;
				return head;
			}
			next = next.next;
		}
		return null;
	}

	/**
	 * 这样占据太多 性能差
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		Map<Integer, ListNode> hashMap = new HashMap<>();
		int a = 1;
		ListNode next = head;
		hashMap.put(1, head);
		while (next.next != null) {
			next = next.next;
			hashMap.put(++a, next);
		}
		if (a - n == 0) {
			return head.next;
		}

		ListNode listNode = hashMap.get(a - n);
		listNode.next = hashMap.get(a - n + 2);
		return head;

	}

	public ListNode removeNthFromEnd3(ListNode head, int n) {
		ListNode first = head;
		ListNode next = head;
		while (next.next != null) {
			next = next.next;
			if (n > 0) {
				n--;
			} else {
				first = first.next;
			}
		}
		if (n > 1) {
			return head.next;
		}
		first.next = first.next.next;
		return head;
	}

	@Test
	public void t1() {
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
//		listNode.next = listNode2;
		ListNode listNode1 = removeNthFromEnd3(listNode, 1);
		System.out.println(listNode1);
	}

}