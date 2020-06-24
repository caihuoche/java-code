package com.example.demo.esay;

import java.util.HashSet;

import org.junit.Test;

/**
 *
 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。



 示例 1：

 输入：head = [3,2,0,-4], pos = 1
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。
 * @author yanghaiyu
 * @date 2020/06/24 
 **/
public class Easy141 {
	public boolean hasCycle(ListNode head) {
		HashSet<String> objects = new HashSet<>();
		while (head != null) {
			boolean add = objects.add(head.toString());
			if (!add) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	@Test
	public void t1() {
		ListNode l = new ListNode(1);
		hasCycle(l);
	}

	/**
	 * 最优 双指针,
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {
		if (head == null) return false;
		ListNode fast = head.next;
		while (fast != null) {
			if (head == fast) {
				return true;
			}
			head = head.next;
			fast = fast.next;
			if (fast == null) {
				return false;
			}
			fast = fast.next;
		}
		return false;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}