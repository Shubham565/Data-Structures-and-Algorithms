package com.bhambey.graphs;

public class IfDirectedGraphHasCycle {

	public static void main(String[] args) {
		int nodes = 5;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		// a.addEdge(2, 0);
		a.addEdge(0, 3);
		a.addEdge(3, 4);
		// a.addEdge(4, 0);

		System.out.println(a.ifDirtectedGraphHasCycle());

	}

}
