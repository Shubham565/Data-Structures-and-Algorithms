package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TC: O(N) + O(2E)
// SC: O(3N) ~ O(N)
public class NumberOfConnectedComponents {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		// adj.get(0).add(4);
		// adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);

		NumberOfConnectedComponents bfs = new NumberOfConnectedComponents();
		int count = bfs.bfsOfGraph(5, adj, 0);
		// List<Integer> ans = bfs.bfsOfGraph(5, adj);
		// int n = ans.size();
		/*
		 * for (int i = 0; i < n; i++) { System.out.print(ans.get(i) + " "); }
		 */

		System.out.println(count);

	}

	private /* List<Integer> */ int bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int count) {

		boolean[] visited = new boolean[V];

		visited[0] = true;

		for (int i = 0; i < V; i++) {

			if (visited[i] == false) {
				BFSUtil(visited, adj, i);
				count++;
			}

		}

		return (count);

		// return bfs;
	}

	private void BFSUtil(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int i) {

		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		while (!q.isEmpty()) {
			Integer node = q.remove();
			// bfs.add(node);

			for (Integer n : adj.get(node)) {
				if (visited[n] == false) {
					visited[n] = true;
					q.add(n);
				}
			}
		}

	}

}