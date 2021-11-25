package com.lee.astarsearch;

import java.util.*;
import java.util.stream.Collectors;



public class AStarSearch {
   private Node source;
   private Node destination;
   private Set<Node> explored;
   private PriorityQueue<Node> queue;

   public AStarSearch(Node source, Node destination) {
      this.source = source;
      this.destination = destination;
      this.explored = new HashSet<>();
      this.queue = new PriorityQueue<>(new NodeComparator());

   }

   public void run() {
      queue.add(source);

      while (!queue.isEmpty()) {
         // we always get the node with the lowest f(x) value possible
         Node current = queue.poll();
         explored.add(current);

         if (current == destination) {
            break;
         }

         for (Edge edge : current.getAdjacencyList()) {
            Node child = edge.getTarget();
            double cost = edge.getWeight();
            double tempG = current.getG() + cost;
            double tempF = tempG + heuristic(current, destination);

            if (explored.contains(child) && tempF >= child.getF()) {
               continue;
            } else if (queue.contains(child) || tempF < child.getF()) {
               child.setParent(current);
               child.setG(tempG);
               child.setF(tempF);

               if(queue.contains(child))
                  queue.remove(child);

               queue.add(child);
            }

         }
      }
   }

   private double heuristic(Node node1, Node node2) {
      return Math.sqrt((node1.getX() - node2.getX())*(node1.getX() - node2.getX()) + (node1.getY() - node2.getY())*(node1.getY() - node2.getY()));
   }

   public void printSolutionPath(){
      List<Node> path = new ArrayList<>();

      for(Node node = destination; node!=null;node = node.getParent()){
         path.add(node);

         Collections.reverse(path);

         System.out.println(path);
      }
   }


}
