package SingleLinkedList;

import SingleLinkedList.*;

public class Functions {
    // **** Reverse the LinkedList *********************
    public LinkedList reverseList(LinkedList list) {
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
}