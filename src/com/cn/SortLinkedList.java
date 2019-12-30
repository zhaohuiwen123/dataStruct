package com.cn;

public class SortLinkedList {
    class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public ListNode creatList1(){
        ListNode head= new ListNode(0);
        ListNode prev= head;
        for(int i=1;i<5;i++){
            ListNode next=new ListNode(i+3);
            prev.next=next;
            prev=next;
        }
        return head;
    }
    public ListNode creatList2(){
        ListNode head= new ListNode(0);
        ListNode prev= head;
        for(int i=1;i<5;i++){
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
    public ListNode sort(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        ListNode l1=head1;
        ListNode l2=head2;
        ListNode newHead=new ListNode(-1);
        ListNode tail=newHead;
        while(l1!=null&&l2!=null){
            if(l1.data<l2.data){
               tail.next=l1;
               tail=l1;
               l1=l1.next;
            }else{
                tail.next=l2;
                tail=l2;
                l2=l2.next;
            }
        }
        if(l1==null){
            tail.next=l2;
        }else {
            tail.next=l1;
        }
        return newHead.next;
    }
    public static void main(String[] args){
        SortLinkedList sor = new SortLinkedList();
        ListNode head1=sor.creatList1();
        sor.print(head1);
        ListNode head2=sor.creatList2();
        sor.print(head2);
        ListNode sorted=sor.sort(head1,head2);
        sor.print(sorted);
    }
}
