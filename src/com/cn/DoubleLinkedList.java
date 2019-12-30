package com.cn;

public class DoubleLinkedList {
    class Node{
        private int data;
        private Node prev;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    private Node first;
    private Node last;
    public DoubleLinkedList(){
        this.first=null;
        this.last=null;
    }


}
