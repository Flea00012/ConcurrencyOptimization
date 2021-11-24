package com.lee.deepsearch;

public class Main {

   public static void main(String[] args) {

      Node node1 = new Node("A");
      Node node2 = new Node("B");
      Node node3 = new Node("C");
      Node node4 = new Node("D");
      Node node5 = new Node("E");
      Node node6 = new Node("F");
      Node node7 = new Node("G");

      node1.addNeighbour(node2);
      node1.addNeighbour(node3);
      node2.addNeighbour(node4);
      node4.addNeighbour(node5);
      node4.addNeighbour(node6);
      node5.addNeighbour(node7);

      Algorithm algorithms = new Algorithm(node7);
      algorithms.runDeepeningSearch(node1);
   }
}
