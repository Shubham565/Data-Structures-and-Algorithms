package com.bhambey.graphs;

public class MSTMatrix {

	public static void main(String[] args) {
		GraphMatrix a = new GraphMatrix();
		a.addVertex('A');
		a.addVertex('B');
		a.addVertex('C');
		a.addVertex('D');
		a.addVertex('E');

		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(0, 4);
		a.addEdge(1, 2);
		a.addEdge(1, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 3);
		a.addEdge(2, 4);
		a.addEdge(3, 4);

		System.out.println("MST: ");
		a.mst();
	}

}
