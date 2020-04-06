package com.siruko.graph.edges;

import java.util.HashSet;
import java.util.Set;

/**
 * Edges Keeper for directed edges
 *
 * @param <T> Edge Type
 */
public class DirectedEdgesKeeper<T> implements EdgesKeeper<T> {
    private final Set<T> inEdges = new HashSet<>();
    private final Set<T> outEdges = new HashSet<>();

    @Override
    public void addOutEdge(T edge) {
        this.outEdges.add(edge);
    }

    @Override
    public void addInEdge(T edge) {
        this.inEdges.add(edge);
    }

    @Override
    public Set<T> getInEdges() {
        return this.inEdges;
    }

    @Override
    public Set<T> getOutEdges() {
        return this.outEdges;
    }
}
