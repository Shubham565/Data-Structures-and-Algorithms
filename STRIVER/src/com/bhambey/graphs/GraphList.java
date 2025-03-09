package com.bhambey.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphList {

	List<List<Integer>> graph;
	boolean visited[];
	boolean recursiveStack[];
	HashMap<Integer, Integer> incomingDegree;
	Queue<Integer> sourceQueue;
	int visitedNodes;
	int nodes;

	GraphList(int nodes) {
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		recursiveStack = new boolean[nodes];
		incomingDegree = new HashMap<>();
		sourceQueue = new LinkedList<>();
		visitedNodes = 0;
		this.nodes = nodes;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
			incomingDegree.put(i, 0);
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
		incomingDegree.put(b, incomingDegree.get(b) + 1);
		// comment this out to make this a directed graph
		//graph.get(b).add(a);
	}

	public void dfs(int start) {
		Stack<Integer> s = new Stack<>();

		s.push(start);
		visited[start] = true;

		while (!s.isEmpty()) {
			Integer node = s.pop();
			// Commented to be used by other calling methods
			// System.out.print(node + " ");

			for (Integer n : graph.get(node)) {
				if (!visited[n]) {
					s.push(n);
					visited[n] = true;
				}
			}

		}

	}

	public void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int node = q.remove();
			System.out.print(node + " ");

			for (Integer n : graph.get(node)) {
				if (!visited[n]) {
					q.add(n);
					visited[n] = true;
				}
			}
		}

	}

	public boolean ifUndirectedGraphIsConnected() {

		int start = 0;
		dfs(start);

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;

	}

	public boolean ifDirectedGraphIsStronglyConnected() {

		for (int i = 0; i < nodes; i++) {
			dfs(i);

			for (int j = 0; j < nodes; j++) {
				if (!visited[j]) {
					return false;
				}
			}
			Arrays.fill(visited, false);
		}
		return true;

	}

	public int numberOfConnectedComponents() {
		int number = 0;

		for (int i = 0; i < nodes; i++) {
			if (!visited[i]) {
				dfs(i);
				number++;
			}

		}
		return number;
	}

	public boolean ifDestinationReachableUndirected(int src, int dest) {
		dfs(src);
		return visited[dest];
	}

	public boolean ifDestinationReachableDirected(int src, int dest) {
		dfs(src);
		return visited[dest];
	}

	public boolean ifUndirectedGraphHasCycle() {
		for (int i = 0; i < nodes; i++) {
			if (!visited[i]) {
				if (ifCycle(i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean ifCycle(int index, int parent) {

		visited[index] = true;

		for (Integer n : graph.get(index)) {
			if (!visited[n]) {
				if (ifCycle(n, index))
					return true;
			} else if (n != parent) {
				return true;
			}
		}

		return false;
	}

	public boolean ifDirtectedGraphHasCycle() {

		for (int i = 0; i < nodes; i++) {
			if (ifCycleDirected(i)) {
				return true;
			}
		}
		return false;
	}

	private boolean ifCycleDirected(int i) {

		if (recursiveStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;
		recursiveStack[i] = true;

		for (Integer n : graph.get(i)) {
			if (ifCycleDirected(n))
				return true;
		}

		recursiveStack[i] = false;
		return false;
	}

	public boolean ifDirectedGraphHasCycleIndegree() {
		for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if (entry.getValue() == 0)
				sourceQueue.add(entry.getKey());
		}

		while (!sourceQueue.isEmpty()) {
			visitedNodes++;
			int source = sourceQueue.remove();

			for (Integer child : graph.get(source)) {
				incomingDegree.put(child, incomingDegree.get(child) - 1);

				if (incomingDegree.get(child) == 0) {
					sourceQueue.add(child);
				}
			}

		}
		return nodes != visitedNodes;
	}

	public List<Integer> topologicalSortAdjacencyList() {

		for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if (entry.getValue() == 0) {
				sourceQueue.add(entry.getKey());
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!sourceQueue.isEmpty()) {
			int source = sourceQueue.remove();
			result.add(source);

			for (Integer child : graph.get(source)) {
				incomingDegree.put(child, incomingDegree.get(child) - 1);

				if (incomingDegree.get(child) == 0) {
					sourceQueue.add(child);
				}
			}
		}

		if (result.size() != nodes) {
			System.out.println("Cycle present in graph");
			return new ArrayList<>();
		}

		return result;

	}

	public int minimumDistanceBetweenNodesUnweighted(int source, int destination) {

		if (source == destination) {
			return 0;
		}

		Queue<Integer> queue = new LinkedList<>();

		int minDistance = 0;

		queue.add(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size > 0) {
				Integer node = queue.poll();

				for (Integer child : graph.get(node)) {
					if (child == destination) {
						return ++minDistance;
					}

					if (!visited[child]) {
						queue.add(child);
						visited[child] = true;
					}
				}
				size--;
			}
			minDistance++;
		}
		return -1;
	}

}
