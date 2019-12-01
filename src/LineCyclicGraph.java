// A Java Program to detect cycle in a graph
// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem Statement
 * Given a directed graph, detect whether the graph contains a cycle or not.
 *
 * Input
 * [N_NODES] [N_EDGES]
 * [E1_FROM_NODE] [E1_TO_NODE]
 * [E2_FROM_NODE] [E2_TO_NODE]
 * ...
 * Where N_NODES is the number of nodes in the graph, and N_EDGES is the number of edges in the graph.
 *
 * N_EDGES lines follow after the first line.
 *
 * A pair of En_FROM_NODE  and En_TO_NODE represents a directed edge in the graph.
 *
 * En_FROM_NODE and En_TO_NODE are node ids, which are integers in the range 0..N_NODES-1
 *
 * Output
 * Output "true" if the graph contains at least one cycle; otherwise, "false".
 *
 * [RESULT]
 * Input Example
 * 3 3
 * 0 1
 * 1 2
 * 2 0
 * Output Example
 * true
 *
 */
class LineCyclicGraph
{
    private final int V;
    private final List<List<Integer>> adj;

    public LineCyclicGraph(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS()
    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    // Driver code
    public static void main(String[] args)
    {
        LineCyclicGraph lineCyclicGraph = new LineCyclicGraph(3);
        lineCyclicGraph.addEdge(0, 1);
        lineCyclicGraph.addEdge(1, 2);
        lineCyclicGraph.addEdge(2, 0);

        /*Scanner sc = new Scanner(System.in);
        char[] graphSpec = sc.nextLine().trim().toCharArray();
        Graph graph = new Graph(graphSpec[0]);
        System.out.println(graphSpec);
        for(int i = 0;i<graphSpec[1];i++){
            if(!sc.hasNext()) break;
            char[] temp = sc.nextLine().trim().toCharArray();
            graph.addEdge(temp[0], temp[1]);
        }*/
        System.out.println(lineCyclicGraph.adj);
        if(lineCyclicGraph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }

}

// This code is contributed by Sagar Shah.
