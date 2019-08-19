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
        Node new_node = new Node(data);
        new_node.next = list.head;
        list.head = new_node;
        return list;
    }

    // **** Inserting the Node at the "END" of linkedlist *********
    public static LinkedList insertAtEnd(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    // **** Inserting the Node in "MID" of linkedlist after another node "Key" ****
    // ** This code inserts the node after the first occurence of the key only **
    public static LinkedList insertAtMidByKey(LinkedList list, int key, int data) {
        Node new_node = new Node(data), current_node = list.head;
        if (current_node == null) {
            System.out.println("List is empty");
            return list;
        }
        while (current_node != null && current_node.data != key) {
            current_node = current_node.next;
        }
        if (current_node == null ) {
            System.out.println("Key not found in the linkedlist");
        } else {
            new_node.next = current_node.next;
            current_node.next = new_node;
            
        }
        return list;
    }

    // **** Print the Linkedlist ***************
    public static void printList(LinkedList list) {
        Node current_node = list.head;
        while (current_node != null) {
            System.out.print(current_node.data + " ");
            current_node = current_node.next;
        }
    }

    // **** Delete by Key ***************************************
    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node current_node = list.head, prev_node = null;
        if (current_node == null) {
            System.out.println("List is empty");
            return list;
        }
        if (current_node.data == key) {
            list.head = current_node.next;
            System.out.println("Key found at first node and deleted");
            return list;
        }
        while (current_node.next != null && current_node.data != key) {
            prev_node = current_node;
            current_node = current_node.next;
        }
        if (current_node.data == key) {
            prev_node.next = current_node.next;
            System.out.println("Key found and deleted");
        } else {
            System.out.println("Key not found");
        }
        return list;
    }

    // **** Delete By Index *****************************************
    public static LinkedList deleteByIndex(LinkedList list, int index) {
        Node current_node = list.head, prev_node = null;
        if (current_node == null) {
            System.out.println("List is empty");
            return list;
        }
        if (index == 0) {
            list.head = current_node.next;
            return list;
        }
        int counter = 0;
        while (current_node != null) {
            if (counter == index) {
                prev_node.next = current_node.next;
                System.out.println("Key found and deleted");
                break;
            } else {
                prev_node = current_node;
                current_node = current_node.next;
                counter += 1;
            }
        }
        if (current_node == null) {
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
        Node current_node = list.head, prev_node = null;
        ArrayList<Integer> number_list = new ArrayList<Integer>();
        while (current_node != null) {
            if (number_list.indexOf(current_node.data) == -1) {
                number_list.add(current_node.data);
                prev_node = current_node;
                current_node = current_node.next;
            } else {
                prev_node.next = current_node.next;
                current_node = current_node.next;
            }
        }
        return list;
    }

    // **** Reverse the LinkedList *********************
    public static LinkedList reverseList(LinkedList list) {
        Node current_node = list.head, next_node = current_node.next, after_node = null;
        current_node.next = null;
        //System.out.print(next_node.next);
        while (next_node != null) {
            after_node = next_node.next;
            next_node.next = current_node;
            current_node = next_node;
            next_node = after_node;
        }
        list.head = current_node;
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insertAtEnd(list, 1);
        list = insertAtEnd(list, 2);
        list = insertAtEnd(list, 3);
        list = insertAtEnd(list, 4);
        list = insertAtEnd(list, 2);
        list = insertAtEnd(list, 3);

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
    }
}