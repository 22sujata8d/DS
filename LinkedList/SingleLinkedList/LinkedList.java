package SingleLinkedList;

import java.util.ArrayList;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        // Constructor
        Node(final int dataa) {
            data = dataa;
            next = null;
        }
    }

    // **** Inserting the Node at the "BEGINING" of linkedlist ****
    public LinkedList insertAtBeg(final LinkedList list, final int data) {
        final Node newNode = new Node(data);
        newNode.next = list.head;
        list.head = newNode;
        return list;
    }

    // **** Inserting the Node at the "END" of linkedlist *********
    public LinkedList insertAtEnd(final LinkedList list, final int data) {
        final Node newNode = new Node(data);
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
    public LinkedList insertAtMidByKey(final LinkedList list, final int key, final int data) {
        final Node newNode = new Node(data);
		Node currentNode = list.head;
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
    public int length(final LinkedList list) {
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
    public void isEvenLength(final LinkedList list) {
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
    public void printList(final LinkedList list) {
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    // **** Delete by Key ***************************************
    public LinkedList deleteByKey(final LinkedList list, final int key) {
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
    public LinkedList deleteByIndex(final LinkedList list, final int index) {
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
    public void deleteList(final LinkedList list) {
        list.head = null;
    }

    // **** Remove Duplicates from the LinkedList ***********
    public LinkedList removeDuplicates(final LinkedList list) {
        Node currentNode = list.head, prevNode = null;
        final ArrayList<Integer> numberList = new ArrayList<Integer>();
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

    // **** Remove Duplicates from "SORTED LINKED LIST" *****
    // Example: Input 1->2->2->3->5     Output 1->2->3->5
    public LinkedList removeDuplicatesSortedList(final LinkedList list) {
        Node currentNode = list.head.next, prevNode = list.head;
        if (prevNode == null) {
            System.out.println("List is empty");
            return list;
        }
        while (currentNode != null) {
            if (prevNode.data == currentNode.data) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return list;
    }

}