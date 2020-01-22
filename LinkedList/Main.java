import SingleLinkedList.LinkedList;
//import java.io.*;

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(list, 1);
        list.insertAtEnd(list, 1);
        list.insertAtEnd(list, 2);
        list.insertAtEnd(list, 3);
        list.insertAtEnd(list, 3);

        list.printList(list);
        System.out.print("\n");
        list.insertAtBeg(list, 1);
        list.printList(list);
        System.out.print("\n");
        list.removeDuplicatesSortedList(list);
        list.printList(list);
        System.out.print("\n");
        list.isEvenLength(list);
    }
}