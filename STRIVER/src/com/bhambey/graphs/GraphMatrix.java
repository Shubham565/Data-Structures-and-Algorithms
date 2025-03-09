package com.bhambey.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {

	char label;
	boolean visited;

	public Vertex(char lab) {
		label = lab;
		visited = false;
	}

}

public class GraphMatrix {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private char sortedArray[];
	private Stack<Integer> s;
	private Queue<Integer> q;

	public GraphMatrix() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		sortedArray = new char[MAX_VERTS];
		s = new Stack<Integer>();
		q = new LinkedList<>();
	}

	public void addVertex(char label) {
		vertexList[nVerts++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label + " ");
	}

	public int getAdjacentUnvisitedVertex(int v) {
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].visited == false) {
				return i;
			}
		}
		return -1;
	}

	public void dfs() {

		vertexList[0].visited = true;
		displayVertex(0);
		s.push(0);
		int v2;

		while (!s.isEmpty()) {
			int v1 = s.peek();
			v2 = getAdjacentUnvisitedVertex(v1);

			if (v2 == -1) {
				s.pop();
			} else {
				vertexList[v2].visited = true;
				displayVertex(v2);
				s.push(v2);
			}
		}

	}

	public void bfs() {

		vertexList[0].visited = true;
		displayVertex(0);
		q.add(0);
		int v2;

		while (!q.isEmpty()) {
			int v1 = q.remove();
			// v2 = getAdjacentUnvisitedVertex(v1);
			while ((v2 = getAdjacentUnvisitedVertex(v1)) != -1) {
				vertexList[v2].visited = true;
				displayVertex(v2);
				q.add(v2);
			}
		}

	}

	public void mst() {
		vertexList[0].visited = true;
		s.push(0);

		while (!s.isEmpty()) {
			int node = s.peek();
			int v = getAdjacentUnvisitedVertex(node);

			if (v == -1) {
				s.pop();
			} else {
				vertexList[v].visited = true;
				displayVertex(node);
				displayVertex(v);
				System.out.println();
				s.push(v);

			}

		}
	}

	public void topo() {
		int orig_nVerts = nVerts;

		while (nVerts > 0) {
			int currentVertex = noSuccessors();
			if (currentVertex == -1) {
				System.out.println("Error: Graph has cycle");
				return;
			}

			sortedArray[nVerts - 1] = vertexList[currentVertex].label;

			deleteVertex(currentVertex);

		}

		System.out.println("Topologically Sorted order: ");
		for (int j = 0; j < orig_nVerts; j++) {
			System.out.print(sortedArray[j]);
		}
		System.out.println("");
	}

	public int noSuccessors() {
		boolean isEdge;

		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			for (int col = 0; col < nVerts; col++) {
				if (adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge)
				return row;
		}
		return -1;
	}

	public void deleteVertex(int delVert) {
		if (delVert != nVerts - 1) { // if not last vertex,
			for (int j = delVert; j < nVerts - 1; j++) // delete from vertexList
				vertexList[j] = vertexList[j + 1];

			for (int row = delVert; row < nVerts - 1; row++) // delete row from adjMat
				moveRowUp(row, nVerts);

			for (int col = delVert; col < nVerts - 1; col++) // delete col from adjMat
				moveColLeft(col, nVerts - 1);
		}
		nVerts--; // one less vertex
	}

	private void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++)
			adjMat[row][col] = adjMat[row + 1][col];
	}

	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++)
			adjMat[row][col] = adjMat[row][col + 1];

	}

}
