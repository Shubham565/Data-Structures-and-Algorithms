package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 
 * Problem Statement: Given an undirected graph with V vertices.
 * We say two vertices u and v belong to a single province if there is a path from u to v or v to u.
 * Your task is to find the number of provinces.
 * 
 * */

// TC: O(N) + O(V + 2E)
// SC: O(N) + O(N)
public class NumberOfProvinces {

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();

		adj.add(new ArrayList<Integer>());
		adj.get(0).add(0, 1);
		adj.get(0).add(1, 0);
		adj.get(0).add(2, 1);
		adj.add(new ArrayList<Integer>());
		adj.get(1).add(0, 0);
		adj.get(1).add(1, 1);
		adj.get(1).add(2, 0);
		adj.add(new ArrayList<Integer>());
		adj.get(2).add(0, 1);
		adj.get(2).add(1, 0);
		adj.get(2).add(2, 1);

		NumberOfProvinces ob = new NumberOfProvinces();
		System.out.println(ob.numProvinces(adj, 3));
	}

	private int numProvinces(List<List<Integer>> adj, int V) {

		int[] visited = new int[V];
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				count++;
				dfs(i, adj, visited);
			}
		}

		return count;
	}

	private void dfs(int node, List<List<Integer>> result, int[] visited) {

		// Stack<Integer> s = new Stack<>();
		// s.push(node);
		visited[node] = 1;

		for (Integer n : result.get(node)) {
			if (visited[n] == 0) {
				// s.push(n);
				visited[n] = 1;
				dfs(n, result, visited);
			}
		}
	}

}
