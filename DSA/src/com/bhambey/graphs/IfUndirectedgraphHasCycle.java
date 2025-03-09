package com.bhambey.graphs;

public class IfUndirectedgraphHasCycle {

	public static void main(String[] args) {

		int nodes = 3;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);

		System.out.println(a.ifUndirectedGraphHasCycle());

	}

}
