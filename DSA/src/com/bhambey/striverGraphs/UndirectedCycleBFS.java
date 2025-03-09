package com.bhambey.striverGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// TC: O(N+2E) + O(N)
// SC: O(N) + O(N) ~ O(N)
public class UndirectedCycleBFS {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);

		UndirectedCycleBFS obj = new UndirectedCycleBFS();
		boolean ans = obj.isCycle(4, adj);
		if (ans)
			System.out.println("1");
		else
			System.out.println("0");

	}

	private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] visited = new int[V];
		int[] parent = new int[V];
		Arrays.fill(parent, -1);

		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				if (checkCycle(i, adj, visited, parent)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean checkCycle(int start, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] parent) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, -1));
		visited[start] = 1;

		while (!q.isEmpty()) {
			Node curr = q.remove();

			int node = curr._node;
			int par = curr._parent;

			for (Integer i : adj.get(node)) {
				if (visited[i] == 0) {
					q.add(new Node(i, node));
					visited[node] = 1;

				} else if (par != i)
					return true;
			}

		}

		return false;
	}

	class Node {
		int _node;
		int _parent;

		public Node(int node, int parent) {
			_node = node;
			_parent = parent;
		}
	}

}
