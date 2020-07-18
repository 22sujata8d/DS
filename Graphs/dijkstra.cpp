#include<iostream>
#include<bits/stdc++.h>

using namespace std;

#define INF 0x3f3f3f3f

// Interger Pair ==> iPair
typedef pair<int, int> iPair;

// To add an edge to the weighted undirected graph
void addEdge(vector<iPair> adj[], int u, int v, int weight) {
	adj[u].push_back({v, weight});
	adj[v].push_back({u, weight});
}

// Dijkstra algorithm : Print all the shortest distances to 
// every node from the given source.
void dijkstra(vector<iPair> adj[], int vertices, int src) {
	priority_queue<iPair, vector<iPair>, greater<iPair>> minHeap;

	// create a vector and set all the vertices distances
	// to be infinity.
	vector<int> dist(vertices, INF);

	// insert the source node with 0 to minHeap 
	// and initialise its distance to be 0
	minHeap.push({src, 0});
	dist[src] = 0;

	while (!minHeap.empty()) {
		int u = minHeap.top().first;
		minHeap.pop();

		for (const auto neighbour : adj[u]) {
			int v = neighbour.first;
			int weight = neighbour.second;

			// If there is a shorter path to v
			// through u
			if (dist[v] > weight + dist[u]) {
				// update the distance
				dist[v] = weight + dist[u];
				minHeap.push({v, dist[v]});
			}
		}
	}

	// Print the shortest path
	printf("Vertex Shortest Distance from the Source \n");
	for (int i = 0; i < vertices; ++i) {
		printf("%d \t\t %d\n", i, dist[i]);
	}
}

// Driver code
int main () {
	int vertices = 9;
	vector<iPair> adj[vertices];

	addEdge(adj, 0, 1, 4); 
    addEdge(adj, 0, 7, 8); 
    addEdge(adj, 1, 2, 8); 
    addEdge(adj, 1, 7, 11); 
    addEdge(adj, 2, 3, 7); 
    addEdge(adj, 2, 8, 2); 
    addEdge(adj, 2, 5, 4); 
    addEdge(adj, 3, 4, 9); 
    addEdge(adj, 3, 5, 14); 
    addEdge(adj, 4, 5, 10); 
    addEdge(adj, 5, 6, 2); 
    addEdge(adj, 6, 7, 1); 
    addEdge(adj, 6, 8, 6); 
    addEdge(adj, 7, 8, 7);

    dijkstra(adj, vertices, 0);
	return 0;
}