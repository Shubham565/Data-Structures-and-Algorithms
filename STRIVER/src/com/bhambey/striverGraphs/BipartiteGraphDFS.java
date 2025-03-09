package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem Statement: Given an adjacency list of a graph adj of V no. of vertices having 0 based index.
 * Check whether the graph is bipartite or not.
 * If we are able to colour a graph with two colours such that no adjacent nodes have the same colour, 
 * it is called a bipartite graph.
 * 
 * 
 * TC: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.
 * SC: O(3V) ~ O(V), Space for DFS stack space, colour array and an adjacency list.
 * */

public class BipartiteGraphDFS {
	public static void main(String[] args) {

		// V = 4, E = 4
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(1).add(3);
		adj.get(3).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);

		BipartiteGraphDFS obj = new BipartiteGraphDFS();
		boolean ans = obj.isBipartite(4, adj);
		if (ans)
			System.out.println("Bipartite");
		else
			System.out.println("Not Bipartite");

	}

	private boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] color = new int[V];
		Arrays.fill(color, -1);

		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (dfs(i, 0, color, adj) == false)
					return false;
			}
		}

		return true;
	}

	private boolean dfs(int node, int clr, int[] color, ArrayList<ArrayList<Integer>> adj) {

		color[node] = clr;

		for (int i : adj.get(node)) {
			if (color[i] == -1) {
				if (dfs(i, 1 - clr, color, adj) == false)
					return false;
			} else if (color[i] == clr)
				return false;
		}

		return true;
	}
}
