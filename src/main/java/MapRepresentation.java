import java.util.HashMap;
import java.util.Map;

/**
 * Similar to matrix implementation but the structure inside will be
 * a map with key (v1, v2) -> Node<T> , where T is user defined type
 */
public class MapRepresentation<T> {
        private Map<Pair<Integer, Integer> , T> hashMap ;

    public MapRepresentation() {
        hashMap = new HashMap<>();
    }

    static class Pair<T1, T2> {
        T1 key1;
        T2 key2;

        Pair() {
            super();
        }

        Pair(T1 key1, T2 key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        @Override
        public int hashCode() {
            return this.key1.hashCode() + this.key2.hashCode();
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == this)
                return true;
            if (!(obj instanceof Pair)) {
                return false;
            }
            @SuppressWarnings("unchecked")
            Pair<T1, T2> pair = (Pair<T1, T2>) obj;

            return this.key1.equals(pair.key1) && this.key2.equals(pair.key2);
        }
    }
}
