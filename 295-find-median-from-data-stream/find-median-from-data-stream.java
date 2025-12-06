class Node {
    int val;
    Node next, prev;

    Node(int v) { val = v; }
}

class MedianFinder {

    Node head = null;
    Node middle = null;
    int n = 0;

    public MedianFinder() {}

    // Insert into sorted DLL
    private void insert(int num) {
        Node newNode = new Node(num);

        if (head == null) {
            head = middle = newNode;
            n = 1;
            return;
        }

        // Insert at beginning
        if (num < head.val) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

            if (n % 2 == 1) middle = middle.prev;  // size increases from odd → even
            n++;
            return;
        }

        Node temp = head;

        // Move to correct spot
        while (temp.next != null && temp.next.val <= num) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;

        // Fix middle pointer after insertion
        if (num < middle.val) {
            if (n % 2 == 1) middle = middle.prev;
        } else {
            if (n % 2 == 0) middle = middle.next;
        }

        n++;
    }

    public void addNum(int num) {
        insert(num);
    }

    public double findMedian() {
        if (n % 2 == 1) return middle.val;

        return (middle.val + middle.next.val) / 2.0;
    }
}
