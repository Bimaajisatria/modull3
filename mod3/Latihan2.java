package mod3;

public class Latihan2 {
    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;
    private int size;

    public Latihan2() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void add(Object item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }

        this.size++;
    }

    public void offer(Object item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }

        this.size++;
    }

    public Object remove() {
        if (isEmpty()) {
            return null;
        }

        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        this.size--;
        return temp.data;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return this.front.data;
    }

    public int search(Object item) {
        int count = 1;
        Node current = this.front;

        while (current != null) {
            if (current.data.equals(item)) {
                return count;
            }

            current = current.next;
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Latihan2 queue = new Latihan2();

        queue.add("Java");
        queue.add("DotNet");
        queue.offer("PHP");
        queue.offer("HTML");

        System.out.println("remove : " + queue.remove());
        System.out.println("element : " + queue.peek());
        System.out.println("poll : " + queue.remove());
        System.out.println("peek : " + queue.peek());

        int count = queue.search("Java");
        while (count != -1 && count > 1) {
            queue.remove();
            count--;
        }

        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}
