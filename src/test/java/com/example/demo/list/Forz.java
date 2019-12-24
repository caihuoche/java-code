package com.example.demo.list;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/11/30
 **/
public class Forz {

	@Test
	public void t1() {
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		node.next = node2;
		node.next.next = node3;
		System.out.println(node);
		ListNode l = for2(node);
		System.out.println(node);
		ReentrantLock lock = new ReentrantLock();
		CountDownLatch countDownLatch = new CountDownLatch(2);
		//countDownLatch.await();
		lock.lock();

	}

	public ListNode for2(ListNode listNode) {
		ListNode result = null;
		while (listNode != null) {
			if (result != null) {
				ListNode temp = listNode;
				listNode = listNode.next;
				temp.next = result;
				result = temp;
				//	result.next = listNode;

			} else {
				result = new ListNode(listNode.val);
				listNode = listNode.next;

			}
		}
		return result;
	}

	public void t2() { int a = 1;
		fb(a);

	}

	private int fb(int a) {
		if (a==1)return 1;
		if (a== 2)return 1;
		fb(a + fb(a));
		return 2;
	}
}
