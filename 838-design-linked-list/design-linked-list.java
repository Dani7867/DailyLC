class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        head = new ListNode(0); // Dummy head node
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        if (index > size) return; // Do not allow adding beyond current size

        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }
}
