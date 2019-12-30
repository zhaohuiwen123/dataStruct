package com.cn;

public class SeqList {
    private int size = 0;
    private int capacity = 10;
    private int[] data = new int[capacity];

    //打印顺序表
    public void display(){
        System.out.println("[");
        for(int i=0;i<size;i++){
                System.out.println(data[i]);
                if(size != size-1){
                    System.out.println(",");
                }
        }
        System.out.println("]");
    }
    //在pos的位置新插入数据元素
    public void add(int pos,int data){
        if( pos<0 ||pos>this.size){
            return;
        }
        if(this.size+1>this.capacity){
            realloc();
        }
        //需要将Pos位置后的数据依次向后移动
        // 将 elementData中从Index位置开始、长度为size-index的元素，
        // 拷贝到从下标为index+1位置开始的新的elementData数组中。
        // 即将当前位于该位置的元素以及所有后续元素右移一个位置。
        for(int i=size;i>pos;i--){
            this.data[i] = this.data[i-1];
        }
        this.data[pos] = data;
        this.size+=1;
    }
    //扩容
    private void realloc(){
        this.capacity = this.capacity*2;
        int[] tmp = new int[this.capacity];
        for(int i=0;i<this.size;i++){
            tmp[i] = data[i];
        }
        this.data = tmp;
    }
    //判定是否包含某一个元素
    public boolean contains(int toFind){
        for(int i=0;i<this.size;i++){
            if(this.data[i] == toFind){
                return true;
            }
        }
        return false;
    }
    //查找每一个元素对应的位置
    public int search(int toFind){
        for(int i=0;i<this.size;i++){
            if(this.data[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos){
        return data[pos];
    }
    //给pos位置的元素设置value
    public void setPos(int pos,int value){
        if(pos>size|| pos <0){
            return ;
        }
        this.data[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove){
        int pos = search(toRemove);
        if(pos == -1){
            return;
        }
        for(int i=pos;i<size-1;i++){
            data[i] = data[i+1];
        }
        this.size += 1;
    }
    //获取数组的长度
    public int size(){
        return this.size;
    }
    //清空顺序表
    public void clear(){
        this.size = 0;
        this.capacity = 10;
        int[] data = new int[capacity];
    }
}
