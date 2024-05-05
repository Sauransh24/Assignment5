package com.example.socialnetwork.algorithms;
import java.util.*;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.SocialNetwork;


public class DepthFirstSearch {
    public static int analyzeInformationSpread(SocialNetwork network, Node startNode) {
        Set<Node> visited = new HashSet<>();
        int count = dfs(network, startNode, visited);
        return count;
    }

    private static int dfs(SocialNetwork network, Node node, Set<Node> visited) {
        visited.add(node);
        int count = 1;

        List<Node> neighbors = network.getNeighbors(node);


        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                count += dfs(network, neighbor, visited);
            }
        }


        return count;
    }
}
