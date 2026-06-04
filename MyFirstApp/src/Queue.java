


public class Queue {
    private class Node {
        User user;
        Node next;
        public Node(User user) {
            this.user = user;
        }

    }

    User user;
    protected Node head;
    protected Node tail;
    protected int size;


    public Queue() {
        // super();
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add to the tail
    public void enQueue(User user) {
        Node newUser = new Node(user);
        if (tail == null)
            this.head = this.tail = newUser;
        else {
            tail.next = newUser;
            tail = newUser;
        }
        size++;
        user.setRole(size);
    }

    // Get the first customer out of line
    public User deQueue() {
        if (isEmpty()) {
            System.out.println("There are no customers in line!");
            return null;
        } else {
            // get the first user
            User getFirstUser = head.user;
            // delet the first user from the queue
            head = head.next;
            // if after delet the first user the head is null then the tail should be null
            if (head == null) {
                tail = null;
            }
            size--;
            return getFirstUser;
        }

    }

    // How the first in the queue
    public User peek() {
        if (isEmpty()) {
            System.out.println("There are no customers in line!");
            return null;
        }
        return head.user;
    }

    // Chek if the queue is Empty
    public boolean isEmpty() {
        return this.head == null;
    }

    // Size
    public int getSize() {
        return size;
    }


}
