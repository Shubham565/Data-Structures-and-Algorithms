package com.bhambey.graphs;

public class IfDestinationReachableDirected {

	public static void main(String[] args) {

		int nodes = 5;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		a.addEdge(3, 2);
		a.addEdge(3, 0);
		a.addEdge(2, 4);

		System.out.println(a.ifDestinationReachableDirected(0, 3));
		System.out.println(a.ifDestinationReachableDirected(0, 2));

	}

}
