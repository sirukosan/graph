package com.siruko.graph;

import java.util.List;

/**
 * Generic Graph interface
 *
 * @param <V>  Vertex type
 * @param <E> Edge type
 */
public interface Graph<V, E> {

	/**
	 * Add Edge
	 *
	 * @param edge Edge
	 * @param source source Vertex
	 * @param destination destination Vertex
	 */
	void addEdge(E edge, V source, V destination);

	/**
	 * Add vertex
	 *
	 * @param vertex vertex
	 */
	void addVertex(V vertex);

	/**
	 *  Get Any path between two vertices
	 *
	 * @param source source vertex
	 * @param destination destination vertex
	 * @return sequence of edges which joins source and destination vertices
	 */
	List<E> getAnyPath(V source, V destination);
}
