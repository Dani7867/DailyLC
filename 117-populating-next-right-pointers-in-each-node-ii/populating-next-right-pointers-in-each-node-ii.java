class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (leftMost != null) {
            Node current = leftMost;
            Node temp = new Node(0); 
            Node dummy = temp;

            while (current != null) {
                if (current.left != null) {
                    temp.next = current.left;
                    temp = temp.next;
                }
                if (current.right != null) {
                    temp.next = current.right;
                    temp = temp.next;
                }
                current = current.next;
            }

            leftMost = dummy.next; 
        }

        return root;
    }
}
