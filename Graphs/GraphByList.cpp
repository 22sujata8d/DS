#include <iostream>
#include <map>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

// Initialisation of the adjacency list for implementing graph
map<int, vector<int> *> adjacency_list;

void add_edge(int i, int j)
{

    if (adjacency_list.find(i) == adjacency_list.end())
    {
        pair<int, vector<int> *> p = pair<int, vector<int> *>(i, new vector<int>());
        adjacency_list.insert(p);
    }

    // for undirected graph
    if (adjacency_list.find(j) == adjacency_list.end())
    {
        pair<int, vector<int> *> p = pair<int, vector<int> *>(j, new vector<int>());
        adjacency_list.insert(p);
    }

    adjacency_list[i]->push_back(j);
    // for undirected graph
    adjacency_list[j]->push_back(i);
}

void breadth_first_traversal(int startingVertix, int vertices)
{
    int visited_array[vertices + 1]{0};
    queue<int> que;

    que.push(startingVertix);
    visited_array[startingVertix] = 1;
    while (!que.empty())
    {
        int vertex = que.front();
        cout << vertex << endl;
        que.pop();
        if (adjacency_list.find(vertex) != adjacency_list.end())
        {
            // this means key is found
            // so iterating over the list
            for (const auto &i : *adjacency_list.at(vertex))
            {
                // checking the array for visited vertices
                // if the vertix is not visited then push it in
                // the queue.
                if (visited_array[i] == 0)
                {
                    que.push(i);
                    // after visiting the vertix
                    // mark the vertix visited.
                    visited_array[i] = 1;
                }
            }
        }
    }
}

void depth_first_traversal(int startingVertex, int vertices)
{
    stack<int> stk;
    int visited_vertices[vertices + 1]{0};
    int valid_vertex_flag = 0;

    stk.push(startingVertex);
    visited_vertices[stk.top()] = 1;
    cout << stk.top() << endl;

    while (!stk.empty())
    {
        int p = stk.top();
        valid_vertex_flag = 0;
        for (const auto &vertex : *adjacency_list.at(p))
        {
            // If there is an unvisited adjacent vertex:
            // a valid vertex then push it in the stack
            // print it out and mark as visited.
            if (visited_vertices[vertex] != 1)
            {
                valid_vertex_flag = 1;
                stk.push(vertex);
                visited_vertices[vertex] = 1;
                cout << vertex << endl;
                break;
            }
        }
        // If there is no valid adjacent vertex available for the
        // current top element in the stack
        // then remove it from the stack as all the adjacent vertices
        // have already been visited and recorded.
        if (valid_vertex_flag == 0)
        {
            stk.pop();
        }
    }
}

void display_graph()
{
    for (const auto &lst : adjacency_list)
    {
        cout << lst.first << "-->";
        for (const auto &i : *lst.second)
        {
            cout << i << " ";
        }
        cout << endl;
    }
}

// Building the adjacency list for the undirected graph
int main()
{
    // total number of vertices in the graph
    int vertices = 8;

    /**
     *  Adjacency List:
     *      It will be a map of key: integer and value: a vector of integers.
    */
    add_edge(1, 2);
    add_edge(1, 3);
    add_edge(1, 4);
    add_edge(2, 3);
    add_edge(3, 4);
    add_edge(4, 6);
    add_edge(4, 5);
    add_edge(5, 6);
    add_edge(5, 7);
    add_edge(6, 7);
    add_edge(6, 8);
    add_edge(8, 7);
    //add_edge(4, 6);

    cout << "Printing the undirected graph: \n";
    display_graph();
    cout << '\n';
    cout << "Breadth First Traversal of the undirected graph: \n";
    breadth_first_traversal(1, vertices);
    cout << '\n';
    cout << "Depth First Traversal of the undirected graph: \n";
    depth_first_traversal(1, vertices);
    cout << '\n';

    return 0;
}

