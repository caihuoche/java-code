package com.example.demo.listnode;

import org.junit.Test;

/**
 *
 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 示例 2:

 输入: 0->1->2->NULL, k = 4
 输出: 2->0->1->NULL
 解释:
 向右旋转 1 步: 2->0->1->NULL
 向右旋转 2 步: 1->2->0->NULL
 向右旋转 3 步: 0->1->2->NULL
 向右旋转 4 步: 2->0->1->NULL
 **/
public class Middle61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head==null) return null;
		if (head.next==null) return head;
		if (k==0) return head;
		int sum = 0;
		ListNode a = head;
		ListNode b = head;
		while (a.next != null) {
			if (sum >= k) {
				b = b.next;
			}
			sum++;
			if (a.next.next == null && sum < k) {
				a = head;
				b = head;
				k = k % (sum+1);
				if ( k == 0){
					return head;
				}
				sum = 0;
			}else {
				a = a.next;
			}


		}
		ListNode next = b.next;
		b.next = null;
		a.next = head;

		return next;
	}

	@Test
	public void t1(){
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode.next=listNode2;
		//listNode2.next=listNode3;
		//listNode3.next=listNode4;
	//	listNode4.next=listNode5;
		ListNode listNode1 = rotateRight(listNode, 2);
		System.out.printf("");
	}
}

