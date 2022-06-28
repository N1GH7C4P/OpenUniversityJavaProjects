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
    private int id;
    private List<Kaari> neighbors;

    public Node(int id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Kaari e) {
        this.neighbors.add(e);
    }
    
    public int getId() {
        return this.id;
    }

    public List<Kaari> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", neighbors=" + neighbors +
                "}"+ "\n";
    }
}