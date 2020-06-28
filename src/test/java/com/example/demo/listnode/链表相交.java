package com.example.demo.listnode;

import org.junit.Test;

/**
 *给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 *
 *
 * 示例 1：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例 3：
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null 。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author yanghaiyu
 * @date 2020/06/28 
 **/
public class 链表相交 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode first = headA;
		int lengthA = 0;
		int lengthB = 0;
		while (first != null) {
			lengthA++;
			first = first.next;
		}
		ListNode second = headB;
		while (second != null) {
			lengthB++;
			second = second.next;

		}
		int c = lengthA - lengthB;
		int start = 0;
		if (lengthA - lengthB > 0) {
			while (headA != null) {
				if (start == c) {
					if ( headA ==headB){
						return headA;
					}
					headB = headB.next;
				}
				headA = headA.next;

				start++;

			}
		} else {
			c = Math.abs(c);
			while (headB != null) {
				if (start >= c) {
					if ( headA ==headB){
						return headA;
					}
					headA = headA.next;
				}
				headB = headB.next;

				start++;

			}
		}

		return null;
	}

	/**
	 * 8
	 * [4,1,8,4,5]
	 * [5,0,1,8,4,5]
	 * 2
	 */
	@Test
	public void t1(){
		ListNode listNode = new ListNode(4);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(8);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(5);
		ListNode listNode7 = new ListNode(0);
		ListNode listNode8 = new ListNode(1);
		listNode.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		listNode6.next=listNode7;
		listNode7.next=listNode8;
		listNode8.next=listNode3;
		ListNode intersectionNode = getIntersectionNode(listNode, listNode6);
		System.out.printf("");
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}