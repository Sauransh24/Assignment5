import pandas as pd
import matplotlib.pyplot as plt

# Read performance metrics from CSV file
df = pd.read_csv("social-network-analysis\performance_metrics.csv")

# Plot execution time vs. number of nodes
plt.figure(figsize=(10, 6))
for num_nodes in df['NumNodes'].unique():
    subset = df[df['NumNodes'] == num_nodes]
    plt.plot(subset["NumEdges"], subset["ExecutionTime(ms)"], marker='o', label=f'NumNodes={num_nodes}')
plt.title("Execution Time vs. Number of Edges")
plt.xlabel("Number of Edges")
plt.ylabel("Execution Time (ms)")
plt.legend()
plt.grid(True)
plt.savefig("execution_time_vs_edges.png")  # Save plot as PNG file
plt.show()

# Plot memory usage vs. number of nodes
plt.figure(figsize=(10, 6))
for num_edges in df['NumEdges'].unique():
    subset = df[df['NumEdges'] == num_edges]
    plt.plot(subset["NumNodes"], subset["MemoryUsage(bytes)"], marker='o', label=f'NumEdges={num_edges}')
plt.title("Memory Usage vs. Number of Nodes")
plt.xlabel("Number of Nodes")
plt.ylabel("Memory Usage (bytes)")
plt.legend()
plt.grid(True)
plt.savefig("memory_usage_vs_nodes.png")  # Save plot as PNG file
plt.show()
