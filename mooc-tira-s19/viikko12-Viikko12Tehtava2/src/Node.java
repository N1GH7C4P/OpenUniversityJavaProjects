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

public class Node {
    private String name;
    private List<String> neighbors;

    public Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(String e) {
        this.neighbors.add(e);
    }
    
    public String getName() {
        return this.name;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name=" + name +
                ", neighbors=" + neighbors +
                "}"+ "\n";
    }
}