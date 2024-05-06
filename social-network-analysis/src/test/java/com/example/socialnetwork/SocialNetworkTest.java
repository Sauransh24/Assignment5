package com.example.socialnetwork;
import java.util.*;
import com.example.socialnetwork.graph.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SocialNetworkTest {
    @Test
    public void testGetNeighbors() {
    SocialNetwork socialNetwork = new SocialNetwork();
    Node node1 = new Node(1, "Groot");
    Node node2 = new Node(2, "Rocket");
    socialNetwork.addNode(node1);
    socialNetwork.addNode(node2);
    Edge edge = new Edge(node1, node2, 1.0);
    socialNetwork.addEdge(edge);
    List<Node> neighbors = socialNetwork.getNeighbors(node1);
    assertEquals(1, neighbors.size());
    assertTrue(neighbors.contains(node2));
    }
}
    