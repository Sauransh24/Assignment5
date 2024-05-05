package com.example.socialnetwork.algorithms;
import java.util.*;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadthFirstSearchTest {
    @Test
    public void testFindInfluentialNodes() {
    SocialNetwork socialNetwork = createSampleSocialNetwork();
    Node startNode = socialNetwork.getNode(1);
    int topK = 2;
    
    List<Node> influentialNodes = BreadthFirstSearch.findInfluentialNodes(socialNetwork, startNode, topK);
    assertEquals(2, influentialNodes.size());
    assertTrue(influentialNodes.contains(socialNetwork.getNode(4)));
    assertTrue(influentialNodes.contains(socialNetwork.getNode(1)));
    }
    
    
    private SocialNetwork createSampleSocialNetwork() {
        SocialNetwork socialNetwork = new SocialNetwork();
    
        Node node1 = new Node(1, "Alice");
        Node node2 = new Node(2, "Bob");
        Node node3 = new Node(3, "Charlie");
        Node node4 = new Node(4, "David");
        Node node5 = new Node(5, "Eve");
    
        socialNetwork.addNode(node1);
        socialNetwork.addNode(node2);
        socialNetwork.addNode(node3);
        socialNetwork.addNode(node4);
        socialNetwork.addNode(node5);
    
        socialNetwork.addEdge(new Edge(node1, node2, 1.0));
        socialNetwork.addEdge(new Edge(node1, node3, 1.0));
        socialNetwork.addEdge(new Edge(node2, node4, 1.0));
        socialNetwork.addEdge(new Edge(node3, node4, 1.0));
        socialNetwork.addEdge(new Edge(node4, node5, 1.0));
    
        return socialNetwork;
    }
    }
    