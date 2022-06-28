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

public class Graph 
{ 
    private int V; 
    private LinkedList<Integer> adj[];
  
    public Graph(int v) 
    { 
        this.V = v; 
        this.adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            this.adj[i] = new LinkedList(); 
    } 

    public void addEdge(int v,int w) {  adj[v].add(w); } 
  
    public void syvyyshaku(int v,Boolean visited[]) 
    { 
        visited[v] = true; 
  
        int n; 
  
        Iterator<Integer> i = adj[v].iterator(); 
        while (i.hasNext()) 
        { 
            n = i.next(); 
            if (!visited[n]) 
                syvyyshaku(n,visited); 
        } 
    }
    public int getSize() {
        return this.V;
    }
    public Graph getTranspose() 
    { 
        Graph g = new Graph(V); 
        for (int v = 0; v < V; v++) 
        {  
            Iterator<Integer> i = adj[v].listIterator(); 
            while (i.hasNext()) 
                g.adj[i.next()].add(v); 
        } 
        return g; 
    }
    public Boolean vahvaYhteys() 
    { 
        Boolean visited[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        syvyyshaku(0, visited); 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                return false; 
  
        Graph gr = getTranspose(); 
  
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        gr.syvyyshaku(0, visited); 
  
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                return false; 
  
        return true; 
    } 
}