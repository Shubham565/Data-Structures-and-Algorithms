package com.bhambey.graphs;

public class TraversalDFSList {

	public static void main(String[] args) {
//		int nodes = 7;
//
//		GraphList a = new GraphList(nodes);
//
//		a.addEdge(0, 1);
//		a.addEdge(0, 2);
//		a.addEdge(1, 3);
//		a.addEdge(2, 4);
//		a.addEdge(3, 5);
//		a.addEdge(4, 5);
//		a.addEdge(4, 6);
//
//		a.dfs(0);
		
		int nodes = 6;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 4);
		a.addEdge(2, 5);
		a.addEdge(4, 5);

		a.dfs(0);
	}

}
