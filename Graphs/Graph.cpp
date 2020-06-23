#include<iostream>

using namespace std;

// Initialzation of the adjaceny matrix
int adjacency_matrix[20][20];

// Displaying the adjaceny matrix
void display_matrix(int vertix) {

    for (int i = 0; i < vertix; i++) {
        for (int j = 0; j < vertix; j++) {
            cout << adjacency_matrix[i][j] << " ";
        }
        cout << endl;
    }
}

// Add edge in the adjacency matrix
void add_edge(int u, int v) {
    adjacency_matrix[u][v] = 1;
    adjacency_matrix[v][u] = 1;
}

// Building the adjaceny matrix for the Undirected Graph
int main() {
    // Number of vertices in the undirected graph
    int vertices = 6;

    cout << "\nAdjacency Matrix of the Undirected Graph:\n" << endl;
    add_edge(0, 4);
    add_edge(0, 3);
    add_edge(1, 2);
    add_edge(1, 4);
    add_edge(1, 5);
    add_edge(2, 3);
    add_edge(2, 5);
    add_edge(5, 3);
    add_edge(5, 4);

    display_matrix(vertices);

    return 0;
}
