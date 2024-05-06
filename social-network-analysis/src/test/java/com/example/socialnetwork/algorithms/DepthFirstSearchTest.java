package com.example.socialnetwork.algorithms;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstSearchTest {
    @Test
    public void testAnalyzeInformationSpread() {
    SocialNetwork socialNetwork = createSampleSocialNetwork();
    Node startNode = socialNetwork.getNode(1);
    
    
        int reachedCount = DepthFirstSearch.analyzeInformationSpread(socialNetwork, startNode);
        assertEquals(5, reachedCount);
    }
    
    private SocialNetwork createSampleSocialNetwork() {
        SocialNetwork socialNetwork = new SocialNetwork();
    
        Node node1 = new Node(1, "Flash");
        Node node2 = new Node(2, "Captain");
        Node node3 = new Node(3, "Thor");
        Node node4 = new Node(4, "Hulk");
        Node node5 = new Node(5, "Thanos");
    
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
    