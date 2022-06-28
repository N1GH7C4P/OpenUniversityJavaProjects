import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimmo
 */
public class Graph { 
    int V; 

    private List<Integer> adjListArray[];
    private int solutions;
    private ArrayList<Integer> stack;
    public Graph(int V) { 
        
        this.solutions = 0;
        this.V = V; 
        this.adjListArray = new LinkedList[V];
        this.stack = new ArrayList<>(); 

        for (int i = 0; i < V; i++) { 
            this.adjListArray[i] = new LinkedList<>(); 
        }
    } 
     
    public void addEdge(int src, int dest) {
        this.adjListArray[src].add(dest);
    }
    
    public void allTopologicalSortsUtil(boolean[] visited, int[] indegree, ArrayList<Integer> stack) { 
        boolean flag = false; 

        for (int i = 0; i < this.V; i++) { 
            if (!visited[i] && indegree[i] == 0) { 
                visited[i] = true; 
                stack.add(i); 
                for (int adjacent : this.adjListArray[i]) { 
                        indegree[adjacent]--; 
                } 
                allTopologicalSortsUtil(visited, indegree, stack);
                visited[i] = false; 
                stack.remove(stack.size() - 1); 
                for (int adjacent : this.adjListArray[i]) { 
                        indegree[adjacent]++; 
                } 
                flag = true; 
            } 
        } 
        if (!flag) {
            this.solutions++;
        } 
    } 
    
    public int numberOfSolutions() {
        return this.solutions;
    }
     
    public void allTopologicalSorts() { 
        boolean[] visited = new boolean[this.V]; 

        int[] indegree = new int[this.V]; 

        for (int i = 0; i < this.V; i++) { 
            for (int var : this.adjListArray[i]) { 
                    indegree[var]++; 
            } 
        }
        allTopologicalSortsUtil(visited, indegree, stack);
    }
}