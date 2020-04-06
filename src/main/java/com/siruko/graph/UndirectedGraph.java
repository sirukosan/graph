package com.siruko.graph;

import com.siruko.graph.edges.EdgesKeeper;
import com.siruko.graph.edges.UndirectedEdgesKeeper;

/**
 * UnDirected implementation of Graph
 * @param <V> Vertices type
 * @param <E> Edges type
 */
public class UndirectedGraph<V, E> extends AbstractGraph<V, E> {

    @Override
    protected EdgesKeeper<E> getEdgesKeeper() {
        return new UndirectedEdgesKeeper<>();
    }

}
