public class DuplicateRemoverSorted {

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
        DuplicateRemoverSorted list = new DuplicateRemoverSorted();

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(4);

        printLinkedList(head);
        System.out.println("**********************************");

        list.removeDuplicates();
        printLinkedList(head);
    }

    private void removeDuplicates() {
        Node ptr = head;

        while (ptr != null && ptr.next != null){
            if(ptr.data == ptr.next.data){
                ptr.next = ptr.next.next;
            }
            else {
                ptr = ptr.next;
            }
        }
    }
}
