package com.example.demo.guigu;

import org.junit.Test;

/**
 *
 * @author yanghaiyu
 * @date 2020/06/26 
 **/
public class 约瑟夫 {

	public void outQueue(ListNode listNode, int k, int m) {
		int x = 1;
		int y = 1;
		ListNode before = listNode;
		while (listNode != null) {
			if (x < k) {
				before = listNode;
				listNode = listNode.next;
				x++;
			} else {
				if (y < m) {
					before = listNode;
					listNode = listNode.next;
					y++;
				} else if (y == m) {
					System.out.printf(listNode.val + "");
					listNode = listNode.next;
					if (before == listNode){
						System.out.printf(listNode.val + "");
						break;
					}
					before.next = listNode;
					y = 1;
				}
			}
		}

	}

	@Test
	public void t1(){

		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
	//	ListNode listNode6 = new ListNode(6);
		listNode.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		listNode5.next=listNode;
		//listNode6.next= listNode;
		outQueue(listNode,1,2);
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