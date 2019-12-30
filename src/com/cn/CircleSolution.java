package com.cn;

/**
 * 首先这个问题分两部走，用快慢指针去判断到底有木有环，最小公倍数的概念
 * 其次再根据映射，即直线投射到圆弧上的原理去求解结点
 *
 */
public class CircleSolution {
    class ListNode{
        int val;
        ListNode next;
        public  ListNode(int data){
            val=data;
            next=null;
        }
    }
    public ListNode detectedCircle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        ListNode node = head;
        while(node!=slow){
            node=node.next;
            slow=slow.next;
        }
        return node;
    }

}
