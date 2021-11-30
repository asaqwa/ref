package EpicTasks.WordChain;

import java.util.ArrayList;
import java.util.TreeSet;

class Graph {
    private final int edgesAmount;
    private final TreeSet<Node> nodesList = new TreeSet<>();

    Graph(String... words) {
        if (words.length < 1) throw new IllegalArgumentException();
        int i = 0;
        for (String word: words) {
            if (word == null || word.isEmpty()) continue;
            new Edge(word);
            i++;
        }
        edgesAmount = i;
    }

    StringBuilder getLongestSequence() {
        for (Node node: nodesList) {
            if (node.edges.size() < 1) continue;
            ArrayList<Edge> sequence = new ArrayList<>();
            nextNode(0, sequence, node);
            if (maxSequence == edgesAmount) break;
        }

        StringBuilder result = new StringBuilder();
        for (Edge edge: orderedWords) {
            result.append(edge.name).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result;
    }

    private class Edge {
        Node node;
        String name;
        Node destination;

        public Edge(String name) {
            if (name == null || name.isEmpty()) throw new IllegalArgumentException();
            this.name = name;
            node = Node.getNode(name.charAt(0), Graph.this);
            destination = Node.getNode(name.charAt(name.length()-1), Graph.this);
            node.edges.add(this);
        }
    }

    private static class Node implements Comparable<Node> {
        protected char vertex;
        protected ArrayList<Edge> edges = new ArrayList<>();

        private Node(char vertex) {
            this.vertex = vertex;
        }

        protected static Node getNode(char ch, Graph graph) {
            Character vertexName = Character.toUpperCase(ch);
            for (Node node : graph.nodesList) {
                if (node.equals(vertexName)) return node;
            }
            Node node = new Node(vertexName);
            graph.nodesList.add(node);
            return node;
        }

        @Override
        public int compareTo(Node o) {
            return Character.compare(vertex, o.vertex);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node node = (Node) o;
                return vertex == node.vertex;
            }
            Character ch = Character.toUpperCase((char)o);
            return ch.equals(vertex);

        }

        @Override
        public int hashCode() {
            return Character.hashCode(vertex);
        }
    }

    private ArrayList<Edge> orderedWords = new ArrayList<>();
    private int maxSequence;
    private void nextNode(int range, ArrayList<Edge> sequence, Node node){
        if (maxSequence == edgesAmount) return;

        if (node.edges.size() < 1 || sequence.containsAll(node.edges)) {
            if (range > maxSequence) {
                maxSequence = range;
                orderedWords = (ArrayList<Edge>) sequence.clone();
            }
        }

        else {
            for (Edge edge: node.edges) {
                if (sequence.contains(edge)) continue;
                sequence.add(edge);
                nextNode(range+1, sequence, edge.destination);
                if (range > maxSequence) {
                    maxSequence = range;
                    orderedWords = (ArrayList<Edge>) sequence.clone();
                }
                sequence.remove(edge);
            }
        }
    }
}
