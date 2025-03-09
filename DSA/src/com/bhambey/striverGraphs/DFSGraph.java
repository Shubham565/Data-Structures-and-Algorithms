package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TC: O(N) + O(2E)
// SC: O(3N) ~ O(N)
public class DFSGraph {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);

		DFSGraph dfs = new DFSGraph();
		List<Integer> ans = dfs.dfsOfGraph(5, adj);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	private List<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean[] visited = new boolean[V];
		visited[0] = true;
		List<Integer> dfs = new ArrayList<>();

		return dfs(0, adj, visited, dfs);

	}

	private List<Integer> dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> dfs) {

		visited[node] = true;
		dfs.add(node);

		for (Integer n : adj.get(node)) {
			if (!visited[n]) {
				dfs(n, adj, visited, dfs);
			}
		}

		return dfs;

		/*
		 * Stack<Integer> s = new Stack<>();
		 * 
		 * visited[start] = true; s.push(start);
		 * 
		 * while (!s.isEmpty()) {
		 * 
		 * Integer n = s.pop(); dfs.add(n);
		 * 
		 * for (Integer i : adj.get(n)) { if (!visited[i]) { visited[i] = true;
		 * s.push(i); } }
		 * 
		 * } return dfs;
		 */
	}

}
