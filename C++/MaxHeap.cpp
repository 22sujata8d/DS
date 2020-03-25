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

        // GOOD CONSTRUCTOR
        // MaxHeap(int const _heapSize, int const _arrLen)
        //     : heapsize(_heapSize), length(_arrLen) {};

        // Returns the position of the left child of the parent
        int left_child(int i) {
            return 2*i;
        }

        // Returns the position of the right child of the parent
        int right_child(int i) {
            return (2*i+1);
        }

        // Building max heap
        void buildMaxHeap(vector<int> &arr) {
            for (int i = heapsize/2; i >= 1; i--) {
                maxHeapify(arr, i);
            }
        }

        // Heapifying Function
        void maxHeapify(vector<int> &arr, int i) {
            left = left_child(i);
            right = right_child(i);
            // Checking if the left child greater than parent
            if (left <= heapsize && arr[left-1] > arr[i-1]) {
                // If left child is greater than the parent 
                // then set its value to the largest.
                largest = left;
            } else {
                largest = i;
            }
            // Checking if the right child greater than parent
            if (right <= heapsize && arr[right-1] > arr[largest-1]) {
                // If right child is greater than the parent
                // then set its value to the largest.
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

        // Function to Insert a number in heap
        void insertElement(vector<int> &heapArr, int num) {
            heapArr.push_back(num);
            //heap.emplace_back(num);
            
            heapsize += 1;
            buildMaxHeap(heapArr);
        }

        // Function to delete an element from the heap
        void deleteElement(vector<int> &heapArr) {
            // In Max Heap, Deletion always takes place of the
            // largest number that is the First Element of the 
            // heap array.
            heapArr[0] = heapArr[heapsize-1];
            heapsize -= 1;
            buildMaxHeap(heapArr);
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
    //heap.printMaxHeap(arr);

    // Inserting element 12 in heap 
    // And printing the heap
    cout << "Max Heap after inserting the element 12 : \n";
    heap.insertElement(arr, 12);
    heap.printMaxHeap(arr);
    cout << "\nMax Heap after deletion from the max heap: \n";
    heap.deleteElement(arr);
    heap.printMaxHeap(arr);
    
    return 0;
}

