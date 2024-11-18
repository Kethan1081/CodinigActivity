
class Solution {
    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
        int[] colors = new int[n]; // 0: unvisited, 1: color1, 2: color2

        // Perform BFS for each component of the graph
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // If the node is unvisited
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1; // Assign the first color

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int currentColor = colors[node];

                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {
                            // Assign the opposite color to the neighbor
                            colors[neighbor] = (currentColor == 1) ? 2 : 1;
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == currentColor) {
                            // A conflict is found
                            return false;
                        }
                    }
                }
            }
        }

        return true; 
    }
}