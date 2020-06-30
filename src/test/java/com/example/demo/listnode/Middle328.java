package com.example.demo.listnode;

import org.junit.Test;

/**
 *
 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

 示例 1:

 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 示例 2:

 输入: 2->1->3->5->6->4->7->NULL
 输出: 2->3->6->7->1->5->4->NULL
 * @author yanghaiyu
 * @date 2020/06/29 
 **/
public class Middle328 {
	public ListNode oddEvenList(ListNode head) {
		if (head ==null || head.next ==null || head.next.next==null) return head;
		ListNode a = head;
		ListNode b = head.next;
		ListNode c = head.next;
		ListNode d = head.next;
		int sum =0;
		while (c.next!=null){
			sum ++;
			if (sum%2 ==0){
				b.next = c.next;
				b= b.next;
			}else {
				a.next = c.next;
				a=a.next;
			}
			c =c.next;
		}
		if (sum%2 == 1){
			b.next=null;
		}
		a.next =d;
		return head;
	}

	@Test
	public void t1(){
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		//listNode4.next=listNode5;
		ListNode listNode1 = oddEvenList(listNode);
		System.out.printf("");
	}
}

