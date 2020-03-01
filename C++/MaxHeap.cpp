#include<iostream>
#include<vector>

using namespace std;

// Class for representing Maximum Heap
class MaxHeap {
    public:

        // Initializing the heapsize and array length both equal to 0
        int heapsize {0}, length {0};
        int left {0}, right {0}, largest {0};

        // Constructor for MaxHeap Class
        MaxHeap(int const heapSize, int const arrayLength) {
            // Setting the heapsize and array length according to given parameters
            heapsize = heapSize;
            length = arrayLength;
        }

        // Building max heap
        void buildMaxHeap(vector<int> &arr) {
            for (int i = heapsize/2; i >= 1; i--) {
                maxHeapify(arr, i);
            }
        }

        // Heapifying Function
        void maxHeapify(vector<int> &arr, int i) {
            left = 2*i;
            right = 2*i+1;
            // Checking if the left child greater than parent
            if (left <= heapsize && arr[left-1] > arr[i-1]) {
                largest = left;
            } else {
                largest = i;
            }
            // Checking if the right child greater than parent
            if (right <= heapsize && arr[right-1] > arr[largest-1]) {
                largest = right;
            }
            // If parent was already greater than its child 
            // Then don't swap and terminate the recursion
            if (i != largest) {
                int temp = arr[i-1];
                arr[i-1] = arr[largest-1];
                arr[largest-1] = temp;
                maxHeapify(arr, largest);
            }
        }

        // Function to print the Max Heap
        void printMaxHeap(vector<int> &arr) {
            for (auto element: arr) {
                cout << element << endl;
            }
        }
};

int main() {
    vector<int> arr {4, 1, 3, 2, 16, 9, 10, 14, 8, 7}; 

    MaxHeap heap(10, 15);

    heap.buildMaxHeap(arr);
    heap.printMaxHeap(arr);

    return 0;
}

