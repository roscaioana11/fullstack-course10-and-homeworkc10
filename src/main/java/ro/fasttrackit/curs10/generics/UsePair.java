package ro.fasttrackit.curs10.generics;

public interface UsePair<V> {
    V transform(Pair<?, V> pair);
}
