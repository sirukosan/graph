package com.siruko.graph.edges;

import java.util.HashSet;
import java.util.Set;

/**
 * Edges Keeper for undirected edghes
 *
 * @param <T> Edge Type
 */
public class UndirectedEdgesKeeper<T> implements EdgesKeeper<T> {
    private Set<T> edges = new HashSet<>();

    @Override
    public void addOutEdge(T edge) {
        this.edges.add(edge);
    }

    @Override
    public void addInEdge(T edge) {
        this.edges.add(edge);
    }

    @Override
    public Set<T> getInEdges() {
        return this.edges;
    }

    @Override
    public Set<T> getOutEdges() {
        return this.edges;
    }
}
