package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//TC: O(N+2E) + O(N)
//SC: O(N) + O(N) ~ O(N)
public class UndirectedCycleDFSStack {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);
		adj.get(3).add(1);
		adj.get(1).add(3);

		UndirectedCycleDFSStack obj = new UndirectedCycleDFSStack();
		boolean ans = obj.isCycle(4, adj);
		if (ans)
			System.out.println("1");
		else
			System.out.println("0");

	}

	private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] visited = new int[V];
		Arrays.fill(visited, 0);
		int[] parent = new int[V];
		Arrays.fill(parent, -1);

		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				if (dfs(i, parent, adj, visited))
					return true;
			}
		}

		return false;
	}

	private boolean dfs(int start, int[] parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {

		Stack<Pair> s = new Stack<>();
		s.push(new Pair(start, -1));
		visited[start] = 1;

		while (!s.isEmpty()) {
			Pair p = s.pop();

			int curr = p.node;
			int par = p.parent;

			for (Integer i : adj.get(curr)) {
				if (visited[i] == 0) {
					s.push(new Pair(i, curr));
					visited[i] = 1;
				} else if (par != i) {
					return true;
				}
			}

		}

		return false;
	}

	class Pair {
		int node;
		int parent;

		public Pair(int _node, int _parent) {
			node = _node;
			parent = _parent;
		}
	}

}
