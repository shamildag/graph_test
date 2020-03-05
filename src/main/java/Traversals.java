import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Traversals {

    public <T> void Breadth_First(IGraph<T> graph, int[] visited, int current) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
        queue.add(current);
        while (!queue.isEmpty()) {
            int vertexId = queue.poll();
            if (visited[current] == 1) {
                log.debug("vertex with id = {} already visited", current);
                continue;
            }
            log.debug(" {} -> ", vertexId);
            visited[current] = 1;
            List<Integer> listOfNeigbors = graph.getAdjacentVertices(vertexId);
            for(int v : listOfNeigbors) {
                if (visited[v] == 1 ) {
                    queue.add(v);
                }
            }
        }
    }

    public <T> void depthFirst(IGraph<T> graph, int[] visited, int current) {
        if (visited[current] == 1) {
            log.debug("vertex with id = {} already visited", current);
            return;
        }
        visited[current] = 1;
        List<Integer> listOfNeigbors = graph.getAdjacentVertices(current);
        for (int vertex : listOfNeigbors) {
            depthFirst(graph, visited, vertex);
        }
        log.debug(" {} ->", current);
    }
}
