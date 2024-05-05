package com.example.socialnetwork;
import java.util.*;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.algorithms.*;
import org.junit.jupiter.api.Test;


public class PerformanceTest {
    @Test
    public void testGraphPerformance() {
    int numNodes = 10000;
    int numEdges = 50000;
    
    
        SocialNetwork socialNetwork = createRandomSocialNetwork(numNodes, numEdges);
    
        long startTime = System.currentTimeMillis();
        BreadthFirstSearch.findInfluentialNodes(socialNetwork, socialNetwork.getNode(0), 10);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
    
        System.out.println("Execution Time (ms): " + executionTime);
        // Add assertions for performance metrics
    }
    
    private SocialNetwork createRandomSocialNetwork(int numNodes, int numEdges) {
        SocialNetwork socialNetwork = new SocialNetwork();
    
        for (int i = 0; i < numNodes; i++) {
            Node node = new Node(i, "Node " + i);
            socialNetwork.addNode(node);
        }
    
        Random random = new Random();
        for (int i = 0; i < numEdges; i++) {
            int source = random.nextInt(numNodes);
            int destination = random.nextInt(numNodes);
            double weight = random.nextDouble();
            Edge edge = new Edge(socialNetwork.getNode(source), socialNetwork.getNode(destination), weight);
            socialNetwork.addEdge(edge);
        }
    
        return socialNetwork;
    }
    }
    