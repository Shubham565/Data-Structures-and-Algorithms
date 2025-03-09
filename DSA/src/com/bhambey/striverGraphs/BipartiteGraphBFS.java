package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

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

		BipartiteGraphBFS obj = new BipartiteGraphBFS();
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
				if (check(i, V, adj, color) == false)
					return false;
			}
		}

		return true;
	}

	private boolean check(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int node : adj.get(curr)) {
				if (color[node] == -1) {
					color[node] = 1 - color[node];
					q.add(node);
				} else if (color[node] == color[curr])
					return false;
			}

		}

		return true;
	}
}