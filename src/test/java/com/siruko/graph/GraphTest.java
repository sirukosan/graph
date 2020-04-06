package com.siruko.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {

    private UndirectedGraph<Vertex, Edge> undirectedGraph;
    private DirectedGraph<Vertex, Edge> directedGraph;
    private Vertex v1, v2, v3, v4, v5, v6, v7;
    private Edge e12, e23, e56, e67, e75;

    private void populateGraph(Graph<Vertex, Edge> graph) {
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);

        graph.addEdge(e12, v1, v2);
        graph.addEdge(e23, v2, v3);
        graph.addEdge(e56, v5, v6);
        graph.addEdge(e67, v6, v7);
        graph.addEdge(e75, v7, v5);
    }

    @Before
    @Test
    public void initTests() {
        v1 = new Vertex("1");
        v2 = new Vertex("2");
        v3 = new Vertex("3");
        v4 = new Vertex("4");
        v5 = new Vertex("5");
        v6 = new Vertex("6");
        v7 = new Vertex("7");

        e12 = new Edge("1-2");
        e23 = new Edge("2-3");
        e56 = new Edge("5-6");
        e67 = new Edge("6-7");
        e75 = new Edge("7-5");

        undirectedGraph = new UndirectedGraph<>();
        populateGraph(undirectedGraph);

        directedGraph = new DirectedGraph<>();
        populateGraph(directedGraph);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullInAddEdgeMethod() {
        undirectedGraph.addEdge(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNotExistedVertexInAddEdgeMethod() {
        undirectedGraph.addEdge(new Edge("com/siruko/graph"), new Vertex("com/siruko/graph"), new Vertex("com/siruko/graph"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAlreadyExistedEdgeInAddEdgeMethod() {
        undirectedGraph.addEdge(e12, new Vertex("com/siruko/graph"), new Vertex("com/siruko/graph"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullVertexInAddVertexMethod() {
        undirectedGraph.addVertex(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAlreadyExistedVertexInAddVertexMethod() {
        undirectedGraph.addVertex(v1);
    }

    @Test
    public void undirectedPath12Test() {
        List<Edge> path = undirectedGraph.getAnyPath(v1, v2);
        assertNotNull(path);
        assertEquals(1, path.size());
        assertEquals(e12, path.get(0));
    }

    @Test
    public void undirectedPath123Test() {
        List<Edge> path = undirectedGraph.getAnyPath(v1, v3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(e12, path.get(0));
        assertEquals(e23, path.get(1));
    }

    @Test
    public void undirectedNullPathTest() {
        List<Edge> path = undirectedGraph.getAnyPath(v1, v4);
        assertNull(path);
    }

    @Test
    public void directedPath12Test() {
        List<Edge> path = directedGraph.getAnyPath(v1, v2);
        assertNotNull(path);
        assertEquals(1, path.size());
        assertEquals(e12, path.get(0));
    }

    @Test
    public void directedPath123Test() {
        List<Edge> path = directedGraph.getAnyPath(v1, v3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(e12, path.get(0));
        assertEquals(e23, path.get(1));
    }

    @Test
    public void directedNullPathTest() {
        List<Edge> path = directedGraph.getAnyPath(v1, v4);
        assertNull(path);
    }

}
