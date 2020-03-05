import java.util.List;

public interface IGraph<T> {
    enum TypeOfGraph {DIRECTED, UNDIRECTED}

    void addEdge (int v1, int v2);
    void addVertex(int v, T type);
    List<Integer> getAdjacentVertices(int v);
    void removeEdge(int v1, int v2);
}
