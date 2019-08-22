import java.io.*;
import java.util.ArrayList;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int dataa) {
            data = dataa;
            next = null;
        }
    }

    // **** Inserting the Node at the "BEGINING" of linkedlist ****
    public static LinkedList insertAtBeg(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = list.head;
        list.head = newNode;
        return list;
    }

    // **** Inserting the Node at the "END" of linkedlist *********
    public static LinkedList insertAtEnd(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    // **** Inserting the Node in "MID" of linkedlist after another node "Key" ****
    // ** This code inserts the node after the first occurence of the key only **
    public static LinkedList insertAtMidByKey(LinkedList list, int key, int data) {
        Node newNode = new Node(data), currentNode = list.head;
        if (currentNode == null) {
            System.out.println("List is empty");
            return list;
        }
        while (currentNode != null && currentNode.data != key) {
            currentNode = currentNode.next;
        }
        if (currentNode == null ) {
            System.out.println("Key not found in the linkedlist");
        } else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            
        }
        return list;
    }

    // **** Find the length of the linked list **
    public static int length(LinkedList list) {
        Node currentNode = list.head;
        int length = 0;
        if (currentNode == null) {
            return length;
        }
        while (currentNode != null) {
            currentNode = currentNode.next;
            length += 1;
        }
        return length;
    }

    // **** Find whether the length of linkedlist is even or not ***
    //    **  Approach includes without finding actual length  **
    public static void isEvenLength(LinkedList list) {
        Node slowPtr = list.head, fastPtr = slowPtr;
        if (slowPtr == null) {
            System.out.println("The list is empty");
            return;
        }
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        //  **  HERE fast_ptr == null is checked first  ** 
        //  **  BECAUSE if fast_ptr.next is checked on  ** 
        //  **  condition that fast_ptr is already null.**
        //  **  IT WILL THROW NULL EXCEPTION ERROR      **
        if (fastPtr == null) {
            System.out.println("The list is of even length");
        } else {
            System.out.println("The list is of odd length");
        }
        return;
    }


    // **** Print the Linkedlist ***************
    public static void printList(LinkedList list) {
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    // **** Delete by Key ***************************************
    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currentNode = list.head, prevNode = null;
        if (currentNode == null) {
            System.out.println("List is empty");
            return list;
        }
        if (currentNode.data == key) {
            list.head = currentNode.next;
            System.out.println("Key found at first node and deleted");
            return list;
        }
        while (currentNode.next != null && currentNode.data != key) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode.data == key) {
            prevNode.next = currentNode.next;
            System.out.println("Key found and deleted");
        } else {
            System.out.println("Key not found");
        }
        return list;
    }

    // **** Delete By Index *****************************************
    public static LinkedList deleteByIndex(LinkedList list, int index) {
        Node currentNode = list.head, prevNode = null;
        if (currentNode == null) {
            System.out.println("List is empty");
            return list;
        }
        if (index == 0) {
            list.head = currentNode.next;
            return list;
        }
        int counter = 0;
        while (currentNode != null) {
            if (counter == index) {
                prevNode.next = currentNode.next;
                System.out.println("Key found and deleted");
                break;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
                counter += 1;
            }
        }
        if (currentNode == null) {
            System.out.println("Current index is not available");
        }
        return list;
    }
    
    // **** Delete whole Linkedlist ****
    public static void deleteList(LinkedList list) {
        list.head = null;
    }

    // **** Remove Duplicates from the LinkedList ***********
    public static LinkedList removeDuplicates(LinkedList list) {
        Node currentNode = list.head, prevNode = null;
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        while (currentNode != null) {
            if (numberList.indexOf(currentNode.data) == -1) {
                numberList.add(currentNode.data);
                prevNode = currentNode;
                currentNode = currentNode.next;
            } else {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            }
        }
        return list;
    }

    // **** Reverse the LinkedList *********************
    public static LinkedList reverseList(LinkedList list) {
        Node currentNode = list.head, nextNode = currentNode.next, afterNode = null;
        currentNode.next = null;
        //System.out.print(next_node.next);
        while (nextNode != null) {
            afterNode = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = afterNode;
        }
        list.head = currentNode;
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insertAtEnd(list, 1);
        list = insertAtEnd(list, 2);
        list = insertAtEnd(list, 7);
        list = insertAtEnd(list, 4);
        list = insertAtEnd(list, 2);

        printList(list);
        System.out.print("\n");
        // removeDuplicates(list);
        reverseList(list);
        printList(list);
        System.out.print("\n");
        list = insertAtBeg(list, 38);
        printList(list);
        System.out.print("\n");
        list = insertAtMidByKey(list, 100, 40);
        printList(list);
        deleteByKey(list, 100);
        printList(list);
        deleteList(list);
        System.out.print("\n");
        isEvenLength(list);
        //System.out.println(length(list));
        // reversePart(list, 3, 7);
        // printList(list);
    }
}