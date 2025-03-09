package com.bhambey.graphs;

public class IfDestinationReachableUndirected {

	public static void main(String[] args) {

		int nodes = 7;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(1, 3);

		a.addEdge(4, 5);
		a.addEdge(4, 6);

		System.out.println(a.ifDestinationReachableUndirected(0, 5));

	}

}
