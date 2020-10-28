class MyLinkedList {

    private Node pHead;

    class Node {
        int val;
        Node next;
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        Node Node = new Node();
        pHead = Node;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node head = pHead;
        while (index >= 0) {
            if (head == null) {
//                解决index > length问题
                return -1;
            }
            index--;
            head = head.next;
        }
        return head == null ? -1 : head.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node Node = new Node();
        Node.val = val;
        Node.next = pHead.next;
        pHead.next = Node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = pHead.next;
        while (node.next != null) {
            node = node.next;
        }
        Node finalNode = new Node();
        finalNode.val = val;
        node.next = finalNode;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node node = pHead;
        while (index > 0) {
            index--;
            node = node.next;
            if (node == null) {
//                解决index > length问题
                return;
            }

        }
        Node node1 = new Node();
        node1.val = val;
        node1.next = node.next;
        node.next = node1;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node head = pHead;
        Node prev = pHead;
        while (index >= 0) {
            if (head == null) {
//                解决index > length问题
                return;
            }
            index--;
            prev = head;
            head = head.next;
        }
        prev.next = head.next;
        head = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = pHead.next;
        while (node != null) {
            stringBuilder.append(node.val + "-->");
            node = node.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(2));

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */