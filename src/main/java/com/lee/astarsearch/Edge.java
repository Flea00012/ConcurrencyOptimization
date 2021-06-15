package com.lee.astarsearch;

public class Edge {

   private double weight;
   private Node target;

   public Edge(Node target, double weight) {
      this.weight = weight;
      this.target = target;
   }

   public double getWeight() {
      return weight;
   }

   public Node getTarget() {
      return target;
   }
}
