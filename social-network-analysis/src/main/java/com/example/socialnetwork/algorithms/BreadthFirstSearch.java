package com.example.socialnetwork.algorithms;
import java.util.*;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.SocialNetwork;

public class BreadthFirstSearch {
    public static List<Node> findInfluentialNodes(SocialNetwork network, Node startNode, int topK) {
        Map<Node, Integer> connectionCounts = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int count = 0;

            List<Node> neighbors = network.getNeighbors(currentNode);
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    count++;
                }
            }

            connectionCounts.put(currentNode, count);
        }

        List<Node> influentialNodes = new ArrayList<>(connectionCounts.keySet());
        influentialNodes.sort((node1, node2) -> connectionCounts.get(node2) - connectionCounts.get(node1));

        return influentialNodes.subList(0, Math.min(topK, influentialNodes.size()));
    }
}
