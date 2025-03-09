package com.bhambey.graphs;

public class IfDirectedGraphHasCycleIndegree {

	public static void main(String[] args) {

		int nodes = 4;

		GraphList a = new GraphList(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		a.addEdge(3, 0);

		System.out.println(a.ifDirectedGraphHasCycleIndegree());

	}

}
