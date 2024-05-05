package com.example.socialnetwork;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.example.socialnetwork.graph.*;


public class SocialNetwork implements Graph {
    private Map<Integer, Node> nodes;
    private Map<Node, List<Node>> adjacencyList;

    public SocialNetwork() {
        nodes = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addNode(Node node) {
        nodes.put(node.getId(), node);
        adjacencyList.put(node, new ArrayList<>());
    }

    @Override
    public void addEdge(Edge edge) {
        Node source = edge.getSource();
        Node destination = edge.getDestination();
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    @Override
    public List<Node> getNeighbors(Node node) {
        return adjacencyList.get(node);
    }

    @Override
    public int getNodeCount() {
        return nodes.size();
    }

    @Override
    public int getEdgeCount() {
        int count = 0;
        for (List<Node> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count / 2;
    }

    @Override
    public Node getNode(int id) {
        return nodes.get(id);
    }
    
    
}
