import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class BFS {
    
    // linked list for storing all the vertices
    private LinkedList<Integer> adjList[];

    // creates graph and adds vertices to it
    public BFS(int maxVertices) {
        adjList = new LinkedList[maxVertices];
        for (int i = 0; i < maxVertices; i++) {
            // linked list for storing all the edges of index "i" vertex in linked list
            adjList[i] = new LinkedList<>();
        }
    }

    // creates edge between source vertex and destination vertex
    public void addEdge(int vertex1, int vertex2) {
        // checks if vertex1 is not already connected to vertex2 then connect it
        if (!adjList[vertex1].contains(vertex2)) {
            adjList[vertex1].add(vertex2);
        }
        // checks if vertex2 is not already connected to vertex1 then connect it
        if (!adjList[vertex2].contains(vertex1)) {
            adjList[vertex2].add(vertex1);
        }
    }

    // graph traversing with BFS
    public void bfsTraversal(int start) {
        // linked list is used because bfs use queue and linked list is basically a queue
        LinkedList<Integer> queue = new LinkedList<>();
        // boolean array for storing already visited vertices
        boolean isVisited[] = new boolean[adjList.length];

        isVisited[start] = true;
        // pushing first vertex to queue so that traversing can start
        queue.add(start);

        // boolean for checking whether current vertex's neighbor has been visited or not
        boolean isNeighborVisited = false;
        int countLevels = 1;

        // displaying current level and incrementing its value by one
        System.out.print(countLevels++ + ") ");
        // traversing the graph until queue is empty
        while (queue.size() != 0) {
            // getting current vertex
            int current = queue.pop();
            // displaying current vertex
            System.out.print(current + " ");

            // iterating through all neighbors of current vertex
            for (int neighbor : adjList[current]) {
                // checking if current neighbor is already visited or not
                if (!isVisited[neighbor]) {
                    // marking current vertex as visited
                    isVisited[neighbor] = true;
                    // pushing current visiting neighbor to queue
                    queue.add(neighbor);
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

    public static void main(String args[])
    {
        BFS g = new BFS(8);

        // calling addEdge method for adding edges to graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 6);
        g.addEdge(4, 7);

        System.out.println("Breadth First Traversal with levels mentioned:");
        // calling bfsTraversal method for traversing
        g.bfsTraversal(0);
    }
}