/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimmo
 */
import java.util.*;

public class Graph {
    
    private int V; 
    private LinkedList<Integer> adj[];
    private ArrayList<Integer> topologicalOrder;
    
    Graph(int v) { 
        this.topologicalOrder = new ArrayList();
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    void addEdge(int v,int w) {
        adj[v].add(w); 
    } 
    
    void helper(int v, boolean visited[], Stack stack) { 
        visited[v] = true; 
        Integer i; 
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
            if (!visited[i]) {
                helper(i, visited, stack);
            } 
        } 
        stack.push(new Integer(v)); 
    }
    
    void topologicalSort() {
        
    Stack stack = new Stack(); 

    boolean visited[] = new boolean[V]; 
    for (int i = 0; i < V; i++) 
        visited[i] = false; 

    for (int i = 0; i < V; i++) 
        if (visited[i] == false) {
            helper(i, visited, stack);
        } 
    while (stack.empty() == false) 
        topologicalOrder.add((int)stack.pop()); 
    }
    
    public ArrayList<Integer> getTopoSort() {
        this.topologicalSort();
        return this.topologicalOrder;
    }
}
