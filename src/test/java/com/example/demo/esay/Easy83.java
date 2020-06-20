package com.example.demo.esay;



import org.junit.Test;

/**
 *给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author yanghaiyu
 * @date 2020/06/19 
 **/
public class Easy83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head==null) return null;
		ListNode uniq = head;
		ListNode next  = head.next;
		while (next !=null){
			if (next.val == uniq.val ){
				uniq.next =next.next;
				next = next.next;
			}else {
				uniq = uniq.next;
				next = next.next;

			}

		}
		return head;
	}
	@Test
	public void t1(){
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		node.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode node1 = deleteDuplicates(node);
		System.out.printf("  "+node1);
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

}
