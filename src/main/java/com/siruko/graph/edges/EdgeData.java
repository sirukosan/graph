package com.siruko.graph.edges;

public class EdgeData<T> {
    private T sourceVertex;
    private T destinationVertex;

    public EdgeData(T sourceVertex, T destinationVertex) {
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
    }

    public T getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(T sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public T getDestinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(T destinationVertex) {
        this.destinationVertex = destinationVertex;
    }
}
