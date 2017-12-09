public class ReverseALinkedList {
    static Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    static void printLinkedList(Node head){
        while(head!=null){
            System.out.println("value = [" + head.data + "]");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ReverseALinkedList list = new ReverseALinkedList();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printLinkedList(head);
        System.out.println("**********************");

        printLinkedList(list.reverse(head));
    }

    private Node reverse(Node root) {
        Node current = root, prev = null, next;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev =current;
            current = next;
        }
        return prev;
    }
}
