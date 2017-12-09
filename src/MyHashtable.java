import java.util.ArrayList;

class MyHashNode<K, V> {

    K key;
    V value;

    MyHashNode<K, V> next;

    public MyHashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashtable<K, V> {

    private ArrayList<MyHashNode<K, V>> bucketArray;

    private int capacity;

    private int size;


    public MyHashtable() {
        bucketArray = new ArrayList<>();
        capacity = 16;
        size = 0;

        for (int i = 0; i < capacity; i++) {
            bucketArray.add(null);
        }
    }

    //size
    public int size() {
        return size;
    }

    //isEmpty
    public boolean isEmpty() {
        return size() == 0;
    }

    //clear
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            bucketArray.add(null);
        }
        size = 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    //put
    public void put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }

        int bucketIndex = getBucketIndex(key);
        MyHashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;

        }

        size++;

        head = bucketArray.get(bucketIndex);
        MyHashNode<K, V> newNode = new MyHashNode<K,V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        //resize
        if ((1.0 * size) / capacity >= 0.7) {
            resize();
        }


    }

    private void resize() {

        ArrayList<MyHashNode<K, V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        capacity = 2 * capacity;
        size = 0;
        for (int i = 0; i < capacity; i++)
            bucketArray.add(null);

        for (MyHashNode<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    //get
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MyHashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            } else {
                head = head.next;
            }
        }
        return null;
    }

    //remove
    public V remove(K key){
        int bucketIndex = getBucketIndex(key);

        // Get head of chain
        MyHashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        MyHashNode<K, V> prev = null;
        while (head != null)
        {
            // If Key found
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    public static void main(String[] args) {
//        MyHashtable<String, Integer> map = new MyHashtable<>();
        MyHashtable<String, String> map = new MyHashtable<>();
        map.put("this", "One" );
        map.put("coder","Two" );
        map.put("this", "Four" );
        map.put("hi", "Five" );
        System.out.println("Map Size = "+map.size());
        System.out.println("Map Remove key: this = " + map.remove("this"));
        System.out.println("Map Remove key: this = " + map.remove("this"));
        System.out.println("Map Size = "+map.size());
        System.out.println("Is Map empty " + map.isEmpty());
        System.out.println("Map Get Key for \"Coder\" = " + map.get("coder"));
        System.out.println("Map cleared");
        map.clear();
        System.out.println("Is Map empty " + map.isEmpty());

    }

}
