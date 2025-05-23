package com.bhambey.graphs;

public class TraversalDFSMatrix {

	public static void main(String[] args) {

		GraphMatrix theGraph = new GraphMatrix();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');

		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		theGraph.addEdge(4, 5);
		theGraph.addEdge(1, 3);

		System.out.println("Visits: ");
		theGraph.dfs();
		System.out.println();

	}

}
