package com.example.socialnetwork.graph;
import java.util.List;

public interface Graph {
    void addNode(Node node);
    void addEdge(Edge edge);
    List<Node> getNeighbors(Node node);
    int getNodeCount();
    int getEdgeCount();
    Node getNode(int id);

}
