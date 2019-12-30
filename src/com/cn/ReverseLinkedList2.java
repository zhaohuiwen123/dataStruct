package com.cn;

public class ReverseLinkedList2 {
    class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public ListNode creatList(){
        ListNode head= new ListNode(0);
        ListNode prev= head;
        for(int i=1;i<2;i++){
            ListNode next=new ListNode(i);
            prev.next=next;
            prev=next;
        }
        return head;
    }
    public void print(ListNode head){
        ListNode nt=head;
        while(nt!=null){
            System.out.println(nt.data + " ");
            nt=nt.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        //如果链表为空的情况或者只有一个节点的情况下
        if (head == null || head.next == null) {
            return head;
        }
        //一般情况下
        ListNode cur = head;
        ListNode nt = head.next;
        head.next = null;
        while (nt != null) {
            ListNode tmp = nt.next;
            nt.next = cur;
            cur = nt;
            nt = tmp;
        }
        head = cur;
        return head;
    }
    public static  void main(String[] args){
        ReverseLinkedList2 r = new ReverseLinkedList2();
        ListNode head = r.creatList();
        r.print(head);
        System.out.println("-----------");
        ListNode rverseHead= r.reverseList(head);
        r.print(rverseHead);
    }
}
