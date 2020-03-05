import java.util.ArrayList;
import java.util.List;

public class MatrixRepresentative<T> implements IGraph<T> {
    private int initialNubOfVertices =100;
    private int[][] adjacentMatrix;
    private TypeOfGraph typeOfGraph;
    List<T> nodes = new ArrayList<>();


    public MatrixRepresentative( TypeOfGraph typeOfGraph) {

        this.typeOfGraph = typeOfGraph;
        adjacentMatrix = new int[initialNubOfVertices][initialNubOfVertices];
        for (int i = 0, j = 0; j < initialNubOfVertices && i < initialNubOfVertices; i++, j++) {
            adjacentMatrix[i][j] = 0;
        }
    }

    @Override
    public void addEdge(int v1, int v2 ) {
        if (v1 == 0 || v2 == 0 || v1 < initialNubOfVertices || v2 < initialNubOfVertices) {
            throw new IllegalArgumentException("vertex number is not valid" + v1 + " : " + v2);
        }
        adjacentMatrix[v1][v2] = 1;
        if (typeOfGraph.equals(TypeOfGraph.UNDIRECTED)) {
            adjacentMatrix[v2][v1] = 1;
        }
    }

    @Override
    public void addVertex(int v, T userObject) {

    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        return null;
    }

    @Override
    public void removeEdge(int v1, int v2) {
        if (v1 == 0 || v2 == 0 || v1 < initialNubOfVertices || v2 < initialNubOfVertices) {
            throw new IllegalArgumentException("vertex number is not valid" + v1 + " : " + v2);
        }
        adjacentMatrix[v1][v2] = 0;
        if (typeOfGraph.equals(TypeOfGraph.UNDIRECTED)) {
            adjacentMatrix[v2][v1] = 0;
        }
    }
}
