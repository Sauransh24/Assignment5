package com.example.socialnetwork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import com.example.socialnetwork.graph.*;
import com.example.socialnetwork.algorithms.*;
import org.junit.jupiter.api.Test;

public class PerformanceTest {

    @Test
    public void testBreadthFirstSearchPerformance() {
        int[] numNodesList = {10000, 50000, 100000}; // Different numbers of nodes
        int[] numEdgesList = {5000, 25000, 100000}; // Corresponding numbers of edges

        try (FileWriter writer = new FileWriter("performance_metrics.csv")) {
            writer.append("NumNodes,NumEdges,ExecutionTime(ms),MemoryUsage(bytes)\n");

            for (int i = 0; i < numNodesList.length; i++) {
                int numNodes = numNodesList[i];
                int numEdges = numEdgesList[i];

                SocialNetwork socialNetwork = createRandomSocialNetwork(numNodes, numEdges);

                long startTime = System.currentTimeMillis();
                List<Node> influentialNodes = BreadthFirstSearch.findInfluentialNodes(socialNetwork, socialNetwork.getNode(0), 10);
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;

                // Measure memory usage
                long memoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

                // Write performance metrics to CSV file
                writer.append(String.format("%d,%d,%d,%d\n", numNodes, numEdges, executionTime, memoryUsage));
            }
        } catch (IOException e) {
            e.printStackTrace();
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
