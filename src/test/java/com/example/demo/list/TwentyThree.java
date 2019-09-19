package com.example.demo.list;


/**
 * @author yanghaiyu
 * @date 2019/09/16
 **/
public class TwentyThree {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null) return null;
		if(lists.length==0) return null;
		ListNode listNode = lists[0];
		for (int i = 1; i < lists.length - 1; i++) {
			listNode = mergeTwoLists(listNode, lists[i]);

		}
		return listNode;

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode result;
		ListNode no;
		if (l1.val < l2.val) {
			result = l1;
			no = result;
			l1 = l1.next;
		} else {
			result = l2;
			no = result;
			l2 = l2.next;
		}
		while (l2 != null && l1 != null) {
			if (l1.val < l2.val) {
				no.next = l1;
				l1 = l1.next;
			} else {
				no.next = l2;
				l2 = l2.next;
			}
			no = no.next;
		}
		if (l1 != null) {
			no.next = l1;
		}
		if (l2 != null) {
			no.next = l2;
		}
		return result;
	}


}
