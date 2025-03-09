package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BREADTH FIRST SEARCH
// TC: O(N) + O(2E)
// SC: O(3N) ~ O(N)
public class BFSGraph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(4);
		adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);

		BFSGraph sl = new BFSGraph();
		List<Integer> ans = sl.bfsOfGraph(5, adj);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	private List<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean[] vis = new boolean[V];

		List<Integer> bfs = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		vis[0] = true;

		while (!q.isEmpty()) {
			Integer node = q.poll();
			bfs.add(node);

			for (Integer i : adj.get(node)) {
				if (!vis[i]) {
					vis[i] = true;
					q.add(i);
				}
			}

		}

		return bfs;
	}

}
