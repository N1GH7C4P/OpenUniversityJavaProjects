import java.util.*;

public class Kurssit {
    
    private Graph verkko = new Graph();
    private Boolean cyclic = false;
    
    public void lisaaKurssi(String s) {
        Node a = new Node(s);
        this.verkko.addNode(a);
    }

    public void lisaaVaatimus(String a, String b) {
        this.verkko.getNode(a).addNeighbor(verkko.getNode(b).getName());
    }
  
    public ArrayList<String> muodosta() {
        ArrayList<String> order = topoSort(this.verkko);
        if(cyclic) {
            return null;
        }
        return order;
    }
    
    private ArrayList<String> topoSort(Graph g) {

        int V = g.getSize();
        ArrayList<String> order = new ArrayList<> ();
        Map<String, Integer> visited = new HashMap<>();
        for (Node tmp: g.getNodes())
            visited.put(tmp.getName(), 0);

        for (Node tmp: g.getNodes()) {
            if (visited.get(tmp.getName()) == 0)
                topoSort(g, tmp.getName(), visited, order);
        }

        Collections.reverse(order);
        return order;
    }

    private void topoSort(Graph g, String current, Map<String, Integer> visited, List<String> order) {
        
        visited.replace(current, 2);
        Integer i;

        for (String neighborName: g.getNode(current).getNeighbors()) {
            if (visited.get(neighborName) == 0)
                topoSort(g, neighborName, visited, order);
            else if(visited.get(neighborName) == 2) {
                this.cyclic = true;
            }
        }

        visited.replace(current, 1);
        order.add(current);
    }
}
