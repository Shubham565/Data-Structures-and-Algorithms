package com.bhambey.graphs;

public class TraversalBFSList {

	public static void main(String[] args) {

		int nodes = 6;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 4);
		a.addEdge(2, 5);
		a.addEdge(4, 5);

		a.bfs(0);

	}

}
