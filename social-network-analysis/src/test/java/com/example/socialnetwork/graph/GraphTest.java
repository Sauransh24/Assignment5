package com.example.socialnetwork.graph;
import com.example.socialnetwork.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GraphTest {
    @Test
    public void testAddNode() {
    Graph graph = new SocialNetwork();
    Node node = new Node(1, "Groot");
    graph.addNode(node);
    assertEquals(1, graph.getNodeCount());
    }
    
    
    @Test
    public void testAddEdge() {
        Graph graph = new SocialNetwork();
        Node node1 = new Node(1, "Groot");
        Node node2 = new Node(2, "Rocket");
        graph.addNode(node1);
        graph.addNode(node2);
        Edge edge = new Edge(node1, node2, 1.0);
        graph.addEdge(edge);
        assertEquals(1, graph.getEdgeCount());
    }
    
}
    