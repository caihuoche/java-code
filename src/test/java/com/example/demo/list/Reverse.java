package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/09/13
 **/
public class Reverse {

	@Test
	public void t1() {
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node.next = node2;
		node.next.next = node3;
		ListNode a = reverse(node);
		System.out.println(a);
	}

	public ListNode reverse(ListNode test) {
		ListNode rever = test;
		ListNode temp;
		test = test.next;
		while (test != null) {
			temp = rever;
			rever =test;
			test = test.next;
			rever.next = temp;
		}
		return rever;
	}
}
