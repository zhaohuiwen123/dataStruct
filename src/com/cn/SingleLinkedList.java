package com.cn;

public class SingleLinkedList {
    //定义节点
    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //
    Node head = null;
    //链表头部插入
    public void addFirst(int data){
        Node node  = new Node(data);
        //链表为空的情况，那么新节点作为链表的头节点
        if(head == null){
            this.head = node;
            return;
        }
        //链表不为空
        if(this.head.next!=null){
            node.next = head;
            this.head = node;
        }
    }
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            node = head;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = node;
    }
    public boolean addLast(int index,int data){
        Node node = new Node(data);
       if(index==0){
           node.next = this.head;
           this.head = node;
           return true;
       }
       Node curNode = getIndexPrevious(index);
       if( curNode==null ){
           return false;
       }
       node.next = curNode.next;
       curNode.next = node;
       return true;
    }
    //链表的长度
    public int getLength(){
        int length = 0;
        Node curNode = head;
        while(curNode != null){
            length++;
            curNode = curNode.next;
        }
        return length;
    }
    //寻找index的前节点
    private Node getIndexPrevious(int index){
        if(index<=0 ||index>getLength()){
            return null;
        }
        Node node = null;
        int count = 0;
        while(node.next!=null && count <index-1){
            node  = node.next;
            count++;
        }
        return node;
    }
    //寻找链表中是否包含某数据
    public boolean contains(int data){
        Node curNode = head;
        while(curNode!=null){
            if(curNode.data==data){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }
    //寻找指定节点的头节点
    private Node searchPre(int key){
        Node curNode = head;
        Node preNode = head;
        while(curNode != null){
            if(curNode.data==key){
                return preNode;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return null;
    }
    //删除节点
    public void remove(int key){
        //删除任意节点
        Node preNode = searchPre(key);
        //如果是头节点
        if(preNode==this.head){
            head=head.next;
            return;
        }
        if(preNode==null){
            return;
        }
        preNode.next = preNode.next.next;
    }
    //删除所有的节点
    public void removeAllKey(int key){
        //1,处理头节点为需要删除的元素
        if(this.head.data==key){
            this.head = this.head.next;
        }
        //1,先删除非头节点元素
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur!=null){
            if(cur.data==key){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
    }
    public void display(){
        Node cur = this.head;
        System.out.println("[");
        while(cur!=null){
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
        System.out.println("]");
    }
    public void clear() {
        this.head = null;
    }

}
