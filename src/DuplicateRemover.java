public class DuplicateRemover {
    private static Node head = new Node(1);

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    private void removeDuplicates() {
        Node ptr1, ptr2;
        ptr1 = head;

        while(ptr1 != null && ptr1.next !=null){
            ptr2 = ptr1;
            while(ptr2.next != null){
                if (ptr1.data == ptr2.next.data){
                    ptr2.next = ptr2.next.next;
                }
                else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    void remove_duplicates() {
        Node ptr1, ptr2;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {

                    /* sequence of steps is important here */
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    private static void printLinkedList(Node head){
        while(head!=null){
            System.out.println("value = [" + head.data + "]");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        DuplicateRemover list = new DuplicateRemover();

        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        printLinkedList(head);
        System.out.println("**********************************");

        list.removeDuplicates();
        printLinkedList(head);
    }
}
