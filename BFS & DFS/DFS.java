import java.util.LinkedList;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class DFS {

    // linked list for storing all the vertices
    private LinkedList<Integer> adjList[];

    // creates graph and adds vertices to it
    public DFS(int maxVertices) {
        adjList = new LinkedList[maxVertices];
        for (int i = 0; i < maxVertices; i++) {
            // linked list for storing all the edges of index "i" vertex in linked list
            adjList[i] = new LinkedList<>();
        }
    }
    
    // creates edge source vertex to destination vertex
    public void addEdge(int source, int destination) {
        adjList[source].addFirst(destination);
        adjList[destination].addFirst(source);
    }

    // graph traversing with DFS
    public void dfsTraversal(int start) {
        // stack is used because dfs use stack
        Stack<Integer> stack = new Stack<Integer>();
        // boolean array for storing already visited vertices
        boolean[] isVisited = new boolean[adjList.length];

        // pushing first vertex to stack so that traversing can start
        stack.push(start);

        // boolean for checking whether current vertex's neighbor has been visited or not
        boolean isNeighborVisited = false;
        int countLevels = 1;
        
        // displaying current level and incrementing its value by one
        System.out.print(countLevels++ + ") ");
        // traversing the graph until stack is empty
        while (!stack.isEmpty()) {
            // getting current vertex
            int current = stack.pop();
            // displaying current vertex
            System.out.print(current + " ");

            // marking current vertex as visited
            isVisited[current] = true;
            // iterating through all neighbors of current vertex
            for (int neighbor : adjList[current]) {
                // checking if current neighbor is already visited or not
                if (!isVisited[neighbor]) {
                    // pushing current visiting neighbor to stack
                    stack.push(neighbor);
                    // marking as neighbor has been visited
                    isNeighborVisited = true;
                }
            }

            // checking if neighbor has been visited
            if (isNeighborVisited) {
                // marking as neighbor has not been visited
                isNeighborVisited = false;
                System.out.println();
                // displaying current level and incrementing its value by one
                System.out.print(countLevels++ + ") ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DFS graph = new DFS(6);
        
        // calling addEdge method for adding edges to graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 5);

        System.out.println("Depth First Traversal with levels mentioned:");
        // calling dfsTraversal method for traversing
        graph.dfsTraversal(0);
    }
}