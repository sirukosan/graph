package com.siruko.graph.edges;

import java.util.Set;

/**
 * Generic Edges Keeper
 *
 * @param <T> Edge Type
 */
public interface EdgesKeeper<T> {
    void addInEdge(T edge);

    void addOutEdge(T edge);

    Set<T> getInEdges();

    Set<T> getOutEdges();

}
