package com.example.socialnetwork;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.algorithms.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    SocialNetwork socialNetwork = new SocialNetwork();
    
    
        // Create nodes
        Node node1 = new Node(1, "Alice");
        Node node2 = new Node(2, "Bob");
        Node node3 = new Node(3, "Charlie");
        Node node4 = new Node(4, "David");
        Node node5 = new Node(5, "Eve");
    
        // Add nodes to the social network
        socialNetwork.addNode(node1);
        socialNetwork.addNode(node2);
        socialNetwork.addNode(node3);
        socialNetwork.addNode(node4);
        socialNetwork.addNode(node5);
    
        // Create edges
        Edge edge1 = new Edge(node1, node2, 1.0);
        Edge edge2 = new Edge(node1, node3, 1.0);
        Edge edge3 = new Edge(node2, node4, 1.0);
        Edge edge4 = new Edge(node3, node4, 1.0);
        Edge edge5 = new Edge(node4, node5, 1.0);
    
        // Add edges to the social network
        socialNetwork.addEdge(edge1);
        socialNetwork.addEdge(edge2);
        socialNetwork.addEdge(edge3);
        socialNetwork.addEdge(edge4);
        socialNetwork.addEdge(edge5);
    
        // Find influential nodes using BFS
        int topK = 3;
        List<Node> influentialNodes = BreadthFirstSearch.findInfluentialNodes(socialNetwork, node1, topK);
        System.out.println("Influential Nodes:");
        for (Node node : influentialNodes) {
            System.out.println(node.getName());
        }
    
        // Analyze information spread using DFS
        int reachedCount = DepthFirstSearch.analyzeInformationSpread(socialNetwork, node1);
        System.out.println("Number of nodes reached: " + reachedCount);
    }
    }
    