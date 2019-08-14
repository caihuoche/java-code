package com.example.demo.list;

import java.math.BigInteger;


import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/08/14
 **/
public class Tow {

	@Test
	public void t1() {
		ListNode listNode = new ListNode(9);

		ListNode listNode2 = new ListNode(8);
		ListNode listNode3 = new ListNode(8);
		listNode.next = listNode2;
		//listNode2.next = listNode3;

		ListNode addumbers = addumbers(listNode, new ListNode(1));
		System.out.println(addumbers);
	}

	public ListNode addumbers(ListNode l1, ListNode l2) {
		String aa = null;
		String bb = null;
		if (l1 != null) {
			aa = aa(l1, l1.val + "");
		}
		if (l2 != null) {
			bb = aa(l2, l2.val + "");
		}
		System.out.println(aa);
		System.out.println(bb);
		String i = add2(aa, bb);
		char[] chars = i.toCharArray();
		ListNode listNode = null;
		for (int j = chars.length - 1; j >= 0; j--) {
			int i1 = Integer.parseInt(String.valueOf(chars[j]));
			if (listNode == null) {
				listNode = new ListNode(i1);
			} else {
				bb(listNode, i1);
			}
		}

		return listNode;
	}

	private void bb(ListNode listNode, int i1) {
		if (listNode.next == null) {
			ListNode listNode2 = new ListNode(i1);
			listNode.next = listNode2;
		} else {
			bb(listNode.next, i1);
		}
	}

	private String aa(ListNode listNode, String a) {
		ListNode node = listNode.next;
		if (node != null) {
			a = node.val + a;
			return aa(node, a);
		} else {
			return a;
		}

	}

	/**
	 * 用字符串模拟两个大数相加
	 *
	 * @param n1 加数1
	 * @param n2 加数2
	 * @return 相加结果
	 */
	public static String add2(String a, String b) {
		int carry = 0;  //记录进位数
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= (a.length() > b.length() ? a.length() : b.length()); i++) {
			int c = (a.length() >= i ? a.charAt(a.length() - i) - '0' : 0)  //短的字符串数字高位用0补齐
					+ (b.length() >= i ? b.charAt(b.length() - i) - '0' : 0)
					+ carry;
			sb.append(c % 10); //当前位拼接到字符串
			carry = c / 10;    //进位留到下一次运算
		}
		if (carry > 0) {
			sb.append(carry); //最后一次运算若有进位，拼接到字符串
		}
		return sb.reverse().toString();
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	@Test
	public void t2() {
		ListNode listNode = new ListNode(9);

		ListNode listNode2 = new ListNode(9);
		ListNode listNode3 = new ListNode(8);
		listNode.next = listNode2;
		//listNode2.next = listNode3;

		//ListNode addumbers = addumbers2(listNode, new ListNode(5));
		ListNode addumbers2 = addumbers2(new ListNode(1), listNode);
		System.out.println(addumbers2);
	}

	private ListNode addumbers2(ListNode l1, ListNode l2) {
		ListNode p1, p2, p3 = null, result = null;
		p1 = l1;
		p2 = l2;
		int a = 0;
		int num = 0;
		boolean flag = true;
		while (p1 != null || p2 != null) {
			if (p1 == null) {
				num = p2.val;
				p2 = p2.next;

			} else if (p2 == null) {
				num = p1.val;
				p1 = p1.next;

			} else {
				int x = p1.val;
				int y = p2.val;
				num = x + y;
				p1 = p1.next;
				p2 = p2.next;
			}
			int m = (num) % 10;
			if (flag) {
				result = new ListNode(a == 1 ? m + 1 : m);
				p3 = result;
			} else {
				int i = a == 1 ? m + 1 : m;
				if (i>=10)
				result.next = new ListNode();
				result = result.next;
			}
			a = num / 10;
			flag = false;

		}
		if (a == 1) {
			ListNode listNode = new ListNode(a);
			p3.next = listNode;
		}
		return p3;
	}
}
