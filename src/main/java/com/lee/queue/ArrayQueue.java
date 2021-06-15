package com.lee.queue;

public class ArrayQueue<E> implements Queue <E> {
   private E[] data;
   private int f = 0;
   private int sz = 0;

   public ArrayQueue() {
//      this(CAPACITY);
   }

   public ArrayQueue(int capacity){
      data = (E[]) new Object[capacity];
   }


   @Override
   public int size() {
      return sz;
   }

   @Override
   public boolean isEmpty() {
      return (sz == 0);
   }

   @Override
   public void enqueue(E e) {
      if(sz == data.length) throw new IllegalStateException("Queue is full");
      int avail = (f + sz) % data.length;

   }

   @Override
   public E first() {
      return null;
   }

   @Override
   public E dequeue() {
      return null;
   }


}