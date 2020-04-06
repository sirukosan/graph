package com.siruko.graph;

import com.siruko.graph.edges.DirectedEdgesKeeper;
import com.siruko.graph.edges.EdgesKeeper;

/**
 * UnDirected implementation of Graph
 *
 * @param <V> Vertices type
 * @param <E> Edges type
 */
public class DirectedGraph<V, E> extends AbstractGraph<V, E> {

    @Override
    protected EdgesKeeper<E> getEdgesKeeper() {
        return new DirectedEdgesKeeper<>();
    }

}
