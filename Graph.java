
/**
 * Created by jmishra on 29-06-2017.
 */

import java.util.*;
public class Graph {

    HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();
    public static class Node{
        int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();

        public Node(int id){
            this.id = id;
        }
    }

    public  Node getNode(int id){
        return nodeLookUp.get(id);
    }

    public void addEdge(Node source, Node destination){
        source.adjacent.add(destination);
    }

    public boolean hasPath(int source, int destination){
        Node sourceNode = nodeLookUp.get(source);
        Node destinationNode = nodeLookUp.get(destination);

        HashSet<Integer> visited = new HashSet<Integer>();

        return hasPathDFS(sourceNode, destinationNode, visited);
    }

    private boolean hasPathDFS(Node sourceNode, Node destinationNode, HashSet<Integer> visited) {
        if(sourceNode == destinationNode)
            return true;
        if(visited.contains(sourceNode.id))
            return false;
        if(sourceNode.adjacent.contains(destinationNode))
            return true;
        visited.add(sourceNode.id);
        for(Node child: sourceNode.adjacent){
            hasPathDFS(child, destinationNode, visited);
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        Node sourceNode = nodeLookUp.get(source);
        Node destinationNode = nodeLookUp.get(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathBFS(sourceNode, destinationNode, visited);

    }

    private boolean hasPathBFS(Node sourceNode, Node destinationNode, HashSet<Integer> visited) {

        LinkedList<Node> nextNodeToVisitQueue = new LinkedList<>();
        nextNodeToVisitQueue.add(sourceNode);
        while(!nextNodeToVisitQueue.isEmpty()){
            Node  currentNode = nextNodeToVisitQueue.removeFirst();
            if(currentNode == destinationNode)
                return true;
            if(visited.contains(currentNode.id))
                return false;
            visited.add(currentNode.id);
            if(currentNode.adjacent.contains(destinationNode))
                return true;
            for(Node child : currentNode.adjacent){
                nextNodeToVisitQueue.add(child);
            }

        }
        return false;
    }
}
