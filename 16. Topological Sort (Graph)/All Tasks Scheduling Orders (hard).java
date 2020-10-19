import java.util.*;

class AllTaskSchedulingOrders {
  public static void printOrders(int tasks, int[][] prerequisites) {
    List<Integer> sortedOrder = new ArrayList<>();
    if (tasks <= 0)
      return;

    // a. Initialize the graph
    HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
    HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
    for (int i = 0; i < tasks; i++) {
      inDegree.put(i, 0);
      graph.put(i, new ArrayList<Integer>());
    }

    // b. Build the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][0], child = prerequisites[i][1];
      graph.get(parent).add(child); // put the child into it's parent's list
      inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Integer> sources = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0)
        sources.add(entry.getKey());
    }

    printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);
  }

  private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
      HashMap<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {
    if (!sources.isEmpty()) {
      for (Integer vertex : sources) {
        sortedOrder.add(vertex);
        Queue<Integer> sourcesForNextCall = cloneQueue(sources);
        // only remove the current source, all other sources should remain in the queue for the next call
        sourcesForNextCall.remove(vertex);
        List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
        for (int child : children) {
          inDegree.put(child, inDegree.get(child) - 1);
          if (inDegree.get(child) == 0)
            sourcesForNextCall.add(child); // save the new source for the next call
        }

        // recursive call to print other orderings from the remaining (and new) sources
        printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);

        // backtrack, remove the vertex from the sorted order and put all of its children back to consider 
        // the next source instead of the current vertex
        sortedOrder.remove(vertex);
        for (int child : children)
          inDegree.put(child, inDegree.get(child) + 1);
      }
    }

    // if sortedOrder doesn't contain all tasks, either we've a cyclic dependency between tasks, or 
    // we have not processed all the tasks in this recursive call
    if (sortedOrder.size() == inDegree.size())
      System.out.println(sortedOrder);
  }

  // makes a deep copy of the queue
  private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
    Queue<Integer> clone = new LinkedList<>();
    for (Integer num : queue)
      clone.add(num);
    return clone;
  }

  public static void main(String[] args) {
    AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println();

    AllTaskSchedulingOrders.printOrders(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println();

    AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
        new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println();
  }
}