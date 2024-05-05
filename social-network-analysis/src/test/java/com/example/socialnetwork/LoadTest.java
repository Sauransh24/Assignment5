package com.example.socialnetwork;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.algorithms.*;

public class LoadTest {
    @Test
    public void testGraphLoadCapacity() {
    int[] sizes = {1000, 10000, 100000};
    
    
        for (int size : sizes) {
            SocialNetwork socialNetwork = createRandomSocialNetwork(size, size * 5);
    
            long startTime = System.currentTimeMillis();
            BreadthFirstSearch.findInfluentialNodes(socialNetwork, socialNetwork.getNode(0), 10);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
    
            System.out.println
    
    ("Graph Size: " + size + ", Execution Time (ms): " + executionTime);
    // Add assertions for load capacity metrics
    }
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
    