package com.siruko.graph;

import com.siruko.graph.edges.EdgeData;
import com.siruko.graph.edges.EdgesKeeper;

import java.util.*;

public abstract class AbstractGraph<V, E> implements Graph<V, E> {
    protected Map<V, EdgesKeeper<E>> vertices = new HashMap<>();
    protected Map<E, EdgeData<V>> edges = new HashMap<>();

    public void addVertex(V vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex shouldn't be null");
        }

        if (vertices.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex already exists in this graph");
        }

        vertices.put(vertex, getEdgesKeeper());
    }

    public void addEdge(E edge, V source, V destination) {
        if (edge == null || source == null || destination == null) {
            throw new IllegalArgumentException("Edges and vertices shouldn't be null");
        }

        if (edges.containsKey(edge)) {
            throw new IllegalArgumentException("Edge already exists");
        }

        if (!vertices.containsKey(source) || !vertices.containsKey(destination)) {
            throw new IllegalArgumentException("Vertex does not exist in this graph");
        }

        vertices.get(source).addOutEdge(edge);
        vertices.get(destination).addInEdge(edge);
        edges.put(edge, new EdgeData<>(source, destination));
    }

    public List<E> getAnyPath(V fromVertex, V toVertex) {
        if (fromVertex == null || toVertex == null) {
            throw new IllegalArgumentException("Vertices shouldn't be null");
        }

        if (!vertices.containsKey(fromVertex) || !vertices.containsKey(toVertex)) {
            throw new IllegalArgumentException("Vertex does not exist in this graph");
        }

        List<E> path = new ArrayList<>();
        if (!calculatePath(fromVertex, toVertex, new HashSet<>(), path)) {
            return null;
        }

        return path;
    }

    protected boolean calculatePath(V from, V to, Set<V> passed, List<E> path) {
        passed.add(from);
        Set<E> outEdges = vertices.get(from).getOutEdges();
        for (E edge : outEdges) {
            EdgeData<V> edgeData = edges.get(edge);
            V nextVertex;
            if (from.equals(edgeData.getDestinationVertex())) {
                nextVertex = edgeData.getSourceVertex();
            } else {
                nextVertex = edgeData.getDestinationVertex();
            }

            if (passed.contains(nextVertex)) {
                continue;
            }

            if (nextVertex.equals(to) || calculatePath(nextVertex, to, passed, path)) {
                path.add(0, edge);
                return true;
            }
        }
        return false;
    }

    protected abstract EdgesKeeper<E> getEdgesKeeper();
}
