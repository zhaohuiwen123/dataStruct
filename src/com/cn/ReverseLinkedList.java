package com.cn;

public class ReverseLinkedList {
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
        for(int i=1;i<7;i++){
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
    public ListNode reverseList(ListNode head){
        //如果链表为空的情况或者只有一个节点的情况下
        if(head==null || head.next==null){
            return head;
        }
        //一般情况下
        ListNode cur=head.next;
        ListNode prev=head.next.next;
        head.next=null;
        while(prev!=null){
          cur.next=head;
          head=cur;
          cur=prev;
          prev=prev.next;
        }
        cur.next=head;
        head=cur;
        return head;
    }
    public static  void main(String[] args){
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode head = r.creatList();
        r.print(head);
        System.out.println("-----------");
        ListNode rverseHead=r.reverseList(head);
        r.print(rverseHead);
    }
}
