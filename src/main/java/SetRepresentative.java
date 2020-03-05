import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetRepresentative<T> implements IGraph<T> {

    private List<NodeOfGraph> nodeOfGraphs = Collections.synchronizedList(new ArrayList<>());
    private int amountOfVertices;
    private TypeOfGraph typeOfGraph;

    public SetRepresentative(int amountOfVertices, TypeOfGraph typeOfGraph) {
        this.amountOfVertices = amountOfVertices;
        this.typeOfGraph = typeOfGraph;
        for (int i = 0; i < amountOfVertices; i++) {
            NodeOfGraph newNode = new NodeOfGraph(i, null);
            nodeOfGraphs.add(newNode);
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 == 0 || v2 == 0 || v1 < amountOfVertices || v2 < amountOfVertices) {
            throw new IllegalArgumentException("vertex number is not valid" +  v1 + " : " + v2);
        }
        nodeOfGraphs.get(v1).addEdge(nodeOfGraphs.get(v2).vertexNumber);
        if (typeOfGraph.equals(TypeOfGraph.UNDIRECTED)) {
            nodeOfGraphs.get(v2).addEdge(nodeOfGraphs.get(v1).vertexNumber);
        }
    }

    @Override
    public void addVertex(int v, T userObject ) {
        nodeOfGraphs.add(new NodeOfGraph(v, userObject));
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        return new ArrayList<>(nodeOfGraphs.get(v).getAdjacentVertices());
    }

    @Override
    public void removeEdge(int v1, int v2) {
        if (v1 == 0 || v2 == 0 || v1 < amountOfVertices || v2 < amountOfVertices) {
            throw new IllegalArgumentException("vertex number is not valid" +  v1 + " : " + v2);
        }
        nodeOfGraphs.get(v1).deleteEdge(nodeOfGraphs.get(v2).vertexNumber);
        if (typeOfGraph.equals(TypeOfGraph.UNDIRECTED)) {
            nodeOfGraphs.get(v2).deleteEdge(nodeOfGraphs.get(v1).vertexNumber);
        }
    }

    private  class NodeOfGraph {
        private int vertexNumber;
        private Set<Integer> adjacentSet = new HashSet<>();
        T userObject;

        public NodeOfGraph(int number , T userDefinedObject) {
            this.vertexNumber = number;
            this.userObject = userDefinedObject;
        }

        public Integer getVertexNumber() {
            return vertexNumber;
        }

        public List<Integer> getAdjacentVertices() {
            return new ArrayList<>(adjacentSet);
        }

       public  void addEdge(Integer idOfNeigbor) {
            adjacentSet.add(idOfNeigbor);
        }
        public  void  deleteEdge(Integer idOfNeigbor) {
            adjacentSet.remove(idOfNeigbor);
        }
    }
}
